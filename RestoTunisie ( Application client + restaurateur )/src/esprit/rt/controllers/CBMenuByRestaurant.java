/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.rt.controllers;

import esprit.rt.dao.MenuDAO;
import esprit.rt.entities.Menu;
import esprit.rt.utilities.SessionRestoTunisie;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Aditsan Kadmus
 */
public class CBMenuByRestaurant extends DefaultComboBoxModel{
    public List<Menu> liste = new ArrayList<Menu>();
    
    public CBMenuByRestaurant() {
           liste = new MenuDAO().displayMenusByRestaurant(SessionRestoTunisie.crtResto.getId());
     }
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
    public Menu getElementAt(int index)
    {
        return liste.get(index);
    }
}
