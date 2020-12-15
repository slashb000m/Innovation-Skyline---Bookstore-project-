package bookstore.esprit.interfacee;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Dhia
 */


 
import bookstore.esprit.entities.Livre;
import bookstore.esprit.entities.users;
import bookstore.esprit.services.souhaitsCRUD;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
 
public class HashMapToArrayListMainJava8 {
 
	public static void main(String[] args) {
		 String str = "2015-03-31";
        Date date = Date.valueOf(str);
        users u=   new users("anyname", "anylastname", "anything@gmail.com", "1234", "hammadi", "bolice", "N/A",date, 10);
        
              
       souhaitsCRUD sc= new souhaitsCRUD();
      
      HashMap m =sc.listerSouhaits(u);
		HashMap<Livre, users> customerIdNameMap = new HashMap<>();
                customerIdNameMap = m;
		// Putting key-values pairs in HashMap
		
		
		
		// Java 8
                // Convert keys to ArrayList
		List<Livre> customerIdList = customerIdNameMap.keySet()
				                                        .stream()
				                                        .collect(Collectors.toList());
		System.out.println("customerIds: "+customerIdList);
		
                // Convert values to ArrayList
		List<users> customerNames = customerIdNameMap.values()
				                                      .stream()
				                                      .collect(Collectors.toList());
		System.out.println("Customer Names: "+ customerNames);
		
                // Convert entry objects to ArrayList
		List<Entry<Livre, users>> entryCustomerList = customerIdNameMap.entrySet()
				                                                           .stream()
				                                                           .collect(Collectors.toList());
		//System.out.println("Customer ID and Names: "+entryCustomerList);
                
                
                for (int i=0 ; i<entryCustomerList.size() ; i++)
                    
                { 
                    System.out.println(entryCustomerList.get(i).getKey().getIdentifiant());
                    System.out.println(entryCustomerList.get(i).getKey().getTitre());
                    System.out.println(entryCustomerList.get(i).getKey().getDescription());
                    System.out.println(entryCustomerList.get(i).getValue().getId_user());
                    System.out.println(entryCustomerList.get(i).getValue().getPrenom());
                    System.out.println(entryCustomerList.get(i).getValue().getNom());
                    System.out.println("*****************************");
                  
                
                }
                ObservableList<Map.Entry<Livre, users>> intermediaire = FXCollections.observableArrayList();
        for (int i=0 ; i<entryCustomerList.size() ; i++)
        {
        intermediaire.add(entryCustomerList.get(i));
        }
            System.out.println(intermediaire);
	}
}

