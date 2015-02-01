/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.metier;

import com.lateu.boutique.entities.Personnel;
import com.lateu.boutique.entities.UserRole;
import java.util.List;

/**
 *
 * @author ing-lateu
 */
public interface IsPersonnel {

    public String Login(String login, String password);

    public Personnel Save(Personnel p, UserRole role);

    public List<Personnel> findAll();

    public Personnel findPersonnelByID(Long id);

    public Personnel updatePersonnel(Personnel f);
    public Personnel TestUsername(String username);
}
