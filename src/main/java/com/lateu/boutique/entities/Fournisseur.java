/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.entities;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author lateu
 */

public class Fournisseur implements Serializable {

   
    private Long id;
    private String nom;
    private String ville;
    private String contact;

    public Fournisseur() {
        
    }

    public Fournisseur(String nom, String ville, String contact) {
        this.nom = nom;
        this.ville = ville;
        this.contact = contact;
    }
   
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

  
    @Override
    public String toString() {
        return "Fournisseur{" + "id=" + id + ", nom=" + nom + ", ville=" + ville + ", contact=" + contact + '}';
    }

   
   
}
