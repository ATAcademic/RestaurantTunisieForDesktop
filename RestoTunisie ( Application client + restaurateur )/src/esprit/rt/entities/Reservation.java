package esprit.rt.entities;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author Pingouins de désert
 * 
 */

public class Reservation {
    
    private int id;
    private Date date;
    private int nbrPlace;
    private float prixTotale;
    private Client client;
    private List<Commande> commandes;
    private Restaurant restaurant;

    public Reservation() {
    }

    public Reservation(Date date, int nbrPlace) {
        this.date = date;
        this.nbrPlace = nbrPlace;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNbrPlace() {
        return nbrPlace;
    }

    public void setNbrPlace(int nbrPlace) {
        this.nbrPlace = nbrPlace;
    }

    public float getPrixTotale() {
        return prixTotale;
    }

    public void setPrixTotale(float prixTotale) {
        this.prixTotale = prixTotale;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Reservation other = (Reservation) obj;
        if (this.id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", date=" + date + ", nbrPlace=" + nbrPlace + ", prixTotale=" + prixTotale + ", client=" + client + ", commandes=" + commandes + ", restaurant=" + restaurant + '}';
    }
    
    
    
}
