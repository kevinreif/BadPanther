package com.example.application.views.dataforms;

import com.example.application.data.entity.ClientInfo;
import com.example.application.views.AddClientForm;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;

public class ClientInfoDataForm extends FormLayout {
    private TextField clientFirstName = new TextField("First Name");
    private TextField clientLastName = new TextField("Last Name");
    private TextField clientCaregiver = new TextField("Caregiver");
    private DatePicker clientDateOfBirth = new DatePicker("Date of Birth");
    private IntegerField clientAge = new IntegerField("Age");
    private TextField clientContact = new TextField("Contact");
    private TextField clientAltContact = new TextField("Alternate Contact");
    private DatePicker clientDateOfAssessment = new DatePicker("Date of Assessment");
    private TextField clientAssessor = new TextField("Assessor");
    Binder<ClientInfo> binder = new BeanValidationBinder<>(ClientInfo.class);
    private ClientInfo clientInfo;
    private Button save = new Button("Save");

    public ClientInfoDataForm() {
        addClassName("client-info-data-form");
        binder.bindInstanceFields(this);

        save.addClickListener(e -> validateAndSave());
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        add(clientFirstName, clientLastName, clientCaregiver, clientDateOfBirth,
                clientAge, clientContact, clientAltContact, clientDateOfAssessment, clientAssessor, save);
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
        binder.readBean(clientInfo);
    }



    private void validateAndSave() {
        try {
            binder.writeBean(clientInfo);
            fireEvent(new SaveEvent(this, clientInfo));
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

    public static abstract class ClientInfoDataFormEvent extends ComponentEvent<ClientInfoDataForm> {
        private ClientInfo clientInfo;

        protected ClientInfoDataFormEvent(ClientInfoDataForm source, ClientInfo clientInfo) {
            super(source, false);
            this.clientInfo = clientInfo;
        }

        public ClientInfo getClientInfo() {
            return clientInfo;
        }
    }

    public static class SaveEvent extends ClientInfoDataForm.ClientInfoDataFormEvent {
        SaveEvent(ClientInfoDataForm source, ClientInfo clientInfo) {
            super(source, clientInfo);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}
