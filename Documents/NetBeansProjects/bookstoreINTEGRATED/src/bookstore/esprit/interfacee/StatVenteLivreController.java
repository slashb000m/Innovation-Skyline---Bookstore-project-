/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.interfacee;

import bookstore.esprit.DAO.ChiffreDaffaireMensuel;
import bookstore.esprit.services.AdminCRUD;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Legion
 */
public class StatVenteLivreController implements Initializable {

    @FXML
    private AreaChart areaChartChiffreDaffaire;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        XYChart.Series series = new XYChart.Series();

        AdminCRUD ac = new AdminCRUD();
        ArrayList<ChiffreDaffaireMensuel> data = new ArrayList<>();
        data = ac.getDataForChiffreDaffaire();

        for (ChiffreDaffaireMensuel o : data) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            String strDate = dateFormat.format(o.getDate());

            series.getData().add(new XYChart.Data(String.valueOf(o.getDate().getMonth()) + "/" + String.valueOf((o.getDate().getYear()) + 1900), o.getSommeMensuel()));
        }

        areaChartChiffreDaffaire.getData().add(series);

    }

    @FXML
    private Button btnRetour;

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
