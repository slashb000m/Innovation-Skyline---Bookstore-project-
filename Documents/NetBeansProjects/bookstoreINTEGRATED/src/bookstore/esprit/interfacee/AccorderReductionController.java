/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.interfacee;

import bookstore.esprit.entities.Livre;
import bookstore.esprit.services.AdminCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Legion
 */
public class AccorderReductionController implements Initializable {

    @FXML
    private TableColumn<?, ?> colonneNom;
    
    @FXML
    private Button btnRetour;


    @FXML
    private TableColumn<?, ?> colonneId;

    @FXML
    private Button btnConfirmer;

    @FXML
    private TableColumn<?, ?> colonnePrix;
    
       @FXML
    private TableView<Livre> tableLivres;

    @FXML
    private TextField tfIdLivre;

    @FXML
    private TextField tfPourcentageReduction;

   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colonneId.setCellValueFactory(new PropertyValueFactory<>("identifiant"));

        colonneNom.setCellValueFactory(new PropertyValueFactory<>("titre"));

        colonnePrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        AdminCRUD ac = new AdminCRUD();
        
        ObservableList<Livre> data = FXCollections.observableArrayList(ac.getLivresForReduction());
        tableLivres.setItems(data);

        
       

      
    }    
    


    @FXML
    void accorderReduction(ActionEvent event) {
        try {
            AdminCRUD ac = new AdminCRUD();
            int id = Integer.valueOf(tfIdLivre.getText());
            int reduction = Integer.valueOf(tfPourcentageReduction.getText());
            ac.setReduction(id, reduction);
            System.out.println("Reduction accordé ! ");
            EnvoyerNotificationController notif = new EnvoyerNotificationController();
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AccorderReduction.fxml"));
            Parent root = loader.load();
            btnConfirmer.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AccorderReductionController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     @FXML
    void retourPannel(ActionEvent event) {
         try {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("PannelAdmin.fxml"));
             Parent root = loader.load();
             btnConfirmer.getScene().setRoot(root);
         } catch (IOException ex) {
             Logger.getLogger(ListeReclamationsController.class.getName()).log(Level.SEVERE, null, ex);
         }


    }
    
}
