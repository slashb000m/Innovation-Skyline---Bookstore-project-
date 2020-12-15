/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.history;

import bookstore.esprit.entities.Achats;
import bookstore.esprit.entities.Livre;
import bookstore.esprit.entities.Users;
import bookstore.esprit.services.usersCRUD;
import java.net.URL;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Oussema
 */
public class ConsulaterHistoriqueController implements Initializable {

    /**
     * Initializes the controller class.
     */
//    final ObservableList<Map> data = FXCollections.observableArrayList();
//data.addAll();
    @FXML
    private TableView<Livre> table2;

    @FXML
    private TableColumn<Livre, String> auteur;

    @FXML
    private TableColumn<Livre, String> titre;

    @FXML
    private TableView<Achats> table;

    @FXML
    private TableColumn<Achats, Float> prix;

    @FXML
    private TableColumn<Achats, Date> date;
    @FXML
    private TableColumn<Achats, Integer> id;

    ObservableList<Livre> list = FXCollections.observableArrayList();
    ObservableList<Achats> list2 = FXCollections.observableArrayList();

    @FXML
    void listerAchat(ActionEvent event) {
        Map<Achats, Livre> myList = new HashMap<Achats, Livre>();
        String str = "2015-03-31";
        Date dates = Date.valueOf(str);
        Users u = new Users("Ahmed", "samaali", "ahmed.samaali@gmail.com", "efjekgerg", "vitctore hugo", "romance", "etudiant", dates, 1);
        usersCRUD uc = new usersCRUD();

        Map m = uc.consulterHistorique(u);
        Set<Map.Entry<Achats, Livre>> entrySet = m.entrySet();
        for (Map.Entry<Achats, Livre> entry : entrySet) {
            list2.add(entry.getKey());
            list.add(entry.getValue());
            auteur.setCellValueFactory(new PropertyValueFactory<>("auteur"));
            titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
            id.setCellValueFactory(new PropertyValueFactory<>("id_achat_user"));
            prix.setCellValueFactory(new PropertyValueFactory<>("prix_dachat"));
            date.setCellValueFactory(new PropertyValueFactory<>("date_achat"));
            table.setItems(list2);
            table2.setItems(list);

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

}
