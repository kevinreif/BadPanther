package com.example.application.views.dataforms;

import com.example.application.data.entity.Behavior;
import com.example.application.data.entity.CaregiverInterview;
import com.example.application.data.entity.ClientInfo;
import com.example.application.holders.FormHolders;
import com.example.application.views.AddClientForm;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;
import org.apache.poi.ss.formula.functions.T;

public class BehaviorDataForm extends FormLayout {
    private TextField behaviorName = new TextField("Behavior Name");
    private TextArea behaviorResultsOfAssessment = new TextArea("Results of Indirect Functional Assessment");
    private TextField behaviorDuration = new TextField("Duration");
    private TextField behaviorFrequency = new TextField("Frequency");
    private TextField behaviorIntensity = new TextField("Intensity");
    private TextField behaviorSeverity = new TextField("Severity");
    private TextField behaviorTriggers = new TextField("Triggers");
    private TextField behaviorAntecedents = new TextField("Antecedents");
    private TextField behaviorConsequences = new TextField("Consequences");
    private TextField behaviorAlternativeBehavior = new TextField("Functionally Appropriate Alternative Behavior");
    private TextField behaviorAttemptToCommunicate = new TextField("Attempt To Communicate");
    private TextField behaviorResultOfCondition = new TextField("Result of Medical or Mental Health Condition");
    private TextField behaviorTraumaResponse = new TextField("Trauma Response");
    private TextField behaviorControlMaintained = new TextField("Control Maintained");
    private TextArea behaviorMostLikelyToOccur = new TextArea("Context Challenging Behavior is Most Likely to Occur");
    private TextArea behaviorLeastLikelyToOccur = new TextArea("Context Challenging Behavior is Least Likely to Occur");
    private TextArea behaviorAssessmentAcrossEnvironments = new TextArea("Assessment Across Environments");
    private TextArea behaviorObservationNotes = new TextArea("Observation Notes");
    private TextArea behaviorHypothesizedFunctions = new TextArea("Hypothesized Function(s)");

    Binder<Behavior> binder = new BeanValidationBinder<>(Behavior.class);
    private Behavior behavior;
    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");

    public BehaviorDataForm() {
        addClassName("behavior-data-form");
        binder.bindInstanceFields(this);


        add(behaviorName, behaviorResultsOfAssessment, behaviorDuration, behaviorFrequency, behaviorIntensity, behaviorSeverity,
                behaviorTriggers, behaviorAntecedents, behaviorConsequences, behaviorAlternativeBehavior,
                behaviorAttemptToCommunicate, behaviorResultOfCondition, behaviorTraumaResponse, behaviorControlMaintained,
                behaviorMostLikelyToOccur, behaviorLeastLikelyToOccur, behaviorAssessmentAcrossEnvironments,
                behaviorObservationNotes, behaviorHypothesizedFunctions, createButtonsLayout());

    }

    private HorizontalLayout createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        save.addClickListener(event -> validateAndSave());
        delete.addClickListener(event -> fireEvent(new BehaviorDataForm.DeleteEvent(this, behavior)));
        close.addClickListener(event -> fireEvent(new BehaviorDataForm.CloseEvent(this)));

        binder.addStatusChangeListener(e -> save.setEnabled(binder.isValid()));
        return new HorizontalLayout(save, delete, close);
    }



    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
        binder.readBean(behavior);
    }

    private void validateAndSave() {
        try {
            binder.writeBean(behavior);
            behavior.setClientID(FormHolders.getClientInfoHolder().getClientID());
            fireEvent(new BehaviorDataForm.SaveEvent(this, behavior));
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

    public static abstract class BehaviorDataFormEvent extends ComponentEvent<BehaviorDataForm> {
        private Behavior behavior;

        protected BehaviorDataFormEvent(BehaviorDataForm source, Behavior behavior) {
            super(source, false);
            this.behavior = behavior;
        }

        public Behavior getBehavior() {
            return behavior;
        }
    }

    public static class SaveEvent extends BehaviorDataForm.BehaviorDataFormEvent {
        SaveEvent(BehaviorDataForm source, Behavior behavior) {
            super(source, behavior);
        }
    }

    public static class DeleteEvent extends BehaviorDataForm.BehaviorDataFormEvent {
        DeleteEvent(BehaviorDataForm source, Behavior behavior) {
            super(source, behavior);
        }
    }

    public static class CloseEvent extends BehaviorDataForm.BehaviorDataFormEvent {
        CloseEvent(BehaviorDataForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}
