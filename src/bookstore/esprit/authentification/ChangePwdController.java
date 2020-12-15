/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.authentification;

import bookstore.esprit.entities.Users;
import bookstore.esprit.mainInterface.PersonnalDataInterfaceController;
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
import javafx.scene.control.PasswordField;

/**
 * FXML Controller class
 *
 * @author Oussema
 */
public class ChangePwdController implements Initializable {

    /**
     * Initializes the controller class.
     */
   

    @FXML
    private PasswordField Newpwd;

    @FXML
    private PasswordField Confirmnewpwd;

    @FXML
    void alter_Pw(ActionEvent event) {
       String theNewpwd = Newpwd.getText();
       String theConfirmation = Confirmnewpwd.getText();
        Users u = bookstore.esprit.entities.GlobalClass.getCurrentUser();
        if(theNewpwd.equals(theConfirmation)){
            usersCRUD uc = new usersCRUD();
            uc.modifier_PW(u.getEmail(), theNewpwd);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("CHANGE PASSWORD");
            alert.setHeaderText(null);    
            alert.setContentText("Password changed");
            alert.showAndWait();
             try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AuthentificationInterface.fxml"));
            Parent root3 = loader.load();
            AuthentificationInterfaceController pc2 = loader.getController();
           Confirmnewpwd.getScene().setRoot(root3);
        } catch (IOException ex) {
            ex.getMessage();
        }

            
        }
        else if( theNewpwd.isEmpty()){
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("UNCHECKED FIELD");
            alert.setHeaderText(null);    
            alert.setContentText("please enter the new password");
            alert.showAndWait();
        }
        else if (theConfirmation.isEmpty()){
             Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("UNCHECKED FIELD");
            alert.setHeaderText(null);    
            alert.setContentText("please confirm the new password");
            alert.showAndWait();
        }
        else if (!theNewpwd.equals(theConfirmation)){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("UNCHECKED FIELD");
            alert.setHeaderText(null);    
            alert.setContentText("your new password and its confirmation are not the same");
            alert.showAndWait();
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
