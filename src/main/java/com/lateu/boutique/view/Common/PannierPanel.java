/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.view.Common;

import com.lateu.boutique.view.admin.*;
import com.douwe.generic.dao.DataAccessException;
import com.lateu.boutique.entities.Pannier;
import com.lateu.boutique.metier.Impl.IsProduitImpl;
import com.lateu.boutique.metier.IsProduit;
import com.lateu.boutique.view.MenuPrincipal;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
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
public class PannierPanel extends JPanel {

    private JButton nouveauBtn;
    private JButton supprimerBtn;
    private JButton modifierBtn;
    private JButton imprimerBtn;
    private JButton filtreBtn;
    private JTable clientTable;
    private DefaultTableModel tableModel;
    private MenuPrincipal parent;
    private JTextField nameText;
    private List<Pannier> liste = new ArrayList<Pannier>();
    private IsProduit servproduit;

    public PannierPanel(MenuPrincipal parentFrame) throws DataAccessException {
        servproduit = new IsProduitImpl();
        try {
            setLayout(new BorderLayout());
            this.parent = parentFrame;
            JPanel haut = new JPanel();
            haut.setLayout(new FlowLayout(FlowLayout.CENTER));
            JLabel lbl;
            haut.add(lbl = new JLabel("PANNIER COURANT"));
            lbl.setFont(new Font("Times New Roman", Font.ITALIC, 18));
            add(BorderLayout.BEFORE_FIRST_LINE, haut);
            JPanel contenu = new JPanel();
            contenu.setLayout(new BorderLayout());
            JPanel bas = new JPanel();
            bas.setLayout(new FlowLayout());
            nouveauBtn = new JButton("Nouveau");
            supprimerBtn = new JButton("Supprimer");
            modifierBtn = new JButton("Modifier");
            imprimerBtn = new JButton("Imprimer");
            filtreBtn = new JButton("Filtrer");
            filtreBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
//
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
                    try {
                        parent.setContenu(new NouveauPannierPannel(parent));
                    } catch (DataAccessException ex) {
                        Logger.getLogger(ProduitPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            modifierBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    int selected = clientTable.getSelectedRow();
                    if (selected >= 0) {
                        try {
                            parent.setContenu(new NouveauPannierPannel(parent, (Long) tableModel.getValueAt(selected, 0)));
                        } catch (DataAccessException ex) {
                            Logger.getLogger(ProduitPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Aucun Personnel n'est selectionné");
                    }
                }
            });
            supprimerBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    int selected = clientTable.getSelectedRow();
                    if (selected >= 0) {
                        try {
//                            int idCustomer=(Integer) tableModel.getValueAt(selected, 0);
//                            int res=customerService.modifierStatut(1, idCustomer);
//                             if(res> 0){
//                             tableModel.removeRow(selected);
//                             
//                             }
//                        operations.setOperationType(OperationType.suppression);
//                            operations.setDescription("Suppression du client " + tableModel.getValueAt(selected, 1));
//                            operationService.creer(operations);
//                     
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Erreur lors de la suppression du client " + tableModel.getValueAt(selected, 1));
                            //     Logger.getLogger(ClientPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Aucune donnée n'est selectionnée");
                    }
                }
            });

            imprimerBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MessageFormat header = new MessageFormat("facture du client");
                    MessageFormat footer = new MessageFormat("page no");
                    try {
                      //  tableModel.
                        JTable jtab=new JTable(tableModel);
                        jtab.print(JTable.PrintMode.NORMAL, header, footer);
                    } catch (java.awt.print.PrinterException ec) {
                        System.err.format("cannot print %s%n", ec.getMessage());
                    }
                  //  JOptionPane.showMessageDialog(null, "cette  fonctionnalité n'est pas encore operationnel");

                }
            });
            bas.add(nouveauBtn);
            bas.add(modifierBtn);
            bas.add(supprimerBtn);
            bas.add(imprimerBtn);
            JPanel filtrePanel = new JPanel();
            filtrePanel.setLayout(new FlowLayout());
            filtrePanel.add(new JLabel("Nom"));
            filtrePanel.add(nameText = new JTextField());
            nameText.setPreferredSize(new Dimension(100, 25));
            filtrePanel.add(filtreBtn);
            contenu.add(BorderLayout.AFTER_LAST_LINE, bas);
            contenu.add(BorderLayout.BEFORE_FIRST_LINE, filtrePanel);
            tableModel = new DefaultTableModel(new Object[]{"id", "Designation", "PU", "quantite", "PT"}, 0);
            clientTable = new JTable(tableModel);
            clientTable.removeColumn(clientTable.getColumnModel().getColumn(0));
            contenu.add(BorderLayout.CENTER, new JScrollPane(clientTable));
            add(BorderLayout.CENTER, contenu);


            liste = servproduit.findAllPannier();
            for (Pannier p : liste) {
                tableModel.addRow(new Object[]{
                    p.getId(),
                    p.getDesignation(),
                    p.getPU(),
                    p.getQuantite(),
                    p.getPT(),});

            }



        } catch (Exception ex) {
            Logger.getLogger(PersonnelPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
