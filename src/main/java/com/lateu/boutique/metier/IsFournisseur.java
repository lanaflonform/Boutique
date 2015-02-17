/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.metier;

import com.douwe.generic.dao.DataAccessException;
import com.lateu.boutique.entities.Fournisseur;
import java.util.List;

/**
 *
 * @author ing-lateu
 */
public interface IsFournisseur {

    List<Fournisseur> findAll();

    Fournisseur Ajouter(Fournisseur j)throws DataAccessException;

    Fournisseur findById(Long j);

    Fournisseur update(Fournisseur f);
}
