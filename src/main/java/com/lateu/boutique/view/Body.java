/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.view;

import com.douwe.generic.dao.DataAccessException;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ing-lateu
 */
public class Body extends JFrame {

    private Banniere headerPanel;
    private JPanel contentPanel;

    public Body() throws DataAccessException {


        setTitle("j4U");
        getContentPane().setLayout(new BorderLayout(10, 10));
        headerPanel = new Banniere() {
            @Override
            public void deconnexion() {
             
                contentPanel.removeAll();
//                contentPanel.add(BorderLayout.CENTER, new LoginPanel() {
//                    @Override
//                    public void success() {
//                        contentPanel.removeAll();
//                        contentPanel.add(BorderLayout.CENTER, new MenuPrincipal());
//                        contentPanel.validate();
//                        headerPanel.setEnabledHeader(true);
//                    }
//                });

                
                contentPanel.validate();
            }
        };
        getContentPane().add(headerPanel, BorderLayout.BEFORE_FIRST_LINE);
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        JPanel login = new LoginPanel(){
            @Override
            public void success() {
                contentPanel.removeAll();
                contentPanel.add(BorderLayout.CENTER, new MenuPrincipal());
                contentPanel.validate();
                headerPanel.setEnabledHeader(true);
            }
        };
        contentPanel.add(login, BorderLayout.CENTER);
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
