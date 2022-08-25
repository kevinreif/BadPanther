package com.example.application.views.newuser;

import com.example.application.data.Role;
import com.example.application.data.entity.User;
import com.example.application.data.service.user.UserRepository;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.security.RolesAllowed;
import java.util.Collections;
import java.util.EnumSet;

@PageTitle("Create New User")
@Route(value = "newuser", layout = MainLayout.class)
@RolesAllowed("ADMIN")
public class NewUserView extends FormLayout {

    private TextField usernameField = new TextField("Username");
    private PasswordField passwordField = new PasswordField("Password");
    private TextField nameField = new TextField("Name");
    private TextField picURLField = new TextField("Profile picture URL");
    private ComboBox<Role> roleBox = new ComboBox<Role>("Role");
    private Button saveButton = new Button("Create User");


    public NewUserView(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        roleBox.setItems(EnumSet.allOf(Role.class));


        add(usernameField, passwordField, nameField, picURLField, roleBox, saveButton);

        saveButton.addClickListener(e -> {
            User user = new User();
            user.setUsername(usernameField.getValue());
            user.setHashedPassword(passwordEncoder.encode(passwordField.getValue()));
            user.setName(nameField.getValue());
            user.setProfilePictureUrl(picURLField.getValue());
            user.setRoles(Collections.singleton(roleBox.getValue()));

            userRepository.save(user);
        });
    }
}
