/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.authentification;

import bookstore.esprit.SignUp.InscriptionController;
import bookstore.esprit.entities.Users;
import bookstore.esprit.mainInterface.PersonnalDataInterfaceController;
import bookstore.esprit.services.JavaMailing;
//import static edu.projet.mainInterface.AuthentificationInterfaceController.useremail;
import bookstore.esprit.services.usersCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Oussema
 */
public class AuthentificationInterfaceController implements Initializable {

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;
    @FXML
    private Button forgetbutton;

    @FXML
    private Button setButton1;

    public void setEmail(TextField email) {
        this.email = email;
    }

    public void setPassword(PasswordField password) {
        this.password = password;
    }

    public void setLoginButton(Button loginButton) {
        this.loginButton = loginButton;
    }

    @FXML
    private Button loginButton;

//public static String useremail ;
//useremail = email.getText();
    @FXML
    void authentificationTest(ActionEvent event) {
        String temail = email.getText();
        String tpwd = password.getText();
        Users u = new Users(temail, tpwd);
        usersCRUD uc = new usersCRUD();
        Boolean testerAuthentification = uc.authentifier(temail, tpwd);
        if (!testerAuthentification) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("AUTHENTIFICATION FAILURE");
            alert.setHeaderText(null);
            alert.setContentText("wrong login or password");
            alert.showAndWait();

        } else {
            //       U
            // String currentUserName = u.getNom();

            bookstore.esprit.entities.GlobalClass.setCurrentUser(uc.getUser(email.getText()));
            //Global.GlobalClass.setCurrentUser(u); 

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("AUTHENTIFICATION SUCCEEDED");
            alert.setHeaderText(null);
            alert.setContentText("welcome again ");
            alert.showAndWait();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../mainInterface/PersonnalDataInterface.fxml"));
                Parent root2 = loader.load();
                PersonnalDataInterfaceController pc2 = loader.getController();
                email.getScene().setRoot(root2);

            } catch (IOException ex) {
                ex.getMessage();
            }
        }

    }

    @FXML
    void pwdMail(ActionEvent event) {
        usersCRUD uc = new usersCRUD();
        String temail = email.getText();
        String pwd = uc.getPwfromDB(temail);
        Boolean testerAuthentification = uc.authentifier(temail, pwd);
        if (!testerAuthentification) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("AUTHENTIFICATION SUCCEEDED");
            alert.setHeaderText(null);
            alert.setContentText("you do not even have an account");
            alert.showAndWait();
        } else {
            JavaMailing.sendMail(temail, "PWD", "your password is :" + pwd);
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("PWD RECOVERY");
            alert.setHeaderText(null);
            alert.setContentText("check your email, we sent your paassword");
            alert.showAndWait();
        }
    }

    @FXML
    void set_Pwd(ActionEvent event) {
        String temail = email.getText();
        usersCRUD uc = new usersCRUD();
   //  Users u =  bookstore.esprit.entities.GlobalClass.getCurrentUser();
//        System.out.println(u.getEmail());
           if(temail.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WRONG EMAIL");
            alert.setHeaderText(null);
            alert.setContentText("please check your email");
            alert.showAndWait();
        }
           else if (uc.exist(temail)) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ChangePwd.fxml"));
                Parent root2 = loader.load();
                ChangePwdController pc2 = loader.getController();
                email.getScene().setRoot(root2);
            } catch (IOException ex) {
                ex.getMessage();
            }
        } 

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setEmail(String temail) {
        this.email.setText(temail);
    }

    public void setPassword(String tpassword) {
        this.password.setText(tpassword);
    }

}
