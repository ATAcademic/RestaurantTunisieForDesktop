/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.rt.controllers;

import esprit.rt.dao.PlatDAO;
import esprit.rt.dao.RegionDAO;
import esprit.rt.entities.Plat;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Aditsan Kadmus
 */
public class CBRegions extends DefaultComboBoxModel{
    List<String> liste;
    public CBRegions() {
       liste = new RegionDAO().display();
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
    public String getElementAt(int index)
    {
        return liste.get(index);
    }
}
