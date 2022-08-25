package com.example.application.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class ClientInfo {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientID;
    @Type(type = "uuid-char")
    private UUID userID;
    private String clientFirstName;
    private String clientLastName;
    private String clientCaregiver;
    private LocalDate clientDateOfBirth;
    private Integer clientAge;
    private String clientContact;
    private String clientAltContact;
    private LocalDate clientDateOfAssessment;
    private String clientAssessor;

    public Long getClientID() {
        return clientID;
    }

    public void setClientID(Long clientID) {
        this.clientID = clientID;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public String getClientCaregiver() {
        return clientCaregiver;
    }

    public void setClientCaregiver(String clientCaregiver) {
        this.clientCaregiver = clientCaregiver;
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public LocalDate getClientDateOfBirth() {
        return clientDateOfBirth;
    }

    public void setClientDateOfBirth(LocalDate clientDateOfBirth) {
        this.clientDateOfBirth = clientDateOfBirth;
    }

    public Integer getClientAge() {
        return clientAge;
    }

    public void setClientAge(Integer clientAge) {
        this.clientAge = clientAge;
    }

    public String getClientContact() {
        return clientContact;
    }

    public void setClientContact(String clientContact) {
        this.clientContact = clientContact;
    }

    public String getClientAltContact() {
        return clientAltContact;
    }

    public void setClientAltContact(String clientAltContact) {
        this.clientAltContact = clientAltContact;
    }

    public LocalDate getClientDateOfAssessment() {
        return clientDateOfAssessment;
    }

    public void setClientDateOfAssessment(LocalDate clientDateOfAssessment) {
        this.clientDateOfAssessment = clientDateOfAssessment;
    }

    public String getClientAssessor() {
        return clientAssessor;
    }

    public void setClientAssessor(String clientAssessor) {
        this.clientAssessor = clientAssessor;
    }
}

