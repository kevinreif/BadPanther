package com.example.application.data.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class SummaryOfHistory {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long summaryID;
    private Long clientID;
    private String summaryMilestones;
    private String summaryDiagnosis;
    private String summaryMedications;
    private String summaryPsychiatricTreatment;
    private String summaryFamilyHistory;
    private String summaryMedicalHistory;
    private String summarySubstanceAbuseHistory;
    private String summaryLivingSituation;
    private String summarySocialSupport;
    private String summarySchoolHistory;
    private String summaryActivitiesOfInterest;
    private String summaryLegalAndCriminalHistory;
    private String summaryEmployment;
    private String summaryInSchoolSpeech;
    private String summaryCounseling;
    private String summaryIndependentSupportPlan;
    private String summaryAssistiveDevices;

    public Long getSummaryID() {
        return summaryID;
    }

    public void setSummaryID(Long summaryID) {
        this.summaryID = summaryID;
    }

    public Long getClientID() {
        return clientID;
    }

    public void setClientID(Long clientID) {
        this.clientID = clientID;
    }

    public String getSummaryMilestones() {
        return summaryMilestones;
    }

    public void setSummaryMilestones(String summaryMilestones) {
        this.summaryMilestones = summaryMilestones;
    }

    public String getSummaryDiagnosis() {
        return summaryDiagnosis;
    }

    public void setSummaryDiagnosis(String summaryDiagnosis) {
        this.summaryDiagnosis = summaryDiagnosis;
    }

    public String getSummaryMedications() {
        return summaryMedications;
    }

    public void setSummaryMedications(String summaryMedications) {
        this.summaryMedications = summaryMedications;
    }

    public String getSummaryPsychiatricTreatment() {
        return summaryPsychiatricTreatment;
    }

    public void setSummaryPsychiatricTreatment(String summaryPsychiatricTreatment) {
        this.summaryPsychiatricTreatment = summaryPsychiatricTreatment;
    }

    public String getSummaryFamilyHistory() {
        return summaryFamilyHistory;
    }

    public void setSummaryFamilyHistory(String summaryFamilyHistory) {
        this.summaryFamilyHistory = summaryFamilyHistory;
    }

    public String getSummaryMedicalHistory() {
        return summaryMedicalHistory;
    }

    public void setSummaryMedicalHistory(String summaryMedicalHistory) {
        this.summaryMedicalHistory = summaryMedicalHistory;
    }

    public String getSummarySubstanceAbuseHistory() {
        return summarySubstanceAbuseHistory;
    }

    public void setSummarySubstanceAbuseHistory(String summarySubstanceAbuseHistory) {
        this.summarySubstanceAbuseHistory = summarySubstanceAbuseHistory;
    }

    public String getSummaryLivingSituation() {
        return summaryLivingSituation;
    }

    public void setSummaryLivingSituation(String summaryLivingSituation) {
        this.summaryLivingSituation = summaryLivingSituation;
    }

    public String getSummarySocialSupport() {
        return summarySocialSupport;
    }

    public void setSummarySocialSupport(String summarySocialSupport) {
        this.summarySocialSupport = summarySocialSupport;
    }

    public String getSummarySchoolHistory() {
        return summarySchoolHistory;
    }

    public void setSummarySchoolHistory(String summarySchoolHistory) {
        this.summarySchoolHistory = summarySchoolHistory;
    }

    public String getSummaryActivitiesOfInterest() {
        return summaryActivitiesOfInterest;
    }

    public void setSummaryActivitiesOfInterest(String summaryActivitiesOfInterest) {
        this.summaryActivitiesOfInterest = summaryActivitiesOfInterest;
    }

    public String getSummaryLegalAndCriminalHistory() {
        return summaryLegalAndCriminalHistory;
    }

    public void setSummaryLegalAndCriminalHistory(String summaryLegalAndCriminalHistory) {
        this.summaryLegalAndCriminalHistory = summaryLegalAndCriminalHistory;
    }

    public String getSummaryEmployment() {
        return summaryEmployment;
    }

    public void setSummaryEmployment(String summaryEmployment) {
        this.summaryEmployment = summaryEmployment;
    }

    public String getSummaryInSchoolSpeech() {
        return summaryInSchoolSpeech;
    }

    public void setSummaryInSchoolSpeech(String summaryInSchoolSpeech) {
        this.summaryInSchoolSpeech = summaryInSchoolSpeech;
    }

    public String getSummaryCounseling() {
        return summaryCounseling;
    }

    public void setSummaryCounseling(String summaryCounseling) {
        this.summaryCounseling = summaryCounseling;
    }

    public String getSummaryIndependentSupportPlan() {
        return summaryIndependentSupportPlan;
    }

    public void setSummaryIndependentSupportPlan(String summaryIndependentSupportPlan) {
        this.summaryIndependentSupportPlan = summaryIndependentSupportPlan;
    }

    public String getSummaryAssistiveDevices() {
        return summaryAssistiveDevices;
    }

    public void setSummaryAssistiveDevices(String summaryAssistiveDevices) {
        this.summaryAssistiveDevices = summaryAssistiveDevices;
    }
}
