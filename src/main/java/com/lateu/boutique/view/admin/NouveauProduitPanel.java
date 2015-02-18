/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.view.admin;

import com.douwe.generic.dao.DataAccessException;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;
import com.lateu.boutique.entities.Fournisseur;
import com.lateu.boutique.entities.ProductType;
import com.lateu.boutique.entities.Produit;
import com.lateu.boutique.metier.Impl.IsFournisseurImpl;
import com.lateu.boutique.metier.Impl.IsProduitImpl;
import com.lateu.boutique.metier.IsFournisseur;
import com.lateu.boutique.metier.IsProduit;
import com.lateu.boutique.view.MenuPrincipal;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class NouveauProduitPanel extends JPanel {

    private JTextField designationText;
    private JTextField codeText;
    private JTextField seuilText;
    private JTextField puText;
    private JTextField usernameText;
    private JPasswordField passwordText;
    private JComboBox<ProductType> TypeText;
    private JComboBox<String> fourJComboBox;
    private JXDatePicker datenais;
    private JButton btnEnregistrer;
    private MenuPrincipal parent;
    private Long id = -1L;
    private String currentPassword;
    private Produit p = new Produit();
    private Produit p2 = new Produit();
    private Produit p3 = new Produit();
    IsProduit servIsProduit;
    IsFournisseur servFournisseur;

    public NouveauProduitPanel(MenuPrincipal parentFrame, Long fournisseur_id) throws DataAccessException {
        this(parentFrame);
        servIsProduit = new IsProduitImpl();
        servFournisseur = new IsFournisseurImpl();
        this.id = fournisseur_id;

        if (this.id > 0) {
            btnEnregistrer.setText("Modifier");
             p = servIsProduit.findById(id);
            if (p != null) {
                designationText.setText(p.getDesignation());
                // contactText.setText(p.getContact());
                //TypeText.
                puText.setText(p.getPU()+"");
                 seuilText.setText(p.getSeuil()+"");
                codeText.setText(p.getCode());

            }
        }

        //  System.out.println("selected -----" + p.toString());
    }

    public NouveauProduitPanel(MenuPrincipal parentFrame) throws DataAccessException {

        this.parent = parentFrame;
        servFournisseur = new IsFournisseurImpl();
        servIsProduit = new IsProduitImpl();
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
        builder.append("fournisseur", fourJComboBox = new JComboBox<String>());
        builder.append("Type", TypeText = new JComboBox<ProductType>());
        TypeText.addItem(ProductType.Alimentaire);
        TypeText.addItem(ProductType.Electronique);

        fourJComboBox.addItem("");
        List<Fournisseur> liste = servFournisseur.findAll();
        System.out.println("----------------fournisseur courants------" + liste.size());
        if (!liste.isEmpty()) {
            for (Fournisseur c : liste) {
                if (c != null) {
                    fourJComboBox.addItem(c.getNom());

                }
            }

        }


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
                         p3.setPU(Integer.parseInt(puText.getText()));
                          p3.setSeuil(Integer.parseInt(seuilText.getText()));
                        p3.setType(TypeText.toString());
                        p3.setId(id);


                        servIsProduit.udpdate(p3);



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
                    String seuil = seuilText.getText();

                    ProductType type = (ProductType) TypeText.getSelectedItem();
                    String typeProd = type.toString();


                    String nomFourn = (String) fourJComboBox.getSelectedItem();
                    if ("".equalsIgnoreCase(nomFourn)) {
                        JOptionPane.showMessageDialog(null, "le fournisseur est obligatoire");
                        return;
                    }


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
                    Integer prixU = Integer.parseInt(pu);
                    Integer s = Integer.parseInt(seuil);
                    p.setSeuil(s.intValue());
                    p.setPU(prixU.intValue());
                    p.setType(typeProd);

                    System.out.println("----------------avant ajout du produit------" + pu + "-------- aprssssss" + prixU);
                    servIsProduit.save(p, nomFourn);



                }
                try {
                    parent.setContenu(new ProduitPanel(parent));
                } catch (DataAccessException ex) {
                    Logger.getLogger(NouveauProduitPanel.class.getName()).log(Level.SEVERE, null, ex);
                }


            }
        });
    }
}
