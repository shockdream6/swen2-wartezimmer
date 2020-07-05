package swen.cloud.service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Patient class to store patient related information
 */
@Entity
public class Patient extends PanacheEntity {
    private static final Logger logger = Logger.getLogger("Patient");

    private Long patId;
    private Long waitNo;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private LocalDate birth;
    @Enumerated(EnumType.STRING)
    private WaitingStatus status;
    private LocalDateTime waitingStart;
    private LocalDateTime waitingEnd;
    private Duration waitingTime;

    //waiting number counter
    private static long counter = 0;

    public Patient() {

    }

    public Long getPatId() {
        return patId;
    }

    public void setPatId(Long patId) {
        this.patId = patId;
    }

    public Long getWaitNo() {
        return waitNo;
    }

    public void setWaitNo(Long waitNo) {
        this.waitNo = waitNo;
    }

    /**
     * finds out the current biggest waiting number in the database and adds 1 to it. The it sets it as a the number.
     * It is pretty inefficient always having to go through all data. SHould be reconsiderd in the future.
     */
    public void setWaitNoCount() {
        DatabaseService service = new DatabaseService();
        List<Patient> patientData = new ArrayList<>();
        patientData = service.getList();
        long maxNo = 0;
        long currentWaitNo = 0;

        for (Patient patient : patientData) {
            currentWaitNo = patient.getWaitNo();
            if (currentWaitNo > maxNo) {
                maxNo = currentWaitNo;
            }
        }
        this.waitNo = maxNo + 1;
    }

    public String getFirstName() {
        return firstName.toUpperCase();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName.toLowerCase();
    }

    public String getLastName() {
        return lastName.toUpperCase();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.toLowerCase();
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public WaitingStatus getStatus() {
        return status;
    }

    public void setStatus(WaitingStatus status) {
        this.status = status;
    }

    public LocalDateTime getWaitingStart() {
        return waitingStart;
    }

    public void setWaitingStart(LocalDateTime waitingStart) {
        this.waitingStart = waitingStart;
    }

    public LocalDateTime getWaitingEnd() {
        return waitingEnd;
    }

    /**
     * Method sets the waitingEnd variable and calculates the wait time if waiting start is set. Throws a exception when the waiting start is bigger than waiting end.
     *
     * @param waitingEnd Time when the patient was finish with waiting
     * @throws WaitingTimeException If the waiting time end is before the waiting time start
     */
    public void setWaitingEnd(LocalDateTime waitingEnd) throws WaitingTimeException {

        if ((waitingStart != null) && (waitingStart.compareTo(waitingEnd) > 1)) {
            logger.info("Error: Patient with the ID " + patId + " has waiting that that is after the waiting end.");
            throw new WaitingTimeException();
        }

        //calculation of the actual waiting time of the patient
        //check first if the waitingStart has been set
        if (waitingStart != null) {
            waitingTime = Duration.between(waitingEnd, waitingStart);
        } else {
            logger.info("Error: Patient with the ID " + patId + " has no Waiting Start. Occured during setting the WaitingEnd. WaitingTime could not be calculated.");
        }
    }

    /**
     * gets the waiting time of the patient in seconds if it has been calculated. Otherwise it returns 0.
     *
     * @return returns zero when no waiting time calculated
     */
    public long getWaitingTime() {
        if (waitingTime != null) {
            return waitingTime.getSeconds();
        }
        return 0;
    }


}
