/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.rt.entities;

/**
 *
 * @author Aditsan Kadmus
 */
public class Chambre {
    private int id;
    private String nom;
    private String description;
    private Restaurant restaurant;

    public Chambre() {
        restaurant = new Restaurant();
    }

    public Chambre(String nom, String description) {
        this.nom = nom;
        this.description = description;
        restaurant = new Restaurant();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Chambre other = (Chambre) obj;
        if (other.id != this.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Chambre{" + "id=" + id + ", nom=" + nom + ", description=" + description + ", restaurant=" + restaurant + '}';
    }
    
    
}
