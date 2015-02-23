/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.metier;

import com.lateu.boutique.entities.Pannier;
import com.lateu.boutique.entities.Produit;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ing-lateu
 */
public interface IsProduit {

    public List<Produit> findAll();

    public int recetteJourn(Date d);

    public int recettePeriod(Date d, Date d2);

    public void save(Produit p, String nomFoun);

    public Produit findById(Long id);

    public void AjouterAuPannier(Pannier p, String codeProd);

    public void udpdate(Produit p);

    public List<Pannier> findAllPannier();

    public Pannier findPannierByID(Long id);

    public Produit findByCodProd(String s);

    public void udpdatePannier(Pannier pan);

    public void DeletePannier(Long idPannier);
    
    
      public Produit findByPannierID(Long idPannier);
}
