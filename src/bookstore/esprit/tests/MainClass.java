/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.tests;

import bookstore.esprit.entities.Users;
import bookstore.esprit.services.JavaMailing;
import bookstore.esprit.services.usersCRUD;

/**
 *
 * @author Oussema
 */
public class MainClass {
    public static void main(String[] args) {
        MyConnection mc = MyConnection.getInstance();
        usersCRUD uc = new usersCRUD();
        
      //  Users u = new Users("ala_soltani@hotmail.com", "Aezakmi402??");
      //  System.out.println(uc.authentifier("edinealaeddine344@gmail.com", "Aezakmi402??"));;
  //     System.out.println(uc.exist("helimi.dhaouadi@hotmail.com"));
//       JavaMailing
//               .sendMail("soltanialia114@gmail.com","INSCRIPTION","Felicitation, vous êtes inscrit ");   
    }

}
