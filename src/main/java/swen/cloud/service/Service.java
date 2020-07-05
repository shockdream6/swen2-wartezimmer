package swen.cloud.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Service to inject the database functionality.
 */
public abstract class Service {
	
	public abstract String addPatient();
	
	public abstract String addPatientString();
	
	public abstract String deletePatient(Long waitNo);
		
	public abstract List<Patient> getList();

}
