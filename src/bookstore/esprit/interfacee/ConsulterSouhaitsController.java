package bookstore.esprit.interfacee;

import bookstore.esprit.entities.Livre;
import bookstore.esprit.entities.souhaits;
import bookstore.esprit.entities.users;
import bookstore.esprit.services.souhaitsCRUD;
import bookstore.esprit.services.usersCrud;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableHashMap;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import static javafx.scene.control.SelectionMode.MULTIPLE;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import static jdk.nashorn.internal.objects.NativeArray.map;
import static jdk.nashorn.internal.objects.NativeDebug.map;
import test.MyConnexion;


public class ConsulterSouhaitsController {
  

    @FXML
    private TableView<Livre> table1;

    @FXML
    private TableColumn<Livre, String> id_livre;

    @FXML
    private TableColumn<Livre,String> titre;

    @FXML
    private TableColumn<Livre,String> description;

    @FXML
    private Button btn;
    
        @FXML
    private Button delete;
    
        
        int i;
    @FXML
   
            
    void delete_souhait(ActionEvent event) {
ObservableList<Livre> selectedRows1, alllivres;
        alllivres = table1.getItems();
   
       
        
         
        selectedRows1 = table1.getSelectionModel().getSelectedItems();
       String str = "2015-03-31";
        Date date = Date.valueOf(str);
        users u=   new users("anyname", "anylastname", "anything@gmail.com", "1234", "hammadi", "bolice", "N/A",date, 10);
        
              
       souhaitsCRUD sc= new souhaitsCRUD();

      Livre l=selectedRows1.get(1);
//    
    for (Livre Livre: selectedRows1)
        {
            
            alllivres.remove(Livre);
            
        }
      
   
            
           
            
             sc.supprimerSouhaits(u,l);   
             System.exit(0);
        
        }
     

    
     ObservableList<Livre> list = FXCollections.observableArrayList();
     ObservableList<users> list1 = FXCollections.observableArrayList();
     
    public void initialize(URL url, ResourceBundle rb){
    
     
    
    }


    @FXML
    void afficherListeSouhait(ActionEvent event) {
    
           
        
       String str = "2015-03-31";
        Date date = Date.valueOf(str);
        users u=   new users("anyname", "anylastname", "anything@gmail.com", "1234", "hammadi", "bolice", "N/A",date, 10);
        
              
       souhaitsCRUD sc= new souhaitsCRUD();
      
      Map m =sc.listerSouhaits(u);
      Set<Map.Entry<Livre, users>> entrySet = m.entrySet();
      for(Map.Entry<Livre,users> entry:entrySet)
      {
        list.add(entry.getKey());
        list1.add(entry.getValue());
      }
       
  id_livre.setCellValueFactory(new PropertyValueFactory<>("identifiant"));
        titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
              table1.setItems(list);
    
    }

}
