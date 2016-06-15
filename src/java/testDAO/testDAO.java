/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testDAO;
import DAO.DAOCommande;
import DAO.DAOFactory;
import DAO.JPADAOFactory;
import controller.DBManager;

/**
 *
 * @author yahyaz_rif
 */
public class testDAO {
      
    public static void main(String[] args){
        
           System.out.println("PPPP");
          // DBManager dM = new DBManager();
           //dM.boxAchetesList();
           //System.out.println("ffff "+dM.commandesList());
          // System.out.println(dM.commandesTable());
       JPADAOFactory jpaDaoFactory = (JPADAOFactory) DAOFactory.getDaoFactory(DAOFactory.PersistType.JPA);
                   DAOCommande daoCommande = jpaDaoFactory.getCommandeDao();

                  
    }
}


