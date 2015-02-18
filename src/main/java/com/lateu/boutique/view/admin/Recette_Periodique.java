/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.view.admin;

import com.douwe.generic.dao.DataAccessException;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;
import com.lateu.boutique.metier.Impl.IsProduitImpl;
import com.lateu.boutique.metier.IsProduit;
import com.lateu.boutique.view.MenuPrincipal;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author ing-lateu
 */
public class Recette_Periodique extends JPanel {

    private JButton nouveauBtn;
    private JButton buton;
    private JTable clientTable;
    private DefaultTableModel tableModel;
    private MenuPrincipal parent;
    private JXDatePicker datebutText;
    private JXDatePicker datefinText;
    private JButton btnEnregistrer;
    private IsProduit servproduit;

    public Recette_Periodique(MenuPrincipal parentFrame) throws DataAccessException {
        servproduit = new IsProduitImpl();

        try {
            setLayout(new BorderLayout());
            this.parent = parentFrame;
            JPanel haut = new JPanel();
            haut.setLayout(new FlowLayout(FlowLayout.CENTER));
            JLabel lbl;
            haut.add(lbl = new JLabel("Recette Journaliere"));
            lbl.setFont(new Font("Times New Roman", Font.ITALIC, 18));
            add(BorderLayout.BEFORE_FIRST_LINE, haut);
            JPanel contenu = new JPanel();
            contenu.setLayout(new BorderLayout());
            //JPanel bas = new JPanel();
            //bas.setLayout(new FlowLayout());
            DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout("right:max(40dlu;p), 12dlu, 180dlu:", ""));
            builder.append("debut", datebutText = new JXDatePicker());
             builder.append("fin", datefinText = new JXDatePicker());
            builder.append(btnEnregistrer = new JButton("Evaluer"));
            add(BorderLayout.CENTER, builder.getPanel());
       


          btnEnregistrer.addActionListener(new ActionListener() {
              Date debut=datebutText.getDate();
               Date fin=datefinText.getDate();
                public void actionPerformed(ActionEvent ae) {
                   // try {
                        JOptionPane.showMessageDialog(null, "montant de la recette----------------"+servproduit.recettePeriod(debut, fin));
                        return;
                       // parent.setContenu(new NouveauProduitPanel(parent));
                  /*  } catch (DataAccessException ex) {
                        Logger.getLogger(Recette_J.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
                }
            });


           // bas.add(buton);

           // contenu.add(BorderLayout.AFTER_LAST_LINE, bas);

            //add(BorderLayout.CENTER, contenu);




        } catch (Exception ex) {
            Logger.getLogger(PersonnelPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
