/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.dao.Impl;

import com.lateu.boutique.DB.DBconnection;
import com.lateu.boutique.dao.Personneldao;
import com.lateu.boutique.entities.Personnel;
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
public class PersonneldaoImpl implements Personneldao {

    private DBconnection dBconnection = new DBconnection();
    private Connection conn;

    public Personnel Save(Personnel p) {
        Personnel tmp = null;
        try {
            conn = dBconnection.getConnexion();
            PreparedStatement pst = conn.prepareStatement("insert into Personnel(contact,dateNais,etatCompte,nom,password,prenom,username) values(?,?,?,?,?,?,?)");
            pst.setString(1, p.getContact());
            pst.setDate(2, null);
            pst.setInt(3, p.getEtatCompte());
            pst.setString(4, p.getNom());
            pst.setString(5, p.getPassword());
            pst.setString(6, p.getPrenom());
            pst.setString(7, p.getUsername());
            pst.executeUpdate();
            tmp = p;
        } catch (SQLException ex) {
            Logger.getLogger(PersonneldaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }


        return tmp;



    }

    public Personnel Delete(Long p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String Login(String username, String password) {
        String s = null;
        try {
            conn = dBconnection.getConnexion();
            PreparedStatement pst = conn.prepareStatement("select UserRole.autorié  from Personnel, UserRole where Personnel.username = ? and Personnel.password =? and Personnel.id=UserRole.personnel_id");
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                s = rs.getString(1);

            }

            pst.close();
            rs.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(PersonneldaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;

    }

    public List<Personnel> findAll() {

        List<Personnel> personnels = new ArrayList<Personnel>();
        Personnel p;
        try {
            conn = dBconnection.getConnexion();
            PreparedStatement pst = conn.prepareStatement("select * from Personnel");
            ResultSet res = pst.executeQuery();

            while (res.next()) {
                p = new Personnel();
                p.setContact(res.getString("contact"));
                p.setNom(res.getString("nom"));
                p.setPrenom(res.getString("prenom"));
                p.setUsername(res.getString("username"));
                p.setDateNais(res.getDate("dateNais"));
                p.setEtatCompte(res.getInt("etatCompte"));
                p.setId(res.getLong("id"));

                personnels.add(p);
            }

            pst.close();
            res.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(PersonneldaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return personnels;
    }

    public Personnel findPersonnelByID(Long id) {


        Personnel f = null;
        try {
            conn = dBconnection.getConnexion();
            PreparedStatement pst = conn.prepareStatement("select * from Personnel where id=?");
            pst.setLong(1, id);
            ResultSet res = pst.executeQuery();

            if (res.next()) {
                f = new Personnel();
                f.setContact(res.getString("contact"));
                f.setNom(res.getString("nom"));
                f.setPrenom(res.getString("prenom"));
                f.setUsername(res.getString("username"));
                f.setEtatCompte(res.getInt("etatCompte"));
                f.setId(res.getLong("id"));

            }

            pst.close();
            res.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(PersonneldaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return f;
    }

    public Personnel updatePersonnel(Personnel f) {

        Personnel tmp = null;
        try {
            conn = dBconnection.getConnexion();
            PreparedStatement pst = conn.prepareStatement("update Personnel set contact=?,dateNais=?,etatCompte=?, nom=?, prenom=?,username=? where id=?");
            pst.setString(1, f.getContact());

            pst.setString(2, null);

            pst.setInt(3, f.getEtatCompte());
            pst.setString(4, f.getNom());
            pst.setString(5, f.getPrenom());
            pst.setString(6, f.getUsername());
           // pst.setString(7, f.getPassword());
            pst.setLong(7, f.getId());
            pst.executeUpdate();


            tmp = f;
            pst.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(PersonneldaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tmp;



    }

    public Personnel TestUsername(String username) {

        Personnel p = null;
        try {
            p = new Personnel();
            conn = dBconnection.getConnexion();
            PreparedStatement pst = conn.prepareStatement("select* from Personnel where username = ?");
            pst.setString(1, username);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                p.setId(rs.getLong("id"));
                p.setUsername(rs.getString("username"));

            }

            pst.close();
            rs.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(PersonneldaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;


    }
}
