package esprit.rt.entities;

/**
 *
 * @author Pingouins de désert
 * 
 */

public class Commande {
    
    private int id;
    private Reservation reservation;
    private Plat plat;
    private int nbr;

    public Commande() 
    {
    }
    
    public Commande(int nbr) {
        this.nbr = nbr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Plat getPlat() {
        return plat;
    }

    public void setPlat(Plat plat) {
        this.plat = plat;
    }

    public int getNbr() {
        return nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
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
        final Commande other = (Commande) obj;
        if (this.id == other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", reservation=" + reservation + ", plat=" + plat + ", nbr=" + nbr + '}';
    }
    
}
