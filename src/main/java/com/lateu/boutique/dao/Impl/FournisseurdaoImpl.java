/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.dao.Impl;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.lateu.boutique.dao.Fournisseurdao;
import com.lateu.boutique.entities.Fournisseur;


/**
 *
 * @author lateu
 */
public class FournisseurdaoImpl extends GenericDao<Fournisseur, Long> implements Fournisseurdao {

    @Override
    public Fournisseur findbyNom(String nom) throws DataAccessException {
        return  ( Fournisseur) getManager().createNamedQuery("findbyNom")
                .setParameter("nom", nom)
                .getSingleResult();
        }
    
}
