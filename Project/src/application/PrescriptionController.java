package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.control.Label;
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
    private void ConfirmBtn() {
    	MED1.setText(MED1TXT.getText());
    	MED2.setText(MED2TXT.getText());
    	MED3.setText(MED3TXT.getText());
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




	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}