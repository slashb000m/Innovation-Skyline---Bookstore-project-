/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.interfacee;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class AcheterLivreController implements Initializable {

    @FXML
    private TextField cardNumber;
    @FXML
    private PasswordField pwd;
    @FXML
    private Button Validate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Succes(ActionEvent event) {
        
        Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Success ");
            alert.setHeaderText(null);
            alert.setContentText("Merci d'avoir acheté ce Livre , Congrats !");
            alert.showAndWait();
    }
    
    
}
