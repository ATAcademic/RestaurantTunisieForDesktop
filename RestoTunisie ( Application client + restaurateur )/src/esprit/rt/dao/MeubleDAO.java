/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.rt.dao;

import esprit.rt.entities.Chambre;
import esprit.rt.entities.Meuble;
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
public class MeubleDAO {
    public void insertMeuble(Meuble m){

        String requete = "insert into meuble (x,y,width,height,reserved,current_places,max_places,image,priorite,id_chambre) "
                + "values (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, m.getX());
            ps.setInt(2, m.getY());
            ps.setInt(3, m.getWidth());
            ps.setInt(4, m.getHeight());
            ps.setInt(5, m.getReserved());
            ps.setInt(6, m.getCurrentPlaces());
            ps.setInt(7, m.getMaxPlaces());
            ps.setString(8, m.getImage());
            ps.setInt(9, m.getPriority());
            ps.setInt(10, m.getChambre().getId());
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }
    public void deleteMeuble(int id){
        String requete = "delete from meuble where id=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Chambre supprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }
    
    public List<Meuble> displayMeubleByChambre (Chambre chambre){


        List<Meuble> listem = new ArrayList<Meuble>();

        String requete = "select * from meuble where meuble.id_chambre = chambre.id and"
                + " chambre.id=?";
        
        try {
           PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ps.setInt(1, chambre.getId());
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()){
                Meuble m =new Meuble();
                m.setId(resultat.getInt(1));
                m.setX(resultat.getInt(2));
                m.setY(resultat.getInt(3));
                m.setWidth(resultat.getInt(4));
                m.setHeight(resultat.getInt(5));
                m.setReserved(resultat.getInt(6));
                m.setCurrentPlaces(resultat.getInt(7));
                m.setMaxPlaces(resultat.getInt(8));
                m.setImage(resultat.getString(9));
                m.setPriority(resultat.getInt(10));
                m.setChambre(new ChambreDAO().displayChambresById(resultat.getInt(11)));
                listem.add(m);
            }
            return listem;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des restaurant "+ex.getMessage());
            return null;
        }
    }
    
    public Meuble MeubleById (int id){


       Meuble meuble = new Meuble();

        String requete = "select * from meuble where id = ?";
        
        try {
           PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()){
                meuble.setId(resultat.getInt(1));
                meuble.setX(resultat.getInt(2));
                meuble.setY(resultat.getInt(3));
                meuble.setWidth(resultat.getInt(4));
                meuble.setHeight(resultat.getInt(5));
                meuble.setReserved(resultat.getInt(6));
                meuble.setCurrentPlaces(resultat.getInt(7));
                meuble.setMaxPlaces(resultat.getInt(8));
                meuble.setImage(resultat.getString(9));
                meuble.setPriority(resultat.getInt(10));
                meuble.setChambre(new ChambreDAO().displayChambresById(resultat.getInt(11)));
            }
            return meuble;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des restaurant "+ex.getMessage());
            return null;
        }
    }
}
