package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Scale;

public class PrescriptionController implements Initializable{

    @FXML
    private Label MED1;

    @FXML
    private TextField MED1TXT;

    @FXML
    private Label MED2;

    @FXML
    private TextField MED2TXT;

    @FXML
    private Label MED3;

    @FXML
    private TextField MED3TXT;

    @FXML
    private Label TREATMENT;

    @FXML
    private StackPane panelToprint;
    
    @FXML
    private TextArea TRT;
    
    @FXML
    private void ConfirmBtn() {
    	MED1.setText(MED1TXT.getText());
    	MED2.setText(MED2TXT.getText());
    	MED3.setText(MED3TXT.getText());
    	TREATMENT.setText(TRT.getText());
    	
    }
    
    
    
    
    
    @FXML
    private void print_A() {
        Printer printer = Printer.getDefaultPrinter();
        PageLayout pageLayout = printer.createPageLayout(Paper.A4, PageOrientation.PORTRAIT, Printer.MarginType.DEFAULT);

        PrinterJob printerJob = PrinterJob.createPrinterJob();
        if (printerJob != null) {
            if (printerJob.showPrintDialog(panelToprint.getScene().getWindow())) {
                boolean success = printerJob.printPage(pageLayout, panelToprint);
                if (success) {
                    printerJob.endJob();
                }
            }
            
            // Cleanup after printing
            panelToprint.getTransforms().clear();
            panelToprint.setTranslateX(0);
            panelToprint.setTranslateY(0);
        }
    }


    @FXML
    private Label name;
    @FXML
    private Label Date;
    @FXML
    private Label age;
    @FXML
    private Label doctor;

    @FXML
    private Label doctor_s;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Set_P();
    }
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    public void Set_P() {
        String sql = "SELECT specialized FROM doctor WHERE doctor_id = ?";
        connect = Database.connectDB();
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, Data.doctor_id);
            result = prepare.executeQuery();
            if (result.next()) { // Move the cursor to the first row
                String temp_doctorSpecialized = result.getString("specialized");
                this.doctor.setText(Data.doctor_name);
                this.doctor_s.setText(temp_doctorSpecialized);
 //               this.age.setText(PatientsData.age);
                this.Date.setText(format.format(new java.util.Date()));
                
//                this.name.setText(PatientsData.fullName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}