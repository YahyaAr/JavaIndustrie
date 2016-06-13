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
public abstract class DAOFactory {
      public enum PersistType{
        JPA,
        XML,
        JDBC
    };
    
    public static DAOFactory getDaoFactory(PersistType type){
        switch(type){
            case JPA:
                return new JPADAOFactory();
            case XML:
                throw new UnsupportedOperationException("Not implemented yet.");
            case JDBC:
                throw new UnsupportedOperationException("Not implemented yet.");
            default:
                return null;
        }
    }
  
    public abstract DAOCommande getCommandeDao();
    public abstract DAOCommandeDetails getCommandeDetailDao();
    public abstract DAOLigneProduction getLigneProductionDao();
    public abstract DAOProduit getProduitDao();
    public abstract DAOBox getBoxDao();
    public abstract DAOInstanceBox getInstanceBoxDao();
    public abstract DAOProduitBaked getProduitBaked();
    
}
