package com.example.application.views;


import com.example.application.data.entity.ClientInfo;
import com.example.application.security.AuthenticatedUser;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;

import java.util.List;
import java.util.UUID;


public class AddClientForm extends FormLayout {
    private ClientInfo clientInfo;
    TextField clientFirstName = new TextField("First Name");
    TextField clientLastName = new TextField("Last Name");
    Binder<ClientInfo> binder = new BeanValidationBinder<>(ClientInfo.class);

    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");
    AuthenticatedUser authenticatedUser;


    public AddClientForm(AuthenticatedUser authenticateUser) {
        this.authenticatedUser = authenticateUser;
        addClassName("client-form");
        binder.bindInstanceFields(this);
        add(clientFirstName, clientLastName, createButtonsLayout());
    }

    private HorizontalLayout createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        save.addClickListener(event -> validateAndSave());
        delete.addClickListener(event -> fireEvent(new DeleteEvent(this, clientInfo)));
        close.addClickListener(event -> fireEvent(new CloseEvent(this)));

        binder.addStatusChangeListener(e -> save.setEnabled(binder.isValid()));
        return new HorizontalLayout(save, delete, close);
    }

    private void validateAndSave() {
        try {
            binder.writeBean(clientInfo);
            clientInfo.setUserID(authenticatedUser.get().get().getId());
            fireEvent(new SaveEvent(this, clientInfo));
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
        binder.readBean(clientInfo);
    }


    //Events
    public static abstract class ClientInfoFormEvent extends ComponentEvent<AddClientForm> {
        private ClientInfo clientInfo;

        protected ClientInfoFormEvent(AddClientForm source, ClientInfo clientInfo) {
            super(source, false);
            this.clientInfo = clientInfo;
        }

        public ClientInfo getClientInfo() {
            return clientInfo;
        }
    }

    public static class SaveEvent extends ClientInfoFormEvent {
        SaveEvent(AddClientForm source, ClientInfo clientInfo) {
            super(source, clientInfo);
        }
    }

    public static class DeleteEvent extends ClientInfoFormEvent {
        DeleteEvent(AddClientForm source, ClientInfo clientInfo) {
            super(source, clientInfo);
        }
    }

    public static class CloseEvent extends ClientInfoFormEvent {
        CloseEvent(AddClientForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}


