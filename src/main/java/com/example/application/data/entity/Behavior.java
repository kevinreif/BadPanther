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
public class Behavior {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long behaviorID;
    private Long clientID;
    private String behaviorName;
    private String behaviorResultsOfAssessment;
    private String behaviorDuration;
    private String behaviorFrequency;
    private String behaviorIntensity;
    private String behaviorSeverity;
    private String behaviorTriggers;
    private String behaviorAntecedents;
    private String behaviorConsequences;
    private String behaviorAlternativeBehavior;
    private String behaviorAttemptToCommunicate;
    private String behaviorResultOfCondition;
    private String behaviorTraumaResponse;
    private String behaviorControlMaintained;
    private String behaviorMostLikelyToOccur;
    private String behaviorLeastLikelyToOccur;
    private String behaviorAssessmentAcrossEnvironments;
    private String behaviorObservationNotes;
    private String behaviorHypothesizedFunctions;

    public Long getBehaviorID() {
        return behaviorID;
    }

    public void setBehaviorID(Long behaviorID) {
        this.behaviorID = behaviorID;
    }

    public Long getClientID() {
        return clientID;
    }

    public void setClientID(Long clientID) {
        this.clientID = clientID;
    }

    public String getBehaviorResultsOfAssessment() {
        return behaviorResultsOfAssessment;
    }

    public void setBehaviorResultsOfAssessment(String behaviorResultsOfAssessment) {
        this.behaviorResultsOfAssessment = behaviorResultsOfAssessment;
    }

    public String getBehaviorDuration() {
        return behaviorDuration;
    }

    public void setBehaviorDuration(String behaviorDuration) {
        this.behaviorDuration = behaviorDuration;
    }

    public String getBehaviorFrequency() {
        return behaviorFrequency;
    }

    public void setBehaviorFrequency(String behaviorFrequency) {
        this.behaviorFrequency = behaviorFrequency;
    }

    public String getBehaviorIntensity() {
        return behaviorIntensity;
    }

    public void setBehaviorIntensity(String behaviorIntensity) {
        this.behaviorIntensity = behaviorIntensity;
    }

    public String getBehaviorSeverity() {
        return behaviorSeverity;
    }

    public void setBehaviorSeverity(String behaviorSeverity) {
        this.behaviorSeverity = behaviorSeverity;
    }

    public String getBehaviorTriggers() {
        return behaviorTriggers;
    }

    public void setBehaviorTriggers(String behaviorTriggers) {
        this.behaviorTriggers = behaviorTriggers;
    }

    public String getBehaviorAntecedents() {
        return behaviorAntecedents;
    }

    public void setBehaviorAntecedents(String behaviorAntecedents) {
        this.behaviorAntecedents = behaviorAntecedents;
    }

    public String getBehaviorConsequences() {
        return behaviorConsequences;
    }

    public void setBehaviorConsequences(String behaviorConsequences) {
        this.behaviorConsequences = behaviorConsequences;
    }

    public String getBehaviorAlternativeBehavior() {
        return behaviorAlternativeBehavior;
    }

    public void setBehaviorAlternativeBehavior(String behaviorAlternativeBehavior) {
        this.behaviorAlternativeBehavior = behaviorAlternativeBehavior;
    }

    public String getBehaviorAttemptToCommunicate() {
        return behaviorAttemptToCommunicate;
    }

    public void setBehaviorAttemptToCommunicate(String behaviorAttemptToCommunicate) {
        this.behaviorAttemptToCommunicate = behaviorAttemptToCommunicate;
    }

    public String getBehaviorResultOfCondition() {
        return behaviorResultOfCondition;
    }

    public void setBehaviorResultOfCondition(String behaviorResultOfCondition) {
        this.behaviorResultOfCondition = behaviorResultOfCondition;
    }

    public String getBehaviorTraumaResponse() {
        return behaviorTraumaResponse;
    }

    public void setBehaviorTraumaResponse(String behaviorTraumaResponse) {
        this.behaviorTraumaResponse = behaviorTraumaResponse;
    }

    public String getBehaviorControlMaintained() {
        return behaviorControlMaintained;
    }

    public void setBehaviorControlMaintained(String behaviorControlMaintained) {
        this.behaviorControlMaintained = behaviorControlMaintained;
    }

    public String getBehaviorMostLikelyToOccur() {
        return behaviorMostLikelyToOccur;
    }

    public void setBehaviorMostLikelyToOccur(String behaviorMostLikelyToOccur) {
        this.behaviorMostLikelyToOccur = behaviorMostLikelyToOccur;
    }

    public String getBehaviorLeastLikelyToOccur() {
        return behaviorLeastLikelyToOccur;
    }

    public void setBehaviorLeastLikelyToOccur(String behaviorLeastLikelyToOccur) {
        this.behaviorLeastLikelyToOccur = behaviorLeastLikelyToOccur;
    }

    public String getBehaviorAssessmentAcrossEnvironments() {
        return behaviorAssessmentAcrossEnvironments;
    }

    public void setBehaviorAssessmentAcrossEnvironments(String behaviorAssessmentAcrossEnvironments) {
        this.behaviorAssessmentAcrossEnvironments = behaviorAssessmentAcrossEnvironments;
    }

    public String getBehaviorObservationNotes() {
        return behaviorObservationNotes;
    }

    public void setBehaviorObservationNotes(String behaviorObservationNotes) {
        this.behaviorObservationNotes = behaviorObservationNotes;
    }

    public String getBehaviorHypothesizedFunctions() {
        return behaviorHypothesizedFunctions;
    }

    public void setBehaviorHypothesizedFunctions(String behaviorHypothesizedFunctions) {
        this.behaviorHypothesizedFunctions = behaviorHypothesizedFunctions;
    }

    public String getBehaviorName() {
        return behaviorName;
    }

    public void setBehaviorName(String behaviorName) {
        this.behaviorName = behaviorName;
    }
}
