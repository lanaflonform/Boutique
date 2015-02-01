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

public class Personnel implements Serializable {

   
    private Long id;
  
    private String nom;
    private String prenom;
   
    private Date dateNais;
    private String contact; 
    private String username;
    private String password;
    private int etatCompte;

    public Personnel() {
    }

    public Personnel(String nom, String prenom, Date dateNais, String contact, String username, String password, int etatCompte) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNais = dateNais;
        this.contact = contact;
        this.username = username;
        this.password = password;
        this.etatCompte = etatCompte;
    }

   

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEtatCompte() {
        return etatCompte;
    }

    public void setEtatCompte(int etatCompte) {
        this.etatCompte = etatCompte;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNais() {
        return dateNais;
    }

    public void setDateNais(Date dateNais) {
        this.dateNais = dateNais;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Personnel{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNais=" + dateNais + ", contact=" + contact + ", username=" + username + ", password=" + password + ", etatCompte=" + etatCompte + '}';
    }
    
    
}
