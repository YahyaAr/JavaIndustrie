/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testDAO;
import DAO.*;
import java.util.ArrayList;
import java.util.List;
import model.*;
/**
 *
 * @author yahyaz_rif
 */
public class testDAO {
      
    public static void main(String[] args){
            JPADAOFactory jpaDaoFactory;// = (JPADAOFactory) DAOFactory.getDaoFactory(DAOFactory.PersistType.JPA);
            DAOProduit daoProduit;
            DAOBox daoBox;
            DAOLigneProduction daoLigneProduction;
            DAOCommande daoCommande;
            DAOCommandeDetails daoCommandeDetail;
            DAOInstanceBox daoInstanceBox;

        jpaDaoFactory = (JPADAOFactory) DAOFactory.getDaoFactory(DAOFactory.PersistType.JPA);
        daoProduit = jpaDaoFactory.getProduitDao();
        daoBox = jpaDaoFactory.getBoxDao();
        daoLigneProduction = jpaDaoFactory.getLigneProductionDao();
        daoCommande = jpaDaoFactory.getCommandeDao();
        daoCommandeDetail = jpaDaoFactory.getCommandeDetailDao();
        daoInstanceBox = jpaDaoFactory.getInstanceBoxDao();
        
        
     /*   daoProduit.deleteAll();
        daoBox.deleteAll();
        daoLigneProduction.deleteAll();
        daoCommande.deleteAll();
        daoCommandeDetail.deleteAll();
        daoInstanceBox.deleteAll();*/
//         
//            Produit p = new Produit();
//            p.setId("PROD01");
//            p.setHauteur(2);
//            p.setLongueur(3);
//            p.setNbEmpileMax(2);
//            daoProduit.create(p);
//            
//            Produit p1 = new Produit();
//            p1.setId("PROD02");
//            p1.setHauteur(2);
//            p1.setLongueur(3);
//            p1.setNbEmpileMax(2);
//            daoProduit.create(p1);
//            
//            Produit p2 = new Produit();
//            p2.setId("PROD03");
//            p2.setHauteur(2);
//            p2.setLongueur(3);
//            p2.setNbEmpileMax(2);
//            daoProduit.create(p2);
//            
            //daoProduit.deleteAll();
         
            
//            Commande c = new Commande();
//            c.setId("COM01");
//            daoCommande.create(c);
//            
//            Box b = new Box();
//            b.setId("BOX01");
//            b.setHauteur(23);
//            b.setLongueur(4);
//            b.setPrixBox(34.32);
//            daoBox.create(b);
            
            LigneProduction lp = new LigneProduction();
            lp.setId(1);
            lp.setNbLignes(1);
            daoLigneProduction.create(lp);
            daoLigneProduction.deleteAll();
            
//            CommandeDetails cd = new CommandeDetails();
//            cd.setId(1);
//            cd.setIdCommande(c);
//            cd.setIdProduit(p);
//            cd.setQuantite(5);
//            daoCommandeDetail.create(cd);
//            
//            InstanceBox ib = new InstanceBox();
//            ib.setId(1);
//            ib.setIdBox(b);
//            ib.setIdProduit(p);
//            ib.setLibre(1);
//            daoInstanceBox.create(ib);
            

            
                  
    }
}


