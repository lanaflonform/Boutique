/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jdesktop.swingx.JXHyperlink;

/**
 *
 * @author ing-lateu
 */
public abstract class Banniere extends JPanel {

    private JXHyperlink deconnexion;
    private JLabel username;
    private Image image;

    Image findImage(String path) throws IOException {


        return image = ImageIO.read(new File(path));

    }

    public Banniere() {
        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        setBackground(new Color(166, 202, 240));
        //JPanel pan = new JPanel(new FlowLayout(FlowLayout.RIGHT,10,10));
        //pan.setBorder(new EmptyBorder(0, 0, 0, 10));
        setPreferredSize(new Dimension(800, 120));
        username = new JLabel("Bonjour,");
        deconnexion = new JXHyperlink();
        deconnexion.setUnclickedColor(Color.blue);
        deconnexion.setClickedColor(Color.blue);
        deconnexion.setText("Deconnexion");
        deconnexion.setVisible(false);
        username.setVisible(false);
        add(username);
        add(deconnexion);
        //add(BorderLayout.CENTER,pan);
        deconnexion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                deconnexion();
                setEnabledHeader(false);
            }
        });
    }

    public abstract void deconnexion();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Font font = new Font("Serif", Font.PLAIN, 32);
        GradientPaint gp = new GradientPaint(0f, 0f, Color.blue, 0f, 30f, Color.green);
        ((Graphics2D) g).setPaint(gp);
        g.setFont(font);
        g.setColor(Color.yellow);

        g.drawString("Le gestionnaire", 310, 80);
        g.setFont(new Font("Serif", Font.ITALIC, 24));

        try {
            //        g.setColor(Color.CYAN);
            //        g.drawString("ouverture le 30/10/2015", 390, 120);
            g.drawImage(findImage("/home/ing-lateu/NetBeansProjects/Boutique/images/d12.JPG"), 0, 0, null);
        } catch (IOException ex) {
            Logger.getLogger(Banniere.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public void setEnabledHeader(boolean status) {
        username.setVisible(status);
        deconnexion.setVisible(status);
        if (true) {
            //   username.setText("Bonjour "+UserInfo.getUsername()+", ");
            username.setText("Bonjour visiteur");

        }
    }
}
