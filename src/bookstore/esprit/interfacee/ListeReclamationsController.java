/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.interfacee;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import bookstore.esprit.DAO.ListeReclamtionDAO;
import bookstore.esprit.Mailing.JavaMailUtil;
import bookstore.esprit.services.AdminCRUD;
import java.io.IOException;
import java.util.logging.Level;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Legion
 */
public class ListeReclamationsController implements Initializable {

    @FXML
    private TableColumn<ListeReclamtionDAO, String> colonneNom;

    @FXML
    private TableColumn<ListeReclamtionDAO, String> colonneTitre;

    @FXML
    private TableColumn<ListeReclamtionDAO, Integer> colonneId;

    @FXML
    private TableView<ListeReclamtionDAO> tableReclamation;

    @FXML
    private TableColumn<ListeReclamtionDAO, String> colonneDescription;

    @FXML
    private TextField tfIdReclamation;

    @FXML
    private Button btnTraiter;

    @FXML
    private Button btnSupprimer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        colonneId.setCellValueFactory(new PropertyValueFactory<>("id"));

        colonneNom.setCellValueFactory(new PropertyValueFactory<>("mail"));

        colonneTitre.setCellValueFactory(new PropertyValueFactory<>("titre"));

        colonneDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        AdminCRUD ac = new AdminCRUD();

        ObservableList<ListeReclamtionDAO> data = FXCollections.observableArrayList(ac.afficherReclamations());
        tableReclamation.setItems(data);

    }

    @FXML
    void traiterReclamation(ActionEvent event) throws IOException {
        System.out.println("Traitement de la reclamation");
        String idTexte = tfIdReclamation.getText();
        int i = Integer.parseInt(idTexte);
        
        AdminCRUD ac = new AdminCRUD();
        JavaMailUtil.sendMail(ac.getUserEmailFromReclamationId(i), "Validation de réclamation", "Bonjour \n, Votre réclmamation a été traitée par l'admin");
        ac.traiterReclamation(i);
       
        System.out.println("Mail envoyé !");
         FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeReclamations.fxml"));
           Parent root = loader.load();
           tfIdReclamation.getScene().setRoot(root);

    }

    @FXML
    void supprimerReclamation(ActionEvent event) throws IOException {
 System.out.println("Supression de la réclamation");
        String idTexte = tfIdReclamation.getText();
        int i = Integer.parseInt(idTexte);
        AdminCRUD ac = new AdminCRUD();
         JavaMailUtil.sendMail(ac.getUserEmailFromReclamationId(i), "retour sur réclamation", "Bonjour \n, l'admin ayant étudié votre réclamation, vous informe par la présente qu'il est dans l'incapacité de la traiter.");
        ac.traiterReclamation(i);
         FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeReclamations.fxml"));
           Parent root = loader.load();
           tfIdReclamation.getScene().setRoot(root);        

    }

}
