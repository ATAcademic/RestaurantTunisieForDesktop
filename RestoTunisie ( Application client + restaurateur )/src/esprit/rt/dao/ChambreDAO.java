/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.rt.dao;

import esprit.rt.entities.Chambre;
import esprit.rt.entities.Restaurant;
import esprit.rt.utilities.MyConnection;
import esprit.rt.utilities.SessionRestoTunisie;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aditsan Kadmus
 */
public class ChambreDAO {
    public void insertChambre(Chambre ch, int idRes){

        String requete = "insert into chambre (nom,description,id_restaurant) values (?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, ch.getNom());
            ps.setString(2, ch.getDescription());
            ps.setInt(3, idRes);
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }
    public void deleteChambre(int id){
        String requete = "delete from chambre where id=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Chambre supprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }
    
    public List<Chambre> displayChambresByRestaurant (Restaurant restaurant){


        List<Chambre> listec = new ArrayList<Chambre>();

        String requete = "select * from chambre where chambre.id_restaurant = restaurant.id and "
                + "restaurant.id=?";
        
        try {
           PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ps.setInt(1, restaurant.getId());
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()){
                Chambre c =new Chambre();
                c.setId(resultat.getInt(1));
                c.setNom(resultat.getString(2));
                c.setDescription(resultat.getString(3));
                c.setRestaurant(restaurant);
                listec.add(c);
            }
            return listec;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des restaurant "+ex.getMessage());
            return null;
        }
    }
    
    public Chambre displayChambresById (int id){


       Chambre c = new Chambre();

        String requete = "select * from chambre where chambre.id = ?";
        
        try {
           PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()){
                c.setId(resultat.getInt(1));
                c.setNom(resultat.getString(2));
                c.setDescription(resultat.getString(3));
                c.setRestaurant(new RestaurantDAO().findRestaurantById(resultat.getInt(4)));
            }
            return c;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des restaurant "+ex.getMessage());
            return null;
        }
    }
}

