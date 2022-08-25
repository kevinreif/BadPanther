package com.example.application.views.dataforms;

import com.example.application.data.entity.ClientInfo;
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

public class ObservationDataForm extends FormLayout {
    private TextField obsCooperation = new TextField("Cooperation");
    private TextField obsAppearance = new TextField("Appearance");
    private TextField obsGroomingAndHygiene = new TextField("Grooming and Hygiene");
    private TextField obsMotorBehavior = new TextField("Motor Behavior");
    private TextField obsMemory = new TextField("Memory");
    private TextField obsSpeech = new TextField("Speech");
    private TextField obsIntelligence = new TextField("Intelligence");
    private TextField obsMood = new TextField("Mood");
    private TextField obsAffect = new TextField("Affect");
    private TextField obsSuicidalIdeationIntent = new TextField("Suicidal Ideation/Intent");
    private TextField obsAssaultiveIdeation = new TextField("Assaultive Ideation");
    private TextField obsThoughtProcesses = new TextField("Thought Processes");
    private TextField obsThoughtContent = new TextField("Thought Content");
    private TextField obsMotivationForRecovery = new TextField("Motivation for Recovery");
    private TextField obsPeerRelationships = new TextField("Peer Relationships");
    private TextField obsSexualBehavior = new TextField("Sexual Behavior");
    private TextField obsAbuseTraumaNeglect = new TextField("Abuse, Trauma, and Neglect");
    private TextField obsLegalAndCriminalHistory = new TextField("Legal and Criminal History");

    Binder<Observation> binder = new BeanValidationBinder<>(Observation.class);
    private Observation observation;
    private Button save = new Button("Save");

    public ObservationDataForm() {
        addClassName("observation-data-form");
        binder.bindInstanceFields(this);

        save.addClickListener(e -> validateAndSave());
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        add(obsCooperation, obsAppearance,
                obsGroomingAndHygiene, obsMotorBehavior, obsMemory, obsSpeech, obsIntelligence, obsMood,
                obsAffect, obsSuicidalIdeationIntent, obsAssaultiveIdeation, obsThoughtProcesses,
                obsThoughtContent, obsMotivationForRecovery, obsPeerRelationships, obsSexualBehavior,
                obsAbuseTraumaNeglect, obsLegalAndCriminalHistory, save);
    }

    public void setObservation(Observation observation) {
        this.observation = observation;
        binder.readBean(observation);
    }

    private void validateAndSave() {
        try {
            binder.writeBean(observation);
            observation.setClientID(FormHolders.getClientInfoHolder().getClientID());
            fireEvent(new ObservationDataForm.SaveEvent(this, observation));
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

    public static abstract class ObservationDataFormEvent extends ComponentEvent<ObservationDataForm> {
        private Observation observation;

        protected ObservationDataFormEvent(ObservationDataForm source, Observation observation) {
            super(source, false);
            this.observation = observation;
        }

        public Observation getObservation() {
            return observation;
        }
    }

    public static class SaveEvent extends ObservationDataForm.ObservationDataFormEvent {
        SaveEvent(ObservationDataForm source, Observation observation) {
            super(source, observation);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}


