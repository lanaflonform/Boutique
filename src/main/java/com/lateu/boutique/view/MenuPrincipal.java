/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.view;

import com.douwe.generic.dao.DataAccessException;
import com.lateu.boutique.view.Common.PannierPanel;
import com.lateu.boutique.view.admin.FournisseurPanel;
import com.lateu.boutique.view.admin.PersonnelPanel;
import com.lateu.boutique.view.admin.ProduitPanel;
import com.lateu.boutique.view.admin.Recette_J;
import com.lateu.boutique.view.admin.Recette_Periodique;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.jdesktop.swingx.JXHyperlink;
import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.JXTaskPaneContainer;

/**
 *
 * @author ing-lateu
 */
public class MenuPrincipal extends JPanel {

    private JXHyperlink stock;
    private JXHyperlink recetteJ;
    private JXHyperlink userrole;
    private JXHyperlink recetteP;
    //private JXHyperlink customer;
    private JXHyperlink personnel;
    private JXHyperlink produit;
    private JXHyperlink fournisseur;
    private JXHyperlink approvisionement;
    private JXHyperlink pannier;
    private JPanel container;

    public MenuPrincipal() {
        setLayout(new BorderLayout());
        /**
         * stock
         */
        stock = new JXHyperlink();
        stock.setText("Stock");
        stock.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    //    setContenu(new MesCompteListePanel());
                } catch (Exception ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        stock.setUnclickedColor(Color.blue);
        stock.setClickedColor(Color.blue);
        approvisionement = new JXHyperlink();
        approvisionement.setText("Approisionnement");
        approvisionement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    //    setContenu(new MesOperationsListePanel());
                } catch (Exception ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        approvisionement.setUnclickedColor(Color.blue);
        approvisionement.setClickedColor(Color.blue);

        /**
         * vente
         */
        pannier = new JXHyperlink();
        pannier.setText("Pannier");
        pannier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                        setContenu(new PannierPanel(MenuPrincipal.this));
                } catch (Exception ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        pannier.setUnclickedColor(Color.blue);
        pannier.setClickedColor(Color.blue);

        /**
         * ***********role utilisateur***********
         */
        userrole = new JXHyperlink() {
            @Override
            public boolean isVisible() {
                //   return UserInfo.getRole() == RoleType.admin;
                return true;
            }
        };
        userrole.setText("Utilisateurs");
        userrole.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
              //    setContenu(new PersonnelPanel(MenuPrincipal.this));
            }
        });
        userrole.setUnclickedColor(Color.blue);
        userrole.setClickedColor(Color.blue);

        /**
         * * ********produit **********
         */
        produit = new JXHyperlink() {
            @Override
            public boolean isVisible() {
                //   return UserInfo.getRole() == RoleType.admin;
                return true;
            }
        };
        produit.setText("Produits");
        produit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    setContenu(new ProduitPanel(MenuPrincipal.this));
                } catch (DataAccessException ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        produit.setUnclickedColor(Color.blue);
        produit.setClickedColor(Color.blue);

        /**
         * fournisseur
         */
        fournisseur = new JXHyperlink();
        fournisseur.setText("Fournisseur");
        fournisseur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    setContenu(new FournisseurPanel(MenuPrincipal.this));
                } catch (DataAccessException ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
     
            }
        });
        fournisseur.setUnclickedColor(Color.blue);
        fournisseur.setClickedColor(Color.blue);

        /**
         * ********
         * personnel
         */
        personnel = new JXHyperlink() {
            @Override
            public boolean isVisible() {
                //   return UserInfo.getRole() == RoleType.admin;
                return true;
            }
        };
        personnel.setText("Personnel");
        personnel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    setContenu(new PersonnelPanel(MenuPrincipal.this));
                } catch (DataAccessException ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        personnel.setUnclickedColor(Color.blue);
        personnel.setClickedColor(Color.blue);
        
        /**
         * recette periodique
         */
         recetteP = new JXHyperlink() {
            @Override
            public boolean isVisible() {
                //   return UserInfo.getRole() == RoleType.admin;
                return true;
            }
        };
        recetteP.setText("Recette-P");
        recetteP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    setContenu(new Recette_Periodique(MenuPrincipal.this));
                } catch (DataAccessException ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
        recetteP.setUnclickedColor(Color.blue);
        recetteP.setClickedColor(Color.blue);
        /**
         * recette journalière
         */
        recetteJ = new JXHyperlink();
         recetteJ.setText("Reccete-Journalière");
         recetteJ.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    setContenu(new Recette_J(MenuPrincipal.this));
                } catch (DataAccessException ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
         recetteJ.setUnclickedColor(Color.blue);
         recetteJ.setClickedColor(Color.blue);
        JXTaskPaneContainer menu = new JXTaskPaneContainer();
        JXTaskPane clientPane = new JXTaskPane() {
            @Override
            public boolean isVisible() {
                //   return UserInfo.getRole() == RoleType.customer;
                return true;
            }
        };
        
        

        /**
         * panneau pour le caissier
         */
        clientPane.setTitle("Caissier");
        clientPane.add(stock);
        clientPane.add(pannier);
        menu.add(clientPane);

        JXTaskPane adminPane = new JXTaskPane() {
            @Override
            public boolean isVisible() {
                //   return (UserInfo.getRole() == RoleType.admin) || (UserInfo.getRole() == RoleType.employee);
                return true;
            }
        };
        adminPane.setTitle("Administration");
        adminPane.add(personnel);
        adminPane.add(userrole);
        adminPane.add(fournisseur);
        adminPane.add(produit);
        adminPane.add(approvisionement);
        adminPane.add(recetteJ);
        adminPane.add(recetteP);
        menu.add(adminPane);


        add(menu, BorderLayout.BEFORE_LINE_BEGINS);
        container = new JPanel();
        container.setLayout(new BorderLayout());
        container.setBorder(new EmptyBorder(2, 20, 20, 20));

        add(container, BorderLayout.CENTER);
    }

    public void setContenu(JPanel pan) {
        container.removeAll();
        container.add(BorderLayout.CENTER, pan);
        container.validate();
    }
}
