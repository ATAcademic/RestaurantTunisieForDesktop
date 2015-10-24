/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.rt.dao;

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
public class TypePlatDAO {
    public List<String> displayAllTypes()
    {
        List<String> listetypes = new ArrayList<String>();
        String s ="";
        String requete = "select nom from types_plat";
        try {
           PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ResultSet resultat = ps.executeQuery();
           
            while(resultat.next()){
                
                s = resultat.getString(1);
                

                listetypes.add(s);
            }
            
            
            return listetypes;
            
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des restaurant "+ex.getMessage());
            return null;
        }
    }
}