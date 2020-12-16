/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.interfacee;

import bookstore.esprit.Mailing.JavaMailUtil;
import bookstore.esprit.services.AdminCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Legion
 */
public class EnvoyerNotificationController implements Initializable {

    
    @FXML
    private TextArea tfContenu;

    @FXML
    private Button btnNotifier;

    @FXML
    private TextField tfObjet;
    
        @FXML
    private Button btnRetour;


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    void envoyerReclamation(ActionEvent event) {
        
        String obj = tfObjet.getText();
        String contenu = tfContenu.getText();
        AdminCRUD ac = new AdminCRUD();
        ArrayList<String> liste = ac.getMailsFromUsers();
        for(String o:liste){
            JavaMailUtil.sendMail(o,obj, contenu);
        }
        System.out.println("Notif envoyé avec succés !");
        
        
    }
    
      @FXML
    void retourPannel(ActionEvent event) {
         try {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("PannelAdmin.fxml"));
             Parent root = loader.load();
             btnRetour.getScene().setRoot(root);
         } catch (IOException ex) {
             Logger.getLogger(ListeReclamationsController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
}
