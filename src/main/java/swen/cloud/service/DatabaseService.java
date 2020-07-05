package swen.cloud.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.persistence.OrderBy;
import javax.transaction.Transactional;


/**
 * Service to connect to the H2 Database. Uses persistance with hibernate framework.
 */
@ApplicationScoped
@Default
public class DatabaseService {
	private static final Logger logger = Logger.getLogger("DatabaseService");

	/**
	 * Adds patient
	 * @param patId Patient ID
	 * @param firstName Firstname of the patient
	 * @param lastName Lastname of the patient
	 * @param gender The sex of the patient
	 * @param birth Birthdate of the patient
	 * @return returns a string saying it was successful
	 */
	@Transactional
	public String addPatient(Long patId, String firstName, String lastName, Gender gender, String birth) {
		logger.info(lastName + " is on waiting list");
		
		// creating a patient
		Patient patient = new Patient();
		patient.setPatId(patId);
		patient.setWaitNoCount();
		patient.setFirstName(firstName);
		patient.setLastName(lastName);
		patient.setGender(gender);
		patient.setBirth(LocalDate.parse(birth));
		patient.setStatus(WaitingStatus.WAITING);
		
		DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime waitingStart = LocalDateTime.now();
		String parsedString = waitingStart.format(customFormatter);
		LocalDateTime parsedLocalDateTime = LocalDateTime.parse(parsedString, customFormatter);
		patient.setWaitingStart(parsedLocalDateTime);
		
		// saving a patient to database
		patient.persist();
		
		return (firstName + " " + lastName + " is saved.");
	}
	
	@Transactional
	public String deletePatient(Long waitNo) {
		logger.info("deleting a patient from waiting list");
		
		// check if it's persistent
		Patient.delete("waitNo", waitNo);
				
		return ("Patient with waiting no " + waitNo + " is deleted.");
	}

	/**
	 * returns the waiting list of all patients in descending order of the waintingTimeStart variable.
	 * @return returns the waiting list of all patients in descending order of the waintingTimeStart variable.
	 */
	@OrderBy("waitingStart DESC")
	public List<Patient> getList() {
		logger.info("show waiting list");
		return (Patient.listAll());
	}
	
}
