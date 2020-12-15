/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.entities;

import bookstore.esprit.entities.Users;

/**
 *
 * @author Oussema
 */
public class GlobalClass {
  private static  Users currentUser ;

    public static Users getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(Users currentUser) {
        GlobalClass.currentUser = currentUser;
    }
}
