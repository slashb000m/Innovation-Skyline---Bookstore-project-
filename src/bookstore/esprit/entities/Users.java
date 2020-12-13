package bookstore.esprit.entities ;

import java.util.Date;

public class Users {
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String auteur_préféré;
    private String genre_préféré;
    private String statut;
    private Date date_dinscription ;
    private int id_user;

    public Users() {
    }

    public Users(String nom, String prenom, String email, String password, String auteur_préféré, String genre_préféré, String statut, Date date_dinscription) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.auteur_préféré = auteur_préféré;
        this.genre_préféré = genre_préféré;
        this.statut = statut;
        this.date_dinscription = date_dinscription;
    }

    public Date getDate_dinscription() {
        return date_dinscription;
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

    public String getAuteur_préféré() {
        return auteur_préféré;
    }

    public String getGenre_préféré() {
        return genre_préféré;
    }

    public String getStatut() {
        return statut;
    }

    public int getId_user() {
        return id_user;
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

    public void setAuteur_préféré(String auteur_préféré) {
        this.auteur_préféré = auteur_préféré;
    }

    public void setGenre_préféré(String genre_préféré) {
        this.genre_préféré = genre_préféré;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setDate_dinscription(Date date_dinscription) {
        this.date_dinscription = date_dinscription;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Users{" + "nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password=" + password + ", auteur_pr\u00e9f\u00e9r\u00e9=" + auteur_préféré + ", genre_pr\u00e9f\u00e9r\u00e9=" + genre_préféré + ", statut=" + statut + ", date_dinscription=" + date_dinscription + ", id_user=" + id_user + '}';
    }
}
    