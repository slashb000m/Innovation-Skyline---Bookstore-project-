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
public class PannelAdminController implements Initializable {

        @FXML
    private Button btnGotoStat;

    @FXML
    private Button btnGotoReclamation;
    
        @FXML
    private Button btnGestionUser;

    @FXML
    private Button btnGotoNotif;

    @FXML
    private Button btnGotoReduction;
    
    
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
     @FXML
    void goReclamation(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeReclamations.fxml"));
            Parent root = loader.load();
            btnGotoReclamation.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(StatVenteLivreController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void gotoStat(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Statistiques.fxml"));
            Parent root = loader.load();
            btnGotoReclamation.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(StatVenteLivreController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
       @FXML
    void goReduction(ActionEvent event) {
        
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AccorderReduction.fxml"));
            Parent root = loader.load();
            btnGotoReclamation.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(StatVenteLivreController.class.getName()).log(Level.SEVERE, null, ex);
        }
           

    }
    
     @FXML
    void goNotif(ActionEvent event) {
           try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EnvoyerNotification.fxml"));
            Parent root = loader.load();
            btnGotoReclamation.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(StatVenteLivreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        @FXML
    void goGestionUser(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListUsers.fxml"));
            Parent root = loader.load();
            btnGotoReclamation.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(StatVenteLivreController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
   
}
