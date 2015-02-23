/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.view.Common;

import com.lateu.boutique.view.admin.*;
import com.douwe.generic.dao.DataAccessException;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;
import com.lateu.boutique.entities.Pannier;
import com.lateu.boutique.metier.Impl.IsProduitImpl;
import com.lateu.boutique.metier.IsProduit;
import com.lateu.boutique.view.MenuPrincipal;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ing-lateu
 */
public class NouveauPannierPannel extends JPanel {

    private JTextField quantiteText;
    private JTextField codeText;
    private JButton btnEnregistrer;
    private MenuPrincipal parent;
    private Long id = -1L;
    private Pannier p = new Pannier();
    private Pannier p3 = new Pannier();
    IsProduit servIsProduit;
 

    public NouveauPannierPannel(MenuPrincipal parentFrame, Long fournisseur_id) throws DataAccessException {
        this(parentFrame);
        servIsProduit = new IsProduitImpl();
       
        this.id = fournisseur_id;

        if (this.id > 0) {
            btnEnregistrer.setText("Modifier");
             p = servIsProduit.findPannierByID(id);
            if (p != null) {
                quantiteText.setText(p.getQuantite()+"");
       
            }
        }

        //  System.out.println("selected -----" + p.toString());
    }

    public NouveauPannierPannel(MenuPrincipal parentFrame) throws DataAccessException {

        this.parent = parentFrame;
   
        servIsProduit = new IsProduitImpl();
        setLayout(new BorderLayout(10, 10));

        JPanel haut = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel lbl;
        haut.add(lbl = new JLabel("AJOUT D'UN ELEMENT AU PANNIER "));
        lbl.setFont(new Font("Times New Roman", Font.ITALIC, 18));
        add(BorderLayout.BEFORE_FIRST_LINE, haut);
        DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout("right:max(40dlu;p), 12dlu, 180dlu:", ""));
       
        builder.append("code", codeText = new JTextField());
        builder.append("quantite", quantiteText = new JTextField());
    

        builder.append(btnEnregistrer = new JButton("Enrégistrer"));
        add(BorderLayout.CENTER, builder.getPanel());

        btnEnregistrer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (id > 0) {
                    try {
                         
                        System.out.println("===je suis de passage ici====");
                        int r=Integer.parseInt(quantiteText.getText());
                        p3.setQuantite(r);
                         
                        p3.setId(id);

                        servIsProduit.udpdatePannier(p3);

                        parent.setContenu(new ProduitPanel(parent));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Impossible de mettre à jour le compte");
                        Logger.getLogger(NouveauProduitPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {

                    // I need to get the customer_id
                    String code = codeText.getText();
                   
                 
                    if ((code == null) || ("".equals(code))) {
                        JOptionPane.showMessageDialog(null, "Le code n'est pas specifie");
                        return;
                    }
                    
                    if ((servIsProduit.findByCodProd(code)==null)) {
                        JOptionPane.showMessageDialog(null, "Le code n'est pas valide");
                        return;
                    }

                    Integer qte = Integer.parseInt(quantiteText.getText());
                    p.setQuantite(qte.intValue());

                 //   System.out.println("----------------avant ajout du produit------" + pu + "-------- aprssssss" + prixU);
                    servIsProduit.AjouterAuPannier(p, code);



                }
                try {
                    parent.setContenu(new PannierPanel(parent));
                } catch (DataAccessException ex) {
                    Logger.getLogger(NouveauProduitPanel.class.getName()).log(Level.SEVERE, null, ex);
                }


            }
        });
    }
}
