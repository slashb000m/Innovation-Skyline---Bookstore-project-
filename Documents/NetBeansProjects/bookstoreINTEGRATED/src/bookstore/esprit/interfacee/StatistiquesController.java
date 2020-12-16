/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.interfacee;

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
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Legion
 */
public class StatistiquesController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
    @FXML
    private Button btnStatChiffreDaffaire;

    @FXML
    private Button btnStatGenreLivre;

    @FXML
    void afficherStatChiffreDaffaire(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("StatVenteLivre.fxml"));
            Parent root = loader.load();
            btnStatChiffreDaffaire.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(StatistiquesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void AfficherStatGenreLivre(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("StatVenteSelonGenre.fxml"));
            Parent root = loader.load();
            btnStatGenreLivre.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(StatistiquesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
}
    @FXML
    void retourPannel(ActionEvent event) {
         try {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("PannelAdmin.fxml"));
             Parent root = loader.load();
             btnStatChiffreDaffaire.getScene().setRoot(root);
         } catch (IOException ex) {
             Logger.getLogger(ListeReclamationsController.class.getName()).log(Level.SEVERE, null, ex);
         }


    }
}