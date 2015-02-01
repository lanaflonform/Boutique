/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.entities;


/**
 *
 * @author lateu
 */

public class UserRole {
    
    
    private Long id;
    private String autorié;
    private Personnel personnel;

  
    public UserRole() {
    }

    public UserRole(String autorié, Personnel personnel) {
        this.autorié = autorié;
        this.personnel = personnel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutorié() {
        return autorié;
    }

    public void setAutorié(String autorié) {
        this.autorié = autorié;
    }
    
    
    
 
    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

  
    
    
}
