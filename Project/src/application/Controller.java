package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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

public class Controller implements Initializable{
	@FXML
	private TextField tfTitle;
	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	public void btnOKClicked(ActionEvent event) {
		Stage mainWindow = (Stage) tfTitle.getScene().getWindow();
		String title = tfTitle.getText();
		mainWindow.setTitle(title);

	}

	public void switchToScene1(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ProjectDesign.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void switchToScene2(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);

		stage.centerOnScreen();

		stage.show();
	}

	@FXML
	private CheckBox login_checkbox;

	@FXML
	private TextField login_username;

	@FXML
	private AnchorPane login_form;

	@FXML
	private Button login_login;

	@FXML
	private PasswordField login_password;

	@FXML
	private Hyperlink login_registerHere;

	@FXML
	private CheckBox register_checkbox;

	@FXML
	private TextField register_email;

	// @FXML
	// private TextField register_fn;

	@FXML
	private AnchorPane register_form;

	@FXML
	private TextField register_username;

	@FXML
	private Hyperlink register_loginHere;

	@FXML
	private PasswordField register_password;
	
	@FXML
	private TextField register_showPassword;

	@FXML
	private PasswordField register_password_confirm;

	@FXML
	private Button register_signup;
	
	@FXML
	private TextField login_showPassword;
	
	@FXML
    private ComboBox<?> login_user;

	// DB TOOLS

	private Connection connect;
	private PreparedStatement prepare;
	private ResultSet result;
	private AlertMessage alert = new AlertMessage();
	
	public void loginAccount() {
	    if (login_username.getText().isEmpty() && login_password.getText().isEmpty()) {
	        alert.errorMessage("Incorrect Username/Password");
	    } else {
	        String username = login_username.getText();
	        String password = login_password.getText();
	        
	        // Check if the show password field is visible
	        if (login_showPassword.isVisible()) {
	            // Use the visible password field
	            password = login_showPassword.getText();
	        }
	        
	        
	        
	        String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";
	        
	        connect = Database.connectDB();
	        
	        try {
	            prepare = connect.prepareStatement(sql);
	            prepare.setString(1, username);
	            prepare.setString(2, login_password.getText());
	            result = prepare.executeQuery();
	            
	            if (result.next()) {
	                // Correct
	                alert.successMessage("Login Successfully");
	            } else {
	                // Wrong
	                alert.errorMessage("Incorrect Username/Password");    
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            alert.errorMessage("An error occurred. Please try again later.");
	            
	        } finally {
	            // Close resources
	            try {
	                if (result != null) result.close();
	                if (prepare != null) prepare.close();
	                if (connect != null) connect.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}

	
public void loginShowPassword() {
		
		
		if(login_checkbox.isSelected()) {
			login_showPassword.setText(login_password.getText());
			login_showPassword.setVisible(true);
			login_password.setVisible(false);
		}else {
			login_password.setText(login_showPassword.getText());
			login_showPassword.setVisible(false);
			login_password.setVisible(true);
		}
		
		
	}

public boolean registerConfirmPassword(String password, String confirmPassword) {
    return password.equals(confirmPassword);
}

public void registerAccount() { // Error handling checkbox password confirmation (register page admin)
	
	
    if (register_email.getText().isEmpty() || register_username.getText().isEmpty()
            || (register_password.getText().isEmpty() && !register_showPassword.isVisible())
            || register_password_confirm.getText().isEmpty()) {
        alert.errorMessage("All blank fields must be filled");
    } else {
        String username = register_username.getText();
        String password = register_password.getText();
        
        if (register_showPassword.isVisible()) {
            // Use the visible password field
            password = register_showPassword.getText();
        }
        
        if (!registerConfirmPassword(password, register_password_confirm.getText())) {
            alert.errorMessage("Passwords do not match");
        } else {
            String checkUsername = "SELECT * FROM admin WHERE username = ?";
            connect = Database.connectDB();
            
            try {
                prepare = connect.prepareStatement(checkUsername);
                prepare.setString(1, username);
                result = prepare.executeQuery();
                if (result.next()) {
                    alert.errorMessage(username + " Already exists!");
                } else if (password.length() < 8) {
                    alert.errorMessage("Invalid Password, at least 8 characters needed.");
                } else {
                    String insertData = "INSERT INTO admin (email, username, password, date) VALUES (?, ?, ?, ?)";
                    
                    java.time.LocalDate currentDate = java.time.LocalDate.now();
                    java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);
                    
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, register_email.getText());
                    prepare.setString(2, username);
                    prepare.setString(3, password);
                    prepare.setDate(4, sqlDate);
                    prepare.executeUpdate();
                    alert.successMessage("Registered Successfully");
                    
                    // Switch to login after success
                    login_form.setVisible(true);
                    register_form.setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // Close resources
                try {
                    if (result != null) result.close();
                    if (prepare != null) prepare.close();
                    if (connect != null) connect.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

	
	
public void registerShowPassword() {
		
		
		if(register_checkbox.isSelected()) {
			register_showPassword.setText(register_password.getText());
			register_showPassword.setVisible(true);
			register_password.setVisible(false);
		}else {
			register_password.setText(register_showPassword.getText());
			register_showPassword.setVisible(false);
			register_password.setVisible(true);
		}
		
		
	}



	public void userList() {
		List<String> listU = new ArrayList<>();
		
		for(String data : Users.user) {
			listU.add(data);
		}
		
		ObservableList listData = FXCollections.observableList(listU);
		login_user.setItems(listData);

	}

	
	public void switchForm(ActionEvent event) {

		if (event.getSource() == login_registerHere) {
			login_form.setVisible(false);
			register_form.setVisible(true);
		} else if (event.getSource() == register_loginHere) {
			login_form.setVisible(true);
			register_form.setVisible(false);

		}

	}
	
	public void switchPage() {
		
		if(login_user.getSelectionModel().getSelectedItem() == "Admin Portal") {
			
			try {
				
				Parent root = FXMLLoader.load(getClass().getResource("ProjectDesign.fxml"));
				Stage stage = new Stage();
				
				stage.setTitle("Hospital Management System 1.0");
				
				stage.setMinWidth(340);
				stage.setMinHeight(580);
				
				
				stage.setScene(new Scene(root));
				
				stage.show();
				
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}else if(login_user.getSelectionModel().getSelectedItem() == "Doctor Portal") {
			
try {
				
				Parent root = FXMLLoader.load(getClass().getResource("DoctorPage.fxml"));
				Stage stage = new Stage();
				
				stage.setTitle("Hospital Management System 1.0D");
				
				stage.setMinWidth(340);
				stage.setMinHeight(580);
				
				
				stage.setScene(new Scene(root));
				
				stage.show();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
		login_user.getScene().getWindow().hide();
		
		
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		userList();
		
	}

}
