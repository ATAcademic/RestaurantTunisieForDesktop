/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.rt.gui;

import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaLookAndFeel;
import esprit.rt.controllers.CBRegions;
import esprit.rt.controllers.CBRestaurantsByRegion;
import esprit.rt.dao.RestaurantDAO;
import esprit.rt.entities.Restaurant;
import esprit.rt.utilities.SessionRestoTunisie;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author hp
 */
public class MenuConsultationRestaurant extends javax.swing.JFrame {
    //private String ch;
   
   

    /**
     * Creates new form MenuConsultationRestaurant
     */
    public MenuConsultationRestaurant() {
         try {
            SyntheticaLookAndFeel.setWindowsDecorated(false);

            UIManager.put("Synthetica.dialog.icon.enabled", true);

            //Application du look SynthLookAndFeel
            //UIManager.setLookAndFeel(new SynthLookAndFeel());
            //Application du look MotifLookAndFeel
            //  UIManager.setLookAndFeel(new MotifLookAndFeel());
            //Application du look SyntheticaBlackEyeLookAndFeel   
            UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());

            //Application du look SyntheticaStandardLookAndFeel
            //  UIManager.setLookAndFeel(new SyntheticaStandardLookAndFeel());
            //Pour ajouter un nouveau look il faut importer le jar correspondant
            //Voici des liens utiles :
            //http://www.jyloo.com/
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MenuConsultationRestaurant.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(MenuConsultationRestaurant.class.getName()).log(Level.SEVERE, null, ex);
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxres = new javax.swing.JComboBox();
        labelcon = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        label7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboadress = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("         Bienvenue cher client");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(180, 30, 360, 27);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Veilleuez choisissez un restaurant");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(360, 100, 340, 22);

        jComboBoxres.setModel(new CBRestaurantsByRegion());
        jComboBoxres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxresMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jComboBoxresMouseExited(evt);
            }
        });
        jComboBoxres.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxresItemStateChanged(evt);
            }
        });
        jComboBoxres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxresActionPerformed(evt);
            }
        });
        jComboBoxres.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBoxresFocusLost(evt);
            }
        });
        getContentPane().add(jComboBoxres);
        jComboBoxres.setBounds(440, 130, 159, 20);
        getContentPane().add(labelcon);
        labelcon.setBounds(227, 71, 172, 43);
        getContentPane().add(label2);
        label2.setBounds(227, 120, 0, 0);
        getContentPane().add(label3);
        label3.setBounds(227, 132, 0, 0);
        getContentPane().add(label6);
        label6.setBounds(227, 187, 0, 0);
        getContentPane().add(label4);
        label4.setBounds(227, 146, 0, 0);
        getContentPane().add(label5);
        label5.setBounds(227, 158, 0, 0);
        getContentPane().add(label7);
        label7.setBounds(227, 193, 0, 0);

        jButton2.setText("Quitter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(290, 300, 100, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Veilleuez choisissez une region");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 100, 360, 20);

        jComboadress.setModel(new CBRegions());
        jComboadress.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboadressMouseClicked(evt);
            }
        });
        jComboadress.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboadressItemStateChanged(evt);
            }
        });
        jComboadress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboadressActionPerformed(evt);
            }
        });
        getContentPane().add(jComboadress);
        jComboadress.setBounds(70, 130, 176, 20);

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/esprit/rt/images/detail001.png"))); // NOI18N
        jLabel3.setText("Consulter");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(250, 210, 180, 80);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/esprit/rt/images/blurred.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 690, 350);

        setSize(new java.awt.Dimension(707, 386));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxresActionPerformed
        
    }//GEN-LAST:event_jComboBoxresActionPerformed

    private void jComboBoxresFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBoxresFocusLost

        
        
        
    }//GEN-LAST:event_jComboBoxresFocusLost

    private void jComboBoxresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxresMouseClicked
        
        
       
    }//GEN-LAST:event_jComboBoxresMouseClicked

    private void jComboBoxresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxresMouseExited
        
          
        
        
    }//GEN-LAST:event_jComboBoxresMouseExited

    private void jComboBoxresItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxresItemStateChanged

        
//           if(jComboBoxres.getSelectedIndex()==3)
//        {
//         for(int i=0 ; i< restaurantDAO.DisplayAllRestaurants().size();i++)
//        {
//             labelcon.setText(restaurantDAO.DisplayAllRestaurants().get(i).getNom());
//        
//             label2.setText(restaurantDAO.DisplayAllRestaurants().get(i).getAdresse());
//              label3.setText(String.valueOf(restaurantDAO.DisplayAllRestaurants().get(i).getNumTel())); 
//             label4.setText(restaurantDAO.DisplayAllRestaurants().get(i).getDescription());
//             label5.setText(restaurantDAO.DisplayAllRestaurants().get(i).getUrl());
//             label6.setText(restaurantDAO.DisplayAllRestaurants().get(i).getType());
//             label7.setText(String.valueOf(restaurantDAO.DisplayAllRestaurants().get(i).getRestaurateur().getId()));
//        }
//         
//        
//        }
       
        
    }//GEN-LAST:event_jComboBoxresItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       System.exit(1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
         RestaurantDAO restaurantDAO = new RestaurantDAO();

    }//GEN-LAST:event_formWindowOpened

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
             if ((jComboBoxres.getSelectedItem() != null) && (!"".equals(jComboBoxres.getSelectedItem().toString())))
             {
        SessionRestoTunisie.crtResto = (Restaurant) jComboBoxres.getSelectedItem();
                 System.out.println(SessionRestoTunisie.crtResto);
        new InterfaceRestaurant().setVisible(true);
             }
             else
             {
                  JOptionPane.showMessageDialog(this, "Veuillez choisir un restaurant!", "Erreur", JOptionPane.PLAIN_MESSAGE);
             }
        
        
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jComboadressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboadressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboadressActionPerformed

    private void jComboadressItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboadressItemStateChanged
jComboBoxres.setModel(new CBRestaurantsByRegion(jComboadress.getSelectedItem().toString()));        
        
        
        
    }//GEN-LAST:event_jComboadressItemStateChanged

    private void jComboadressMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboadressMouseClicked
        
     
        
    }//GEN-LAST:event_jComboadressMouseClicked

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuConsultationRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuConsultationRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuConsultationRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuConsultationRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuConsultationRestaurant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBoxres;
    private javax.swing.JComboBox jComboadress;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel labelcon;
    // End of variables declaration//GEN-END:variables

    
    
   
    
}
