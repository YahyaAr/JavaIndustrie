/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.persistence.EntityTransaction;
import model.Box;

/**
 *
 * @author yahyaz_rif
 */
public class JPADAOBox extends JpaDao<Box> implements DAOBox{
    private static JPADAOBox instance;
    
    private JPADAOBox() {
        
    }
    
    protected static JPADAOBox getInstance() {
        if(instance == null)
            instance = new JPADAOBox();
        return instance;
    }
    @Override
    public Box find(long id) {
        return em.find(Box.class, Integer.valueOf((int) id));
    }

    @Override
    public Box find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Box> findAll() {
        return em.createNamedQuery("BoxType.findAll").getResultList();
    }
    // Supprime tout les type de box
    @Override
    public boolean deleteAll() {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.createNamedQuery("Box.deleteAll").executeUpdate();
        et.commit();
        return true;
    }
    // Retrouve la premiére box avec les dimensions requises
    @Override
    public Box findFirstBylh(int l, int h) {
        return (Box) em.createNamedQuery("Box.findFirstByLH").setParameter("lbox", l).setParameter("hbox", h).getResultList().get(0);
    }
    
}
