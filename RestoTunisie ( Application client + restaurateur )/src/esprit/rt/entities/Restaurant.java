package esprit.rt.entities;

/**
 *
 * @author Pingouins du désert
 * 
 */

public class Restaurant 
{
    private int id;
    private String nom;
    private String adresse;
    private String cordonnee;
    private int numTel;
    private String description;
    private String url;
    private String type, region;
    private Restaurateur restaurateur;
    
    public Restaurant() {
    }

    public Restaurant(int id, String nom, String adresse, String cordonnee, int numTel, String description, String url, String type, Restaurateur restaurateur) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.cordonnee = cordonnee;
        this.numTel = numTel;
        this.description = description;
        this.url = url;
        this.type = type;
        this.restaurateur = restaurateur;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCordonnee() {
        return cordonnee;
    }

    public void setCordonnee(String cordonnee) {
        this.cordonnee = cordonnee;
    }

    public int getNumTel() {
        return numTel;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Restaurateur getRestaurateur() {
        return restaurateur;
    }

    public void setRestaurateur(Restaurateur restaurateur) {
        this.restaurateur = restaurateur;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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
        final Restaurant other = (Restaurant) obj;
        if (other.id != this.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return  nom ;
    }
    
    
}
