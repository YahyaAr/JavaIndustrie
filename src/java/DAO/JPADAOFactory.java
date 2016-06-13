/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author yahyaz_rif
 */
public class JPADAOFactory extends DAOFactory {
      protected JPADAOFactory(){
        
    }

    @Override
    public DAOCommande getCommandeDao() {
        return JPADAOCommande.getInstance();
    }

    @Override
    public DAOCommandeDetails getCommandeDetailDao() {
        return JPADAOCommandeDetails.getInstance();
    }

    @Override
    public DAOLigneProduction getLigneProductionDao() {
        return JPADAOLigneProduction.getInstance();
    }

    @Override
    public DAOProduit getProduitDao() {
        return JPADAOProduit.getInstance();
    }

    
    @Override
    public DAOBox getBoxDao() {
        return JPADAOBox.getInstance();
    }

    @Override
    public DAOInstanceBox getInstanceBoxDao() {
        return JPADAOInstanceBox.getInstance();
    }

    

  
    
}
