/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.metier;

import com.lateu.boutique.entities.Personnel;
import com.lateu.boutique.entities.Produit;
import java.util.List;

/**
 *
 * @author ing-lateu
 */
public interface IsProduit {
     public List<Produit> findAll();

      public void save(Produit p, String nomFoun);
    
}
