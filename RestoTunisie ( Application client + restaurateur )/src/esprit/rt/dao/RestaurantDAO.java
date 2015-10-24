package esprit.rt.dao;

import esprit.rt.entities.Restaurant;
import esprit.rt.entities.Restaurateur;
import esprit.rt.utilities.MyConnection;
import esprit.rt.utilities.SessionRestoTunisie;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pingouins de désert
 * 
 */

public class RestaurantDAO {
    
    public void insertRestaurant(Restaurant r){

        String requete = "insert into restaurant (nom,adresse,cordonnee,num_tel,description,url,type,id_restaurateur) values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, r.getNom());
            ps.setString(2, r.getAdresse());
            ps.setString(3, r.getCordonnee());
            ps.setInt(4, r.getNumTel());
            ps.setString(5, r.getDescription());
            ps.setString(6, r.getUrl());
            ps.setString(7, r.getType());
            ps.setInt(8, SessionRestoTunisie.getId());
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }
public void insertMenuAjouterRestaurant(Restaurant r){

        String requete = "insert into restaurant (nom,adresse,num_tel,description,url,type,id_restaurateur,region) values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, r.getNom());
            ps.setString(2, r.getAdresse());
            ps.setInt(3, r.getNumTel());
            ps.setString(4, r.getDescription());
            ps.setString(5, r.getUrl());
            ps.setString(6, r.getType());
            ps.setInt(7, SessionRestoTunisie.getId());
            ps.setString(8, r.getRegion());
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }

    public void updateRestaurant(Restaurant r){
        String requete = "update restaurant set nom=?,adresse=?,cordonnee=?,num_tel=?,description=?,url=?,type=? where id=? and id_restaurateur=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, r.getNom());
            ps.setString(2, r.getAdresse());
            ps.setString(3, r.getCordonnee());
            ps.setInt(4, r.getNumTel());
            ps.setString(5, r.getDescription());
            ps.setString(6, r.getUrl());
            ps.setString(7, r.getType());
            ps.setInt(8, r.getId());
            ps.setInt(9, SessionRestoTunisie.getId());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
    }

    public void updateRestaurantInterGestRes(Restaurant r){
        String requete = "update restaurant set nom=?,adresse=?,num_tel=?,description=?,url=?,type=? where id=? and id_restaurateur=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, r.getNom());
            ps.setString(2, r.getAdresse());
            ps.setInt(3, r.getNumTel());
            ps.setString(4, r.getDescription());
            ps.setString(5, r.getUrl());
            ps.setString(6, r.getType());
            ps.setInt(7, r.getId());
            ps.setInt(8, SessionRestoTunisie.getId());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
    }
    public void deleteRestaurant(int id){
        String requete = "delete from restaurant where id=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Restaurant supprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }


    public Restaurant findRestaurantById(int id){
    Restaurant r = new Restaurant();
     String requete = "select * from restaurant where id=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                r.setId(resultat.getInt(1));
                r.setNom(resultat.getString(2));
                r.setAdresse(resultat.getString(3));
                r.setCordonnee(resultat.getString(4));
                r.setNumTel(resultat.getInt(5));
                r.setDescription(resultat.getString(6));
                r.setUrl(resultat.getString(7));
                r.setType(resultat.getString(8));
            }
            return r;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du restaurant "+ex.getMessage());
            return null;
        }
    }

    public Restaurant findRestaurantByNom(String nom){
    Restaurant r = new Restaurant();
     String requete = "select * from restaurant where nom = ? and id_restaurateur = ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, nom);
            ps.setInt(2, SessionRestoTunisie.getId());
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                r.setId(resultat.getInt(1));
                r.setNom(resultat.getString(2));
                r.setAdresse(resultat.getString(3));
                r.setCordonnee(resultat.getString(4));
                r.setNumTel(resultat.getInt(5));
                r.setDescription(resultat.getString(6));
                r.setUrl(resultat.getString(7));
                r.setType(resultat.getString(8));
            }
            return r;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du restaurant "+ex.getMessage());
            return null;
        }
    }

    public List<Restaurant> DisplayAllRestaurants (){


        List<Restaurant> listerestaurants = new ArrayList<Restaurant>();

        String requete = "select * from restaurant where id_restaurateur = ?";
        try {
           PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ps.setInt(1, SessionRestoTunisie.getId());
           ResultSet resultat = ps.executeQuery();
           
            while(resultat.next()){
                Restaurant r =new Restaurant();
                r.setId(resultat.getInt(1));
                r.setNom(resultat.getString(2));
                r.setAdresse(resultat.getString(3));
                r.setCordonnee(resultat.getString(4));
                r.setNumTel(resultat.getInt(5));
                r.setDescription(resultat.getString(6));
                r.setUrl(resultat.getString(7));
                r.setType(resultat.getString(8));

                listerestaurants.add(r);
            }
            
            
            return listerestaurants;
            
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des restaurant "+ex.getMessage());
            return null;
        }
        
    }
    
    public List<Restaurant> DisplayAllAllRestaurants (){


        List<Restaurant> listerestaurants = new ArrayList<Restaurant>();

        String requete = "select * from restaurant";
        try {
           PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ResultSet resultat = ps.executeQuery();
           
            while(resultat.next()){
                Restaurant r =new Restaurant();
                r.setId(resultat.getInt(1));
                r.setNom(resultat.getString(2));
                r.setAdresse(resultat.getString(3));
                r.setCordonnee(resultat.getString(4));
                r.setNumTel(resultat.getInt(5));
                r.setDescription(resultat.getString(6));
                r.setUrl(resultat.getString(7));
                r.setType(resultat.getString(8));

                listerestaurants.add(r);
            }
            
            
            return listerestaurants;
            
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des restaurant "+ex.getMessage());
            return null;
        }
        
    }
    
    public List<Restaurant> findRestaurantsByType (String type){


        List<Restaurant> listedepots = new ArrayList<Restaurant>();

        String requete = "select * from restaurant where type=? and id_restaurateur=?";
        
        try {
           PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ps.setString(1, type);
           ps.setInt(2, SessionRestoTunisie.getId());
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()){
                Restaurant r =new Restaurant();
                r.setId(resultat.getInt(1));
                r.setNom(resultat.getString(2));
                r.setAdresse(resultat.getString(3));
                r.setCordonnee(resultat.getString(4));
                r.setNumTel(resultat.getInt(5));
                r.setDescription(resultat.getString(6));
                r.setUrl(resultat.getString(7));
                r.setType(resultat.getString(8));

                listedepots.add(r);
            }
            return listedepots;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des restaurant "+ex.getMessage());
            return null;
        }
    }
    
    
    public List<Restaurant> findRestaurantsByRegion (String region){


        List<Restaurant> listedepots = new ArrayList<Restaurant>();

        String requete = "select * from restaurant where region=?";
        
        try {
           PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ps.setString(1, region);
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()){
                Restaurant r =new Restaurant();
                r.setId(resultat.getInt(1));
                r.setNom(resultat.getString(2));
                r.setAdresse(resultat.getString(3));
                r.setCordonnee(resultat.getString(4));
                r.setNumTel(resultat.getInt(5));
                r.setDescription(resultat.getString(6));
                r.setUrl(resultat.getString(7));
                r.setType(resultat.getString(8));
                r.setRestaurateur(new Restaurateur());
                r.getRestaurateur().setNom(new UtilisateurDAO().findUtilisateurtById(resultat.getInt(9)).getNom());
                r.getRestaurateur().setPrenom(new UtilisateurDAO().findUtilisateurtById(resultat.getInt(9)).getPrenom());
                r.setRegion(resultat.getString(10));
                listedepots.add(r);
            }
            return listedepots;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des restaurant "+ex.getMessage());
            return null;
        }
    }
}
