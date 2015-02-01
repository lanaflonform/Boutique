/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.dao;

import com.lateu.boutique.entities.Personnel;
import com.lateu.boutique.entities.UserRole;
import java.util.List;

/**
 *
 * @author ing-lateu
 */
public interface Userdao {

    public UserRole Save(UserRole p);

    public UserRole Delete(Long id);

    public List<UserRole> findAll();

    public UserRole findUserRoleByID(Long id);

    public int TestUsername(String username);

    public UserRole updatePersonnel(UserRole f);
}
