/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.persistence.EntityTransaction;
import model.Commande;
import model.CommandeDetails;

/**
 *
 * @author yahyaz_rif
 */
public class JPADAOCommandeDetails extends JpaDao<CommandeDetails> implements DAOCommandeDetails {
    
    private static JPADAOCommandeDetails instance;
    
    private JPADAOCommandeDetails() {
        
    }
    
    protected static JPADAOCommandeDetails getInstance() {
        if(instance == null)
            instance = new JPADAOCommandeDetails();
        return instance;
    }

    @Override
    public CommandeDetails find(long id) {
        return em.find(CommandeDetails.class, Integer.valueOf((int) id));
    }

    @Override
    public CommandeDetails find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CommandeDetails> findAll() {
        return em.createNamedQuery("CommandeDetails.findAll").getResultList();
    }

    @Override
    public boolean deleteAll() {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.createNamedQuery("CommandeDetails.deleteAll").executeUpdate();
        et.commit();
        return true;
    }

    @Override
    public List<CommandeDetails> findProduitByCommande(Commande c) {
        return em.createNamedQuery("CommandeDetails.findAllOfCommande").setParameter("commande", c.getId()).getResultList();
    }
    
}
