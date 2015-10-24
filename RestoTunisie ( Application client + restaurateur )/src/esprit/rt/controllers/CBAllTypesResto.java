/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.rt.controllers;

import esprit.rt.dao.TypeRestoDAO;
import esprit.rt.entities.Restaurant;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Aditsan Kadmus
 */
public class CBAllTypesResto extends DefaultComboBoxModel{
    List <String> lbp = new ArrayList<String>();
    

    public CBAllTypesResto() {
       lbp = new TypeRestoDAO().displayAllTypes();
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
    public String getElementAt(int index)
    {
        return lbp.get(index);
    }
}
