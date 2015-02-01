/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.dao;

import com.lateu.boutique.entities.Produit;
import java.util.List;

/**
 *
 * @author ing-lateu
 */
public interface Produitdao {
    List<Produit> findAll();
}
