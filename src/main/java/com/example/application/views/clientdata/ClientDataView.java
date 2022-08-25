package com.example.application.views.clientdata;

import com.example.application.data.Role;
import com.example.application.data.entity.*;
import com.example.application.data.service.behavior.BehaviorService;
import com.example.application.data.service.caregiverInterview.CaregiverInterviewService;
import com.example.application.data.service.clientInfo.ClientInfoService;
import com.example.application.data.service.dailyLivingSkills.DailyLivingSkillsService;
import com.example.application.data.service.observation.ObservationService;
import com.example.application.data.service.summaryOfHistory.SummaryOfHistoryService;
import com.example.application.holders.FormHolders;
import com.example.application.report.FBA;
import com.example.application.views.AddClientForm;
import com.example.application.views.MainLayout;
import com.example.application.views.dataforms.*;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.apache.commons.math3.stat.descriptive.summary.Sum;

import javax.annotation.security.PermitAll;
import java.io.IOException;
import java.util.List;


@PageTitle("Client Data")
@Route(value = "data", layout = MainLayout.class)
@PermitAll
public class ClientDataView extends VerticalLayout {
    private ClientInfo clientInfo;
    private Observation observation;
    private Grid<Behavior> behaviorGrid = new Grid<>(Behavior.class);
    ClientInfoService clientInfoService;
    ObservationService observationService;
    CaregiverInterviewService caregiverInterviewService;
    DailyLivingSkillsService dailyLivingSkillsService;
    BehaviorService behaviorService;
    SummaryOfHistoryService summaryOfHistoryService;
    ClientInfoDataForm clientInfoDataForm;
    ObservationDataForm observationDataForm;
    CaregiverInterviewDataForm caregiverInterviewDataForm;
    DailyLivingSkillsDataForm dailyLivingSkillsDataForm;
    BehaviorDataForm behaviorDataForm;
    SummaryOfHistoryDataForm summaryOfHistoryDataForm;
    VerticalLayout behaviorLayout = new VerticalLayout();
    Accordion accordion = new Accordion();
    Button runReport = new Button("Run FBA");




    public ClientDataView(ClientInfoService clientInfoService,
                          ObservationService observationService,
                          CaregiverInterviewService caregiverInterviewService,
                          DailyLivingSkillsService dailyLivingSkillsService,
                          BehaviorService behaviorService,
                          SummaryOfHistoryService summaryOfHistoryService) {
        this.clientInfoService = clientInfoService;
        this.observationService = observationService;
        this.caregiverInterviewService = caregiverInterviewService;
        this.dailyLivingSkillsService = dailyLivingSkillsService;
        this.behaviorService = behaviorService;
        this.summaryOfHistoryService = summaryOfHistoryService;




        clientInfo = FormHolders.getClientInfoHolder();
        observation = observationService.getObservationByClient(FormHolders.getClientInfoHolder().getClientID());

        setSizeFull();



        configureClientInfoForm();
        configureObservationForm();
        configureCaregiverInterviewForm();
        configureDailyLivingSkillsForm();
        configureSummaryOfHistoryForm();
        configureBehaviorForm();
        configureBehaviorGrid();

        accordion.add("Client Info", clientInfoDataForm);
        accordion.add("Summary of Individual's History", summaryOfHistoryDataForm);
        accordion.add("Observation", observationDataForm);
        accordion.add("Caregiver Interview", caregiverInterviewDataForm);
        accordion.add("Daily Living Skills", dailyLivingSkillsDataForm);
        accordion.add("Challenging Behavior(s)", behaviorLayout);

        runReport.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        runReport.addClickListener(e -> {
            try {
                FBA.createDoc(clientInfo, observation);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        add(accordion, runReport);


        clientInfoDataForm.setClientInfo(FormHolders.getClientInfoHolder());
        setObservation();
        setCaregiverInterview();
        setDailyLivingSkills();
        setSummaryOfHistory();

        behaviorLayout.add(getToolBar(), getContent());
        behaviorLayout.setSizeFull();

        updateList();
        closeEditor();

    }

    //ClientInfo
    private void configureClientInfoForm() {
        clientInfoDataForm = new ClientInfoDataForm();
        clientInfoDataForm.addListener(ClientInfoDataForm.SaveEvent.class, this::saveClientInfo);
    }

    private void saveClientInfo(ClientInfoDataForm.SaveEvent event) {
        clientInfoService.update(event.getClientInfo());
    }

    //Observation
    private void configureObservationForm() {
        observationDataForm = new ObservationDataForm();
        observationDataForm.addListener(ObservationDataForm.SaveEvent.class, this::saveObservation);
    }

    private void saveObservation(ObservationDataForm.SaveEvent event) {
        observationService.update(event.getObservation());
    }

    private void setObservation() {
        Observation observation = observationService.getObservationByClient(FormHolders.getClientInfoHolder().getClientID());
        if (observation == null) {
            observationDataForm.setObservation(new Observation());
        } else {
            observationDataForm.setObservation(observation);
        }
    }

    //Caregiver Interview
    private void configureCaregiverInterviewForm() {
        caregiverInterviewDataForm = new CaregiverInterviewDataForm();
        caregiverInterviewDataForm.addListener(CaregiverInterviewDataForm.SaveEvent.class, this::saveCaregiverInterview);
    }

    private void saveCaregiverInterview(CaregiverInterviewDataForm.SaveEvent event) {
        caregiverInterviewService.update(event.getCaregiverInterview());
    }

    private void setCaregiverInterview() {
        CaregiverInterview caregiverInterview = caregiverInterviewService.getCaregiverInterviewByClient(FormHolders.getClientInfoHolder().getClientID());
        if (caregiverInterview == null) {
            caregiverInterviewDataForm.setCaregiverInterview(new CaregiverInterview());
        } else {
            caregiverInterviewDataForm.setCaregiverInterview(caregiverInterview);
        }
    }

    //Summary of History
    private void configureSummaryOfHistoryForm() {
        summaryOfHistoryDataForm = new SummaryOfHistoryDataForm();
        summaryOfHistoryDataForm.addListener(SummaryOfHistoryDataForm.SaveEvent.class, this::saveSummaryOfHistory);
    }

    private void saveSummaryOfHistory(SummaryOfHistoryDataForm.SaveEvent event) {
        summaryOfHistoryService.update(event.getSummaryOfHistory());
    }

    private void setSummaryOfHistory() {
        SummaryOfHistory summaryOfHistory = summaryOfHistoryService.getSummaryOfHistoryByClient(FormHolders.getClientInfoHolder().getClientID());
        if (summaryOfHistory == null) {
            summaryOfHistoryDataForm.setSummaryOfHistory(new SummaryOfHistory());
        } else {
            summaryOfHistoryDataForm.setSummaryOfHistory(summaryOfHistory);
        }
    }

    //Daily Living Skills
    private void configureDailyLivingSkillsForm() {
        dailyLivingSkillsDataForm = new DailyLivingSkillsDataForm();
        dailyLivingSkillsDataForm.addListener(DailyLivingSkillsDataForm.SaveEvent.class, this::saveDailyLivingSkills);
    }

    private void saveDailyLivingSkills(DailyLivingSkillsDataForm.SaveEvent event) {
        dailyLivingSkillsService.update(event.getDailyLivingSkills());
    }

    private void setDailyLivingSkills() {
        DailyLivingSkills dailyLivingSkills = dailyLivingSkillsService.getDailyLivingSkillsByClient(FormHolders.getClientInfoHolder().getClientID());
        if (dailyLivingSkills == null) {
            dailyLivingSkillsDataForm.setDailyLivingSkills(new DailyLivingSkills());
        } else {
            dailyLivingSkillsDataForm.setDailyLivingSkills(dailyLivingSkills);
        }
    }

    //Behavior
    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(behaviorGrid, behaviorDataForm);
        content.setFlexGrow(2, behaviorGrid);
        content.setFlexGrow(1, behaviorDataForm);
        content.addClassName("behavior-list-content");
        content.setSizeFull();
        return content;
    }

    private void configureBehaviorForm() {
        behaviorDataForm = new BehaviorDataForm();
        behaviorDataForm.addListener(BehaviorDataForm.SaveEvent.class, this::saveBehavior);
        behaviorDataForm.addListener(BehaviorDataForm.DeleteEvent.class, this::deleteBehavior);
        behaviorDataForm.addListener(BehaviorDataForm.CloseEvent.class, e -> closeEditor());
    }

    private void saveBehavior(BehaviorDataForm.SaveEvent event) {
        behaviorService.update(event.getBehavior());
        updateList();
        closeEditor();
    }

    private void deleteBehavior(BehaviorDataForm.DeleteEvent event) {
        behaviorService.delete((event.getBehavior()));
        updateList();
        closeEditor();
    }

    private HorizontalLayout getToolBar() {
        Button addBehaviorButton = new Button("Add Behavior");
        addBehaviorButton.addClickListener(click -> addBehavior());

        HorizontalLayout toolbar = new HorizontalLayout(addBehaviorButton);
        toolbar.addClassName("behavior-list-toolbar");
        return toolbar;
    }

    public void editBehavior(Behavior behavior) {
        if (behavior == null) {
            closeEditor();
        } else {
            behaviorDataForm.setBehavior(behavior);
            behaviorDataForm.setVisible(true);
            addClassName("editing");
        }
    }

    private void closeEditor() {
        behaviorDataForm.setBehavior(null);
        behaviorDataForm.setVisible(false);
        removeClassName("editing");
    }

    private void addBehavior() {
        behaviorGrid.asSingleSelect().clear();
        editBehavior(new Behavior());
    }

    private void updateList() {
            behaviorGrid.setItems(behaviorService.getBehaviorsByClient(FormHolders.getClientInfoHolder().getClientID()));
    }

    private void configureBehaviorGrid() {
        behaviorGrid.addClassName("behavior-list");
        behaviorGrid.setColumns("behaviorName");
        behaviorGrid.getColumns().forEach(col -> col.setAutoWidth(true));

        behaviorGrid.asSingleSelect().addValueChangeListener(event ->
                editBehavior(event.getValue()));
    }

}
