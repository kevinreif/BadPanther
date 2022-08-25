package com.example.application.views.dataforms;

import com.example.application.data.entity.CaregiverInterview;

import com.example.application.data.entity.Observation;
import com.example.application.holders.FormHolders;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;

public class CaregiverInterviewDataForm extends FormLayout {
    private TextArea carePresentingConcerns = new TextArea("Presenting Concerns");
    private TextArea careImmediateNeedsRisks = new TextArea("Immediate Needs/Risks");
    private TextField careCurrentTreatments = new TextField("Current Treatments");
    private TextField carePreviousTreatments = new TextField("Previous Treatments");
    private TextField carePsychosocialHistory = new TextField("Psychosocial History");
    private TextField careLegalAndCriminalHistory = new TextField("Legal and Criminal History");
    private TextField careClientDiagnosis = new TextField("Client Diagnosis(s)");
    private TextField careMedications = new TextField("Medications");
    private TextField careHistoryOfPsychiatricTreatment = new TextField("History of Psychiatric Treatment");
    private TextField careFamilyPsychologicalHistory = new TextField("Family Psychological History");
    private TextField careHistoryOfMedicalTreatment = new TextField("History of Medical Treatment");
    private TextField careSubstanceAbuseHistory = new TextField("History of Substance Abuse");
    private TextArea careIndividualStrengths = new TextArea("Individual Strengths");
    private TextArea careIndividualPreferenceForSupports = new TextArea("Individual's Preference");
    private TextArea careCulturalConcerns = new TextArea("Cultural Concerns");
    private TextArea careSupportSystems = new TextArea("Support Systems");

    Binder<CaregiverInterview> binder = new BeanValidationBinder<>(CaregiverInterview.class);
    private CaregiverInterview caregiverInterview;
    private Button save = new Button("Save");

    public CaregiverInterviewDataForm() {
        addClassName("caregiver-interview-data-form");
        binder.bindInstanceFields(this);

        save.addClickListener(e -> validateAndSave());
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        add(carePresentingConcerns,
                careImmediateNeedsRisks, careCurrentTreatments, carePreviousTreatments, carePsychosocialHistory,
                careLegalAndCriminalHistory, careClientDiagnosis, careMedications, careHistoryOfPsychiatricTreatment,
                careFamilyPsychologicalHistory, careHistoryOfMedicalTreatment, careSubstanceAbuseHistory,
                careIndividualStrengths, careIndividualPreferenceForSupports, careCulturalConcerns,
                careSupportSystems, save);
    }

    public void setCaregiverInterview(CaregiverInterview caregiverInterview) {
        this.caregiverInterview = caregiverInterview;
        binder.readBean(caregiverInterview);
    }

    private void validateAndSave() {
        try {
            binder.writeBean(caregiverInterview);
            caregiverInterview.setClientID(FormHolders.getClientInfoHolder().getClientID());
            fireEvent(new CaregiverInterviewDataForm.SaveEvent(this, caregiverInterview));
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

    public static abstract class CaregiverInterviewDataFormEvent extends ComponentEvent<CaregiverInterviewDataForm> {
        private CaregiverInterview caregiverInterview;

        protected CaregiverInterviewDataFormEvent(CaregiverInterviewDataForm source, CaregiverInterview caregiverInterview) {
            super(source, false);
            this.caregiverInterview = caregiverInterview;
        }

        public CaregiverInterview getCaregiverInterview() {
            return caregiverInterview;
        }
    }

    public static class SaveEvent extends CaregiverInterviewDataForm.CaregiverInterviewDataFormEvent {
        SaveEvent(CaregiverInterviewDataForm source, CaregiverInterview caregiverInterview) {
            super(source, caregiverInterview);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}
