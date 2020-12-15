/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.entities;

import java.sql.Date;

/**
 *
 * @author Alia
 */
public class Livre {
    private int identifiant;
    private String titre;
    private String auteur;
    private String catégorie;
    private String description;
    private String typelivre;
    private float prix;
    private int nombre_page;
    
    private String image;
   
    

    public Livre() {
    }

    public Livre(int identifiant, String titre, String auteur, String catégorie, String description, String typelivre, float prix, int nombre_page) {
        this.identifiant = identifiant;
        this.titre = titre;
        this.auteur = auteur;
        this.catégorie = catégorie;
        this.description = description;
        this.typelivre = typelivre;
        this.prix = prix;
        this.nombre_page = nombre_page;
    }

    public Livre(int identifiant, String titre, String description) {
        this.identifiant = identifiant;
        this.titre = titre;
        this.description = description;
    }

    

  
    

 

  

    
    

    public int getIdentifiant() {
        return identifiant;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getCatégorie() {
        return catégorie;
    }

    public String getDescription() {
        return description;
    }

    public String getTypelivre() {
        return typelivre;
    }

    public float getPrix() {
        return prix;
    }

    public int getNombre_page() {
        return nombre_page;
    }

   
    

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public void setTitle(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setCatégorie(String catégorie) {
        this.catégorie = catégorie;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTypelivre(String typelivre) {
        this.typelivre = typelivre;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setNombre_page(int nombre_page) {
        this.nombre_page = nombre_page;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

   
    

    public Livre(String titre, String auteur, String catégorie, String description, String typelivre, float prix, int nombre_page, String image) {
        this.titre = titre;
        this.auteur = auteur;
        this.catégorie = catégorie;
        this.description = description;
        this.typelivre = typelivre;
        this.prix = prix;
        this.nombre_page = nombre_page;
                this.image=image;
       
    }

   
    @Override
    public String toString() {
        return "Livre{" + "identifiant=" + identifiant + ", titre=" + titre + ", auteur=" + auteur + ", cat\u00e9gorie=" + catégorie + ", description=" + description + ", typelivre=" + typelivre + ", prix=" + prix + ", nombre_page=" + nombre_page + "image="+ image+ '}';
    }
    

    
    
    
    
    
   
    
}
