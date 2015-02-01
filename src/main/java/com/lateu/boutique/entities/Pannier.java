/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.entities;

import java.io.Serializable;
;

/**
 *
 * @author lateu
 */

public class Pannier implements Serializable {
    private Produit produit;
    private String designation;
    private int PU;
    private int quantite;
    private int PT;
    private int veroux;

    public Pannier(Produit produit, String designation, int PU, int quantite, int PT, int veroux) {
        this.produit = produit;
        this.designation = designation;
        this.PU = PU;
        this.quantite = quantite;
        this.PT = PT;
        this.veroux = veroux;
    }

    public Produit getProduit() {
        return produit;
    }

    public int getVeroux() {
        return veroux;
    }

    public void setVeroux(int veroux) {
        this.veroux = veroux;
    }

   
    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getPU() {
        return PU;
    }

    public void setPU(int PU) {
        this.PU = PU;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getPT() {
        return PT;
    }

    public void setPT(int PT) {
        this.PT = PT;
    }

    public Pannier() {
    }

   
    
    
}
