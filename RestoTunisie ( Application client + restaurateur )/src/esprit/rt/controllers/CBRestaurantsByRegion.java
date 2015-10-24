/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.rt.controllers;

import esprit.rt.dao.RestaurantDAO;
import esprit.rt.entities.Restaurant;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Aditsan Kadmus
 */
public class CBRestaurantsByRegion extends DefaultComboBoxModel{
    public List<Restaurant> liste = new ArrayList<Restaurant>();
    
    public CBRestaurantsByRegion(String region) {
       liste = new RestaurantDAO().findRestaurantsByRegion(region);
     }
    public CBRestaurantsByRegion() {
       liste = new RestaurantDAO().DisplayAllAllRestaurants();
     }
    @Override
    public int getSize()
    {
        try
        {
            return liste.size();
        }
        catch (Exception e)
        {
            return 0;
        }
        
    }
    @Override
        public Restaurant getElementAt(int index)
    {
        return liste.get(index);
    }
        
}
