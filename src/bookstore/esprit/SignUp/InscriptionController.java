/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.SignUp;

import bookstore.esprit.entities.Users;
import bookstore.esprit.services.JavaMailing;
import bookstore.esprit.services.usersCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

/**
 * FXML Controller class
 *
 * @author Oussema
 */
public class InscriptionController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfemail;

    @FXML
    private PasswordField tfpassword;
    @FXML
    private PasswordField tfconfirm;

    @FXML
    private TextField tfauteur;
    @FXML
    private TextField tfgenre;
    @FXML
    private ComboBox<String> tfstatut;
    @FXML
    private Button ok;
    String caracteronly = "[a-zA-Z][a-zA-Z ]+[a-zA-Z][a-zA-Z ]$";
    usersCRUD uc = new usersCRUD();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tfstatut.getItems().setAll("Etudiant", "Enseignant", "Employée", "Autre");
    }

    @FXML
    private void savePerson(ActionEvent event) {
        if (!(tfnom.getText().matches(caracteronly))) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("UNVALIDATE FIRST NAME");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Valid First Name");
            alert.showAndWait();
        } else if (!(tfprenom.getText().matches(caracteronly))) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("UNVALIDATE LAST NAME");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Valid last Name");
            alert.showAndWait();

        } else if (!validateEmail()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("VALIDATE EMAIL");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Valid Email");
            alert.showAndWait();
        } else if (!(tfauteur.getText().matches(caracteronly))) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("UNVALIDATE AOTHOR NAME");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Valid Author Name");
            alert.showAndWait();

        } else if (!(tfgenre.getText().matches(caracteronly))) {

            Alert alert2 = new Alert(Alert.AlertType.WARNING);
            alert2.setTitle("UNVALIDATE GENDER");
            alert2.setHeaderText(null);
            alert2.setContentText("Please Enter Valid gender");
            alert2.showAndWait();
        } else if (!validatePassword()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("UNVALIDATE PWD");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter a pwd that contains at least" + "\n"
                    + "lowercase letter" + "\n" + "one digit" + "\n" + "one special character" + "\n" + "one capital letter" + "\n"
                    + "also limits the length of password from minimum 8 letters to maximum 20 letters.");
            alert.showAndWait();
        } else if (!confirmPwd()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("UNVALIDATE CONFIRMATION ");
            alert.setHeaderText(null);
            alert.setContentText("Your Confirmation doesn't coincide with your Password");
            alert.showAndWait();
        } else if (uc.authentifier(tfemail.getText(), tfpassword.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("UNVALIDATE CONFIRMATION ");
            alert.setHeaderText(null);
            alert.setContentText("Your already have account");
            alert.showAndWait();
        } else {

            System.out.println("-----------enregistrement d'un utilisateur !");
            String tnom = tfnom.getText();
            String tprenom = tfprenom.getText();
            String temail = tfemail.getText();
            String tpassword = tfpassword.getText();
            String tauteur = tfauteur.getText();
            String tgenre = tfgenre.getText();
            String tstatut = tfstatut.getValue();
           
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqldate = new java.sql.Date(utilDate.getTime());
            Users u = new Users(tnom, tprenom, temail, tpassword, tauteur, tgenre, tstatut, sqldate);
         JavaMailing
               .sendMail(temail,"INSCRIPTION","Felicitation, vous êtes inscrit "); 
            clearFields();
            Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("SignUp");
            success.setHeaderText(null);
            success.setContentText("open your email box u've recieved an email");
            success.showAndWait();         
//        
        }

    }

    public void clearFields() {
        tfnom.clear();
        tfprenom.clear();
        tfauteur.clear();
        tfgenre.clear();
        tfpassword.clear();
        tfconfirm.clear();
        tfemail.clear();
        tfstatut.getSelectionModel().clearSelection();
    }

    private Boolean confirmPwd() {
        if (tfconfirm.getText().equals(tfpassword.getText())) {
            return true;
        } else {
            return false;
        }
    }

    private Boolean validateEmail() {
        Pattern p = Pattern.compile("^(.+)@(.+)$");
        Matcher m = p.matcher(tfemail.getText());
        return m.find() && m.group().equals(tfemail.getText());
    }

    private boolean validatePassword() {
        boolean isValid = true;
        if (tfpassword.getLength() > 15 || tfpassword.getLength() < 8) {
            System.out.println("Password must be less than 20 and more than 8 characters in length.");
            isValid = false;
        }
        String upperCaseChars = "(.*[A-Z].*)";
        if (!tfpassword.getText().matches(upperCaseChars)) {
            System.out.println("Password must have atleast one uppercase character");
            isValid = false;
        }
        String lowerCaseChars = "(.*[a-z].*)";
        if (!tfpassword.getText().matches(lowerCaseChars)) {
            System.out.println("Password must have atleast one lowercase character");
            isValid = false;
        }
        String numbers = "(.*[0-9].*)";
        if (!tfpassword.getText().matches(numbers)) {
            System.out.println("Password must have atleast one number");
            isValid = false;
        }
        String specialChars = "(.*[@,#,$,%,:,!,?,*,_,-,&,^,),(,',+,ç,=].*)";
        if (!tfpassword.getText().matches(specialChars)) {
            System.out.println("Password must have atleast one special character");
            isValid = false;
        }
        return isValid;
    }

}
