/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.interfacee;

import bookstore.esprit.DAO.LivreVenduCategorie;
import bookstore.esprit.services.AdminCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Legion
 */
public class StatVenteSelonGenreController implements Initializable {

    @FXML
    private Button btnRetour;
    
      @FXML
    private PieChart chart;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         
        
        chart.setTitle("Proportion des livres vendu selon leur catégorie");
        AdminCRUD ac = new AdminCRUD();
        ArrayList<LivreVenduCategorie> liste = ac.getDataForProportionCategorie();
        ObservableList<PieChart.Data> pieChartData =
               FXCollections.observableArrayList();
        for (LivreVenduCategorie o:liste){
            pieChartData.add(new PieChart.Data(o.getCategorie(), o.getSommesLivreVendu()));
            
        }
        
             
       
        
        
         chart.setData(pieChartData); 
    }

    @FXML
    void retourInterfaceStatistique(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Statistiques.fxml"));
            Parent root = loader.load();
            btnRetour.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(StatVenteLivreController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
