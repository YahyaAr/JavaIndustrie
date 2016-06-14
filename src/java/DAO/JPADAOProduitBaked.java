/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.persistence.EntityTransaction;
import model.Box;
import model.ProduitBaked;

/**
 *
 * @author yahyaz_rif
 */
public class JPADAOProduitBaked extends JpaDao<ProduitBaked> implements DAOProduitBaked {

    private static JPADAOProduitBaked instance;
    
    private JPADAOProduitBaked() {
        
    }
    
    protected static JPADAOProduitBaked getInstance() {
        if(instance == null)
            instance = new JPADAOProduitBaked();
        return instance;
    }
    
    @Override
    public ProduitBaked find(long id) {
        return em.find(ProduitBaked.class, Integer.valueOf((int) id));
    }
    
    @Override
    public List<ProduitBaked> findAll() {
        return em.createNamedQuery("ProduitBaked.findAll").getResultList();
    }

    @Override
    public void deleteAll() {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.createNamedQuery("ProduitBaked.deleteAll").executeUpdate();
        et.commit();
    }

    @Override
    public ProduitBaked find(Integer id) {
        return em.find(ProduitBaked.class, id);
    }
   
}
