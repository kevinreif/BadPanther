package com.example.application.report;

import com.example.application.data.entity.ClientInfo;
import com.example.application.data.entity.Observation;
import com.example.application.views.dataforms.ClientInfoDataForm;
import org.apache.poi.wp.usermodel.HeaderFooterType;
import org.apache.poi.xwpf.usermodel.*;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FBA {

    public static void createDoc(ClientInfo clientInfo, Observation observation) throws IOException {
        XWPFDocument document = new XWPFDocument();
        String docName = clientInfo.getClientFirstName() + " " + clientInfo.getClientLastName() + " FBA.docx";

        //XWPFDocument template = new XWPFDocument(new FileInputStream("/FBA_template/FBA_template.docx"));
        //XWPFStyles newStyles = document.createStyles();
        //XWPFStyle heading1 = template.getStyles().getStyle("Heading1");
        //newStyles.addStyle(heading1);


        File file = new File(docName);
        file.delete();
        file.createNewFile();

        FileOutputStream out = new FileOutputStream(file);


        generateHeader(clientInfo, document);
        writeClientInfo(clientInfo, document/*, heading1*/);
        //writeObservation(observation, document);


        document.write(out);
        out.close();
        if (!Desktop.isDesktopSupported()) {
            System.out.println("Desktop not supported");
        } else {

            Desktop.getDesktop().open(file);
        }

    }

    private static void generateHeader(ClientInfo clientInfo, XWPFDocument document) {
        XWPFHeader header = document.createHeader(HeaderFooterType.DEFAULT);
        header.createParagraph().createRun().setText(clientInfo.getClientLastName() + ", " +
                clientInfo.getClientFirstName() + " FBA");
    }

    private static void writeClientInfo(ClientInfo clientInfo, XWPFDocument document /*XWPFStyle heading1*/) {
        XWPFTable table = document.createTable(9, 2);

        XWPFParagraph clientInfoHeading = document.createParagraph();
        XWPFRun run = clientInfoHeading.createRun();
        //run.setStyle(heading1.getStyleId());
        run.setText("Client Info");


        int rowNumber = 0;

        table.getRow(rowNumber).getCell(0).setText("First Name: ");
        table.getRow(rowNumber).getCell(1).setText(clientInfo.getClientFirstName());
        rowNumber++;
        table.getRow(rowNumber).getCell(0).setText("Last Name: ");
        table.getRow(rowNumber).getCell(1).setText(clientInfo.getClientLastName());
        rowNumber++;
        table.getRow(rowNumber).getCell(0).setText("Caregiver: ");
        table.getRow(rowNumber).getCell(1).setText(clientInfo.getClientCaregiver());
        rowNumber++;
        table.getRow(rowNumber).getCell(0).setText("Date of Birth: ");
        table.getRow(rowNumber).getCell(1).setText(clientInfo.getClientDateOfBirth().toString());
        rowNumber++;
        table.getRow(rowNumber).getCell(0).setText("Age: ");
        table.getRow(rowNumber).getCell(1).setText(String.valueOf(clientInfo.getClientAge()));
        rowNumber++;
        table.getRow(rowNumber).getCell(0).setText("Contact: ");
        table.getRow(rowNumber).getCell(1).setText(clientInfo.getClientContact());
        rowNumber++;
        table.getRow(rowNumber).getCell(0).setText("Alternate Contact: ");
        table.getRow(rowNumber).getCell(1).setText(clientInfo.getClientAltContact());
        rowNumber++;
        table.getRow(rowNumber).getCell(0).setText("Date of Assessment: ");
        table.getRow(rowNumber).getCell(1).setText(clientInfo.getClientDateOfAssessment().toString());
        rowNumber++;
        table.getRow(rowNumber).getCell(0).setText("Assessor: ");
        table.getRow(rowNumber).getCell(1).setText(clientInfo.getClientAssessor());
    }

    private static void writeObservation(Observation observation, XWPFDocument document) {
        XWPFTable table = document.createTable(18, 2);
        int rowNumber = 0;

        table.getRow(rowNumber).getCell(0).setText("Cooperation: ");
        table.getRow(rowNumber).getCell(1).setText(observation.getObsCooperation());
        rowNumber++;
        table.getRow(rowNumber).getCell(0).setText("Appearance: ");
        table.getRow(rowNumber).getCell(1).setText(observation.getObsAppearance());
        rowNumber++;
        table.getRow(rowNumber).getCell(0).setText("Grooming and Hygiene: ");
        table.getRow(rowNumber).getCell(1).setText(observation.getObsGroomingAndHygiene());
        rowNumber++;
        table.getRow(rowNumber).getCell(0).setText("Motor Behavior: ");
        table.getRow(rowNumber).getCell(1).setText(observation.getObsMotorBehavior());
        rowNumber++;
        table.getRow(rowNumber).getCell(0).setText("Memory: ");
        table.getRow(rowNumber).getCell(1).setText(observation.getObsMemory());
        rowNumber++;
        table.getRow(rowNumber).getCell(0).setText("Speech: ");
        table.getRow(rowNumber).getCell(1).setText(observation.getObsSpeech());
        rowNumber++;
        table.getRow(rowNumber).getCell(0).setText("Intelligence: ");
        table.getRow(rowNumber).getCell(1).setText(observation.getObsIntelligence());
        rowNumber++;
        table.getRow(rowNumber).getCell(0).setText("Mood: ");
        table.getRow(rowNumber).getCell(1).setText(observation.getObsMood());
        rowNumber++;
        table.getRow(rowNumber).getCell(0).setText("Affect: ");
        table.getRow(rowNumber).getCell(1).setText(observation.getObsAffect());
        rowNumber++;
        table.getRow(rowNumber).getCell(0).setText("Suicidal Ideation/Intent: ");
        table.getRow(rowNumber).getCell(1).setText(observation.getObsSuicidalIdeationIntent());
        rowNumber++;
        table.getRow(rowNumber).getCell(0).setText("Assaultive Ideation: ");
        table.getRow(rowNumber).getCell(1).setText(observation.getObsAssaultiveIdeation());
        rowNumber++;
        table.getRow(rowNumber).getCell(0).setText("Thought Processes: ");
        table.getRow(rowNumber).getCell(1).setText(observation.getObsThoughtProcesses());
        rowNumber++;
        table.getRow(rowNumber).getCell(0).setText("Thought Content: ");
        table.getRow(rowNumber).getCell(1).setText(observation.getObsThoughtContent());
        rowNumber++;
        table.getRow(rowNumber).getCell(0).setText("Motivation for Recovery: ");
        table.getRow(rowNumber).getCell(1).setText(observation.getObsMotivationForRecovery());
        rowNumber++;
        table.getRow(rowNumber).getCell(0).setText("Peer Relationships: ");
        table.getRow(rowNumber).getCell(1).setText(observation.getObsPeerRelationships());
        rowNumber++;
        table.getRow(rowNumber).getCell(0).setText("Sexual Behavior: ");
        table.getRow(rowNumber).getCell(1).setText(observation.getObsSexualBehavior());
        rowNumber++;
        table.getRow(rowNumber).getCell(0).setText("Abuse, Trauma, and Neglect: ");
        table.getRow(rowNumber).getCell(1).setText(observation.getObsAbuseTraumaNeglect());
        rowNumber++;
        table.getRow(rowNumber).getCell(0).setText("Legal and Criminal History: ");
        table.getRow(rowNumber).getCell(1).setText(observation.getObsLegalAndCriminalHistory());

    }
}
