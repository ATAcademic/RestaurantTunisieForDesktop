/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.rt.dao;

import esprit.rt.entities.Restaurant;
import esprit.rt.utilities.MyConnection;
import esprit.rt.utilities.SessionRestoTunisie;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Aditsan Kadmus
 */
public class StatistiqueDAO {
    public Map<String,String> mostBooked()
    {
        Map<String,String> mb;
        mb = new HashMap<String, String>();
        String requete = "select restaurant.nom, SUM(reservation.nbr_place) from reservation, restaurant where reservation.id_restaurant = restaurant.id and restaurant.id_restaurateur = ? group by restaurant.id limit 10";
        try {
           PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ps.setInt(1, SessionRestoTunisie.getId());
           ResultSet resultat = ps.executeQuery();
           String tmp="", tmp2="";
            while(resultat.next()){
                tmp  =(resultat.getString(1));
                tmp2 =String.valueOf(resultat.getInt(2));
               

                mb.put(tmp, tmp2);
            }
            
            
            return mb;
            
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des restaurant "+ex.getMessage());
            return mb;
        }
    }
    
    
    public Map<String,String> mostPayed()
    {
        Map<String,String> mb;
        mb = new HashMap<String, String>();
        String requete = "select restaurant.nom, SUM(reservation.prix_totale) from reservation, restaurant where reservation.id_restaurant = restaurant.id and restaurant.id_restaurateur = ? group by restaurant.id limit 10";
        try {
           PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ps.setInt(1, SessionRestoTunisie.getId());
           ResultSet resultat = ps.executeQuery();
           String tmp="", tmp2="";
            while(resultat.next()){
                tmp  =(resultat.getString(1));
                tmp2 =String.valueOf(resultat.getInt(2));
               

                mb.put(tmp, tmp2);
            }
            
            
            return mb;
            
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des restaurant "+ex.getMessage());
            return mb;
        }
    }
}
