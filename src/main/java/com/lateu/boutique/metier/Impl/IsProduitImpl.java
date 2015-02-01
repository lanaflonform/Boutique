/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.metier.Impl;

import com.lateu.boutique.dao.Impl.ProduitdaoImpl;
import com.lateu.boutique.dao.Produitdao;
import com.lateu.boutique.entities.Produit;
import com.lateu.boutique.metier.IsPersonnel;
import com.lateu.boutique.metier.IsProduit;
import java.util.List;

/**
 *
 * @author ing-lateu
 */
public class IsProduitImpl implements IsProduit{
private Produitdao produitdao=new ProduitdaoImpl();

        
        
        
    public List<Produit> findAll() {
   
    return produitdao.findAll();
    }
    
}
