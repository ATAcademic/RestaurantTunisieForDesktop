/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.rt.controllers;

import esprit.rt.dao.RestaurantDAO;
import esprit.rt.entities.Restaurant;
import esprit.rt.utilities.SessionRestoTunisie;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Aditsan Kadmus
 */
public class CBRestoRestaurateur extends DefaultComboBoxModel{
    List <Restaurant> lbp = new ArrayList<Restaurant>();
    

    public CBRestoRestaurateur() {
       lbp = new RestaurantDAO().DisplayAllRestaurants();
     }
    public int getSize()
    {
        try
        {
            return lbp.size()+1;
        }
        catch (Exception e)
        {
            return 1;
        }
        
    }
    public Object getElementAt(int index)
    {
        if (index == 0)
            return "Tous les restaurants";
        else
            return lbp.get(index-1);
    }
}
