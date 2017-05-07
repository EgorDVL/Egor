package util;

import bean.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import service.*;

import java.io.FileOutputStream;
import java.util.*;
import java.util.List;

/**
 * Created by Egor on 26.01.2017.
 */
public class CreateReleasePDF {

    private static String FILE = "D://Java//Java_Idea//Hospital//";

    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 14,
            Font.BOLD, BaseColor.RED);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);

    private static DateUtils dateUtils = new DateUtils(DateUtils.YEAR_MONTH_DAY);

    private PatientService patientService;
    private HospitalCardService hospitalCardService;
    private HealingService healingService;
    private DiagnosisService diagnosisService;
    private AppointmentService appointmentService;
    private OperationService operationService;
    private MedicamentService medicamentService;
    private ProceduresService proceduresService;

    public CreateReleasePDF(PatientService patientService, HospitalCardService hospitalCardService,
                            HealingService healingService, DiagnosisService diagnosisService,
                            AppointmentService appointmentService, OperationService operationService,
                            MedicamentService medicamentService, ProceduresService proceduresService) {
        this.patientService = patientService;
        this.hospitalCardService = hospitalCardService;
        this.healingService = healingService;
        this.diagnosisService = diagnosisService;
        this.appointmentService = appointmentService;
        this.operationService = operationService;
        this.medicamentService = medicamentService;
        this.proceduresService = proceduresService;
    }


    public void createRelease(int patientId) {
        Patient patient = patientService.getPatientById(patientId);
        HospitalCard hospitalCard = hospitalCardService.getHospitalCardByPatientId(patientId);

        // find last healing and return them
        Healing healing = healingService.getLastPatientHealing(hospitalCard.getHospitalCardId());
        Diagnosis diagnosis = diagnosisService.getDiagnosisById(healing.getDiagnosisId());
        Appointment appointment = appointmentService.getAppointmentById(healing.getAppointmentId());
        Operation operation = operationService.getOperationById(appointment.getOperationId());
        Medicament medicament = medicamentService.getMedicamentById(appointment.getMedicamentId());
        Procedures procedures = proceduresService.getProceduresById(appointment.getProceduresId());

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE + patient.getSurname() + "_" + dateUtils.format(new Date()) + ".pdf"));
            document.open();
            addMetaData(document);
            addTitlePage(document, patient.getSurname(), patient.getName());
            addContent(document, patient, healing, diagnosis, appointment, operation, medicament, procedures);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addMetaData(Document document) {
        document.addTitle("Release patient");
        document.addSubject("Using iText");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Admin");
        document.addCreator("Admin");
    }

    private static void addTitlePage(Document document, String surname, String name)
            throws DocumentException {
        Paragraph paragraph = new Paragraph();
        paragraph.setAlignment(Element.ALIGN_CENTER);
        paragraph.add(new Paragraph("Release patient - " + surname + " " + name, catFont));

        addEmptyLine(paragraph, 1);
        paragraph.add(new Paragraph(
                "Report issued by : Hospital №1 , Kharkiv, Akhsarova 14 " + ", " + new Date(),
                smallBold));
        addEmptyLine(paragraph, 2);
        paragraph.add(new Paragraph(
                "The document confirms that " + surname + " " + name + " was treated in the Hospital № 1, Kharkiv",
                smallBold));
        document.add(paragraph);
    }

    private static void addContent(Document document,
                                   Patient patient,
                                   Healing healing,
                                   Diagnosis diagnosis,
                                   Appointment appointment,
                                   Operation operation,
                                   Medicament medicament,
                                   Procedures procedures) throws DocumentException {

        Anchor anchor = new Anchor("Medical history", catFont);
        anchor.setName("Medical history");

        Chapter catPart = new Chapter(new Paragraph(anchor), 1);


        Paragraph subParagraph = new Paragraph("FIO", subFont);
        Section subCatPart = catPart.addSection(subParagraph);
        subCatPart.add(new Paragraph("Name - " + patient.getName()));
        subCatPart.add(new Paragraph("Surname - " + patient.getSurname()));
        subCatPart.add(new Paragraph("date of birth - " + patient.getDateOfBirth().toString()));


        subParagraph = new Paragraph("Healing", subFont);
        subCatPart = catPart.addSection(subParagraph);
        subCatPart.add(new Paragraph("Symptoms - " + healing.getSymptoms()));
        subCatPart.add(new Paragraph("Healing start - " + healing.getDateHealingStart().toString()));
        subCatPart.add(new Paragraph("Healing end - " + healing.getDateHealingEnd().toString()));


        subParagraph = new Paragraph("Diagnosis", subFont);
        subCatPart = catPart.addSection(subParagraph);
        subCatPart.add(new Paragraph("Diagnosis - " + diagnosis.getNameDiagnos()));


        subParagraph = new Paragraph("Appointment", subFont);
        subCatPart = catPart.addSection(subParagraph);
        subCatPart.add(new Paragraph("Date appointment - " + appointment.getDateAppointment()));


        if (operation != null) {
            subParagraph = new Paragraph("Operation", subFont);
            subCatPart = catPart.addSection(subParagraph);
            subCatPart.add(new Paragraph("Operation name - " + operation.getNameOperation()));
            subCatPart.add(new Paragraph("Date operation - " + operation.getDateOperation()));
        }
        if (medicament != null) {
            subParagraph = new Paragraph("Medicament", subFont);
            subCatPart = catPart.addSection(subParagraph);
            subCatPart.add(new Paragraph("Medicament - " + medicament.getNameMedicament()));
            subCatPart.add(new Paragraph("Type - " + medicament.getMedicamentEnum().toString()));
            subCatPart.add(new Paragraph("Use - " + medicament.getUseMedicament()));
            subCatPart.add(new Paragraph("Date start - " + medicament.getDateStartMedicament()));
            subCatPart.add(new Paragraph("Date end - " + medicament.getDateEndMedicament()));
        }
        if (procedures != null) {
            subParagraph = new Paragraph("Procedures", subFont);
            subCatPart = catPart.addSection(subParagraph);
            subCatPart.add(new Paragraph("Procedures - " + procedures.getNameProcedure()));
            subCatPart.add(new Paragraph("Use - " + procedures.getUseProcedure()));
            subCatPart.add(new Paragraph("Date start - " + procedures.getDateStartProcedure()));
            subCatPart.add(new Paragraph("Date end - " + procedures.getDateEndProcedure()));
        }
        document.add(catPart);
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}