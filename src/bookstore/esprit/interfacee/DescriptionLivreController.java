/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.interfacee;

import bookstore.esprit.entities.Livre;
import static com.sun.org.apache.bcel.internal.util.SecuritySupport.getResourceAsStream;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;
import test.MyConnexion;

/**
 * FXML Controller class
 *
 * @author Alia
 */
public class DescriptionLivreController implements Initializable {
     @FXML
    private Label nom;

    @FXML
    private Label auteur;

    @FXML
    private TextArea description;

    @FXML
    private Label prix;

    @FXML
    private Label nombre;

    @FXML
    private Label catégorie;

    @FXML
    private Label type;

    @FXML
    private Label datee;
      @FXML
    private ImageView imageView;
      private Image img;
    @FXML
    private TextField quantite;
    int n;
    @FXML
    private TextArea textsp;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          try {
            String requete= "SELECT  titre ,auteur ,categorie, description ,type, prix ,nbr_pages, date_sortie , image FROM livres where  id_livre='12' ";
            //Statement st = new MyConnexion().getCnx().createStatement();
             PreparedStatement pst = new MyConnexion().getCnx().prepareStatement(requete);
            ResultSet rs = pst.executeQuery(requete);
            while(rs.next()){
              
                this.nom.setText(rs.getString("titre"));
                this.auteur.setText(rs.getString("auteur"));
                this.catégorie.setText(rs.getString("categorie"));
                this.description.setText(rs.getString("description"));
                this.type.setText(rs.getString("type"));
                this.prix.setText(String.valueOf(rs.getFloat("prix")));
                this.nombre.setText(String.valueOf(rs.getInt("nbr_pages")));
                this.datee.setText(String.valueOf(rs.getDate("date_sortie")));
                System.out.println(rs.getString("image"));
               /* Image img= new Image(getClass().getResourceAsStream(rs.getString("image")));
                this.image.setImage(img);
                //Toolkit.getDefaultToolkit().geti
                
             /* InputStream is = rs.getBinaryStream("image");
                      img = new Image(is, 100, 150, true, true);
                      
 ImageView image= new ImageView(img);
 Image imagee= new Image(getClass().getResourceAsStream(rs.getString("image")));
  ImageView imageee= new ImageView(imagee);*/
               String urll=rs.getString("image");
               File file = new File(urll);
              
            InputStream stream = new FileInputStream(file);
            Image image = new Image(stream);
            imageView.setImage(image);
         
       
               
            }
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (FileNotFoundException ex) {
             Logger.getLogger(DescriptionLivreController.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }    

    @FXML
    private void moins(ActionEvent event) {
        
        n++;
        quantite.setText(String.valueOf(n));
        n=n;
    
            }

    @FXML
    private void plus(ActionEvent event) {
         n--;
        quantite.setText(String.valueOf(n));
        n=n;
    }
     private static final String VOICENAME = "kevin16";

    @FXML
    private void TextSpeech(ActionEvent event) {
        Voice voice;
         VoiceManager vm=VoiceManager.getInstance();
        voice=vm.getVoice(VOICENAME);
        voice.allocate(); 
        try {
            voice.speak(textsp.getText());
        } catch (Exception e) {
        }
    }
   
    
    
}
