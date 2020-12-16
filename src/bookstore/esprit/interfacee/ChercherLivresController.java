/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.interfacee;

import bookstore.esprit.entities.Livre;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import test.MyConnexion;

/**
 * FXML Controller class
 *
 * @author Alia
 */
public class ChercherLivresController implements Initializable {

    @FXML
    private TextField chercher;

    @FXML
    private TableView<Livre> table;

    @FXML
    private TableColumn<Livre, String> livre;
    @FXML
    private TableColumn<Livre, String> auteur;
     @FXML
    private TableColumn<Livre,?> voir;
    ObservableList<Livre> list = FXCollections.observableArrayList();

    @FXML
    void chercherlivre(ActionEvent event) {
        String ch = chercher.getText();
        int nbn = 0;

        int n = 0;
        boolean test;
        try {
            String requete = "SELECT  titre , auteur ,image  FROM livre ";

            Statement st = new MyConnexion().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            Livre l = new Livre();
            while (rs.next()) {
                n++;
                if (ch.equals(rs.getString(1))||ch.equals(rs.getString(2))) {

                    l.setTitle(rs.getString("titre"));
                    l.setAuteur(rs.getString("auteur"));
                    l.setImage(rs.getString("image"));
                    
                    list.add(l);

                    System.out.println("\n");

                } else {

                    nbn++;
                }

            }
            if (nbn == n) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("CHercher Livre");
                alert.setHeaderText("malhrureusement");
                alert.setContentText("Results: Ce livre n'existe pas");

                alert.showAndWait();
                chercher.setText("");

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        livre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        auteur.setCellValueFactory(new PropertyValueFactory<>("auteur"));
       
        table.setItems(list);

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }
}
