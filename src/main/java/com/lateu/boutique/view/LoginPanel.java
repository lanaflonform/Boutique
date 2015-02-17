/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.view;

import com.douwe.generic.dao.DataAccessException;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;
import com.lateu.boutique.metier.Impl.IsPersonnelImpl;
import com.lateu.boutique.metier.IsPersonnel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author ing-lateu
 */
public class LoginPanel extends JPanel {

    private JTextField loginText;
    private JPasswordField passwdText;
    private JButton btnLogin;
    private Connection conn;
    // private DBAccess dBAccess = new DBAccess();
    private IsPersonnel sPersonnel;

    public LoginPanel() throws DataAccessException {
        sPersonnel = new IsPersonnelImpl();
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(80, 350, 80, 300));
        JPanel haut = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel lbl;

        add(BorderLayout.BEFORE_FIRST_LINE, haut);
        DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout("right:max(40dlu;p), 12dlu, 180dlu:", ""));
        builder.append("Login", loginText = new JTextField());
        builder.append("Mot de passe", passwdText = new JPasswordField());
        builder.append(btnLogin = new JButton("Login"));
        add(BorderLayout.CENTER, builder.getPanel());
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    String username = loginText.getText();
                    String passwd = new String(passwdText.getPassword());
                    if ((username == null) || ("".equals(username))) {
                        JOptionPane.showMessageDialog(null, "Le login est obligatoire");
                        passwdText.setText("");
                        return;
                    }
                    if ("".equals(passwd)) {
                        JOptionPane.showMessageDialog(null, "Le mot de passe est obligatoire");
                        passwdText.setText("");
                        return;
                    }

                     if(sPersonnel.Login(username, passwd)!=null){
                    //System.out.println("======="+s);

                    success();
                    }else {
                            JOptionPane.showMessageDialog(null, "Login ou mot de passe incorrect");
                            passwdText.setText("");
                        }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Impossible de vérifier vos coordonnées");
                    passwdText.setText("");
                    Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    public void success() {
    }
}
