/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.dao.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.lateu.boutique.dao.Ventedao;
import com.lateu.boutique.entities.Vente;

import java.util.Date;
import java.util.List;

/**
 *
 * @author lateu
 */
public class VentedaoImpl extends GenericDao<Vente, Long> implements Ventedao {

    @Override
    public List<Vente> findByType(String type) throws DataAccessException {
        return getManager().createNamedQuery("findByType")
                .setParameter("type", type)
                .getResultList();
    }

    @Override
    public List<Vente> findrecetteJournaliere(Date d) throws DataAccessException {
        return getManager().createNamedQuery("findrecetteJournaliere")
                .setParameter("date", d)
                .getResultList();
    }

    @Override
    public List<Vente> findrecettePeriodique(Date d1, Date d2) throws DataAccessException {
        return getManager().createNamedQuery("findrecettePeriodique")
                .setParameter("d1", d1)
                .setParameter("d2", d2)
                .getResultList();
    }
    
    @Override
     public List<Vente> venteProduit(String type) throws DataAccessException {
        return getManager().createNamedQuery("venteProduit")
                .setParameter("type", type)
                .getResultList();
    }
}
