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

public class Approvision implements Serializable {
   
    private Long id;
    private String codeApprovision;   
    private Date dateFabrication; 
    private Date datePeremption; 
    private Date dateJour;
    private int quantite;
    private Produit produit;

    public Approvision() {
    }

    public Approvision(String codeApprovision, Date dateFabrication, Date datePeremption, Date dateJour, int quantite) {
        this.codeApprovision = codeApprovision;
        this.dateFabrication = dateFabrication;
        this.datePeremption = datePeremption;
        this.dateJour = dateJour;
        this.quantite = quantite;
    }

    public Date getDateFabrication() {
        return dateFabrication;
    }

    public void setDateFabrication(Date dateFabrication) {
        this.dateFabrication = dateFabrication;
    }

    public Date getDatePeremption() {
        return datePeremption;
    }

    public void setDatePeremption(Date datePeremption) {
        this.datePeremption = datePeremption;
    }

   
    public String getCodeApprovision() {
        return codeApprovision;
    }

    public void setCodeApprovision(String codeApprovision) {
        this.codeApprovision = codeApprovision;
    }

    public Date getDateJour() {
        return dateJour;
    }

    public void setDateJour(Date dateJour) {
        this.dateJour = dateJour;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Approvision)) {
            return false;
        }
        Approvision other = (Approvision) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Approvision{" + "id=" + id + ", codeApprovision=" + codeApprovision + ", dateJour=" + dateJour + ", quantite=" + quantite + '}';
    }

   
}
