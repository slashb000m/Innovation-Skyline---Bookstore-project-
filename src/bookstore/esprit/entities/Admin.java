/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.entities;

/**
 *
 * @author Oussema
 */
    public class Admin {
        private int id_admin;
        private String nom;
        private String prenom;
        private String email;
        private String password;

    public Admin() {
    }
        

        public Admin(int id_admin, String nom, String prenom, String email, String password) {
            this.id_admin = id_admin;
            this.nom = nom;
            this.prenom = prenom;
            this.email = email;
            this.password = password;
        }

        public void setId_admin(int id_admin) {
            this.id_admin = id_admin;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getId_admin() {
            return id_admin;
        }

        public String getNom() {
            return nom;
        }

        public String getPrenom() {
            return prenom;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        @Override
        public String toString() {
            return "Admin{" + "id_admin=" + id_admin + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password=" + password + '}';
        }



    }
