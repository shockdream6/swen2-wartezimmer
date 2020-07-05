package swen.cloud.service;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Business Logic class
 * Class to store patient related data between REST Services and HTML pages
 */
public class WaitingRoom {
    public String title;
    public List<Patient> data;
    public LocalDateTime now;
    public String server = "Team 02";
    public long averageWaitingTime;
    private boolean onlyActivePatients = false;

    public WaitingRoom(String title, List<Patient> data, LocalDateTime localDateTime) {
        this.title = title;
        this.data = data;
        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime dateTime = localDateTime;
        String parsedString = dateTime.format(customFormatter);
        LocalDateTime parsedLocalDateTime = LocalDateTime.parse(parsedString, customFormatter);
        this.now = parsedLocalDateTime;
        averageWaitingTime = calculateAverageWaitingTime(data);
    }

    /**
     * Overloaded constructor with a boolean parameter for the option to give out only active patients at the waiting list
     *
     * @param title Titel
     * @param data Patientlist with all
     * @param localDateTime Currenttime to show at the site
     * @param onlyActivePatients activates filtering for only active patients
     */
    public WaitingRoom(String title, List<Patient> data, LocalDateTime localDateTime, boolean onlyActivePatients) {
        this.title = title;

        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime dateTime = localDateTime;
        String parsedString = dateTime.format(customFormatter);
        LocalDateTime parsedLocalDateTime = LocalDateTime.parse(parsedString, customFormatter);
        this.now = parsedLocalDateTime;
        this.onlyActivePatients = onlyActivePatients;
        averageWaitingTime = calculateAverageWaitingTime(data);

        if (onlyActivePatients) {
            this.data = filterForOnlyActivePatient(data);
        } else {
            this.data = data;
        }

    }

    /**
     * Iterator object couldn't be used. Doesn't allow to access underlying objects. Work around using current list and add the wanted elements to another list.
     *
     * @param data Patientlist
     * @return returns list of patients the are not the status dismissed
     */
    private List<Patient> filterForOnlyActivePatient(List<Patient> data) {
        List<Patient> activePatientList = new ArrayList<>();

        for (Patient patient : data) {
            if (patient.getStatus() != WaitingStatus.DISCHARGED) {
                activePatientList.add(patient);
            }
        }

        return activePatientList;
    }


    /**
     * Calculates the average waiting time of patients with waitingTime attribute set from class patient.
     *
     * @param patientData PatientList
     * @return returns the average waiting time of the patients
     */
    private long calculateAverageWaitingTime(List<Patient> patientData) {
        //calculates the average of all specified waiting time
        long sum = 0;
        long divideCounter = 0;
        long helpA;

        for (int i = 0; i < patientData.size(); i++) {
            helpA = patientData.get(i).getWaitingTime();
            if (0 != helpA) {
                divideCounter++;
                sum = sum + helpA;
            }
        }

        if (sum != 0 && divideCounter != 0) {
            return (sum / divideCounter);

        }

        return 0;

    }

    public WaitingRoom(String title) {
        this.title = title;
    }

    public WaitingRoom(List<Patient> data) {
        this.data = data;
    }

    public List<Patient> getList() {
        return this.data;
    }


}
