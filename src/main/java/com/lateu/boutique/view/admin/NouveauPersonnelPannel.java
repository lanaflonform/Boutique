/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.view.admin;

import com.douwe.generic.dao.DataAccessException;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;
import com.lateu.boutique.entities.Fournisseur;
import com.lateu.boutique.entities.Personnel;
import com.lateu.boutique.entities.UserRole;
import com.lateu.boutique.entities.UserType;
import com.lateu.boutique.metier.Impl.IsPersonnelImpl;
import com.lateu.boutique.metier.IsPersonnel;
import com.lateu.boutique.metier.ServiceException;
import com.lateu.boutique.view.MenuPrincipal;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author ing-lateu
 */
public class NouveauPersonnelPannel extends JPanel {

    private JTextField nomText;
    private JTextField prenomText;
    private JTextField contactText;
    private JTextField villeText;
    private JTextField usernameText;
    private JPasswordField passwordText;
    private JComboBox<UserType> TypeText;
    private JXDatePicker datenais;
    private JButton btnEnregistrer;
    private MenuPrincipal parent;
    private Long id = -1L;
    private String currentPassword;
    private Personnel p = new Personnel();
   // private Personnel p2 = new Personnel();
    private Personnel p3 = new Personnel();
    private UserRole userRole = new UserRole();
    IsPersonnel servIsPersonnel ;
 List <Personnel>  listeUsername=new ArrayList<Personnel>();
    public NouveauPersonnelPannel(MenuPrincipal parentFrame, Long fournisseur_id) throws DataAccessException {
        this(parentFrame);
        servIsPersonnel = new IsPersonnelImpl();
        this.id = fournisseur_id;

        if (this.id > 0) {
            btnEnregistrer.setText("Modifier");
            p = servIsPersonnel.findPersonnelByID(id);
            if (p != null) {
                nomText.setText(p.getNom());
                contactText.setText(p.getContact());
                usernameText.setText(p.getUsername());
               // passwordText.setText(p.getPassword());
                prenomText.setText(p.getPrenom());

            }
        }

        //  System.out.println("selected -----" + p.toString());
    }

    public NouveauPersonnelPannel(MenuPrincipal parentFrame) throws DataAccessException {
        this.parent = parentFrame;
         servIsPersonnel = new IsPersonnelImpl();
        setLayout(new BorderLayout(10, 10));

        JPanel haut = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel lbl;
        haut.add(lbl = new JLabel("AJOUT D'UN NOUVEAU PERSONNEL "));
        lbl.setFont(new Font("Times New Roman", Font.ITALIC, 18));
        add(BorderLayout.BEFORE_FIRST_LINE, haut);
        DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout("right:max(40dlu;p), 12dlu, 180dlu:", ""));
        builder.append("nom", nomText = new JTextField());
        builder.append("prenom", prenomText = new JTextField());
        builder.append("contact", contactText = new JTextField());
        builder.append("username", usernameText = new JTextField());
        builder.append("Statut", TypeText = new JComboBox<UserType>());
        builder.append("dateNaiss", datenais = new JXDatePicker());
        TypeText.addItem(UserType.ROLE_ADMIN);
        TypeText.addItem(UserType.ROLE_CAISSIER);
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
                        p3.setNom(nomText.getText());
                        p3.setPrenom(prenomText.getText());
                        p3.setUsername(usernameText.getText());
                        p3.setContact(contactText.getText());
                       // p3.setPassword(currentPassword);
                        p3.setId(id);
                       // p3.setEtatCompte(e);
                        
                        p3=servIsPersonnel.updatePersonnel(p3);



                        parent.setContenu(new PersonnelPanel(parent));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Impossible de mettre à jour le compte");
                        Logger.getLogger(NouveauPersonnelPannel.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {

                    // I need to get the customer_id
                    String nom = nomText.getText();
                    String prenom = prenomText.getText();
                    String contact = contactText.getText();
                    String username = usernameText.getText();
                    String password = username;
                    UserType type = (UserType) TypeText.getSelectedItem();
                    listeUsername = servIsPersonnel.TestUsername(username);
                    if (!listeUsername.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "le login " + username + "  n'est pas disponible");
                        return;
                   }

                    if ((nom == null) || ("".equals(nom))) {
                        JOptionPane.showMessageDialog(null, "Le nom du personnel n'est pas specifie");
                        return;
                    }
                    if ((contact == null) || ("".equals(contact))) {
                        JOptionPane.showMessageDialog(null, "La contact n'est pas specifie");
                        return;
                    }
                    if ((username == null) || ("".equals(username))) {
                        JOptionPane.showMessageDialog(null, "Le login n'est pas specifie");
                        return;
                    }

                    p.setContact(contact);
                    p.setNom(nom);
                    p.setPrenom(prenom);
                    p.setUsername(username);
                    p.setPassword(password);
                    p.setEtatCompte(1);

                    userRole.setAutorié(type.toString());
                    try {
                         System.out.println("=============================================================");
                        System.out.println("==22===" + servIsPersonnel.Save(p, userRole));
                    } catch (ServiceException ex) {
                        Logger.getLogger(NouveauPersonnelPannel.class.getName()).log(Level.SEVERE, null, ex);
                    }



                }
                try {
                    parent.setContenu(new PersonnelPanel(parent));
                } catch (DataAccessException ex) {
                    Logger.getLogger(NouveauPersonnelPannel.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }
}
