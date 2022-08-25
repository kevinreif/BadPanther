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
public class DailyLivingSkills {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillsID;
    private Long clientID;
    private String skillsBathing;
    private String skillsPersonalHygiene;
    private String skillsCognition;
    private String skillsDressing;
    private String skillsGrooming;
    private String skillsEating;
    private String skillsElimination;
    private String skillsMobility;
    private String skillsTransfers;
    private String skillsHousekeeping;
    private String skillsLaundry;
    private String skillsMealPreparation;
    private String skillsShopping;
    private String skillsTransportation;

    public Long getSkillsID() {
        return skillsID;
    }

    public void setSkillsID(Long skillsID) {
        this.skillsID = skillsID;
    }

    public Long getClientID() {
        return clientID;
    }

    public void setClientID(Long clientID) {
        this.clientID = clientID;
    }

    public String getSkillsBathing() {
        return skillsBathing;
    }

    public void setSkillsBathing(String skillsBathing) {
        this.skillsBathing = skillsBathing;
    }

    public String getSkillsPersonalHygiene() {
        return skillsPersonalHygiene;
    }

    public void setSkillsPersonalHygiene(String skillsPersonalHygiene) {
        this.skillsPersonalHygiene = skillsPersonalHygiene;
    }

    public String getSkillsCognition() {
        return skillsCognition;
    }

    public void setSkillsCognition(String skillsCognition) {
        this.skillsCognition = skillsCognition;
    }

    public String getSkillsDressing() {
        return skillsDressing;
    }

    public void setSkillsDressing(String skillsDressing) {
        this.skillsDressing = skillsDressing;
    }

    public String getSkillsGrooming() {
        return skillsGrooming;
    }

    public void setSkillsGrooming(String skillsGrooming) {
        this.skillsGrooming = skillsGrooming;
    }

    public String getSkillsEating() {
        return skillsEating;
    }

    public void setSkillsEating(String skillsEating) {
        this.skillsEating = skillsEating;
    }

    public String getSkillsElimination() {
        return skillsElimination;
    }

    public void setSkillsElimination(String skillsElimination) {
        this.skillsElimination = skillsElimination;
    }

    public String getSkillsMobility() {
        return skillsMobility;
    }

    public void setSkillsMobility(String skillsMobility) {
        this.skillsMobility = skillsMobility;
    }

    public String getSkillsTransfers() {
        return skillsTransfers;
    }

    public void setSkillsTransfers(String skillsTransfers) {
        this.skillsTransfers = skillsTransfers;
    }

    public String getSkillsHousekeeping() {
        return skillsHousekeeping;
    }

    public void setSkillsHousekeeping(String skillsHousekeeping) {
        this.skillsHousekeeping = skillsHousekeeping;
    }

    public String getSkillsLaundry() {
        return skillsLaundry;
    }

    public void setSkillsLaundry(String skillsLaundry) {
        this.skillsLaundry = skillsLaundry;
    }

    public String getSkillsMealPreparation() {
        return skillsMealPreparation;
    }

    public void setSkillsMealPreparation(String skillsMealPreparation) {
        this.skillsMealPreparation = skillsMealPreparation;
    }

    public String getSkillsShopping() {
        return skillsShopping;
    }

    public void setSkillsShopping(String skillsShopping) {
        this.skillsShopping = skillsShopping;
    }

    public String getSkillsTransportation() {
        return skillsTransportation;
    }

    public void setSkillsTransportation(String skillsTransportation) {
        this.skillsTransportation = skillsTransportation;
    }
}
