/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.dao.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.lateu.boutique.dao.Produitdao;
import com.lateu.boutique.entities.Produit;
import java.util.List;

/**
 *
 * @author lateu
 */
public class ProduitdaoImpl extends GenericDao<Produit, Long> implements Produitdao {

    @Override
    public Produit findbyName(String n) throws DataAccessException {
        return (Produit) getManager().createNamedQuery("findbyName")
                .setParameter("nom", n)
                .getSingleResult();
    }

    @Override
    public List<Produit> findbyType(String t) throws DataAccessException {
        return getManager().createNamedQuery("findbyType")
                .setParameter("type", t)
                .getResultList();
    }

    @Override
    public Produit findbyCode(String code) {
        try {
            return (Produit) getManager().createNamedQuery("findbyCode")
                    .setParameter("code", code)
                    .getSingleResult();
        } catch (DataAccessException ex) {
            return null;
            //  Logger.getLogger(ProduitdaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Produit findbyPannierId(Long id) throws DataAccessException {
        return (Produit) getManager().createNamedQuery("Produit.findByPannierId")
                .setParameter("id", id)
                .getSingleResult();

    }
}
