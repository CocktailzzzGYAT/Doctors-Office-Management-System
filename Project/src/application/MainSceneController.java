package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class MainSceneController implements Initializable {
	
	   @FXML
	    private TableColumn<?, ?> appointments_action;

	    @FXML
	    private TableColumn<?, ?> appointments_appointmentID;

	    @FXML
	    private Button appointments_btn;

	    @FXML
	    private TableColumn<?, ?> appointments_contactNumber;

	    @FXML
	    private TableColumn<?, ?> appointments_date;

	    @FXML
	    private TableColumn<?, ?> appointments_dateDelete;

	    @FXML
	    private TableColumn<?, ?> appointments_dateModify;

	    @FXML
	    private TableColumn<?, ?> appointments_description;

	    @FXML
	    private AnchorPane appointments_form;

	    @FXML
	    private TableColumn<?, ?> appointments_gender;

	    @FXML
	    private TableColumn<?, ?> appointments_name;

	    @FXML
	    private TableColumn<?, ?> appointments_status;

	    @FXML
	    private TableView<?> appointments_tableView;

	    @FXML
	    private Label current_form;

	    @FXML
	    private BarChart<?, ?> dashboad_chart_DD;

	    @FXML
	    private AreaChart<?, ?> dashboad_chart_PD;

	    @FXML
	    private TableColumn<?, ?> dashboad_col_doctorID;

	    @FXML
	    private TableColumn<?, ?> dashboad_col_name;

	    @FXML
	    private TableColumn<?, ?> dashboad_col_specialized;

	    @FXML
	    private TableColumn<?, ?> dashboad_col_status;

	    @FXML
	    private TableView<?> dashboad_tableView;

	    @FXML
	    private Label dashboard_AD;

	    @FXML
	    private Label dashboard_AP;

	    @FXML
	    private Label dashboard_TP;

	    @FXML
	    private Button dashboard_btn;

	    @FXML
	    private AnchorPane dashboard_form;

	    @FXML
	    private Label dashboard_tA;

	    @FXML
	    private Label date_time;

	    @FXML
	    private Button doctors_btn;

	    @FXML
	    private TableColumn<?, ?> doctors_col_action;

	    @FXML
	    private TableColumn<?, ?> doctors_col_address;

	    @FXML
	    private TableColumn<?, ?> doctors_col_contactNumber;

	    @FXML
	    private TableColumn<?, ?> doctors_col_doctorID;

	    @FXML
	    private TableColumn<?, ?> doctors_col_email;

	    @FXML
	    private TableColumn<?, ?> doctors_col_gender;

	    @FXML
	    private TableColumn<?, ?> doctors_col_name;

	    @FXML
	    private TableColumn<?, ?> doctors_col_specialization;

	    @FXML
	    private TableColumn<?, ?> doctors_col_status;

	    @FXML
	    private AnchorPane doctors_form;

	    @FXML
	    private TableView<?> doctors_tableView;

	    @FXML
	    private Button logout_btn;

	    @FXML
	    private AnchorPane main_form;

	    @FXML
	    private Label nav_adminID;

	    @FXML
	    private Label nav_username;

	    @FXML
	    private Button patients_btn;

	    @FXML
	    private TableColumn<?, ?> patients_col_action;

	    @FXML
	    private TableColumn<?, ?> patients_col_contactNumber;

	    @FXML
	    private TableColumn<?, ?> patients_col_date;

	    @FXML
	    private TableColumn<?, ?> patients_col_dateDelete;

	    @FXML
	    private TableColumn<?, ?> patients_col_dateModify;

	    @FXML
	    private TableColumn<?, ?> patients_col_description;

	    @FXML
	    private TableColumn<?, ?> patients_col_gender;

	    @FXML
	    private TableColumn<?, ?> patients_col_name;

	    @FXML
	    private TableColumn<?, ?> patients_col_patientID;

	    @FXML
	    private TableColumn<?, ?> patients_col_status;

	    @FXML
	    private AnchorPane patients_form;

	    @FXML
	    private TableView<?> patients_tableView;

	    @FXML
	    private Button payment_btn;

	    @FXML
	    private Button payment_checkoutBtn;

	    @FXML
	    private Circle payment_circle;

	    @FXML
	    private TableColumn<?, ?> payment_col_date;

	    @FXML
	    private TableColumn<?, ?> payment_col_diagnosis;

	    @FXML
	    private TableColumn<?, ?> payment_col_doctor;

	    @FXML
	    private TableColumn<?, ?> payment_col_gender;

	    @FXML
	    private TableColumn<?, ?> payment_col_name;

	    @FXML
	    private TableColumn<?, ?> payment_col_patientID;

	    @FXML
	    private Label payment_date;

	    @FXML
	    private Label payment_doctor;

	    @FXML
	    private AnchorPane payment_form;

	    @FXML
	    private Label payment_name;

	    @FXML
	    private Label payment_patientID;

	    @FXML
	    private TableView<?> payment_tableView;

	    @FXML
	    private TextField profile_adminID;

	    @FXML
	    private Button profile_btn;

	    @FXML
	    private Circle profile_circle;

	    @FXML
	    private TextField profile_email;

	    @FXML
	    private AnchorPane profile_form;

	    @FXML
	    private Button profile_importBtn;

	    @FXML
	    private Label profile_label_adminIO;

	    @FXML
	    private Label profile_label_dateCreated;

	    @FXML
	    private Label profile_label_email;

	    @FXML
	    private Label profile_label_name;

	    @FXML
	    private ComboBox<?> profile_status;

	    @FXML
	    private Button profile_updateBtn;

	    @FXML
	    private TextField profile_username;

	    @FXML
	    private Circle top_profile;

	    @FXML
	    private Label top_username;
	    
	    private Connection connect;
	    private PreparedStatement prepare;
	    private Statement statement;
	    private ResultSet result;
	    
	    
	    
	    
	    public void switchForm(ActionEvent event) {

	        if (event.getSource() == dashboard_btn) {
	            dashboard_form.setVisible(true);
	            doctors_form.setVisible(false);
	            patients_form.setVisible(false);
	            appointments_form.setVisible(false);
	            payment_form.setVisible(false);
	            profile_form.setVisible(false);

	            

	            current_form.setText("Dashboard Form");
	        } else if (event.getSource() == doctors_btn) {
	            dashboard_form.setVisible(false);
	            doctors_form.setVisible(true);
	            patients_form.setVisible(false);
	            appointments_form.setVisible(false);
	            payment_form.setVisible(false);
	            profile_form.setVisible(false);

	            // DISPLAY DOCTORS IN TABLEVIEW
	            //doctorDisplayData();
	            //doctorActionButton();

	            current_form.setText("Doctor's Form");
	        } else if (event.getSource() == patients_btn) {
	            dashboard_form.setVisible(false);
	            doctors_form.setVisible(false);
	            patients_form.setVisible(true);
	            appointments_form.setVisible(false);
	            payment_form.setVisible(false);
	            profile_form.setVisible(false);

	            // TO DISPLAY IMMEDIATELY THE DATA OF PATIENTS IN TABLEVIEW
	            //patientDisplayData();
	            //patientActionButton();
	            current_form.setText("Patient's Form");
	        } else if (event.getSource() == appointments_btn) {
	            dashboard_form.setVisible(false);
	            doctors_form.setVisible(false);
	            patients_form.setVisible(false);
	            appointments_form.setVisible(true);
	            payment_form.setVisible(false);
	            profile_form.setVisible(false);

	            // TO DISPLAY IMMEDIATELY THE DATA OF APPOINTMENTS IN TABLEVIEW
	            //appointmentDisplayData();

	            current_form.setText("Appointment's Form");
	        } else if (event.getSource() == payment_btn) {
	            dashboard_form.setVisible(false);
	            doctors_form.setVisible(false);
	            patients_form.setVisible(false);
	            appointments_form.setVisible(false);
	            payment_form.setVisible(true);
	            profile_form.setVisible(false);

	            //paymentDisplayData();

	            current_form.setText("Payment Form");
	        } else if (event.getSource() == profile_btn) {
	            dashboard_form.setVisible(false);
	            doctors_form.setVisible(false);
	            patients_form.setVisible(false);
	            appointments_form.setVisible(false);
	            payment_form.setVisible(false);
	            profile_form.setVisible(true);

	            //profileStatusList();
	            //profileDisplayInfo();
	            //profileDisplayImages();

	            current_form.setText("Profile Form");
	        }

	    }
	    
	    public void displayAdminIDUsername() {

	        String sql = "SELECT * FROM admin WHERE username = '"
	                + Data.admin_username + "'";

	        connect = Database.connectDB();

	        try {

	            prepare = connect.prepareStatement(sql);
	            result = prepare.executeQuery();

	            if (result.next()) {
	                nav_adminID.setText(result.getString("admin_id"));
	                String tempUsername = result.getString("username");
	                tempUsername = tempUsername.substring(0, 1).toUpperCase() + tempUsername.substring(1); 
	                nav_username.setText(tempUsername);
	                top_username.setText(tempUsername);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
	    
	    
	    
	    public void runTime() {

	        new Thread() {

	            public void run() {
	                SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
	                while (true) {
	                    try {

	                        Thread.sleep(1000); // 1000 ms = 1s

	                    } catch (Exception e) {
	                        e.printStackTrace();
	                    }

	                    Platform.runLater(() -> {
	                        date_time.setText(format.format(new Date()));
	                    });
	                }
	            }
	        }.start();

	    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		runTime();
		displayAdminIDUsername();
		
	}

}
