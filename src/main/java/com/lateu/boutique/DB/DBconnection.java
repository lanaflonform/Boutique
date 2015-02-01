/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ing-lateu
 */
public class DBconnection {
    
    
    private Connection connexion;

    public DBconnection(Connection connexion) {
        this.connexion = connexion;
    }

    public DBconnection() {
    }

    public Connection getConnexion() {
        String db="commerce";
        connexion=null;
      try{  
        String strClassName = "com.mysql.jdbc.Driver";
      Class.forName(strClassName); 
 String strUrl = "jdbc:mysql://localhost:3306/"+db; 
connexion = DriverManager.getConnection(strUrl,"root","07v120!"); 

} 
catch(ClassNotFoundException e) { 
	System.err.println("Driver non chargé !"); 
	e.printStackTrace(); 
    }   catch (SQLException ex) {
          System.err.println("Echec de la connexion");
          ex.printStackTrace();
           // Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connexion;
      
    }

    public void setConnexion(Connection connexion) {
        this.connexion = connexion;
    }
    
    
    
    
}
