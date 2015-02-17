/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.lateu.boutique.entities.Personnel;
import com.lateu.boutique.entities.UserRole;
import java.util.List;

/**
 *
 * @author lateu
 */
public interface Personneldao extends IDao<Personnel, Long>  {
    
     public UserRole Login(String username, String password)throws DataAccessException;
    public Personnel findPersonnelByName(String s)throws DataAccessException;
     public UserRole findRole(String login)throws DataAccessException;
       public   List <Personnel> TestUsername(String username)throws DataAccessException;
    //  List <Comptabilite> findComptablite() throws DataAccessException;

    
}
