/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.metier.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.lateu.boutique.DB.GConfig;
import com.lateu.boutique.dao.Impl.PersonneldaoImpl;
import com.lateu.boutique.dao.Impl.UserRoledaoImpl;
import com.lateu.boutique.dao.Personneldao;
import com.lateu.boutique.dao.UserRoledao;
import com.lateu.boutique.entities.Personnel;
import com.lateu.boutique.entities.UserRole;
import com.lateu.boutique.metier.IsPersonnel;
import com.lateu.boutique.metier.ServiceException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ing-lateu
 */
public class IsPersonnelImpl extends GConfig implements IsPersonnel {

    private Personneldao personneldao = new PersonneldaoImpl();
    private UserRoledao uSerdao = new UserRoledaoImpl();

    public IsPersonnelImpl() throws DataAccessException {
        this.getTx().begin();
        ((GenericDao) personneldao).setManager(getEm());
         ((GenericDao) uSerdao).setManager(getEm());
    }

    public String Login(String login, String password) throws ServiceException {
        try {
            return personneldao.Login(login, password).getAutorié();
        } catch (DataAccessException ex) {
            Logger.getLogger(IsPersonnelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public Personnel Save(Personnel p, UserRole role) throws ServiceException {
        System.out.println("-----------------------je save un personnel");
        List <Personnel>  tmp1 = null;
             Personnel tmp = null;
             Long id=0L;
        try {
            tmp = new Personnel();
            personneldao.create(p);
         
            tmp = p;
        } catch (DataAccessException ex) {
            Logger.getLogger(IsPersonnelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (tmp != null) {
            tmp1 = new ArrayList<Personnel>();
            try {
                tmp1=personneldao.TestUsername(tmp.getUsername());
                if(!tmp1.isEmpty()){
                    for (Personnel personnel : tmp1) {
                        id =personnel.getId(); 
                    }
                
                
                p.setId(id);
                role.setPersonnel(p);
                System.out.println("=------------------------------------------------tmp---------"+tmp);
                    uSerdao.create(role);
                //    this.getTx().commit();
                }
               
            } catch (DataAccessException ex) {
                Logger.getLogger(IsPersonnelImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
          this.getTx().commit();
        return tmp;

    }

    public List<Personnel> findAll() {
        try {
            return personneldao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(IsPersonnelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Personnel findPersonnelByID(Long id) {
        try {
            return personneldao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(IsPersonnelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Personnel updatePersonnel(Personnel f) {
        Personnel tmp = null;
        try {
            personneldao.update(f);
            this.getTx().commit();
            return tmp = f;
        } catch (DataAccessException ex) {
            return null;
            //Logger.getLogger(IsPersonnelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public List <Personnel>  TestUsername(String username) {
        try {
            return personneldao.TestUsername(username);
        } catch (DataAccessException ex) {
            return null;
            // Logger.getLogger(IsPersonnelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
