/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.rt.controllers;

import esprit.rt.dao.TypePlatDAO;
import esprit.rt.dao.TypeRestoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Aditsan Kadmus
 */
public class CBAllTypesPlat extends DefaultComboBoxModel{
     List <String> lbp = new ArrayList<String>();
    

    public CBAllTypesPlat() {
       lbp = new TypePlatDAO().displayAllTypes();
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
