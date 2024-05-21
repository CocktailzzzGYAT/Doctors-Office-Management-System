package application;

public class Data {

    public static Integer admin_id;
    public static String admin_username;
    public static String path;

    public static String doctor_id;
    public static String doctor_name;

    public static Integer patient_id;

    public static String[] gender = {"Male", "Female"};

    public static String[] status = {"Active", "Inactive", "Confirm"};

    public static String[] specialization = {"Allergist", "Dermatologist", "Ophthalmologist", "Gynecologist", "Cardiologist"};

    public static Integer temp_PatientID;
    public static String temp_name;
    public static String temp_gender;
    public static Long temp_number;
    public static String temp_numberr;
    public static String temp_string;
    public static String temp_address;
    public static String temp_status;
    public static String temp_date;
    public static String temp_path;

    public static String temp_doctorID;
    public static String temp_doctorName;
    public static String temp_doctorEmail;
    public static String temp_doctorPassword;
    public static String temp_doctorSpecialized;
    public static String temp_doctorGender;
    public static String temp_doctorMobileNumber;
    public static String temp_doctorImagePath;
    public static String temp_doctorAddress;
    public static String temp_doctorStatus;

    public static String temp_appID;
    public static String temp_appName;
    public static String temp_appGender;
    public static String temp_appMobileNumber;
    public static String temp_appAddress;
    public static String temp_appDescription;
    public static String temp_appDiagnosis;
    public static String temp_appTreatment;
    public static String temp_appDoctor;
    public static String temp_appSpecialized;
    public static String temp_appStatus;
    
    
    public String id_d;
    public String name_d;
    public String password_d;
    public String email_d;
    public String gender_d;
    public String number_d;
    public String specialization_d;
    public String address_d;
    public String status_d;
    public String action_d;

    
    public String getPassword_d() {
return password_d;
}

public void setPassword_d(String password_d) {
this.password_d = password_d;
}

public String getEmail_d() {
return email_d;
}

public void setEmail_d(String email_d) {
this.email_d = email_d;
}

public String getGender_d() {
return gender_d;
}
    public String getId_d() {
        return id_d;}
    public String getName_d() {
        return name_d;}
    
public void setGender_d(String gender_d) {
this.gender_d = gender_d;
}

public String getNumber_d() {
return number_d;
}

public void setNumber_d(String number_d) {
this.number_d = number_d;
}

public String getSpecialization_d() {
return specialization_d;
}

public void setSpecialization_d(String specialization_d) {
this.specialization_d = specialization_d;
}

public String getAddress_d() {
return address_d;
}

public void setAddress_d(String address_d) {
this.address_d = address_d;
}

public String getStatus_d() {
return status_d;
}

public void setStatus_d(String status_d) {
this.status_d = status_d;
}
        public Data(String id_d, String name_d, String password_d, String email_d, String gender_d, String number_d,
String specialization_d, String address_d, String status_d) {
super();
this.id_d = id_d;
this.name_d = name_d;
this.password_d = password_d;
this.email_d = email_d;
this.gender_d = gender_d;
this.number_d = number_d;
this.specialization_d = specialization_d;
this.address_d = address_d;
this.status_d = status_d;
}

}