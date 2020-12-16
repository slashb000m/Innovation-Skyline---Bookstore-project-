/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.interfacee; 

import bookstore.esprit.entities.Reclamations;
import bookstore.esprit.entities.Users;
import bookstore.esprit.services.UsersCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Legion
 */
public class AjouterReclamationsController implements Initializable {

   @FXML
   private TextField tfObjet;
   @FXML
   private TextField tfExplication;
   @FXML
   private Button btnSoumettreReclamation;
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void saveReclamation(ActionEvent event){
       try {
           System.out.println("-------------------Sauvegarde dans la base ----------------------");
           String str="2018-03-21";
           Date date=Date.valueOf(str);
           String obj = tfObjet.getText();
           String desc = tfExplication.getText();
           Reclamations r = new Reclamations(obj, desc, date);
           Users u = new Users();
           
           UsersCRUD uc = new UsersCRUD();
           
           uc.ajouterReclamation(u, r);
           
           FXMLLoader loader = new FXMLLoader(getClass().getResource("SuccesReclamation.fxml"));
           Parent root = loader.load();
           tfObjet.getScene().setRoot(root);
       } catch (IOException ex) {
           Logger.getLogger(AjouterReclamationsController.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }
    
}
