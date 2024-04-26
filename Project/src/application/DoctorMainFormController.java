package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class DoctorMainFormController implements Initializable {

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
	private ComboBox<String> appointment_gender;

	@FXML
	private Button appointment_insertBtn;

	@FXML
	private TextField appointment_mobileNumber;

	@FXML
	private TextField appointment_name;

	@FXML
	private ComboBox<String> appointment_status;

	@FXML
	private TextField appointment_treatment;

	@FXML
	private Button appointment_updateBtn;

	@FXML
	private TableColumn<AppointmentData, String> appointments_action;

	@FXML
	private TableColumn<AppointmentData, String> appointments_appointmentID;

	@FXML
	private Button appointments_btn;

	@FXML
	private TableColumn<AppointmentData, String> appointments_contactNumber;

	@FXML
	private TableColumn<AppointmentData, String> appointments_date;

	@FXML
	private TableColumn<AppointmentData, String> appointments_dateDelete;

	@FXML
	private TableColumn<AppointmentData, String> appointments_dateModify;

	@FXML
	private TableColumn<AppointmentData, String> appointments_description;

	@FXML
	private AnchorPane appointments_form;

	@FXML
	private TableColumn<AppointmentData, String> appointments_gender;

	@FXML
	private TableColumn<AppointmentData, String> appointments_name;

	@FXML
	private TableColumn<AppointmentData, String> appointments_status;

	@FXML
	private TableView<AppointmentData> appointments_tableView;

	@FXML
	private Label current_form;

	@FXML
	private BarChart<?, ?> dashboad_chart_DD;

	@FXML
	private AreaChart<?, ?> dashboad_chart_PD;

	@FXML
	private TableColumn<?, ?> dashboad_col_doctorID;

	@FXML
	private TableColumn<AppointmentData, String> dashboad_col_name;

	@FXML
	private TableColumn<?, ?> dashboad_col_specialized;

	@FXML
	private TableColumn<AppointmentData, String> dashboad_col_status;

	@FXML
	private TableView<AppointmentData> dashboad_tableView;

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
	private ComboBox<String> patients_gender;

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
	
	@FXML
    private DatePicker appointment_schedule;

	private Connection connect;
	private PreparedStatement prepare;
	private Statement statement;
	private ResultSet result;

	private final AlertMessage alert = new AlertMessage();
	
	
	 private void patientGenderList() {

	        List<String> listG = new ArrayList<>();

	        for (String data : Data.gender) {
	            listG.add(data);
	        }
	        ObservableList listData = FXCollections.observableList(listG);

	        patients_gender.setItems(listData);

	    }
	

	public ObservableList<AppointmentData> dashboardAppointmentTableView() {

        ObservableList<AppointmentData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM appointment WHERE doctor = '"
                + Data.doctor_id + "'";

        connect = Database.connectDB();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            AppointmentData aData;
            
            while (result.next()) {System.out.println("gyatblyat");
                aData = new AppointmentData(result.getInt("appointment_id"),
                        result.getString("name"), result.getString("description"),
                        result.getDate("date"), result.getString("status"));

                listData.add(aData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
	
	  
	
    @FXML
    private TableColumn<AppointmentData, String> dashboad_col_appointmentDate;

    @FXML
    private TableColumn<AppointmentData, String> dashboad_col_appointmentID;

    @FXML
    private TableColumn<AppointmentData, String> dashboad_col_description;



    
	private ObservableList<AppointmentData> dashboardGetData;

    public void dashboardDisplayData() {
        dashboardGetData = dashboardAppointmentTableView();

        dashboad_col_appointmentID.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
        dashboad_col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        dashboad_col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        dashboad_col_appointmentDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        dashboad_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        dashboad_tableView.setItems(dashboardGetData);
    }
	
	
	
	
	  public ObservableList<AppointmentData> appointmentGetData() {

	        ObservableList<AppointmentData> listData = FXCollections.observableArrayList();

	        String sql = "SELECT * FROM appointment WHERE date_delete IS NULL";

	        connect = Database.connectDB();

	        try {

	            prepare = connect.prepareStatement(sql);
	            result = prepare.executeQuery();

	            AppointmentData appData;

	            while (result.next()) {
//	            Integer appointmentID, String name, String gender,
//	            Long mobileNumber, String description, String diagnosis, String treatment, String address,
//	            Date date, Date dateModify, Date dateDelete, String status, Date schedule

	                appData = new AppointmentData(result.getInt("appointment_id"),
	                        result.getString("name"), result.getString("gender"),
	                        result.getLong("mobile_number"), result.getString("description"),
	                        result.getString("diagnosis"), result.getString("treatment"),
	                        result.getString("address"), result.getDate("date"),
	                        result.getDate("date_modify"), result.getDate("date_delete"),
	                        result.getString("status"), result.getDate("schedule"));
	                // STORE ALL DATA
	                listData.add(appData);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return listData;
	    }
	  
	  public ObservableList<AppointmentData> AppointmentListData;

	    public void appointmentShowData() {
	        AppointmentListData = appointmentGetData();

	        
	        System.out.println("Number of appointments retrieved: " + AppointmentListData.size());
	        
	        
	        appointments_appointmentID.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
	        appointments_name.setCellValueFactory(new PropertyValueFactory<>("name"));
	        appointments_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
	        appointments_contactNumber.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
	        appointments_description.setCellValueFactory(new PropertyValueFactory<>("description"));
	        appointments_date.setCellValueFactory(new PropertyValueFactory<>("date"));
	        appointments_dateModify.setCellValueFactory(new PropertyValueFactory<>("dateModify"));
	        appointments_dateDelete.setCellValueFactory(new PropertyValueFactory<>("dateDelete"));
	        appointments_status.setCellValueFactory(new PropertyValueFactory<>("status"));

	        appointments_tableView.setItems(AppointmentListData);
	    }
	    
	    
	    public void appointmentSelect() {

	        AppointmentData appData = appointments_tableView.getSelectionModel().getSelectedItem();
	        int num = appointments_tableView.getSelectionModel().getSelectedIndex();

	        
	        if ((num - 1) < -1) {
	            return;
	        }

	        appointment_appointmentID.setText("" + appData.getAppointmentID());  
	        appointment_name.setText(appData.getName());
	        appointment_gender.getSelectionModel().select(appData.getGender());
	        appointment_mobileNumber.setText("" + appData.getMobileNumber());
	        appointment_description.setText(appData.getDescription());
	        appointment_diagnosis.setText(appData.getDiagnosis());
	        appointment_treatment.setText(appData.getTreatment());
	        appointment_address.setText(appData.getAddress());
	        appointment_status.getSelectionModel().select(appData.getStatus());

	    }
	    
	    public void patientClearFields() {
	        patient_id.clear();
	        patients_patientName.clear();
	        patients_age.clear();
	        patients_gender.getSelectionModel().clearSelection();
	        patients_mobileNumber.clear();
	        patients_adress.clear();

	        
	        patients_PA_dateCreated.setText("");
	        patients_PI_patientName.setText("");
	        patients_PI_gender.setText("");
	        patients_PI_mobileNumber.setText("");
	        patients_PI_address.setText("");
	        patients_PI_age.setText("");
	    }
	    
	    
	    @FXML
	    private Label patients_PI_age;
	    
	    public void patientConfirmBtn() {

	        // CHECK IF SOME OR ALL FIELDS ARE EMPTY
	        if (patient_id.getText().isEmpty()
	        		|| patients_age.getText().isEmpty()
	                || patients_patientName.getText().isEmpty()
	                || patients_gender.getSelectionModel().getSelectedItem() == null
	                || patients_mobileNumber.getText().isEmpty()	                
	                || patients_adress.getText().isEmpty()) {
	            alert.errorMessage("Please fill all blank fields");
	        } else {
	            Date date = new Date();
	            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

	            
	            
	            patients_PA_dateCreated.setText(String.valueOf(sqlDate));

	            // TO DISPLAY THE DATA FROM PERSONAL INFORMATION 
	            patients_PI_patientName.setText(patients_patientName.getText());
	            patients_PI_gender.setText(patients_gender.getSelectionModel().getSelectedItem());
	            patients_PI_mobileNumber.setText(patients_mobileNumber.getText());
	            patients_PI_address.setText(patients_adress.getText());
	            patients_PI_age.setText(patients_age.getText());
	        }

	    }
	    
	    
	    public void patientRecordBtn() {
	        try {
	            // LINK THE NAME OF YOUR FXML FOR RECORD PAGE
	            Parent root = FXMLLoader.load(getClass().getResource("RecordPageForm.fxml"));
	            Stage stage = new Stage();

	            stage.setTitle("Hospital Management System | Record of Patients");
	            stage.setScene(new Scene(root));
	            stage.show();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }

	
	
// Mounir Code section ------------
	@FXML
	private TextArea patients_adress;
	@FXML
	private TextField patient_id;
	

    @FXML
    private TextField patients_age;

	public void register_patient() {

		if (patients_patientName.getText().isEmpty() || patients_mobileNumber.getText().isEmpty()
				|| patients_adress.getText().isEmpty() || patients_age.getText().isEmpty()) {
			
			alert.errorMessage("All blank fields must be filled");
		} else {
			String patient_name = patients_patientName.getText();
			String patient_phone = patients_mobileNumber.getText();
			String patient_adress = patients_adress.getText();
			

			String checkid = "SELECT * FROM patient WHERE patient_name = ?";
			connect = Database.connectDB();

			try {
				prepare = connect.prepareStatement(checkid);
				prepare.setString(1, patient_name);
				result = prepare.executeQuery();
				if (result.next()) {
					alert.errorMessage(patient_name + " Already exists!");

				} else {
					String getSpecialized = "";
	                  String getDoctorData = "SELECT * FROM doctor WHERE doctor_id = '"
	                          + Data.doctor_id + "'";

					String insertData = "INSERT INTO patient (patient_age, patient_name,gender, patient_phone, doctor, patient_adress, date) VALUES (?, ?, ?, ?, ?, ?, ?)";
					java.time.LocalDate currentDate = java.time.LocalDate.now();
					java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);

					prepare = connect.prepareStatement(insertData);
					prepare.setString(1, patients_age.getText());
					prepare.setString(2, patients_patientName.getText());
					prepare.setString(3, patients_gender.getSelectionModel().getSelectedItem());
					prepare.setString(4, patients_mobileNumber.getText());
					prepare.setString(5, Data.doctor_id);
					prepare.setString(6, patients_adress.getText());
					prepare.setDate(7, sqlDate);
					prepare.executeUpdate();
					alert.successMessage("Registered Successfully");
					patientClearFields();

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// Close resources
				try {
					if (result != null)
						result.close();
					if (prepare != null)
						prepare.close();
					if (connect != null)
						connect.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void registerpatientID() {
		String PID = "P-";
		int tempID = 0;
		connect = Database.connectDB();
		String sql = "SELECT MAX(id) FROM patient";

		try {

			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();

			if (result.next()) {
				tempID = result.getInt("MAX(id)");
			}

			if (tempID == 0) {
				tempID += 1;
				PID += tempID;
			} else {
				PID += (tempID + 1);
			}

			patient_id.setText(PID);
			patient_id.setDisable(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void displayAdminIDNumberName() {
		String name = Data.doctor_name;
		System.out.println(name);
		name = name.substring(0, 1).toUpperCase() + name.substring(1);

		nav_username.setText(name);
		nav_adminID.setText(Data.doctor_id);
		top_username.setText(name);
	}

	public void switchForm(ActionEvent event) {
		if (event.getSource() == dashboard_btn) {
			dashboard_form.setVisible(true);
			patients_form.setVisible(false);
			appointments_form.setVisible(false);
			profile_form.setVisible(false);
		} else if (event.getSource() == patients_btn) {
			dashboard_form.setVisible(false);
			patients_form.setVisible(true);
			appointments_form.setVisible(false);
			profile_form.setVisible(false);
		} else if (event.getSource() == appointments_btn) {
			dashboard_form.setVisible(false);
			patients_form.setVisible(false);
			appointments_form.setVisible(true);
			profile_form.setVisible(false);
		} else if (event.getSource() == profile_btn) {
			dashboard_form.setVisible(false);
			patients_form.setVisible(false);
			appointments_form.setVisible(false);
			profile_form.setVisible(true);
		}
	}
	
	
	
	
	public void logoutBtn() {

        try {
            if (alert.confirmationMessage("Are you sure you want to logout?")) {
                Data.doctor_id = "";
                Data.doctor_name = "";
                Parent root = FXMLLoader.load(getClass().getResource("DoctorPage.fxml"));
                Stage stage = new Stage();

                stage.setScene(new Scene(root));
                stage.show();

                
                logout_btn.getScene().getWindow().hide();

                Data.doctor_id = "";
                Data.doctor_name = "";
                Data.temp_PatientID = 0;
                Data.temp_name = "";
                Data.temp_gender = "";
                Data.temp_number = Long.parseLong("0");
                Data.temp_address = "";
                Data.temp_status = "";
                Data.temp_date = "";
                Data.temp_path = "";

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
	
	
	
	
	public void appointmentInsertBtn() {


      if (appointment_appointmentID.getText().isEmpty()
              || appointment_name.getText().isEmpty()
              || appointment_gender.getSelectionModel().getSelectedItem() == null
              || appointment_mobileNumber.getText().isEmpty()
              || appointment_description.getText().isEmpty()
              || appointment_address.getText().isEmpty()
              || appointment_status.getSelectionModel().getSelectedItem() == null
              || appointment_schedule.getValue() == null) {
          alert.errorMessage("Please fill the blank fields");
      } else {
          String checkAppointmentID = "SELECT * FROM appointment WHERE appointment_id = "
                  + appointment_appointmentID.getText();
          connect = Database.connectDB();
          try {
              statement = connect.createStatement();
              result = statement.executeQuery(checkAppointmentID);

              if (result.next()) {
                  alert.errorMessage(appointment_appointmentID.getText() + " was already taken");
              } else {
                  String getSpecialized = "";
                  String getDoctorData = "SELECT * FROM doctor WHERE doctor_id = '"
                          + Data.doctor_id + "'";

                  statement = connect.createStatement();
                  result = statement.executeQuery(getDoctorData);

                  if (result.next()) {
                      getSpecialized = result.getString("specialized");
                  }

                  String insertData = "INSERT INTO appointment (appointment_id, name, gender"
                          + ", description, diagnosis, treatment, mobile_number"
                          + ", address, date, status, doctor, specialized, schedule) "
                          + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
                  prepare = connect.prepareStatement(insertData);

                  prepare.setString(1, appointment_appointmentID.getText());
                  prepare.setString(2, appointment_name.getText());
                  prepare.setString(3, (String) appointment_gender.getSelectionModel().getSelectedItem());
                  prepare.setString(4, appointment_description.getText());
                  prepare.setString(5, appointment_diagnosis.getText());
                  prepare.setString(6, appointment_treatment.getText());
                  prepare.setString(7, appointment_mobileNumber.getText());
                  prepare.setString(8, appointment_address.getText());

                  java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());

                  prepare.setString(9, "" + sqlDate);
                  prepare.setString(10, (String) appointment_status.getSelectionModel().getSelectedItem());
                  prepare.setString(11, Data.doctor_id);
                  prepare.setString(12, getSpecialized);
                  prepare.setString(13, "" + appointment_schedule.getValue());

                  prepare.executeUpdate();

                  appointmentShowData();
                  appointmentAppointmentID();
                  appointmentClearBtn();
                  alert.successMessage("Successully added!");

              }
              
              

          } catch (Exception e) {
              e.printStackTrace();
          }
      }

  }
	
	
	public void appointmentDeleteBtn() {

        if (appointment_appointmentID.getText().isEmpty()) {
            alert.errorMessage("Please select the item first");
        } else {

            String updateData = "UPDATE appointment SET date_delete = ? WHERE appointment_id = '"
                    + appointment_appointmentID.getText() + "'";

            connect = Database.connectDB();

            try {
                java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());

                if (alert.confirmationMessage("Are you sure you want to DELETE Appointment ID: "
                        + appointment_appointmentID.getText() + "?")) {
                    prepare = connect.prepareStatement(updateData);

                    prepare.setString(1, String.valueOf(sqlDate));
                    prepare.executeUpdate();

                    appointmentShowData();
                    appointmentAppointmentID();
                    appointmentClearBtn();

                    alert.successMessage("Successully Updated!");
                } else {
                    alert.errorMessage("Cancelled.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
	
	
	public void appointmentClearBtn() {
        appointment_appointmentID.clear();
        appointment_name.clear();
        appointment_gender.getSelectionModel().clearSelection();
        appointment_mobileNumber.clear();
        appointment_description.clear();
        appointment_treatment.clear();
        appointment_diagnosis.clear();
        appointment_address.clear();
        appointment_status.getSelectionModel().clearSelection();
        appointment_schedule.setValue(null);
    }
	
	
	
	private Integer appointmentID;
	
	public void appointmentGetAppointmentID() {
        String sql = "SELECT MAX(appointment_id) FROM appointment";
        connect = Database.connectDB();

        int tempAppID = 0;
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            if (result.next()) {
                tempAppID = result.getInt("MAX(appointment_id)");
            }
            if (tempAppID == 0) {
                tempAppID += 1;
            } else {
                tempAppID += 1;
            }
            appointmentID = tempAppID;
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
	 public void appointmentAppointmentID() {
	        appointmentGetAppointmentID();

	        appointment_appointmentID.setText("" + appointmentID);
	        appointment_appointmentID.setDisable(true);

	    }
	 
	 

	    public void appointmentGenderList() {
	        List<String> listG = new ArrayList<>();

	        for (String data : Data.gender) {
	            listG.add(data);
	        }

	        ObservableList listData = FXCollections.observableArrayList(listG);
	        appointment_gender.setItems(listData);

	    }
	    
	    
	    public void appointmentStatusList() {
	        List<String> listS = new ArrayList<>();

	        for (String data : Data.status) {
	            listS.add(data);
	        }

	        ObservableList listData = FXCollections.observableArrayList(listS);
	        appointment_status.setItems(listData);

	    }
  
	    
	    

	public void runTime() {
		new Thread() {
			public void run() {
				SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
				while (true) {
					try {
						Thread.sleep(1);
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
		displayAdminIDNumberName();
		runTime();
		registerpatientID();
		
		appointmentAppointmentID();
		appointmentShowData();
		dashboardDisplayData();
		
		
		appointmentGenderList();
		appointmentStatusList();
		patientGenderList();
		
		

	}

}
