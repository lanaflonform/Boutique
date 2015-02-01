/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.metier;

import com.lateu.boutique.entities.Fournisseur;
import java.util.List;

/**
 *
 * @author ing-lateu
 */
public interface IsFournisseur {

    List<Fournisseur> findAll();

    Fournisseur savefoun(Fournisseur j);

    Fournisseur findById(Long j);

    Fournisseur update(Fournisseur f);
}
