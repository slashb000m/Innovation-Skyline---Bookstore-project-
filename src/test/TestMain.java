/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import bookstore.esprit.entities.Livre;
import bookstore.esprit.services.LivreCRUD;
import java.util.Date;


/**
 *
 * @author Alia
 */
public class TestMain {
    

    public static void main(String[] args) {
        Date d= new Date();
        MyConnexion mc = new MyConnexion();
        Livre l2 = new Livre( 10,"The lost girls of Paris", "Pam Jenoff ", "adventure","desc", "numérique", 9.122f, 286 );
       // Livre l3 = new Livre( "mariem abidli", "Pam Jenoff ", "adventure", "After finding an ", "numérique", 122.0f, 286 );
       
        LivreCRUD lc= new LivreCRUD();
        lc.AjouterLivre(l2);
       // lc.supprimerLivre(l2);
       // for (int i = 0; i < 10; i++) {
           //System.out.println(lc.chercherLivre()); 
        //}
       lc.modifierLivre(l2, 4);
        
//      
    

       
    }

}
