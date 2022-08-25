package com.example.application.views.newClient;

import com.example.application.data.Role;
import com.example.application.data.entity.ClientInfo;
import com.example.application.data.entity.User;
import com.example.application.data.service.clientInfo.ClientInfoService;
import com.example.application.holders.FormHolders;
import com.example.application.security.AuthenticatedUser;
import com.example.application.views.AddClientForm;
import com.example.application.views.MainLayout;
import com.example.application.views.clientdata.ClientDataView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.security.PermitAll;
import java.util.Optional;
import java.util.UUID;

@PageTitle("Client List")
@Route(value = "hello", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@PermitAll
public class NewClientView extends VerticalLayout {
    private Grid<ClientInfo> grid = new Grid<>(ClientInfo.class);
    TextField filterText = new TextField();
    AddClientForm addClientForm;
    ClientInfoService clientInfoService;
    private AuthenticatedUser authenticatedUser;
    Optional<User> loggedInUser;

    Button select = new Button("Select");

    public NewClientView(AuthenticatedUser authenticatedUser, ClientInfoService clientInfoService) {
        this.authenticatedUser = authenticatedUser;
        this.clientInfoService = clientInfoService;
        loggedInUser = authenticatedUser.get();
        addClassName("client-list-view");
        setSizeFull();
        configureGrid();
        configureForm();

        add(getToolBar(), getContent(), select);
        updateList();
        closeEditor();

        select.addClickListener(e -> setClientAndGoToData());
        select.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

    }

    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(grid, addClientForm);
        content.setFlexGrow(2, grid);
        content.setFlexGrow(1, addClientForm);
        content.addClassName("client-list-content");
        content.setSizeFull();
        return content;

    }

    private void configureForm() {
        addClientForm = new AddClientForm(authenticatedUser);
        addClientForm.setWidth("25em");
        addClientForm.addListener(AddClientForm.SaveEvent.class, this::saveClient);
        addClientForm.addListener(AddClientForm.DeleteEvent.class, this::deleteClient);
        addClientForm.addListener(AddClientForm.CloseEvent.class, e -> closeEditor());
    }

    private void saveClient(AddClientForm.SaveEvent event) {
        clientInfoService.update(event.getClientInfo());
        updateList();
        closeEditor();
    }

    private void deleteClient(AddClientForm.DeleteEvent event) {
        clientInfoService.delete((event.getClientInfo()));
        updateList();
        closeEditor();
    }

    private void configureGrid() {
        grid.addClassName("client-list");
        grid.setSizeFull();
        grid.setColumns("clientFirstName", "clientLastName");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));

        grid.asSingleSelect().addValueChangeListener(event ->
                editClientInfo(event.getValue()));
    }

    private HorizontalLayout getToolBar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());

        Button addClientButton = new Button("Add Client");
        addClientButton.addClickListener(click -> addClientInfo());

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addClientButton);
        toolbar.addClassName("client-list-toolbar");
        return toolbar;
    }

    public void editClientInfo(ClientInfo clientInfo) {
        if (clientInfo == null) {
            closeEditor();
        } else {
            addClientForm.setClientInfo(clientInfo);
            addClientForm.setVisible(true);
            addClassName("editing");
        }
    }

    private void closeEditor() {
        addClientForm.setClientInfo(null);
        addClientForm.setVisible(false);
        removeClassName("editing");
    }

    private void addClientInfo() {
        grid.asSingleSelect().clear();
        editClientInfo(new ClientInfo());
    }

    private UUID getLoggedInUserID() {
        UUID id = null;
        if (loggedInUser.isPresent()) {
            id = loggedInUser.get().getId();
        }
        return id;
    }

    private void updateList() {
        if (loggedInUser.get().getRoles().contains(Role.ADMIN)) {
            grid.setItems(clientInfoService.findAllClients(filterText.getValue()));
        } else {
            grid.setItems(clientInfoService.findAllClientsByUser(filterText.getValue(), loggedInUser.get().getId()));
        }
    }

    private void setClientAndGoToData() {
        if (grid.asSingleSelect().isEmpty()) {
            return;
        } else {
            FormHolders.setClientInfoHolder(grid.asSingleSelect().getValue());
            ClientInfo saved = grid.asSingleSelect().getValue();
            UI.getCurrent().navigate("data");
        }
    }




}
