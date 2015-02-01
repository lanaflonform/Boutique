/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.view.admin;

import com.lateu.boutique.entities.Fournisseur;
import com.lateu.boutique.metier.Impl.IsFournisseurImpl;
import com.lateu.boutique.metier.IsFournisseur;
import com.lateu.boutique.view.MenuPrincipal;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ing-lateu
 */
public class FournisseurPanel extends JPanel {

    private JButton nouveauBtn;
    private JButton supprimerBtn;
    private JButton modifierBtn;
    private JButton filtreBtn;
    private JTable fournisseurTable;
    private DefaultTableModel tableModel;
    private JTextField nameText;
    private MenuPrincipal parent;
    private IsFournisseur serFournisseur;

    public FournisseurPanel(MenuPrincipal parentFrame) {
        serFournisseur=new IsFournisseurImpl();
        List<Fournisseur> lfours=new ArrayList<Fournisseur>();
    try {
            setLayout(new BorderLayout());
            this.parent = parentFrame;
            JPanel haut = new JPanel();
            haut.setLayout(new FlowLayout(FlowLayout.CENTER));
            JLabel lbl;
            haut.add(lbl = new JLabel("LA LISTE DE MES FOURNISSEURS"));
            lbl.setFont(new Font("Times New Roman", Font.ITALIC, 18));
            add(BorderLayout.BEFORE_FIRST_LINE, haut);
            JPanel contenu = new JPanel();
            contenu.setLayout(new BorderLayout());
            JPanel bas = new JPanel();
            bas.setLayout(new FlowLayout());
            nouveauBtn = new JButton("Nouveau");
            supprimerBtn = new JButton("Supprimer");
            modifierBtn = new JButton("Modifier");
            filtreBtn = new JButton("Filtrer");
            filtreBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {


//                    liste = new ArrayList<Customer>();
//                    liste = customerService.findByStatusName(0, nameText.getText());
//                    for (Customer c : liste) {
//                        tableModel.addRow(new Object[]{c.getId(),
//                            c.getName(),
//                            c.getEmailAdress(),
//                            c.getPhoneNumber()
//                        });
//                    }


//                    String name = nameText.getText();
//                    //if ((name != null) && !("".equals(name))) {
//                    try {
//                      conn = dBAccess.getConnexion();
//                        PreparedStatement pst = conn.prepareStatement("select * from customer where status = ? and name like ?");
//                        pst.setInt(1, 0);
//                        pst.setString(2, "%" + name + "%");
//                        ResultSet rs = pst.executeQuery();
//                        tableModel.setRowCount(0);
//                        while (rs.next()) {
//                            tableModel.addRow(new Object[]{rs.getInt("id"),
//                                rs.getString("name"),
//                                rs.getString("emailAddress"),
//                                rs.getString("phoneNumber")
//                            });
//                        }
//                        rs.close();
//                        pst.close();
//                        conn.close();
//                    } catch (SQLException ex) {
//                        JOptionPane.showMessageDialog(null, "Impossible de filtrer vos données");
//                        Logger.getLogger(ClientPanel.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    if (conn != null) {
//                        try {
//                            conn.close();
//                        } catch (SQLException ex1) {
//                            Logger.getLogger(ClientPanel.class.getName()).log(Level.SEVERE, null, ex1);
//                        }
//                    }
                }
                //}
            });
            nouveauBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    parent.setContenu(new NouveauFournisseurPannel(parent));
                 
                }
            });
            modifierBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                 
                    int selected=fournisseurTable.getSelectedRow();
                   if (selected >= 0) {
                        parent.setContenu(new NouveauFournisseurPannel(parent, (Long) tableModel.getValueAt(selected, 0)));
                    } else {
                        JOptionPane.showMessageDialog(null, "Aucun fournisseur n'est selectionné");
                    }
                }
            });
            supprimerBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    int selected = fournisseurTable.getSelectedRow();
//                    if (selected >= 0) {
//                        try {
//                            
//                            int idCustomer=(Integer) tableModel.getValueAt(selected, 0);
//                            int res=customerService.modifierStatut(1, idCustomer);
//                             if(res> 0){
//                             tableModel.removeRow(selected);
//                             
//                             }
//                            
//                          operations.setOperationType(OperationType.suppression);
//                            operations.setDescription("Suppression du client " + tableModel.getValueAt(selected, 1));
//                            operationService.creer(operations);
//                       } catch (Exception ex) {
//                            JOptionPane.showMessageDialog(null, "Erreur lors de la suppression du client " + tableModel.getValueAt(selected, 1));
//                            Logger.getLogger(ClientPanel.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Aucune donnée n'est selectionnée");
//                    }
               }
            });
            bas.add(nouveauBtn);
            bas.add(modifierBtn);
            bas.add(supprimerBtn);
            JPanel filtrePanel = new JPanel();
            filtrePanel.setLayout(new FlowLayout());
            filtrePanel.add(new JLabel("Nom"));
            filtrePanel.add(nameText = new JTextField());
            nameText.setPreferredSize(new Dimension(100, 25));
            filtrePanel.add(filtreBtn);
            contenu.add(BorderLayout.AFTER_LAST_LINE, bas);
            contenu.add(BorderLayout.BEFORE_FIRST_LINE, filtrePanel);
            tableModel = new DefaultTableModel(new Object[]{"id", "Nom", "Ville", "Contact"}, 0);
            fournisseurTable = new JTable(tableModel);
            fournisseurTable.removeColumn(fournisseurTable.getColumnModel().getColumn(0));
            contenu.add(BorderLayout.CENTER, new JScrollPane(fournisseurTable));
            add(BorderLayout.CENTER, contenu);
            
            
            lfours=serFournisseur.findAll();
            for (Fournisseur c : lfours) {
                
                tableModel.addRow(new Object[]{c.getId(),
                    c.getNom(),
                    c.getVille(),
                    c.getContact()
                });
            
        }

//
//            liste = customerService.findByStatus(0);
//
//            for (Customer c : liste) {
//                tableModel.addRow(new Object[]{c.getId(),
//                    c.getName(),
//                    c.getEmailAdress(),
//                    c.getPhoneNumber()
//                });
//            }
        } catch (Exception ex) {
            Logger.getLogger(FournisseurPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
