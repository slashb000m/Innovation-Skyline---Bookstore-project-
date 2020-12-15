/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import bookstore.esprit.entities.Livre;
import bookstore.esprit.entities.souhaits;
import bookstore.esprit.entities.users;
import bookstore.esprit.services.LivreCRUD;
import bookstore.esprit.services.souhaitsCRUD;
import bookstore.esprit.services.usersCrud;
import java.sql.Date;
import java.util.Map;

/**
 *
 * @author Alia
 */
public class TestMain {

    public static void main(String[] args) {
        MyConnexion mc = new MyConnexion();
//        Livre l1 = new Livre(1, "Cindrella ", "Disnep", "fantasy", "a poor girl who took care of her haiting family ends up living happily ever after", "numérique", 9.122f, 286);
//        Livre l2 = new Livre( 2,"The lost girls of Paris", "Pam Jenoff ", "adventure", "After finding an abandoned suitcase filled with photographs, Grace Healey soon learns the case belonged to the leader of a network of female secret agents deployed during World War II.", "numérique", 9.122f, 286);
       LivreCRUD lc= new LivreCRUD();
    
     // Livre   l3=new Livre(15,"houmem ", "houmembook", "autobiographie", "houmem yahki ala rouhou", "hammeux", 0.15f, 1, "c://bureau");
      Livre   l4=new Livre(25,"hammadi ", "hammadibook", "autobiographie", "hammadi yahki ala rouhou", "hammeux", 0.15f, 1, "c://bureau");
        
//        lc.AjouterLivre(l4);
//        String str = "2015-03-31";
//        Date date = Date.valueOf(str);
//        users u1 = new users("anyname", "anylastname", "anything@gmail.com", "1234", "hammadi", "bolice", "N/A",date, 4);
////        usersCrud us= new usersCrud();
//        us.inscrire(u1);
//    //Livre   l5=new Livre(0,"hey ", "heybook", "autobiographie", "heyheyhey", "heyyo", 0.15f, 1, "c://bureau");
//        //souhaits s3= new souhaits (l4.getIdentifiant(), u1.getId_user());
//    lc.AjouterLivre(l4);

       //users x=new users(1);
       
        
      
String str = "2015-03-31";
        Date date = Date.valueOf(str);
        users u=   new users("anyname", "anylastname", "anything@gmail.com", "1234", "hammadi", "bolice", "N/A",date, 10);
        
      // sc.ajouterSouhaits(s5);
      souhaitsCRUD sc = new souhaitsCRUD();
   
     //souhaits s5= new souhaits(l4.getIdentifiant(), u.getId_user());     
        System.out.println(sc.listerSouhaits(u));
    
    }

}
