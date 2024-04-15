package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class DoctorMainFormController implements Initializable{
	
	
	@FXML
    private TextArea appointment_address;

    @FXML
    private TextField appointment_appointmentID;

    @FXML
    private Button appointment_clearBtn;

    @FXML
    private Button appointment_deleteBtn;

    @FXML
    private TextField appointment_description;

    @FXML
    private TextField appointment_diagnosis;

    @FXML
    private ComboBox<?> appointment_gender;

    @FXML
    private Button appointment_insertBtn;

    @FXML
    private TextField appointment_mobileNumber;

    @FXML
    private TextField appointment_name;

    @FXML
    private ComboBox<?> appointment_status;

    @FXML
    private TextField appointment_treatment;

    @FXML
    private Button appointment_updateBtn;

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
    private Button logout_btn;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Label nav_adminID;

    @FXML
    private Label nav_username;

    @FXML
    private Label patients_PA_dateCreated;

    @FXML
    private Button patients_PI_addBtn;

    @FXML
    private Label patients_PI_address;

    @FXML
    private Label patients_PI_gender;

    @FXML
    private Label patients_PI_mobileNumber;

    @FXML
    private Label patients_PI_patientName;

    @FXML
    private Button patients_PI_recordBtn;

    @FXML
    private Button patients_btn;

    @FXML
    private Button patients_confirmBtn;

    @FXML
    private AnchorPane patients_form;

    @FXML
    private ComboBox<?> patients_gender;

    @FXML
    private TextField patients_mobileNumber;

    @FXML
    private TextField patients_patientName;

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
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
