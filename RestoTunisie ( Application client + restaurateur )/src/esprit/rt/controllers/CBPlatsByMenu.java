/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.rt.controllers;

import esprit.rt.dao.PlatDAO;
import esprit.rt.entities.Plat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Aditsan Kadmus
 */
public class CBPlatsByMenu extends DefaultComboBoxModel{
    public List<Plat> liste = new ArrayList<Plat>();
    
    public CBPlatsByMenu(int idMenu) {
       liste = new PlatDAO().displayPlayByMenu(idMenu);
     }
    public CBPlatsByMenu() {
       liste = new PlatDAO().displayPlats();
     }
    @Override
    public int getSize()
    {
        try
        {
            System.out.println("##"+liste.size());
            return liste.size();
        }
        catch (Exception e)
        {
            return 0;
        }
        
    }

//    @Override
//    public Plat getElementAt(int index)
//    {
//        return liste.get(index);
//    }
    @Override
    public Plat getElementAt(int index) {
        return liste.get(index);
    }
    
    
}
