/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.dao.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.lateu.boutique.dao.Personneldao;
import com.lateu.boutique.entities.Personnel;
import com.lateu.boutique.entities.UserRole;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lateu
 */
public class PersonneldaoImpl extends GenericDao<Personnel, Long> implements Personneldao {

    @Override
    public Personnel findPersonnelByName(String s) throws DataAccessException {
        return (Personnel) getManager().createNamedQuery("findPersonnelByName")
                .setParameter("nom", s)
                .getSingleResult();
    }

    @Override
    public UserRole findRole(String login) throws DataAccessException {
        return (UserRole) getManager().createNamedQuery("findRole")
                .setParameter("username", login)
                //.setParameter("password", pass)
                .getSingleResult();
    }

//        public List<Comptabilite> findComptablite() throws DataAccessException {
//   return  getManager().createNamedQuery("ValeurEntreprise")
//           .getResultList();
//    }
    
     public UserRole Login(String username, String password)throws DataAccessException {
      
            return (UserRole) getManager().createNamedQuery("login")
                    .setParameter("username", username)
                   .setParameter("password", password)                 
                    .getSingleResult();
     
    }

    public List <Personnel>  TestUsername(String username) {
        try {
            return  getManager().createNamedQuery("TestUserName")
                    .setParameter("username", username)             
                    .getResultList();
        } catch (DataAccessException ex) {
            return null;
           // Logger.getLogger(PersonneldaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
}

}
