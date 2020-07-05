package swen.cloud.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.qute.api.ResourcePath;


/**
 * 
 * Patient resource class. Main interface for handling incoming request from the
 * internet
 * Darstellungsschicht von drei Schichten Architektur
 */

@Path("/")
@RequestScoped
public class PatientResource {
		
	@Inject
	DatabaseService service;
	
	@Inject
	@ResourcePath("index.html")
	Template index;

	@Inject
	@ResourcePath("list.html")
	Template list;
	
	@Inject
	@ResourcePath("del.html")
	Template del;
	
	@Inject
	@ResourcePath("add.html")
	Template add;

	@Inject
	@ResourcePath("patientLog.html")
	Template listPatientLog;
		
	public PatientResource(DatabaseService service) {
		this.service = service;
	}
	
	/**
	 * html: call welcome page
	 * @return html website
	 */
	@GET
	@Produces(MediaType.TEXT_HTML)
	public TemplateInstance indexHtml() {
		return index.data("index", new WaitingRoom("Home"));
	}
	
	/**
	 * html: call list for all patient ever in the history and present
	 * @return html website
	 */
	@GET
	@Path("html/patient/list/all")
	@Produces(MediaType.TEXT_HTML)
	public TemplateInstance listAllHtml() {

		return listPatientLog.data("patListData",
				new WaitingRoom("List of Patients", service.getList(), LocalDateTime.now()));
	}

	/**
	 * html: call list for all active patient in the waiting list
	 * @return html website
	 */
	@GET
	@Path("html/patient/list/active")
	@Produces(MediaType.TEXT_HTML)
	public TemplateInstance listActiveHtml() {

		return list.data("patListData",
				new WaitingRoom("List of Patients", service.getList(), LocalDateTime.now(),true));
	}


	/**
	 * html: call list + delete function
	 * @return html website
	 */
	@GET
	@Path("html/patient/del")
	@Produces(MediaType.TEXT_HTML)
	public TemplateInstance deletePatientHtml() {
		return del.data("patListData",
				new WaitingRoom("List of Patients", service.getList(), LocalDateTime.now()));
	}
	
	/**
	 * html: call list + add function
	 * @return html website
	 */
	@GET
	@Path("html/patient/add")
	@Produces(MediaType.TEXT_HTML)
	public TemplateInstance addPatientHtml() {
		return add.data("patListData",
				new WaitingRoom("List of Patients", service.getList(), LocalDateTime.now()));
	}
	

	/**
	 * html: call list + delete patient
	 * @param waitNo Waiting number of the patient
	 * @return html website
	 */
	@POST
	@Path("html/patient/del")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public TemplateInstance deletePatientHtml(@FormParam("waitNo") Long waitNo) {
		service.deletePatient(waitNo);
		return del.data("patListData",
				new WaitingRoom("List of Patients", service.getList(), LocalDateTime.now()));
	}

	/**
	 * json: call list
	 * @return json object
	 */
	@GET
	@Path("json/patient/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Patient> listAll() {
		return service.getList();
	}


	/**
	 * json: call list + delete patient
	 * @param waitNo waiting number of patient
	 * @return json object
	 */
	@POST
	@Path("json/patient/del/{waitNo}")
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response deletePatient(@PathParam("waitNo") Long waitNo) {
		service.deletePatient(waitNo);
		return Response.ok().build();
	}
	
	/**
	 * html: call list + add patient
	 * @param birth Birthdate of the patient
	 * @param firstName Firstname of the patient
	 * @param gender sex of the patient
	 * @param lastName Lastname of the patient
	 * @param patId Patientidentifier
	 * @return json object
	 */
	@POST
	@Path("html/patient/add")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public TemplateInstance addPatientHtml(
			@FormParam("patId") Long patId,
			@FormParam("firstName") String firstName, 
			@FormParam("lastName") String lastName, 
			@FormParam("gender") Gender gender, 
			@FormParam("birth") String birth) {
		service.addPatient(patId, firstName, lastName, gender, birth);
		return add.data("patListData",
				new WaitingRoom("Add", service.getList(), LocalDateTime.now()));
	}
	
	/**
	 * json: call list + add patient
	 * @param birth Birthdate of the patient
	 * @param firstName Firstname of the patient
	 * @param gender sex of the patient
	 * @param lastName Lastname of the patient
	 * @param patId Patientidentifier
	 * @return json object
	 */
	@POST
	@Path("json/patient/add/{patId}/{firstName}/{lastName}/{gender}/{birth}")
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response addPatient(
			@PathParam("patId") Long patId,
			@PathParam("firstName") String firstName, 
			@PathParam("lastName") String lastName, 
			@PathParam("gender") Gender gender, 
			@PathParam("birth") String birth) {
		service.addPatient(patId, firstName, lastName, gender, birth);
		return Response.ok().build();
	}
	
}





