/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.rt.dao;

import esprit.rt.entities.Plat;
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
public class RegionDAO {
    public List<String> display(){


        List<String> liste = new ArrayList<String>();

        String requete = "select * from region";
        try {
           PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ResultSet resultat = ps.executeQuery();
           
            while(resultat.next()){
                liste.add(resultat.getString(1));
            }
            
            
            return liste;
            
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des restaurant "+ex.getMessage());
            return null;
        }
        
    }
    
    
}
