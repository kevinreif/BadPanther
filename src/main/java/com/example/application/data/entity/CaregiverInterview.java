package com.example.application.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class CaregiverInterview {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caregiverInterviewID;
    private Long clientID;
    private String carePresentingConcerns;
    private String careImmediateNeedsRisks;
    private String careCurrentTreatments;
    private String carePreviousTreatments;
    private String carePsychosocialHistory;
    private String careLegalAndCriminalHistory;
    private String careClientDiagnosis;
    private String careMedications;
    private String careHistoryOfPsychiatricTreatment;
    private String careFamilyPsychologicalHistory;
    private String careHistoryOfMedicalTreatment;
    private String careSubstanceAbuseHistory;
    private String careIndividualStrengths;
    private String careIndividualPreferenceForSupports;
    private String careCulturalConcerns;
    private String careSupportSystems;

    public Long getCaregiverInterviewID() {
        return caregiverInterviewID;
    }

    public void setCaregiverInterviewID(Long caregiverInterviewID) {
        this.caregiverInterviewID = caregiverInterviewID;
    }

    public Long getClientID() {
        return clientID;
    }

    public void setClientID(Long clientID) {
        this.clientID = clientID;
    }

    public String getCarePresentingConcerns() {
        return carePresentingConcerns;
    }

    public void setCarePresentingConcerns(String carePresentingConcerns) {
        this.carePresentingConcerns = carePresentingConcerns;
    }

    public String getCareImmediateNeedsRisks() {
        return careImmediateNeedsRisks;
    }

    public void setCareImmediateNeedsRisks(String careImmediateNeedsRisks) {
        this.careImmediateNeedsRisks = careImmediateNeedsRisks;
    }

    public String getCareCurrentTreatments() {
        return careCurrentTreatments;
    }

    public void setCareCurrentTreatments(String careCurrentTreatments) {
        this.careCurrentTreatments = careCurrentTreatments;
    }

    public String getCarePreviousTreatments() {
        return carePreviousTreatments;
    }

    public void setCarePreviousTreatments(String carePreviousTreatments) {
        this.carePreviousTreatments = carePreviousTreatments;
    }

    public String getCarePsychosocialHistory() {
        return carePsychosocialHistory;
    }

    public void setCarePsychosocialHistory(String carePsychosocialHistory) {
        this.carePsychosocialHistory = carePsychosocialHistory;
    }

    public String getCareLegalAndCriminalHistory() {
        return careLegalAndCriminalHistory;
    }

    public void setCareLegalAndCriminalHistory(String careLegalAndCriminalHistory) {
        this.careLegalAndCriminalHistory = careLegalAndCriminalHistory;
    }

    public String getCareClientDiagnosis() {
        return careClientDiagnosis;
    }

    public void setCareClientDiagnosis(String careClientDiagnosis) {
        this.careClientDiagnosis = careClientDiagnosis;
    }

    public String getCareMedications() {
        return careMedications;
    }

    public void setCareMedications(String careMedications) {
        this.careMedications = careMedications;
    }

    public String getCareHistoryOfPsychiatricTreatment() {
        return careHistoryOfPsychiatricTreatment;
    }

    public void setCareHistoryOfPsychiatricTreatment(String careHistoryOfPsychiatricTreatment) {
        this.careHistoryOfPsychiatricTreatment = careHistoryOfPsychiatricTreatment;
    }

    public String getCareFamilyPsychologicalHistory() {
        return careFamilyPsychologicalHistory;
    }

    public void setCareFamilyPsychologicalHistory(String careFamilyPsychologicalHistory) {
        this.careFamilyPsychologicalHistory = careFamilyPsychologicalHistory;
    }

    public String getCareHistoryOfMedicalTreatment() {
        return careHistoryOfMedicalTreatment;
    }

    public void setCareHistoryOfMedicalTreatment(String careHistoryOfMedicalTreatment) {
        this.careHistoryOfMedicalTreatment = careHistoryOfMedicalTreatment;
    }

    public String getCareSubstanceAbuseHistory() {
        return careSubstanceAbuseHistory;
    }

    public void setCareSubstanceAbuseHistory(String careSubstanceAbuseHistory) {
        this.careSubstanceAbuseHistory = careSubstanceAbuseHistory;
    }

    public String getCareIndividualStrengths() {
        return careIndividualStrengths;
    }

    public void setCareIndividualStrengths(String careIndividualStrengths) {
        this.careIndividualStrengths = careIndividualStrengths;
    }

    public String getCareIndividualPreferenceForSupports() {
        return careIndividualPreferenceForSupports;
    }

    public void setCareIndividualPreferenceForSupports(String careIndividualPreferenceForSupports) {
        this.careIndividualPreferenceForSupports = careIndividualPreferenceForSupports;
    }

    public String getCareCulturalConcerns() {
        return careCulturalConcerns;
    }

    public void setCareCulturalConcerns(String careCulturalConcerns) {
        this.careCulturalConcerns = careCulturalConcerns;
    }

    public String getCareSupportSystems() {
        return careSupportSystems;
    }

    public void setCareSupportSystems(String careSupportSystems) {
        this.careSupportSystems = careSupportSystems;
    }
}
