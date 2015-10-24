/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.rt.dao;

import esprit.rt.entities.Chambre;
import esprit.rt.entities.Client;
import esprit.rt.entities.Meuble;
import esprit.rt.entities.Place;
import esprit.rt.utilities.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aditsan Kadmus
 */
public class PlaceDAO {
    
    
    
    public void insertPlace(Place p){

        String requete = "insert into place (id_client,id_meuble) values (?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, p.getClient().getId());
            ps.setInt(2, p.getMeuble().getId());
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }
    public void deletePlace(int id){
        String requete = "delete from place where id=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Place supprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }
    
    public List<Place> displayPlaceByClient (Client client){


        List<Place> listep = new ArrayList<Place>();

        String requete = "select * from place where id_client = ?";
        
        try {
           PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ps.setInt(1, client.getId());
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()){
                Place p =new Place();
                p.setId(resultat.getInt(1));
                p.setClient(new ClientDAO().ClientById(resultat.getInt(2)));
                p.setMeuble(new MeubleDAO().MeubleById(resultat.getInt(3)));
                listep.add(p);
            }
            return listep;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des restaurant "+ex.getMessage());
            return null;
        }
    }
    
    
    public List<Place> displayPlaceByMeuble (Meuble meuble){


        List<Place> listep = new ArrayList<Place>();

        String requete = "select * from place where id_meuble = ?";
        
        try {
           PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ps.setInt(1, meuble.getId());
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()){
                Place p =new Place();
                p.setId(resultat.getInt(1));
                p.setClient(new ClientDAO().ClientById(resultat.getInt(2)));
                p.setMeuble(new MeubleDAO().MeubleById(resultat.getInt(3)));
                listep.add(p);
            }
            return listep;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des restaurant "+ex.getMessage());
            return null;
        }
    }
}
