/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.boutique.dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.lateu.boutique.entities.Stock;


/**
 *
 * @author lateu
 */
public interface Stockdao extends IDao<Stock, Long>{
    
    public Stock findbyCodeStock(String c)throws DataAccessException;
    public Stock findMonStock(Long idProd)throws DataAccessException;
    
}
