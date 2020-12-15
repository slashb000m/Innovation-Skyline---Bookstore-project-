/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.mainInterface;

import bookstore.esprit.SignUp.InscriptionController;
import bookstore.esprit.entities.Users;
import bookstore.esprit.services.usersCRUD;
import bookstore.esprit.tests.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Oussema
 */
public class PersonnalDataInterfaceController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField dataname;

    @FXML
    private TextField dataprenom;

    @FXML
    private TextField dataemail;

    @FXML
    private TextField datadate;

    @FXML
    private TextField dataauteur;

    @FXML
    private TextField datapwd;

    @FXML
    private TextField dataid;

    @FXML
    private TextField datagenre;
//

    public void setDataname(String dataname) {
        this.dataname.setText(dataname);
    }

    public void setDataprenom(String dataprenom) {
        this.dataprenom.setText(dataprenom);
    }

    public void setDataemail(String dataemail) {
        this.dataemail.setText(dataemail);
    }

    public void setDatadate(Date datadate) {
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        String stringDate = df.format(datadate);
        this.datadate.setText(stringDate);
    }

    public void setDataauteur(String dataauteur) {
        this.dataauteur.setText(dataauteur);
    }

    public void setDatapwd(String datapwd) {
        this.datapwd.setText(datapwd);
    }

    public void setDataid(int dataid) {
        String id = Integer.toString(dataid);
        this.dataid.setText(id);
    }

    public void setDatagenre(String datagenre) {
        this.datagenre.setText(datagenre);
    }

    @FXML
    void confirmData(ActionEvent event) {
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {

            Users u = bookstore.esprit.entities.GlobalClass.getCurrentUser();
            System.out.println(u.getEmail());
            String requete = "select * from users where email =?";
            try {
                PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete);
                pst.setString(1, u.getEmail());
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {

                    setDataname(rs.getString(1));
                    setDataprenom(rs.getString(2));
                    setDataemail(rs.getString(3));
                    setDatadate(rs.getDate(4));
                    setDataauteur(rs.getString(6));
                    setDatagenre(rs.getString(5));

                }
            } catch (SQLException ex) {
                ex.getMessage();
            }

        } catch (Exception ex) {
            ex.getMessage();
        }

    }

}
