package application;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Callback;
import application.AlertMessage;

public class MainSceneController implements Initializable {
	
	@FXML
    private TableColumn<AppointmentData, String> appointments_action;

	@FXML
    private TableView<AppointmentData> appointments_tableView;

    @FXML
    private TableColumn<AppointmentData, String> appointments_appointmentID;

	    @FXML
	    private Button appointments_btn;

	    @FXML
	    private TableColumn<AppointmentData, String> appointments_contactNumber;

	    @FXML
	    private TableColumn<AppointmentData, String> appointments_description;

	    @FXML
	    private TableColumn<AppointmentData, String> appointments_date;

	    @FXML
	    private TableColumn<AppointmentData, String> appointments_dateModify;

	    @FXML
	    private TableColumn<AppointmentData, String> appointments_dateDelete;

	    @FXML
	    private AnchorPane appointments_form;

	    @FXML
	    private TableColumn<AppointmentData, String> appointments_name;

	    @FXML
	    private TableColumn<AppointmentData, String> appointments_gender;
	    
	    @FXML
	    private TableColumn<AppointmentData, String> appointments_status;

	    

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
	    private TableColumn<Data, String> doctors_col_action;

	    @FXML
	    private TableColumn<?, ?> doctors_col_address;

	    @FXML
	    private TableColumn<?, ?> doctors_col_contactNumber;

	    @FXML
	    private TableColumn<Data, String> doctors_col_doctorID;

	    @FXML
	    private TableColumn<?, ?> doctors_col_email;

	    @FXML
	    private TableColumn<?, ?> doctors_col_gender;

	    @FXML
	    private TableColumn<Data, String> doctors_col_name;

	    @FXML
	    private TableColumn<?, ?> doctors_col_specialization;

	    @FXML
	    private TableColumn<?, ?> doctors_col_status;

	    @FXML
	    private AnchorPane doctors_form;

	    @FXML
	    private TableView<Data> doctors_tableView;

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
	    private TableView<PatientsData> patients_tableView;

	    @FXML
	    private TableColumn<PatientsData, String> patients_col_patientID;

	    @FXML
	    private TableColumn<PatientsData, String> patients_col_name;

	    @FXML
	    private TableColumn<PatientsData, String> patients_col_gender;

	    @FXML
	    private TableColumn<PatientsData, String> patients_col_contactNumber;

	    @FXML
	    private TableColumn<PatientsData, String> patients_col_description;

	    @FXML
	    private TableColumn<PatientsData, String> patients_col_date;

	    @FXML
	    private TableColumn<PatientsData, String> patients_col_dateModify;

	    @FXML
	    private TableColumn<PatientsData, String> patients_col_dateDelete;

	    @FXML
	    private TableColumn<PatientsData, String> patients_col_status;

	    @FXML
	    private TableColumn<PatientsData, String> patients_col_action;

	    @FXML
	    private AnchorPane patients_form;

	    

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
	    private ComboBox<String> profile_status;

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
	    
	    private final AlertMessage alert = new AlertMessage();
	    
	    public ObservableList<Data> dashboarddoctorTableView() {
	        ObservableList<Data> listData = FXCollections.observableArrayList();
	        String sql = "SELECT * FROM doctor";
	        connect = Database.connectDB();
	        try {

	            prepare = connect.prepareStatement(sql);
	           
	            result = prepare.executeQuery();

	            Data dData;
	            
	            while (result.next()) {
	                dData = new Data(result.getString("doctor_id"),
	                		result.getString("full_name"), 
	                		result.getString("password"),
	                		result.getString("email"),
	                		result.getString("gender"), 
	                		result.getString("mobile_number"),
	                		result.getString("specialized"),
	                		result.getString("address"), 
	                		result.getString("status") 
	            			);
	                listData.add(dData);
	            }
	            int count = listData.size();
	            System.out.println("Number of elements in the list: " + count);
	            

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return listData;
	    }
		
	    @FXML
	    private TableColumn<Data, String> dashboad_col_doctor_id;
	    @FXML
	    private TableColumn<Data, String> dashboad_col_specialization;
		private ObservableList<Data> dashboardGetData;
		
		public void dashboardDisplayData_doctor() {
		    dashboardGetData = dashboarddoctorTableView();
		    doctors_col_doctorID.setCellValueFactory(new PropertyValueFactory<>("id_d"));
		    doctors_col_name.setCellValueFactory(new PropertyValueFactory<>("name_d"));
		    doctors_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender_d"));
		    doctors_col_contactNumber.setCellValueFactory(new PropertyValueFactory<>("number_d"));
		    doctors_col_email.setCellValueFactory(new PropertyValueFactory<>("email_d"));
		    doctors_col_specialization.setCellValueFactory(new PropertyValueFactory<>("specialization_d"));
		    doctors_col_address.setCellValueFactory(new PropertyValueFactory<>("address_d"));
		    doctors_col_status.setCellValueFactory(new PropertyValueFactory<>("status_d"));
		    doctors_tableView.setItems(dashboardGetData);
		}
		protected ObservableList<Data> doctorData;
		public void actionButtons() {
		    connect = Database.connectDB();
		    doctorData = dashboarddoctorTableView();

		    Callback<TableColumn<Data, String>, TableCell<Data, String>> celle = (
		            TableColumn<Data, String> param) -> {
		            	final TableCell<Data, String> cell = new TableCell<Data, String>() {
		            public void updateItem(String item, boolean empty) {
		                super.updateItem(item, empty);

		                if (empty) {
		                    setGraphic(null);
		                    setText(null);
		                } else {
		                    Button confirmButton = new Button("Confirm");
		                    Button declineButton = new Button("Decline");
		                    confirmButton
							.setStyle("-fx-background-color: linear-gradient(to bottom right, #188ba7, #306090);\n"
									+ "    -fx-cursor: hand;\n" + "    -fx-text-fill: #fff;\n"
									+ "    -fx-font-size: 14px;\n" + "    -fx-font-family: Arial;");

		                    declineButton
							.setStyle("-fx-background-color: linear-gradient(to bottom right, #188ba7, #306090);\n"
									+ "    -fx-cursor: hand;\n" + "    -fx-text-fill: #fff;\n"
									+ "    -fx-font-size: 14px;\n" + "    -fx-font-family: Arial;");
		                    confirmButton.setOnAction((ActionEvent event) -> {
		                    	int num = doctors_tableView.getSelectionModel().getSelectedIndex();

								if ((num - 1) < -1) {
									alert.errorMessage("Please select item first");
									return;
								}
		                    	Data dData = doctors_tableView.getSelectionModel().getSelectedItem();
		                        try {
		                                    String updataData = "UPDATE doctor set status=? WHERE doctor_id = '" +dData.getId_d() + "'";
		                                    prepare = connect.prepareStatement(updataData);
		                                    prepare.setString(1, "confirm");
		                                    prepare.executeUpdate();
											alert.successMessage("confirm successfully!");
		                                    
		                                }
		                                catch (Exception e) {
		                                    e.printStackTrace();
		                                }
		                        dashboardDisplayData_doctor();
		                    
		                    });

		                    declineButton.setOnAction((ActionEvent event) -> {
		                    	int num = doctors_tableView.getSelectionModel().getSelectedIndex();

								if ((num - 1) < -1) {
									alert.errorMessage("Please select item first");
									return;
								}
		                    	Data dData = doctors_tableView.getSelectionModel().getSelectedItem();

		                        try {
		                        	String updataData = "UPDATE doctor set status=? WHERE doctor_id = '" +dData.getId_d() + "'";
		                                    prepare = connect.prepareStatement(updataData);
		                                    prepare.setString(1, "inactive");
		                                    prepare.executeUpdate();
											alert.successMessage("decline successfully!");
		                                    
		                                }
		                                catch (Exception e) {
		                                    e.printStackTrace();
		                                }
		                        dashboardDisplayData_doctor();
		                        
		                    });

		                    HBox manageBtn = new HBox(confirmButton, declineButton);
		                    manageBtn.setAlignment(Pos.CENTER);
		                    manageBtn.setSpacing(5);
		                    setGraphic(manageBtn);
		                    setText(null);
		                }
		            }
		        };
		        return cell;
		    };
		    doctors_col_action.setCellFactory(celle);
		    doctors_tableView.setItems(doctorData);
		}
	    
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
	    
	    public void profileStatusList() {
	        List<String> listS = new ArrayList<>();

	        for (String data : Data.gender) {
	            listS.add(data);
	        }
	        ObservableList listData = FXCollections.observableArrayList(listS);
	        profile_status.setItems(listData);
	    }
	    
	    public void profileUpdateBtn() {
	        connect = Database.connectDB();
	        if (profile_adminID.getText().isEmpty()
	                || profile_username.getText().isEmpty()
	                || profile_email.getText().isEmpty()
	                || profile_status.getSelectionModel().getSelectedItem() == null) {
	            alert.errorMessage("Please fill all blank fields");
	        } else {
	            if (Data.path == null || "".equals(Data.path)) {
	                String updateData = "UPDATE admin SET username = ?, email = ?, gender = ? "
	                        + "WHERE admin_id = " + Data.admin_id;

	                try {
	                    prepare = connect.prepareStatement(updateData);
	                    prepare.setString(1, profile_username.getText());
	                    prepare.setString(2, profile_email.getText());
	                    prepare.setString(3, profile_status.getSelectionModel().getSelectedItem());

	                    prepare.executeUpdate();

	                    profileDisplayInfo();

	                    alert.successMessage("Updated Successfully");
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }

	            } else {
	                String updateData = "UPDATE admin SET username = ?, email = ?, image = ?, gender = ? "
	                        + "WHERE admin_id = " + Data.admin_id;
	                try {
	                    prepare = connect.prepareStatement(updateData);
	                    prepare.setString(1, profile_username.getText());
	                    prepare.setString(2, profile_email.getText());

	                    String path = Data.path;
	                    path = path.replace("\\", "\\\\");
	                    Path transfer = Paths.get(path);

	                    Path copy = Paths.get("C:\\Users\\WINDOWS 10\\Documents\\NetBeansProjects\\HospitalManagementSystem\\src\\Admin_Directory\\"
	                            + Data.admin_id + ".jpg");

	                    Files.copy(transfer, copy, StandardCopyOption.REPLACE_EXISTING);
	                    prepare.setString(3, copy.toAbsolutePath().toString());
	                    prepare.setString(4, profile_status.getSelectionModel().getSelectedItem());

	                    prepare.executeUpdate();
	                    profileDisplayInfo();
	                    
	                    alert.successMessage("Updated Successfully!");
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        }

	    }
	    
	    public void profileDisplayInfo() {

	        String sql = "SELECT * FROM admin WHERE admin_id = " + Data.admin_id;
	        System.out.println(Data.admin_id);
	        connect = Database.connectDB();

	        try {
	            prepare = connect.prepareStatement(sql);
	            result = prepare.executeQuery();

	            if (result.next()) {
	                profile_adminID.setText(result.getString("admin_id"));
	                profile_username.setText(result.getString("username"));
	                profile_email.setText(result.getString("email"));
	                profile_status.getSelectionModel().select(result.getString("gender"));

	                profile_label_adminIO.setText(result.getString("admin_id"));
	                profile_label_name.setText(result.getString("username"));
	                profile_label_email.setText(result.getString("email"));
	                profile_label_dateCreated.setText(result.getString("date"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
	    
	    
	    
	    
	    public void logoutBtn() {

	        try {
	            if (alert.confirmationMessage("Are you sure you want to logout?")) {
	                Parent root = FXMLLoader.load(getClass().getResource("ProjectDesign.fxml"));
	                Stage stage = new Stage();

	                stage.setScene(new Scene(root));
	                stage.show();

	                
	                logout_btn.getScene().getWindow().hide();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
	    
	    public void dashboardTP() {

	        String sql = "SELECT COUNT(id) FROM patient WHERE date_delete IS NULL";

	        connect = Database.connectDB();

	        int tempTP = 0;
	        try {

	            prepare = connect.prepareStatement(sql);
	            result = prepare.executeQuery();

	            if (result.next()) {
	                tempTP = result.getInt("COUNT(id)");
	            }
	            dashboard_TP.setText(String.valueOf(tempTP));

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
	    
	    public void dashboardTA() {

	        String sql = "SELECT COUNT(id) FROM appointment WHERE date_delete IS NULL";

	        connect = Database.connectDB();

	        int tempTA = 0;
	        try {

	            prepare = connect.prepareStatement(sql);
	            result = prepare.executeQuery();

	            if (result.next()) {
	                tempTA = result.getInt("COUNT(id)");
	            }
	            dashboard_AP.setText(String.valueOf(tempTA));

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
	    
	    public void dashboardAD() {

	        String sql = "SELECT COUNT(id) FROM doctor WHERE status = 'Active' or status = 'Confirm' AND delete_date IS NULL";

	        connect = Database.connectDB();

	        int tempAD = 0;
	        try {

	            prepare = connect.prepareStatement(sql);
	            result = prepare.executeQuery();

	            if (result.next()) {
	                tempAD = result.getInt("COUNT(id)");
	            }
	            dashboard_AD.setText(String.valueOf(tempAD));

	        } catch (Exception e) {
	            e.printStackTrace();
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
	    
	    
	    
	    public ObservableList<PatientsData> patientGetData() {

	        ObservableList<PatientsData> listData = FXCollections.observableArrayList();

	        String sql = "SELECT * FROM patient";

	        connect = Database.connectDB();

	        try {
	            prepare = connect.prepareStatement(sql);
	            result = prepare.executeQuery();

	            PatientsData pData;

	            while (result.next()) {
//	                PatientsData(Integer id, Integer patientID, String password, String fullName, Long mobileNumber
//	            , String address, String image, String description, String diagnosis, String treatment
//	            , String doctor, String specialized, Date date, Date dateModify
//	            , Date dateDelete, String status)
	            	pData = new PatientsData(result.getInt("id"), result.getString("patient_name"),
							result.getString("gender"), result.getString("patient_phone"),
							result.getString("patient_adress"), result.getString("patient_age"), result.getDate("date"),
							result.getDate("date_modify"), result.getDate("date_delete"));

	                listData.add(pData);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return listData;
	    }

	    public ObservableList<PatientsData> patientListData;

	    public void patientDisplayData() {
	        patientListData = patientGetData();

	        patients_col_patientID.setCellValueFactory(new PropertyValueFactory<>("id"));
	        patients_col_name.setCellValueFactory(new PropertyValueFactory<>("fullName"));
	        patients_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
	        patients_col_contactNumber.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
	        patients_col_description.setCellValueFactory(new PropertyValueFactory<>("address"));
	        patients_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
	        patients_col_dateModify.setCellValueFactory(new PropertyValueFactory<>("dateModify"));
	        patients_col_dateDelete.setCellValueFactory(new PropertyValueFactory<>("dateDelete"));
	        

	        patients_tableView.setItems(patientListData);
	    }
	    
	    public void patientActionButton() {

	        connect = Database.connectDB();
	        patientListData = patientGetData();

	        Callback<TableColumn<PatientsData, String>, TableCell<PatientsData, String>> cellFactory = (TableColumn<PatientsData, String> param) -> {
	            final TableCell<PatientsData, String> cell = new TableCell<PatientsData, String>() {
	                public void updateItem(String item, boolean empty) {
	                    super.updateItem(item, empty);

	                    if (empty) {
	                        setGraphic(null);
	                        setText(null);
	                    } else {
	                        
	                        Button removeButton = new Button("Delete");

	                        

	                        removeButton.setStyle("-fx-background-color: linear-gradient(to bottom right, #188ba7, #306090);\n"
	                                + "    -fx-cursor: hand;\n"
	                                + "    -fx-text-fill: #fff;\n"
	                                + "    -fx-font-size: 14px;\n"
	                                + "    -fx-font-family: Arial;");

	                        ;

	                        removeButton.setOnAction((ActionEvent event) -> {
	                            PatientsData pData = patients_tableView.getSelectionModel().getSelectedItem();
	                            int num = patients_tableView.getSelectionModel().getSelectedIndex();

	                            if ((num - 1) < -1) {
	                                alert.errorMessage("Please select item first");
	                                return;
	                            }

	                            String deleteData = "DELETE FROM patient WHERE id = '"
	                                    + pData.getId() + "'";

	                            try {
	                                if (alert.confirmationMessage("Are you sure you want to delete Patient ID: " + pData.getId() + "?")) {
	                                    prepare = connect.prepareStatement(deleteData);
	                                    
	                                    
	                                    prepare.executeUpdate();

	                                    
	                                    alert.successMessage("Deleted Successfully!");

	                                    patientDisplayData();
	                                    
	                                }
	                            } catch (Exception e) {
	                                e.printStackTrace();
	                            }
	                        });

	                        HBox manageBtn = new HBox(removeButton);
	                        manageBtn.setAlignment(Pos.CENTER);
	                        manageBtn.setSpacing(5);
	                        setGraphic(manageBtn);
	                        setText(null);
	                    }
	                }
	            };
	            
	            return cell;
	        };

	        patients_col_action.setCellFactory(cellFactory);
	        patients_tableView.setItems(patientListData);

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
	    
	    public ObservableList<AppointmentData> appointmentGetData() {

	        ObservableList<AppointmentData> listData = FXCollections.observableArrayList();

	        String sql = "SELECT * FROM appointment";

	        connect = Database.connectDB();

	        try {
	            prepare = connect.prepareStatement(sql);
	            result = prepare.executeQuery();

	            AppointmentData aData;
	            while (result.next()) {
//	            AppointmentData(Integer id, Integer appointmentID, String name, String gender,
//	            Long mobileNumber, String description, String diagnosis, String treatment, String address,
//	            Date date, Date dateModify, Date dateDelete, String status, Date schedule)
	                aData = new AppointmentData(result.getInt("id"), result.getInt("appointment_id"),
	                        result.getString("name"), result.getString("gender"), result.getLong("mobile_number"),
	                        result.getString("description"), result.getString("diagnosis"),
	                        result.getString("treatment"), result.getString("address"),
	                        result.getString("doctor"), result.getString("specialized"),
	                        result.getDate("date"), result.getDate("date_modify"),
	                        result.getDate("date_delete"), result.getString("status"),
	                        result.getDate("schedule"));
	                listData.add(aData);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return listData;
	    }

	    private ObservableList<AppointmentData> appointmentListData;

	    public void appointmentDisplayData() {
	        appointmentListData = appointmentGetData();

	        appointments_appointmentID.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
	        appointments_name.setCellValueFactory(new PropertyValueFactory<>("name"));
	        appointments_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
	        appointments_contactNumber.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
	        appointments_description.setCellValueFactory(new PropertyValueFactory<>("description"));
	        appointments_date.setCellValueFactory(new PropertyValueFactory<>("date"));
	        appointments_dateModify.setCellValueFactory(new PropertyValueFactory<>("dateModify"));
	        appointments_dateDelete.setCellValueFactory(new PropertyValueFactory<>("dateDelete"));
	        appointments_status.setCellValueFactory(new PropertyValueFactory<>("status"));

	        appointments_tableView.setItems(appointmentListData);

	    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		runTime();
		displayAdminIDUsername();
		dashboardDisplayData_doctor();
		actionButtons();
		
		dashboardTP();
		dashboardTA();
		dashboardAD();
		
		
		patientDisplayData();
		patientActionButton();
		
		appointmentDisplayData();
		
		profileStatusList();
        profileDisplayInfo();
        
	}

}
