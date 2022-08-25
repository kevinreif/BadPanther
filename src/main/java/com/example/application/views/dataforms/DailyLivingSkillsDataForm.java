package com.example.application.views.dataforms;

import com.example.application.data.entity.DailyLivingSkills;
import com.example.application.data.entity.Observation;
import com.example.application.holders.FormHolders;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;



public class DailyLivingSkillsDataForm extends FormLayout {
    private TextField skillsBathing = new TextField("Bathing");
    private TextField skillsPersonalHygiene = new TextField("Personal Hygiene");
    private TextField skillsCognition = new TextField("Cognition");
    private TextField skillsDressing = new TextField("Dressing");
    private TextField skillsGrooming = new TextField("Grooming");
    private TextField skillsEating = new TextField("Eating");
    private TextField skillsElimination = new TextField("Elimination");
    private TextField skillsMobility = new TextField("Mobility");
    private TextField skillsTransfers = new TextField("Transfers");
    private TextField skillsHousekeeping = new TextField("Housekeeping");
    private TextField skillsLaundry = new TextField("Laundry");
    private TextField skillsMealPreparation = new TextField("Meal Preparation");
    private TextField skillsShopping = new TextField("Shopping");
    private TextField skillsTransportation = new TextField("Transportation");

    Binder<DailyLivingSkills> binder = new BeanValidationBinder<>(DailyLivingSkills.class);
    private DailyLivingSkills dailyLivingSkills;
    private Button save = new Button("Save");

    public DailyLivingSkillsDataForm() {
        addClassName("daily-living-skills-data-form");
        binder.bindInstanceFields(this);

        save.addClickListener(e -> validateAndSave());
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        add(skillsBathing, skillsPersonalHygiene, skillsCognition, skillsDressing, skillsGrooming,
                skillsEating, skillsElimination, skillsMobility, skillsTransfers, skillsHousekeeping,
                skillsLaundry, skillsMealPreparation, skillsShopping, skillsTransportation, save);
    }

    public void setDailyLivingSkills(DailyLivingSkills dailyLivingSkills) {
        this.dailyLivingSkills = dailyLivingSkills;
        binder.readBean(dailyLivingSkills);
    }

    private void validateAndSave() {
        try {
            binder.writeBean(dailyLivingSkills);
            dailyLivingSkills.setClientID(FormHolders.getClientInfoHolder().getClientID());
            fireEvent(new DailyLivingSkillsDataForm.SaveEvent(this, dailyLivingSkills));
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

    public static abstract class DailyLivingSkillsDataFormEvent extends ComponentEvent<DailyLivingSkillsDataForm> {
        private DailyLivingSkills dailyLivingSkills;

        protected DailyLivingSkillsDataFormEvent(DailyLivingSkillsDataForm source, DailyLivingSkills dailyLivingSkills) {
            super(source, false);
            this.dailyLivingSkills = dailyLivingSkills;
        }

        public DailyLivingSkills getDailyLivingSkills() {
            return dailyLivingSkills;
        }
    }

    public static class SaveEvent extends DailyLivingSkillsDataForm.DailyLivingSkillsDataFormEvent {
        SaveEvent(DailyLivingSkillsDataForm source, DailyLivingSkills dailyLivingSkills) {
            super(source, dailyLivingSkills);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}