package esprit.rt.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Pingouins du désert
 * 
 */

public class Restaurateur extends Utilisateur{
    
    private char etat;
    private List<Restaurant> restaurants;
    
    public Restaurateur() {
        restaurants = new ArrayList<Restaurant>();
    }

    public Restaurateur(char etat, String nom, String prenom, String email, String password, Date dateNaissance, int numTel, String adresse, String region, char sexe, String questionSecurite, String reponseSecurite, String description) {
        super(nom, prenom, email, password, dateNaissance, numTel, adresse, region, sexe, questionSecurite, reponseSecurite, description);
        this.etat = etat;
        restaurants = new ArrayList<Restaurant>();
    }

    public char getEtat() {
        return etat;
    }

    public void setEtat(char etat) {
        this.etat = etat;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Restaurateur other = (Restaurateur) obj;
        if (this.getId() != this.getId())
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Restaurateur{" + "etat=" + etat + ", restaurants=" + restaurants + '}';
    }

    
}
