/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.dao;

import com.lateu.boutique.entities.Fournisseur;
import java.util.List;

/**
 *
 * @author ing-lateu
 */
public interface Fournisseurdao {
    public List<Fournisseur> findAll();
     public Fournisseur SaveFourn(Fournisseur f);
     public void DeleteFourn(Long id);
       public Fournisseur findByID(Long id);
       public Fournisseur update(Fournisseur f);
}
