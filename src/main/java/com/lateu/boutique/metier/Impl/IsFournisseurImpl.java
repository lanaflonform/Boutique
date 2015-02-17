/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.metier.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.lateu.boutique.DB.GConfig;
import com.lateu.boutique.dao.Fournisseurdao;
import com.lateu.boutique.dao.Impl.FournisseurdaoImpl;
import com.lateu.boutique.entities.Fournisseur;
import com.lateu.boutique.metier.IsFournisseur;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ing-lateu
 */
public class IsFournisseurImpl extends GConfig implements IsFournisseur {

    Fournisseurdao fao = new FournisseurdaoImpl();
    private Fournisseurdao fournisseurdao = new FournisseurdaoImpl();
   // GConfig gf = new GConfig();

    public IsFournisseurImpl() throws DataAccessException {
        this.getTx().begin();
        ((GenericDao) fao).setManager(getEm());
    }

    public List<Fournisseur> findAll() {
        List<Fournisseur> liste = null;
        try {

            liste = new ArrayList<Fournisseur>();
            liste = fao.findAll();
           // gf.getEmf().close();
        } catch (DataAccessException ex) {
            Logger.getLogger(IsFournisseurImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liste;



    }

    public Fournisseur Ajouter(Fournisseur f) throws DataAccessException {

       // getTx().begin();
       // ((GenericDao) fao).setManager(getEm());
        fao.create(f);
        getTx().commit();
        return f;
    }

    public Fournisseur findById(Long j) {
        Fournisseur temp = null;
        try {
          //  getTx().begin();
          //  ((GenericDao) fao).setManager(getEm());
            temp = fao.findById(j);
            //  getEm().close();
            //  getEmf().close();
        } catch (DataAccessException ex) {
            Logger.getLogger(IsFournisseurImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

    public Fournisseur update(Fournisseur f) {
//        try {
//            return fournisseurdao.update(f);
//        } catch (DataAccessException ex) {
//            Logger.getLogger(IsFournisseurImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return null;
    }
}
