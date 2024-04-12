package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DoctorPageController implements Initializable {

	@FXML
	private TextField login_DoctorID;

	@FXML
	private CheckBox login_checkbox;

	@FXML
	private AnchorPane login_form;

	@FXML
	private Button login_login;

	@FXML
	private PasswordField login_password;

	@FXML
	private Hyperlink login_registerHere;

	@FXML
	private TextField login_showPassword;

	@FXML
	private CheckBox register_checkbox;

	@FXML
	private TextField register_doctorID;

	@FXML
	private TextField register_email;

	@FXML
	private AnchorPane register_form;

	@FXML
	private TextField register_fullName;

	@FXML
	private Hyperlink register_loginHere;

	@FXML
	private PasswordField register_password;

	@FXML
	private PasswordField register_password_confirm;

	@FXML
	private TextField register_showPassword;

	@FXML
	private Button register_signup;

	@FXML
	private ComboBox<?> login_user;

	// DB TOOLS

	private Connection connect;
	private PreparedStatement prepare;
	private ResultSet result;

	private final AlertMessage alert = new AlertMessage();

	@FXML
	void loginAccount() {

	}

	@FXML
	void loginShowPassword() {

		

	}

	@FXML
	void registerAccount() {

		if (register_fullName.getText().isEmpty() || register_email.getText().isEmpty()
				|| register_doctorID.getText().isEmpty() || register_password.getText().isEmpty()) {

			alert.errorMessage("Please fill all blank fields");
		} else {
			String checkDoctorID = "SELECT * FROM doctor WHERE doctor_id = '" + register_doctorID.getText() + "'";

			connect = Database.connectDB();

			try {

				prepare = connect.prepareStatement(checkDoctorID);
				result = prepare.executeQuery();

				if (result.next()) {
					alert.errorMessage(register_doctorID.getText() + " is already taken");

				} else if (register_password.getText().length() < 8) {

					alert.errorMessage("Invalid Password, at least 8 characters are needed");

				} else {
					
					String insertData = "INSERT INTO doctor (full_name, email, doctor_id, password, date, status) " + "VALUES(?,?,?,?,?,?)";

					
					prepare = connect.prepareStatement(insertData);
					
					java.time.LocalDate currentDate = java.time.LocalDate.now();
                    java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);
					
					
                    prepare.setString(1, register_fullName.getText());
                    prepare.setString(2, register_email.getText());
                    prepare.setString(3, register_doctorID.getText());
                    prepare.setString(4, register_password.getText());
                    prepare.setDate(5, sqlDate);
                    prepare.setString(6, "Confirm");
                    
                    prepare.executeUpdate();
                    
                    alert.successMessage("registered successfully!");
                    
                    
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
	}

	@FXML
	void registerShowPassword() {

	}

	public void userList() {
		List<String> listU = new ArrayList<>();

		for (String data : Users.user) {
			listU.add(data);
		}

		ObservableList listData = FXCollections.observableList(listU);
		login_user.setItems(listData);

	}

	public void switchPage() {

		if (login_user.getSelectionModel().getSelectedItem() == "Admin Portal") {

			try {

				Parent root = FXMLLoader.load(getClass().getResource("ProjectDesign.fxml"));
				Stage stage = new Stage();

				stage.setTitle("Hospital Management System 1.0");

				stage.setMinWidth(340);
				stage.setMinHeight(580);

				stage.setScene(new Scene(root));

				stage.show();

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (login_user.getSelectionModel().getSelectedItem() == "Doctor Portal") {

			try {

				Parent root = FXMLLoader.load(getClass().getResource("DoctorPage.fxml"));
				Stage stage = new Stage();

				stage.setTitle("Hospital Management System 1.0D");

				stage.setMinWidth(340);
				stage.setMinHeight(580);

				stage.setScene(new Scene(root));

				stage.show();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		login_user.getScene().getWindow().hide();

	}

	@FXML
	void switchForm(ActionEvent event) {

		if (event.getSource() == register_loginHere) {
			login_form.setVisible(true);
			register_form.setVisible(false);

		} else if (event.getSource() == login_registerHere) {
			login_form.setVisible(false);
			register_form.setVisible(true);
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		userList();

	}
}