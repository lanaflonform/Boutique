/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.entities;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author lateu
 */

public class Vente implements Serializable {

   
    private Long id;

    private Produit produit;

    public Vente() {
    }
    private int quantite;
    private Date dateRecette;

    public Vente(int quantite, Date dateRecette) {

        this.quantite = quantite;
        this.dateRecette = dateRecette;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Date getDateRecette() {
        return dateRecette;
    }

    public void setDateRecette(Date dateRecette) {
        this.dateRecette = dateRecette;
    }

    @Override
    public String toString() {
        return "Vente{" + "id=" + id  + ", quantite=" + quantite + ", dateRecette=" + dateRecette + '}';
    }
    
    
    
}
