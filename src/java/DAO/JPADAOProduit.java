/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.persistence.EntityTransaction;
import model.Produit;

/**
 *
 * @author yahyaz_rif
 */
public class JPADAOProduit extends JpaDao<Produit> implements DAOProduit{

    private static JPADAOProduit instance;
    
    private JPADAOProduit() {
        
    }
    
    protected static JPADAOProduit getInstance() {
        if(instance == null)
            instance = new JPADAOProduit();
        return instance;
    }
    
    @Override
    public Produit find(long id) {
        return em.find(Produit.class, Integer.valueOf((int) id));
    }

    @Override
    public Produit find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produit> findAll() {
        return em.createNamedQuery("Produit.findAll").getResultList();
    }

    @Override
    public boolean deleteAll() {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.createNamedQuery("Produit.deleteAll").executeUpdate();
        et.commit();
        return true;
    }

    @Override
    public Object findByIdString(String id) {
        return em.createNamedQuery("Produit.findById").setParameter("id", id).getResultList().get(0) ;
    }
    
}
