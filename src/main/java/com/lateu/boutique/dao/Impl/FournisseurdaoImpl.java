/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.dao.Impl;

import com.lateu.boutique.DB.DBconnection;
import com.lateu.boutique.dao.Fournisseurdao;
import com.lateu.boutique.entities.Fournisseur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ing-lateu
 */
public class FournisseurdaoImpl implements Fournisseurdao {

    private DBconnection dBconnection = new DBconnection();
    private Connection conn;

    public List<Fournisseur> findAll() {
        List<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();
        Fournisseur f;
        try {
            conn = dBconnection.getConnexion();
            PreparedStatement pst = conn.prepareStatement("select * from Fournisseur");
            ResultSet res = pst.executeQuery();

            while (res.next()) {
                f = new Fournisseur();
                f.setContact(res.getString("contact"));
                f.setNom(res.getString("nom"));
                f.setVille(res.getString("ville"));
                f.setId(res.getLong("id"));
                fournisseurs.add(f);

            }

            pst.close();
            res.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(FournisseurdaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fournisseurs;
    }

    public Fournisseur SaveFourn(Fournisseur f) {

        Fournisseur tmp = null;
        try {
            conn = dBconnection.getConnexion();
            PreparedStatement pst = conn.prepareStatement("insert into Fournisseur(contact,nom,ville) values(?,?,?)");
            // pst.setLong(1, 2L);
            pst.setString(1, f.getContact());
            pst.setString(2, f.getNom());
            pst.setString(3, f.getVille());

            pst.executeUpdate();

            tmp = f;


            pst.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(FournisseurdaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tmp;

    }

    public void DeleteFourn(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Fournisseur findByID(Long id) {

        Fournisseur f = null;
        try {
            conn = dBconnection.getConnexion();
            PreparedStatement pst = conn.prepareStatement("select * from Fournisseur where id=?");
            pst.setLong(1, id);           
            ResultSet res = pst.executeQuery();

            if(res.next()) {
                f = new Fournisseur();
                f.setContact(res.getString("contact"));
                f.setNom(res.getString("nom"));
                f.setVille(res.getString("ville"));
                f.setId(res.getLong("id"));


            }

            pst.close();
            res.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(FournisseurdaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return f;
    }

    public Fournisseur update(Fournisseur f) {
        Fournisseur tmp = null;
        try {
            conn = dBconnection.getConnexion();
            PreparedStatement pst = conn.prepareStatement("update Fournisseur set nom=?, ville=?,contact=? where id=?");
            pst.setString(1, f.getNom());
            pst.setString(2, f.getVille());
            pst.setString(3, f.getContact());
            pst.setLong(4, f.getId());
            pst.executeUpdate();

            //  ResultSet res = pst.executeQuery();
            tmp = f;
            pst.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(FournisseurdaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tmp;

    }
}
