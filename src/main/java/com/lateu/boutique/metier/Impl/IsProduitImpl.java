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
import com.lateu.boutique.dao.Impl.PersonneldaoImpl;
import com.lateu.boutique.dao.Impl.ProduitdaoImpl;
import com.lateu.boutique.dao.Personneldao;
import com.lateu.boutique.dao.Produitdao;
import com.lateu.boutique.entities.Fournisseur;
import com.lateu.boutique.entities.Personnel;
import com.lateu.boutique.entities.Produit;
import com.lateu.boutique.metier.IsProduit;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ing-lateu
 */
public class IsProduitImpl extends GConfig implements IsProduit {

    private Produitdao produitdao = new ProduitdaoImpl();
    private Fournisseurdao fournisseurdao=new FournisseurdaoImpl();
    private Personneldao personneldao=new PersonneldaoImpl();

    public IsProduitImpl() throws DataAccessException {
        this.getTx().begin();
        ((GenericDao) produitdao).setManager(getEm());
        ((GenericDao) fournisseurdao).setManager(getEm());
         ((GenericDao) personneldao).setManager(getEm());
    }

    public void save(Produit p, String nomFoun) {
        try {
         Fournisseur f= fournisseurdao.findbyNom(nomFoun);
         Personnel per=personneldao.findById(1L);
         p.setFournisseur(f);
         p.setPersonnel(per);
           produitdao.create(p);
           this.getTx().commit();
        } catch (DataAccessException ex) {
            Logger.getLogger(IsProduitImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Produit> findAll() {
        try {
            return produitdao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(IsProduitImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
