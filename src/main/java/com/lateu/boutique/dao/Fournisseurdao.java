/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.lateu.boutique.entities.Fournisseur;

/**
 *
 * @author lateu
 */
public interface Fournisseurdao extends IDao<Fournisseur, Long> {
    public Fournisseur findbyNom(String nom)throws DataAccessException;
    
}
