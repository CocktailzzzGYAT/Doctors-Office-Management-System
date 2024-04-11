package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
    
    //DB TOOLS
    
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    
    
    private final AlertMessage alert = new AlertMessage();
    

    @FXML
    void loginAccount(ActionEvent event) {

    }

    @FXML
    void loginShowPassword(ActionEvent event) {

    }

    @FXML
    void registerAccount(ActionEvent event) {

    }

    @FXML
    void registerShowPassword(ActionEvent event) {

    }

    @FXML
    void switchForm(ActionEvent event) {
         
    	if(event.getSource() == register_loginHere) {
    		login_form.setVisible(true);
    		register_form.setVisible(false);

    	}else if(event.getSource() == login_registerHere) {
    		login_form.setVisible(false);
    		register_form.setVisible(true);
    	}
    	
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}