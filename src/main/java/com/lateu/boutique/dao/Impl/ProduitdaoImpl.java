/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.dao.Impl;

import com.lateu.boutique.DB.DBconnection;
import com.lateu.boutique.dao.Produitdao;
import com.lateu.boutique.entities.Personnel;
import com.lateu.boutique.entities.Produit;
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
public class ProduitdaoImpl implements Produitdao{
 private DBconnection dBconnection = new DBconnection();
    private Connection conn;
    
    
    public List<Produit> findAll() {
    
       List<Produit> prods = new ArrayList<Produit>();
       Produit p;
        try {
            conn = dBconnection.getConnexion();
            PreparedStatement pst = conn.prepareStatement("select * from Produit");
            ResultSet res = pst.executeQuery();

            while (res.next()) {
                p = new Produit();
                p.setCode(res.getString("code"));
                p.setDesignation(res.getString("designation"));
                p.setPU(res.getInt("PU"));
                p.setSeuil(res.getInt("seuil"));
                //p.setFournisseur(res.getLong("fournisseur_id").);
                p.setType(res.getString("type"));
                p.setId(res.getLong("id"));

                prods.add(p);
            }

            pst.close();
            res.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(PersonneldaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return prods;
    }
    
}
