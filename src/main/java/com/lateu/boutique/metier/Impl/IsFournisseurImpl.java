/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.metier.Impl;

import com.lateu.boutique.dao.Fournisseurdao;
import com.lateu.boutique.dao.Impl.FournisseurdaoImpl;
import com.lateu.boutique.entities.Fournisseur;
import com.lateu.boutique.metier.IsFournisseur;
import java.util.List;

/**
 *
 * @author ing-lateu
 */
public class IsFournisseurImpl implements IsFournisseur {

    private Fournisseurdao fournisseurdao = new FournisseurdaoImpl();

    public List<Fournisseur> findAll() {
        return fournisseurdao.findAll();
    }

    public Fournisseur savefoun(Fournisseur j) {
        return fournisseurdao.SaveFourn(j);
    }

    public Fournisseur findById(Long j) {

        return fournisseurdao.findByID(j);
    }

    public Fournisseur update(Fournisseur f) {
        return fournisseurdao.update(f);
    }
}
