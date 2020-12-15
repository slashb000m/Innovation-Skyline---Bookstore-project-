/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.mainInterface;

import bookstore.esprit.SignUp.InscriptionController;
import bookstore.esprit.authentification.AuthentificationInterfaceController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Oussema
 */
public class WelcomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ImageView imageview;
    @FXML
    private AnchorPane window;

    @FXML
    private Button bsigniin;

    @FXML
    private Button bsignup;

    @FXML
    void signIN(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../authentification/AuthentificationInterface.fxml"));
            Parent root3 = loader.load();
            AuthentificationInterfaceController pc2 = loader.getController();
            window.getScene().setRoot(root3);
        } catch (IOException ex) {
            ex.getMessage();
        }

    }

    @FXML
    void signUp(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../SignUp/Inscription.fxml"));
            Parent root2 = loader.load();
            InscriptionController pc2 = loader.getController();
            window.getScene().setRoot(root2);
        } catch (IOException ex) {
            ex.getMessage();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image image;
        image = new Image("/icons/imageB.jpg");
        imageview.setImage(image);
    }

}
