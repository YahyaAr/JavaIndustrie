/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.persistence.EntityTransaction;
import model.Commande;

/**
 *
 * @author yahyaz_rif
 */
public class JPADAOCommande extends JpaDao<Commande> implements DAOCommande {
    
    private static JPADAOCommande instance;
    
    private JPADAOCommande() {
        
    }
    
    protected static JPADAOCommande getInstance() {
        if(instance == null)
            instance = new JPADAOCommande();
        return instance;
    }
    @Override
    public Commande find(long id) {
        return em.find(Commande.class, Integer.valueOf((int) id));
    }

    @Override
    public List<Commande> findAll() {
        return em.createNamedQuery("Commande.findAll").getResultList();
    }
    
    // Supprimer toutes les commandes
    @Override   
    public void deleteAll() {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.createNamedQuery("Commande.deleteAll").executeUpdate();
        et.commit();
    }
    
    // GET des commandes triées par ordre prévu d'envoi
    @Override
    public List<Commande> findAllOrderByDEnvoiPrevue() {
        return em.createNamedQuery("Commande.findAllOrderByDEnvoiPrevue").getResultList();
    }

    @Override
    public Commande find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
