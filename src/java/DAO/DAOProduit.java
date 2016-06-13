/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Produit;

/**
 *
 * @author yahyaz_rif
 */
public interface DAOProduit extends DAO<Produit>{
        public Object findByIdString(String id);

}
