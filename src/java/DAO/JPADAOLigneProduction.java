/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.persistence.EntityTransaction;
import model.LigneProduction;

/**
 *
 * @author yahyaz_rif
 */
public class JPADAOLigneProduction extends JpaDao<LigneProduction> implements DAOLigneProduction {

    private static JPADAOLigneProduction instance;
    
    private JPADAOLigneProduction() {
        
    }

    public static void setInstance(JPADAOLigneProduction instance) {
        JPADAOLigneProduction.instance = instance;
    }
    
    protected static JPADAOLigneProduction getInstance() {
        if(instance == null)
            instance = new JPADAOLigneProduction();
        return instance;
    }
    
    @Override
    public LigneProduction find(long id) {
        return em.find(LigneProduction.class, Integer.valueOf((int) id));
    }

    @Override
    public LigneProduction find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LigneProduction> findAll() {
        return em.createNamedQuery("LigneProduction.findAll").getResultList();
    }

    @Override
    public void deleteAll() {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.createNamedQuery("LigneProduction.deleteAll").executeUpdate();
        et.commit();
    }
    
}
