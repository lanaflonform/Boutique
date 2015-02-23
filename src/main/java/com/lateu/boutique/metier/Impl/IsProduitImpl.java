/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.metier.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.lateu.boutique.DB.GConfig;
import com.lateu.boutique.dao.Fournisseurdao;
import com.lateu.boutique.dao.Impl.FournisseurdaoImpl;
import com.lateu.boutique.dao.Impl.PannierdaoImpl;
import com.lateu.boutique.dao.Impl.PersonneldaoImpl;
import com.lateu.boutique.dao.Impl.ProduitdaoImpl;
import com.lateu.boutique.dao.Impl.VentedaoImpl;
import com.lateu.boutique.dao.Pannierdao;
import com.lateu.boutique.dao.Personneldao;
import com.lateu.boutique.dao.Produitdao;
import com.lateu.boutique.dao.Ventedao;
import com.lateu.boutique.entities.Fournisseur;
import com.lateu.boutique.entities.Pannier;
import com.lateu.boutique.entities.Personnel;
import com.lateu.boutique.entities.Produit;
import com.lateu.boutique.entities.Vente;
import com.lateu.boutique.metier.IsProduit;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ing-lateu
 */
public class IsProduitImpl extends GConfig implements IsProduit {

    private Produitdao produitdao = new ProduitdaoImpl();
    private Fournisseurdao fournisseurdao = new FournisseurdaoImpl();
    private Personneldao personneldao = new PersonneldaoImpl();
    private Ventedao ventedao = new VentedaoImpl();
    private Pannierdao pannierdao = new PannierdaoImpl();

    public IsProduitImpl() throws DataAccessException {
        this.getTx().begin();
        ((GenericDao) produitdao).setManager(getEm());
        ((GenericDao) fournisseurdao).setManager(getEm());
        ((GenericDao) personneldao).setManager(getEm());
        ((GenericDao) ventedao).setManager(getEm());
        ((GenericDao) pannierdao).setManager(getEm());
    }

    public void save(Produit p, String nomFoun) {
        try {
            Fournisseur f = fournisseurdao.findbyNom(nomFoun);
            Personnel per = personneldao.findById(1L);
            p.setFournisseur(f);
            p.setPersonnel(per);
            produitdao.create(p);
            this.getTx().commit();
        } catch (DataAccessException ex) {
            Logger.getLogger(IsProduitImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Produit> findAll() {
        try {
            return produitdao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(IsProduitImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int recetteJourn(Date d) {
        try {
            int reccete = 0;
            List<Vente> liste = ventedao.findrecetteJournaliere(d);
            for (Vente vente : liste) {
                reccete += vente.getQuantite() * vente.getProduit().getPU();

            }

            return reccete;
        } catch (DataAccessException ex) {
            Logger.getLogger(IsProduitImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int recettePeriod(Date d, Date d2) {
        try {
            int reccete = 0;
            List<Vente> liste = ventedao.findrecettePeriodique(d, d2);
            for (Vente vente : liste) {
                reccete += vente.getQuantite() * vente.getProduit().getPU();

            }

            return reccete;
        } catch (DataAccessException ex) {
            Logger.getLogger(IsProduitImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public Produit findById(Long id) {
        try {
            return produitdao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(IsProduitImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void udpdate(Produit p) {
        try {
            Produit p1 = produitdao.findById(p.getId());
            p.setPersonnel(p1.getPersonnel());
            p.setFournisseur(p1.getFournisseur());
            p.setType(p1.getType());
            produitdao.update(p);
            this.getTx().commit();
        } catch (DataAccessException ex) {
            Logger.getLogger(IsProduitImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Pannier> findAllPannier() {
        try {
            return pannierdao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(IsProduitImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void AjouterAuPannier(Pannier p, String codeP) {
        try {
            Produit pr = produitdao.findbyCode(codeP);
            p.setDesignation(pr.getDesignation());
            p.setPU(pr.getPU());
            p.setPT(pr.getPU() * p.getQuantite());
            p.setProduit(pr);
            pannierdao.create(p);
            this.getTx().commit();
        } catch (DataAccessException ex) {
            Logger.getLogger(IsProduitImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Pannier findPannierByID(Long id) {
        try {
            return pannierdao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(IsProduitImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Produit findByCodProd(String s) {
        try {
            return produitdao.findbyCode(s);
        } catch (DataAccessException ex) {
            return null;
            //   Logger.getLogger(IsProduitImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void udpdatePannier(Pannier pan) {
        try {
            System.out.println("---------je met a jour à jour le pannier---------");
            Produit prod=produitdao.findbyPannierId(pan.getId());
            pan.setPU(prod.getPU());
            pan.setPT(prod.getPU()*pan.getQuantite());
            pan.setProduit(prod);
            pan.setDesignation(prod.getDesignation());
            pannierdao.update(pan);
            this.getTx().commit();
        } catch (DataAccessException ex) {
            Logger.getLogger(IsProduitImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DeletePannier(Long idPannier) {
        try {
            Pannier p = pannierdao.findById(idPannier);
            pannierdao.delete(p);
            this.getTx().commit();
        } catch (DataAccessException ex) {
            Logger.getLogger(IsProduitImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Produit findByPannierID(Long idPannier) {
        try {
            return produitdao.findbyPannierId(idPannier);
        } catch (DataAccessException ex) {
            Logger.getLogger(IsProduitImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
