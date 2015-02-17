/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.view.admin;

import com.douwe.generic.dao.DataAccessException;
import com.lateu.boutique.entities.Personnel;
import com.lateu.boutique.entities.UserType;
import com.lateu.boutique.metier.Impl.IsPersonnelImpl;
import com.lateu.boutique.metier.IsPersonnel;
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
import javax.swing.JComboBox;
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
public class PersonnelPanel extends JPanel {

    private JButton nouveauBtn;
    private JButton supprimerBtn;
    private JButton modifierBtn;
    private JButton filtreBtn;
    private JTable clientTable;
    private DefaultTableModel tableModel;
    private JTextField nameText;
    private MenuPrincipal parent;
    private Personnel p = new Personnel();
    private IsPersonnel serIsPersonnel;
    private List<Personnel> liste = new ArrayList<Personnel>();
     private JComboBox<UserType>  role;

    public PersonnelPanel(MenuPrincipal parentFrame) throws DataAccessException {
        serIsPersonnel = new IsPersonnelImpl();
//        customerService = new ICustomerServiceImpl();
//        customer = new Customer();
//        operationService = new IOperationServiceImpl();
//        operations = new Operations();
//        liste = new ArrayList<Customer>();
        try {
            setLayout(new BorderLayout());
            this.parent = parentFrame;
            JPanel haut = new JPanel();
            haut.setLayout(new FlowLayout(FlowLayout.CENTER));
            JLabel lbl;
            haut.add(lbl = new JLabel("LA LISTE DU PERSONNEL"));
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
                        parent.setContenu(new NouveauPersonnelPannel(parent));
                    } catch (DataAccessException ex) {
                        Logger.getLogger(PersonnelPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            modifierBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    int selected = clientTable.getSelectedRow();
                    if (selected >= 0) {
                        try {
                            parent.setContenu(new NouveauPersonnelPannel(parent, (Long) tableModel.getValueAt(selected, 0)));
                        } catch (DataAccessException ex) {
                            Logger.getLogger(PersonnelPanel.class.getName()).log(Level.SEVERE, null, ex);
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
            tableModel = new DefaultTableModel(new Object[]{"id", "Nom", "Prenom", "Username", "DateNais", "Contact", "EtatCompte"}, 0);
            clientTable = new JTable(tableModel);
            clientTable.removeColumn(clientTable.getColumnModel().getColumn(0));
            contenu.add(BorderLayout.CENTER, new JScrollPane(clientTable));
            add(BorderLayout.CENTER, contenu);


            liste = serIsPersonnel.findAll();
            for (Personnel pe : liste) {
                tableModel.addRow(new Object[]{
                    pe.getId(),
                    pe.getNom(),
                    pe.getPrenom(),
                    pe.getUsername(),
                    pe.getDateNais(),
                    pe.getContact(),
                    pe.getEtatCompte()
                });

            }



        } catch (Exception ex) {
                  Logger.getLogger(PersonnelPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
