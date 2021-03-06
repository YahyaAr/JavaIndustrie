/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static java.lang.Math.toIntExact;
import java.util.List;
import javax.persistence.EntityTransaction;
import model.Box;
import model.InstanceBox;
import model.ProduitBaked;

/**
 *
 * @author yahyaz_rif
 */
public class JPADAOInstanceBox extends JpaDao<InstanceBox> implements DAOInstanceBox  {

    
    private static JPADAOInstanceBox instance;
    
    private JPADAOInstanceBox() {
        
    }

    public static void setInstance(JPADAOInstanceBox instance) {
        JPADAOInstanceBox.instance = instance;
    }
    
    protected static JPADAOInstanceBox getInstance() {
        if(instance == null)
            instance = new JPADAOInstanceBox();
        return instance;
    }
    
    
    @Override
    public InstanceBox find(long id) {
        return em.find(InstanceBox.class, Integer.valueOf((int) id));
    }

    @Override
    public InstanceBox find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<InstanceBox> findAll() {
        return em.createNamedQuery("InstanceBox.findAll").getResultList();
    }

    @Override
    public void deleteAll() {
        EntityTransaction et = em.getTransaction();
        et.begin();
         em.createNamedQuery("InstanceBox.deleteAll").executeUpdate();
        et.commit();
    }

    @Override
    public List<InstanceBox> findLesBoxById(Box b) {
        return em.createNamedQuery("InstanceBox.findBoxById").setParameter("id", b.getId()).getResultList();
    }
    
    @Override
    public List<InstanceBox> findBoxByProduitBaked(ProduitBaked b) {
        return em.createNamedQuery("InstanceBox.findBoxByProduitBaked").setParameter("idProduitBaked", b).getResultList();
    }

    @Override
    public List<InstanceBox> findToutesLesBoxAchetees() {
        return em.createNamedQuery("InstanceBox.findAllAchete").getResultList();
    }

    @Override
    public int compteurDeBox(Box b) {
        return  toIntExact((long)em.createNamedQuery("InstanceBox.compteurBox").setParameter("Box", b).getSingleResult());
    }

   
    
}
