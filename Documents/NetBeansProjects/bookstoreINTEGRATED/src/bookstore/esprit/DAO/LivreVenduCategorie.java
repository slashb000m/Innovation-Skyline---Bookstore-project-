/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.DAO;

/**
 *
 * @author Legion
 */
public class LivreVenduCategorie {
    private int sommesLivreVendu;
    private String categorie;

    public int getSommesLivreVendu() {
        return sommesLivreVendu;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setSommesLivreVendu(int sommesLivreVendu) {
        this.sommesLivreVendu = sommesLivreVendu;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public LivreVenduCategorie() {
    }

    @Override
    public String toString() {
        return "LivreVenduCategorie{" + "sommesLivreVendu=" + sommesLivreVendu + ", categorie=" + categorie + '}';
    }
    
    
    
}
