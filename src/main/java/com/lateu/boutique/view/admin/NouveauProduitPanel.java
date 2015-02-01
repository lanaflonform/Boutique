/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.view.admin;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;
import com.lateu.boutique.entities.Fournisseur;
import com.lateu.boutique.entities.Personnel;
import com.lateu.boutique.entities.ProductType;
import com.lateu.boutique.entities.Produit;
import com.lateu.boutique.entities.UserRole;
import com.lateu.boutique.entities.UserType;
import com.lateu.boutique.metier.Impl.IsPersonnelImpl;
import com.lateu.boutique.metier.IsPersonnel;
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
public class NouveauProduitPanel extends JPanel {

    private JTextField designationText;
    private JTextField codeText;
    private JTextField seuilText;
    private JTextField puText;
    private JTextField usernameText;
    private JPasswordField passwordText;
    private JComboBox<ProductType> TypeText;
    private JXDatePicker datenais;
    private JButton btnEnregistrer;
    private MenuPrincipal parent;
    private Long id = -1L;
    private String currentPassword;
    private Produit p = new Produit();
    private Produit p2 = new Produit();
    private Produit p3 = new Produit();
    private UserRole userRole = new UserRole();
    IsPersonnel servIsPersonnel = new IsPersonnelImpl();

    public NouveauProduitPanel(MenuPrincipal parentFrame, Long fournisseur_id) {
        this(parentFrame);
        this.id = fournisseur_id;

        if (this.id > 0) {
            btnEnregistrer.setText("Modifier");
           // p = servIsPersonnel.findPersonnelByID(id);
            if (p != null) {
                designationText.setText(p.getDesignation());
               // contactText.setText(p.getContact());
                //usernameText.setText(p.getUsername());
               // passwordText.setText(p.getPassword());
                codeText.setText(p.getCode());

            }
        }

        //  System.out.println("selected -----" + p.toString());
    }

    public NouveauProduitPanel(MenuPrincipal parentFrame) {

        this.parent = parentFrame;
        setLayout(new BorderLayout(10, 10));

        JPanel haut = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel lbl;
        haut.add(lbl = new JLabel("AJOUT D'UN NOUVEAU PRODUIT "));
        lbl.setFont(new Font("Times New Roman", Font.ITALIC, 18));
        add(BorderLayout.BEFORE_FIRST_LINE, haut);
        DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout("right:max(40dlu;p), 12dlu, 180dlu:", ""));
        builder.append("designation", designationText = new JTextField());
        builder.append("code", codeText = new JTextField());
        builder.append("PU", puText = new JTextField());
        builder.append("Seuil", seuilText = new JTextField());
       // builder.append("contact", contactText = new JTextField());
       // builder.append("username", usernameText = new JTextField());
        builder.append("Type", TypeText = new JComboBox<ProductType>());
       // builder.append("dateNaiss", datenais = new JXDatePicker());
        TypeText.addItem(ProductType.Alimentaire);
        TypeText.addItem(ProductType.Electronique);
        builder.append(btnEnregistrer = new JButton("Enrégistrer"));
        add(BorderLayout.CENTER, builder.getPanel());

        btnEnregistrer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (id > 0) {
                    try {
                        // here I'm updating an account
                        String designation = designationText.getText();

                        if ((designation == null) || ("".equals(designation))) {
                            JOptionPane.showMessageDialog(null, "Le numéro du compte n'est pas specifie");
                            return;
                        }
                        System.out.println("===je suis de passage ici====");
                        p3.setCode(codeText.getText());
                        p3.setDesignation(designationText.getText());
                       // p3.setPU(WIDTH);
                        p3.setType(TypeText.toString());
                        p3.setId(id);
                       // p3.setEtatCompte(e);
                        
                       // p3=servIsPersonnel.updatePersonnel(p3);



                        parent.setContenu(new ProduitPanel(parent));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Impossible de mettre à jour le compte");
                        Logger.getLogger(NouveauProduitPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {

                    // I need to get the customer_id
                    String designation = designationText.getText();
                    String code = codeText.getText();
                    String pu = puText.getText();
                
             
                    ProductType type = (ProductType) TypeText.getSelectedItem();
                    String typeProd=type.toString();
               
//                    if (p2 == null) {
//                        JOptionPane.showMessageDialog(null, "le login " + username + "  n'est pas disponible");
//                        return;
//                    }

                    if ((designation == null) || ("".equals(designation))) {
                        JOptionPane.showMessageDialog(null, "Le nom du produit n'est pas specifie");
                        return;
                    }
                    if ((seuilText == null) || ("".equals(seuilText))) {
                        JOptionPane.showMessageDialog(null, "La contact n'est pas specifie");
                        return;
                    }
                    if ((code == null) || ("".equals(code))) {
                        JOptionPane.showMessageDialog(null, "Le code n'est pas specifie");
                        return;
                    }

                    p.setCode(code);
                    p.setDesignation(designation);
                    //p.setPU(WIDTH);
                    p.setType(typeProd);
                   
                    userRole.setAutorié(type.toString());
                //    System.out.println("=====" + servIsPersonnel.Save(p, userRole));



                }



                parent.setContenu(new ProduitPanel(parent));

            }
        });
    }
}
