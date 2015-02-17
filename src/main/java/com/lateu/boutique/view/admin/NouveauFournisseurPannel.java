/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.view.admin;

import com.douwe.generic.dao.DataAccessException;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;
import com.lateu.boutique.entities.Fournisseur;
import com.lateu.boutique.metier.Impl.IsFournisseurImpl;
import com.lateu.boutique.metier.IsFournisseur;
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
public class NouveauFournisseurPannel extends JPanel{

     private JTextField nomText;
    private JTextField contactText;
    private JTextField villeText;
    private JButton btnEnregistrer;
    private MenuPrincipal parent;
    private Long id = -1L;
    private Fournisseur f=new Fournisseur();
    private IsFournisseur serviceFournisseur; 
    public NouveauFournisseurPannel(MenuPrincipal parentFrame, Long fournisseur_id) throws DataAccessException {
        this(parentFrame);
        serviceFournisseur=new IsFournisseurImpl(); 
       
        this.id = fournisseur_id;
        
         if (this.id > 0) {
            btnEnregistrer.setText("Modifier");
            f=serviceFournisseur.findById(id);
            if(f!=null){
           nomText.setText(f.getNom());
           contactText.setText(f.getContact());
           villeText.setText(f.getVille());
            }
         }
         
         System.out.println("selected -----"+f.toString());
    }

    
    
    
    
    
    public NouveauFournisseurPannel(MenuPrincipal parentFrame) throws DataAccessException {
        
         this.parent = parentFrame; 
         serviceFournisseur=new IsFournisseurImpl(); 
        setLayout(new BorderLayout(10, 10));
        
        JPanel haut = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel lbl;
        haut.add(lbl = new JLabel("AJOUT D'UN NOUVEAU FOURNISSUER "));
        lbl.setFont(new Font("Times New Roman", Font.ITALIC, 18));
        add(BorderLayout.BEFORE_FIRST_LINE, haut);
        DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout("right:max(40dlu;p), 12dlu, 180dlu:", ""));
        builder.append("Nom", nomText = new JTextField());
        builder.append("Ville", villeText = new JTextField());
         builder.append("Contact", contactText = new JTextField());

        builder.append(btnEnregistrer = new JButton("Enrégistrer"));
        add(BorderLayout.CENTER, builder.getPanel());
        
                btnEnregistrer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (id > 0) {
                    try {
                        // here I'm updating an account
                        String nom = nomText.getText();
                       
                        if ((nom == null) || ("".equals(nom))) {
                            JOptionPane.showMessageDialog(null, "Le numéro du compte n'est pas specifie");
                            return;
                        }
                        System.out.println("===je suis de passage ici====");
                        f.setNom(nomText.getText());
                        f.setVille(villeText.getText());
                        f.setContact(contactText.getText());
                        f.setId(id);
                        f=serviceFournisseur.update(f);
                   
                     //   f=null;
                        
           
                       
                        parent.setContenu(new FournisseurPanel(parent));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Impossible de mettre à jour le compte");
                        Logger.getLogger(NouveauFournisseurPannel.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    try {                   
                        // I need to get the customer_id
                        String nom = nomText.getText();
                        String contact= contactText.getText();
                        String ville = villeText.getText();
                        
                        if ((nom == null) || ("".equals(nom))) {
                            JOptionPane.showMessageDialog(null, "Le nom du du fournisseur n'est pas specifie");
                            return;
                        }
                        if ((ville == null) || ("".equals(ville))) {
                            JOptionPane.showMessageDialog(null, "La ville n'est pas specifie");
                            return;
                        }
                        if ((contact == null) || ("".equals(contact))) {
                            JOptionPane.showMessageDialog(null, "Le contact n'est pas specifie");
                            return;
                        }
                        
                         f.setContact(contact);
                         f.setNom(nom);
                         f.setVille(ville);
                         
                          System.out.println(f);
                         
                       System.out.println("++++"+ serviceFournisseur.Ajouter(f));
                
                    } catch (DataAccessException ex) {
                        Logger.getLogger(NouveauFournisseurPannel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                       
                        }
                try {
                    parent.setContenu(new FournisseurPanel(parent));
                } catch (DataAccessException ex) {
                    Logger.getLogger(NouveauFournisseurPannel.class.getName()).log(Level.SEVERE, null, ex);
                }
                  
                }

            
        });
    }
    
    
    
    
    
}
