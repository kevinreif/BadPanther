package com.example.application.views.dataforms;

import com.example.application.data.entity.Observation;
import com.example.application.data.entity.SummaryOfHistory;
import com.example.application.holders.FormHolders;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;



public class SummaryOfHistoryDataForm extends FormLayout {
    private TextArea summaryMilestones = new TextArea("Milestones");
    private TextArea summaryDiagnosis = new TextArea("Client Diagnosis(s)");
    private TextArea summaryMedications = new TextArea("Medications");
    private TextArea summaryPsychiatricTreatment = new TextArea("History of Psychiatric Treatment");
    private TextArea summaryFamilyHistory = new TextArea("Family History");
    private TextArea summaryMedicalHistory = new TextArea("History of Medical Treatment");
    private TextArea summarySubstanceAbuseHistory = new TextArea("Substance Abuse History");
    private TextArea summaryLivingSituation = new TextArea("Living Situation");
    private TextArea summarySocialSupport = new TextArea("Social Support");
    private TextArea summarySchoolHistory = new TextArea("School History");
    private TextArea summaryActivitiesOfInterest = new TextArea("Activities of Interest");
    private TextArea summaryLegalAndCriminalHistory = new TextArea("Legal and Criminal History");
    private TextArea summaryEmployment = new TextArea("Employment");
    private TextArea summaryInSchoolSpeech = new TextArea("In School Speech");
    private TextArea summaryCounseling = new TextArea("Counseling");
    private TextArea summaryIndependentSupportPlan = new TextArea("Independent Support Plan");
    private TextArea summaryAssistiveDevices = new TextArea("Assistive Devices");

    Binder<SummaryOfHistory> binder = new Binder<>(SummaryOfHistory.class);
    private SummaryOfHistory summaryOfHistory;
    private Button save = new Button("Save");

    public SummaryOfHistoryDataForm() {
        addClassName("summary-of-history-data-form");
        binder.bindInstanceFields(this);

        save.addClickListener(e -> validateAndSave());
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        add(summaryMilestones, summaryDiagnosis, summaryMedications, summaryPsychiatricTreatment,
                summaryFamilyHistory, summaryMedicalHistory, summarySubstanceAbuseHistory,
                summaryLivingSituation, summarySocialSupport, summarySchoolHistory, summaryActivitiesOfInterest,
                summaryLegalAndCriminalHistory, summaryEmployment, summaryInSchoolSpeech, summaryCounseling,
                summaryIndependentSupportPlan, summaryAssistiveDevices, save);
    }

    public void setSummaryOfHistory(SummaryOfHistory summaryOfHistory) {
        this.summaryOfHistory = summaryOfHistory;
        binder.readBean(summaryOfHistory);
    }

    private void validateAndSave() {
        try {
            binder.writeBean(summaryOfHistory);
            summaryOfHistory.setClientID(FormHolders.getClientInfoHolder().getClientID());
            fireEvent(new SummaryOfHistoryDataForm.SaveEvent(this, summaryOfHistory));
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

    public static abstract class SummaryOfHistoryDataFormEvent extends ComponentEvent<SummaryOfHistoryDataForm> {
        private SummaryOfHistory summaryOfHistory;

        protected SummaryOfHistoryDataFormEvent(SummaryOfHistoryDataForm source, SummaryOfHistory summaryOfHistory) {
            super(source, false);
            this.summaryOfHistory = summaryOfHistory;
        }

        public SummaryOfHistory getSummaryOfHistory() {
            return summaryOfHistory;
        }
    }

    public static class SaveEvent extends SummaryOfHistoryDataForm.SummaryOfHistoryDataFormEvent {
        SaveEvent(SummaryOfHistoryDataForm source, SummaryOfHistory summaryOfHistory) {
            super(source, summaryOfHistory);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}
