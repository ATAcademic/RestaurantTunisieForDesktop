/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.rt.controllers;

import esprit.rt.dao.RestaurantDAO;
import esprit.rt.entities.BonPlan;
import esprit.rt.entities.Restaurant;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Aditsan Kadmus
 */
public class AllRestaurants extends DefaultComboBoxModel{
    List <Restaurant> lbp = new ArrayList<Restaurant>();
    

    public AllRestaurants() {
       lbp = new RestaurantDAO().DisplayAllRestaurants();
     }
    public int getSize()
    {
        try
        {
            return lbp.size();
        }
        catch (Exception e)
        {
            return 0;
        }
        
    }
    public Restaurant getElementAt(int index)
    {
        return lbp.get(index);
    }
}
