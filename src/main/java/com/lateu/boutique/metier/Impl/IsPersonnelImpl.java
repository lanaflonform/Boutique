/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.metier.Impl;

import com.lateu.boutique.dao.Impl.PersonneldaoImpl;
import com.lateu.boutique.dao.Impl.UserdaoImpl;
import com.lateu.boutique.dao.Personneldao;
import com.lateu.boutique.dao.Userdao;
import com.lateu.boutique.entities.Personnel;
import com.lateu.boutique.entities.UserRole;
import com.lateu.boutique.metier.IsPersonnel;
import java.util.List;

/**
 *
 * @author ing-lateu
 */
public class IsPersonnelImpl implements IsPersonnel {

    private Personneldao personneldao = new PersonneldaoImpl();
    private Userdao uSerdao = new UserdaoImpl();

    public String Login(String login, String password) {
        return personneldao.Login(login, password);
    }

    public Personnel Save(Personnel p, UserRole role) {

        Personnel tmp = new Personnel();
        tmp = personneldao.Save(p);
        if (tmp != null) {
            Long id = personneldao.TestUsername(tmp.getUsername()).getId();
            p.setId(id);
            role.setPersonnel(p);
            System.out.println("=---------" + id);
            uSerdao.Save(role);
        }
        return tmp;

    }

    public List<Personnel> findAll() {

        return personneldao.findAll();
    }

    public Personnel findPersonnelByID(Long id) {

        return personneldao.findPersonnelByID(id);
    }

    public Personnel updatePersonnel(Personnel f) {
        return personneldao.updatePersonnel(f);

    }

    public Personnel TestUsername(String username) {
        return personneldao.TestUsername(username);
    }
}
