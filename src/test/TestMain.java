/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import bookstore.esprit.Mailing.JavaMailUtil;
import bookstore.esprit.entities.Livre;
import bookstore.esprit.entities.Reclamations;
import bookstore.esprit.entities.Users;
import bookstore.esprit.services.AdminCRUD;
import bookstore.esprit.services.LivreCRUD;
import bookstore.esprit.services.UsersCRUD;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alia
 */
public class TestMain {

    public static void main(String[] args) {
        
   String str="2018-03-21";  
    Date date=Date.valueOf(str);//converting string into sql date  
        
        
        MyConnexion mc = new MyConnexion();
       Users u1 = new Users("khalil", "messadi", "inovationskyline99@gmail.com","789456","jules vernes", "SCI-FI", "Etudiant",date);
      UsersCRUD uc = new UsersCRUD();
     uc.ajouterUser(u1);
        System.out.println(u1.getId_user());
      
      Reclamations r1 = new Reclamations("probleme de connexion", " je n'arrive pas a me connecter a mon compte "
              + "en plus j'ai un bug dans le champs de recupération de mot de passe ", date);
     uc.ajouterReclamation(u1, r1);
        System.out.println(r1.getId());
        AdminCRUD ac = new AdminCRUD();
     //  ac.supprimerReclamation(10);
       
    //System.out.println(ac.afficherReclamations());
     //  JavaMailUtil.sendMail("inovationskyline99@gmail.com","Objet quelquonque","Test quelquoncque");

    }

}
