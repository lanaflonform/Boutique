/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.lateu.boutique.entities.Pannier;

import java.util.List;

/**
 *
 * @author lateu
 */
public interface Pannierdao  extends IDao<Pannier, Long> {

    /**
     * donnée disponibles pour le facturier
     * @return liste des paniier
     */
    List <Pannier> findFacture();
    
    /**
     * pannier non encore sauvegardé
     * @return 
     */
     List <Pannier> NoneSave();
}
