/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 *
 * @author lateu
 */

public class Produit implements Serializable {

 
    private Long id;
  
   
    private String code;
    private String designation;
    private String type;
    //private String nomFournisseur;
    private int PU;
    private int seuil;
    private Fournisseur fournisseur;
  
    private Personnel personnel;
    public Produit() {
    }

    public Produit(String code, String designation, String type, int PU, int seuil, Fournisseur fournisseur, Personnel personnel) {
        this.code = code;
        this.designation = designation;
        this.type = type;
        this.PU = PU;
        this.seuil = seuil;
        this.fournisseur = fournisseur;
        this.personnel = personnel;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public int getSeuil() {
        return seuil;
    }

    public void setSeuil(int seuil) {
        this.seuil = seuil;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", code=" + code + ", designation=" + designation + ", type=" + type + ", PU=" + PU + ", seuil=" + seuil + '}';
    }
}
