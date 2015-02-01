/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.entities;

import java.io.Serializable;


/**
 *
 * @author lateu
 */

public class Stock implements Serializable {
    private Long id;
    private Produit produit;
    
    private int quantiteEnStock;
    private String codeProduit;

    public Stock() {
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantiteEnStock() {
        return quantiteEnStock;
    }

    public void setQuantiteEnStock(int quantiteEnStock) {
        this.quantiteEnStock = quantiteEnStock;
    }

    public String getCodeProduit() {
        return codeProduit;
    }

    public void setCodeProduit(String codeProduit) {
        this.codeProduit = codeProduit;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Stock{" + "id=" + id + ", produit=" + produit.getId() + ", quantiteEnStock=" + quantiteEnStock + ", codeProduit=" + codeProduit + '}';
    }

   
    
}
