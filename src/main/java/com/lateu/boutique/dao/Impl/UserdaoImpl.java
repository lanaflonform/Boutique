/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.dao.Impl;

import com.lateu.boutique.DB.DBconnection;
import com.lateu.boutique.dao.Userdao;
import com.lateu.boutique.entities.Personnel;
import com.lateu.boutique.entities.UserRole;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ing-lateu
 */
public class UserdaoImpl implements Userdao{
 private DBconnection dBconnection = new DBconnection();
    private Connection conn;
    public UserRole Save(UserRole p) {
     UserRole tmp = null;
        try {
            conn = dBconnection.getConnexion();
            PreparedStatement pst = conn.prepareStatement("insert into UserRole(autorié,personnel_id) values(?,?)");
            pst.setString(1, p.getAutorié());
            pst.setLong(2,  p.getPersonnel().getId());
            pst.executeUpdate();
            tmp = p;
        } catch (SQLException ex) {
            Logger.getLogger(PersonneldaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return tmp;
        
    
    }

    public UserRole Delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<UserRole> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public UserRole findUserRoleByID(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int TestUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public UserRole updatePersonnel(UserRole f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
