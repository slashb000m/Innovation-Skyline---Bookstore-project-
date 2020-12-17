/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.interfacee;

import bookstore.esprit.entities.Livre;
import bookstore.esprit.services.LivreCRUD;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import test.MyConnexion;

/**
 * FXML Controller class
 *
 * @author Alia
 */
public class SupprimerLivreController implements Initializable {

    @FXML
    private TextField sid;
    @FXML
    private TableView<Livre> tableview;

    @FXML
    private TableColumn<Livre, Integer> identifiant;

    @FXML
    private TableColumn<Livre, String> titre;

    @FXML
    private TableColumn<Livre, String> auteur;

    @FXML
    private TableColumn<Livre, String> categorie;

    ObservableList<Livre> list = FXCollections.observableArrayList();
    @FXML
    private TextField textf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void supprimerLivre(Event event) {

        try {
            String identif = sid.getText();
            

            Livre l = new Livre(Integer.parseInt(identif));
            LivreCRUD lc = new LivreCRUD();
            lc.supprimerLivre(l);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Suppression  d'un livre");
            alert.setContentText("Results: Ce livre  a éte supprimée");
            alert.showAndWait();
            sid.setText("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    private void afficherliste(ActionEvent event) {
        try {
            String requete = "SELECT id_livre , titre ,auteur ,categorie FROM livres";
            Statement st = new MyConnexion().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Livre l = new Livre();

                list.add(new Livre(rs.getInt("id_livre"), rs.getString("titre"), rs.getString("auteur"), rs.getString("categorie")));

                System.out.println("\n");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        identifiant.setCellValueFactory(new PropertyValueFactory<>("identifiant"));
        titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        auteur.setCellValueFactory(new PropertyValueFactory<>("auteur"));
        categorie.setCellValueFactory(new PropertyValueFactory<>("catégorie"));

        tableview.setItems(list);

    }

   @FXML
    private void getselected(MouseEvent event) {
        Livre l = tableview.getSelectionModel().getSelectedItem();
        sid.setText(String.valueOf(l.getIdentifiant()));
       
    }

}
