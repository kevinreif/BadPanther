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
public class Observation {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long observationID;
    private Long clientID;
    private String obsCooperation;
    private String obsAppearance;
    private String obsGroomingAndHygiene;
    private String obsMotorBehavior;
    private String obsMemory;
    private String obsSpeech;
    private String obsIntelligence;
    private String obsMood;
    private String obsAffect;
    private String obsSuicidalIdeationIntent;
    private String obsAssaultiveIdeation;
    private String obsThoughtProcesses;
    private String obsThoughtContent;
    private String obsMotivationForRecovery;
    private String obsPeerRelationships;
    private String obsSexualBehavior;
    private String obsAbuseTraumaNeglect;
    private String obsLegalAndCriminalHistory;

    public Long getObservationID() {
        return observationID;
    }

    public void setObservationID(Long observationID) {
        this.observationID = observationID;
    }

    public Long getClientID() {
        return clientID;
    }

    public void setClientID(Long clientID) {
        this.clientID = clientID;
    }

    public String getObsCooperation() {
        return obsCooperation;
    }

    public void setObsCooperation(String obsCooperation) {
        this.obsCooperation = obsCooperation;
    }

    public String getObsAppearance() {
        return obsAppearance;
    }

    public void setObsAppearance(String obsAppearance) {
        this.obsAppearance = obsAppearance;
    }

    public String getObsGroomingAndHygiene() {
        return obsGroomingAndHygiene;
    }

    public void setObsGroomingAndHygiene(String obsGroomingAndHygiene) {
        this.obsGroomingAndHygiene = obsGroomingAndHygiene;
    }

    public String getObsMotorBehavior() {
        return obsMotorBehavior;
    }

    public void setObsMotorBehavior(String obsMotorBehavior) {
        this.obsMotorBehavior = obsMotorBehavior;
    }

    public String getObsMemory() {
        return obsMemory;
    }

    public void setObsMemory(String obsMemory) {
        this.obsMemory = obsMemory;
    }

    public String getObsSpeech() {
        return obsSpeech;
    }

    public void setObsSpeech(String obsSpeech) {
        this.obsSpeech = obsSpeech;
    }

    public String getObsIntelligence() {
        return obsIntelligence;
    }

    public void setObsIntelligence(String obsIntelligence) {
        this.obsIntelligence = obsIntelligence;
    }

    public String getObsMood() {
        return obsMood;
    }

    public void setObsMood(String obsMood) {
        this.obsMood = obsMood;
    }

    public String getObsAffect() {
        return obsAffect;
    }

    public void setObsAffect(String obsAffect) {
        this.obsAffect = obsAffect;
    }

    public String getObsSuicidalIdeationIntent() {
        return obsSuicidalIdeationIntent;
    }

    public void setObsSuicidalIdeationIntent(String obsSuicidalIdeationIntent) {
        this.obsSuicidalIdeationIntent = obsSuicidalIdeationIntent;
    }

    public String getObsAssaultiveIdeation() {
        return obsAssaultiveIdeation;
    }

    public void setObsAssaultiveIdeation(String obsAssaultiveIdeation) {
        this.obsAssaultiveIdeation = obsAssaultiveIdeation;
    }

    public String getObsThoughtProcesses() {
        return obsThoughtProcesses;
    }

    public void setObsThoughtProcesses(String obsThoughtProcesses) {
        this.obsThoughtProcesses = obsThoughtProcesses;
    }

    public String getObsThoughtContent() {
        return obsThoughtContent;
    }

    public void setObsThoughtContent(String obsThoughtContent) {
        this.obsThoughtContent = obsThoughtContent;
    }

    public String getObsMotivationForRecovery() {
        return obsMotivationForRecovery;
    }

    public void setObsMotivationForRecovery(String obsMotivationForRecovery) {
        this.obsMotivationForRecovery = obsMotivationForRecovery;
    }

    public String getObsPeerRelationships() {
        return obsPeerRelationships;
    }

    public void setObsPeerRelationships(String obsPeerRelationships) {
        this.obsPeerRelationships = obsPeerRelationships;
    }

    public String getObsSexualBehavior() {
        return obsSexualBehavior;
    }

    public void setObsSexualBehavior(String obsSexualBehavior) {
        this.obsSexualBehavior = obsSexualBehavior;
    }

    public String getObsAbuseTraumaNeglect() {
        return obsAbuseTraumaNeglect;
    }

    public void setObsAbuseTraumaNeglect(String obsAbuseTraumaNeglect) {
        this.obsAbuseTraumaNeglect = obsAbuseTraumaNeglect;
    }

    public String getObsLegalAndCriminalHistory() {
        return obsLegalAndCriminalHistory;
    }

    public void setObsLegalAndCriminalHistory(String obsLegalAndCriminalHistory) {
        this.obsLegalAndCriminalHistory = obsLegalAndCriminalHistory;
    }
}
