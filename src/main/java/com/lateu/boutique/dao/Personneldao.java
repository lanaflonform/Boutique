/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.dao;

import com.lateu.boutique.entities.Personnel;
import java.util.List;

/**
 *
 * @author ing-lateu
 */
public interface Personneldao {

    public Personnel Save(Personnel p);

    public Personnel Delete(Long id);

    public String Login(String username, String password);

    public List<Personnel> findAll();

    public Personnel findPersonnelByID(Long id);

    public Personnel TestUsername(String username);

    public Personnel updatePersonnel(Personnel f);
}
