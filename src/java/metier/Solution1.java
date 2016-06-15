/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import DAO.*;
import java.util.List;
import model.Box;
import model.Commande;
import model.CommandeDetails;
import model.InstanceBox;
import model.LigneProduction;
import model.Produit;
import model.ProduitBaked;

/**
 *
 * @author achrafdahmani
 */
public class Solution1 {
    
    private JPADAOFactory jpaDaoFactory;
    private DAOCommande daoCommande;
    private DAOLigneProduction daoLigneProduction;
    private DAOProduit daoProduit;
    private DAOProduitBaked daoProduitBaked;
    private DAOCommandeDetails daoCommandeDetails;
    private DAOBox daoBox;
    private DAOInstanceBox daoInstanceBox;
    private Integer filTempsActuelProd, dateEnvoiBoxPleine;
    
    public Solution1() {
        
        jpaDaoFactory = (JPADAOFactory) DAOFactory.getDaoFactory(DAOFactory.PersistType.JPA);
        
        jpaDaoFactory.resetToNull();

                
        daoCommande = jpaDaoFactory.getCommandeDao();
        daoCommandeDetails = jpaDaoFactory.getCommandeDetailDao();
        daoLigneProduction = jpaDaoFactory.getLigneProductionDao();
        daoProduitBaked = jpaDaoFactory.getProduitBaked();
        daoProduit = jpaDaoFactory.getProduitDao();
        daoBox = jpaDaoFactory.getBoxDao();
        daoInstanceBox = jpaDaoFactory.getInstanceBoxDao();

        filTempsActuelProd = 0;
        dateEnvoiBoxPleine = 0;
    }
    
//  
//    public void solve() {
//        List<Commande> LesCommandes = daoCommande.findAllOrderByDEnvoiPrevue();
//        for (int i = 0; i < LesCommandes.size(); i++) {
//            Commande commande = LesCommandes.get(i);
//            List<CommandeDetails> commandeDetails = commande.getCommandeDetailsList();
//            for (int j = 0; j < commandeDetails.size(); j++) {
//                CommandeDetails commandeDetail = commandeDetails.get(j);
//                
//                LigneProduction ligneProd = daoLigneProduction.findAll().get(0);
//                Produit produit = commandeDetail.getIdProduit();
//                if(produit != null) {
//                    filTempsActuelProd += produit.getTSetup();
//                    for (int k = 0; k < commandeDetail.getQuantite(); k++) {
//                        System.out.println("QUANTITEEEEE :"+commandeDetail.getQuantite());
//                        ProduitBaked produitBaked = new ProduitBaked();
//                        produitBaked.setIdCommandeDetails(commandeDetail);
//                        produitBaked.setDateDebutProd(filTempsActuelProd);
//                        produitBaked.setNbLigne(ligneProd);
//                        daoProduitBaked.create(produitBaked);
//                        
//                        ligneProd.getProduitBakedList().add(produitBaked);
//                        daoLigneProduction.update(ligneProd);
//                        commandeDetail.getProduitBakedList().add(produitBaked);
//                        filTempsActuelProd += produit.getTProduction();
//                        dateEnvoiBoxPleine = filTempsActuelProd;
//                        // début process box
//
//                            // on trouve le type de box approprié
//                        int L = produitBaked.getIdCommandeDetails().getIdProduit().getLongueur();
//                        int H = produitBaked.getIdCommandeDetails().getIdProduit().getHauteur();
//                        Box box = daoBox.findFirstBylh(L, H);
//                        System.out.println(box);
//                            //on achete ce box
//                        InstanceBox instanceBox = new InstanceBox();
//
//                        instanceBox.setIdProduit(produitBaked.getIdCommandeDetails().getIdProduit());
//                        instanceBox.setIdBox(box);
//                        instanceBox.setLibre(0);
//                        instanceBox.setIdProduitBaked(produitBaked);
//                        instanceBox.setIdCommandeDetails(produitBaked.getIdCommandeDetails());
//                            // on incremente l'id de box du meme type
//                        instanceBox.setNumBox(daoInstanceBox.compteurDeBox(box) + 1);
//                        commandeDetail.getInstanceBoxList().add(instanceBox);
//                        daoInstanceBox.create(instanceBox);
//                        daoCommandeDetails.update(commandeDetail);
//                        System.out.println(instanceBox);
//                        box.getInstanceBoxList().add(instanceBox);
//                        daoBox.update(box);
//                        
//
//                    }
//                }
//            }
//        dateEnvoiBoxPleine += commande.getStockMin();
//        dateEnvoiBoxPleine = (dateEnvoiBoxPleine < commande.getDEnvoiPrevue()) ?
//                commande.getDEnvoiPrevue() : dateEnvoiBoxPleine;
//        commande.setDEnvoi(dateEnvoiBoxPleine);
//        daoCommande.update(commande);
//        }
//        
//    }
       public void solve() {
        List<Commande> LesCommandes = daoCommande.findAllOrderByDEnvoiPrevue();
        for (int i = 0; i < LesCommandes.size(); i++) {
            Commande commande = LesCommandes.get(i);
            List<CommandeDetails> commandeDetails = commande.getCommandeDetailsList();
            for (int j = 0; j < commandeDetails.size(); j++) {
                CommandeDetails commandeDetail = commandeDetails.get(j);
                
                LigneProduction ligneProd = daoLigneProduction.findAll().get(0);
                Produit produit = commandeDetail.getIdProduit();
                if(produit != null) {
                    filTempsActuelProd += produit.getTSetup();
                    for (int k = 0; k < commandeDetail.getQuantite(); k++) {
                        ProduitBaked produitBaked = new ProduitBaked();
                        produitBaked.setIdCommandeDetails(commandeDetail);
                        produitBaked.setDateDebutProd(filTempsActuelProd);
                        produitBaked.setNbLigne(ligneProd);
                        daoProduitBaked.create(produitBaked);
                        ligneProd.getProduitBakedList().add(produitBaked);
                        daoLigneProduction.update(ligneProd);
                        commandeDetail.getProduitBakedList().add(produitBaked);
                        filTempsActuelProd += produit.getTProduction();
                        dateEnvoiBoxPleine = filTempsActuelProd;
                        // début process box

                            // on trouve le type de box approprié
                        int L = produitBaked.getIdCommandeDetails().getIdProduit().getLongueur();
                        int H = produitBaked.getIdCommandeDetails().getIdProduit().getHauteur();
                        Box box = daoBox.findFirstBylh(L, H);
                        System.out.println(box);
                            //on achete ce box
                        InstanceBox instanceBox = new InstanceBox();

                        instanceBox.setIdProduit(produitBaked.getIdCommandeDetails().getIdProduit());
                        instanceBox.setIdBox(box);
                        instanceBox.setLibre(0);
                        instanceBox.setIdProduitBaked(produitBaked);
                        instanceBox.setIdCommandeDetails(produitBaked.getIdCommandeDetails());
                            // on incremente l'id de box du meme type
                        instanceBox.setNumBox(daoInstanceBox.compteurDeBox(box) + 1);
                        commandeDetail.getInstanceBoxList().add(instanceBox);
                        daoCommandeDetails.update(commandeDetail);
                        System.out.println(instanceBox);
                        box.getInstanceBoxList().add(instanceBox);
                        daoBox.update(box);
                        daoInstanceBox.create(instanceBox);
                        
                    }
                }
            }
        dateEnvoiBoxPleine += commande.getStockMin();
        dateEnvoiBoxPleine = (dateEnvoiBoxPleine < commande.getDEnvoiPrevue()) ?
                commande.getDEnvoiPrevue() : dateEnvoiBoxPleine;
        commande.setDEnvoi(dateEnvoiBoxPleine);
        daoCommande.update(commande);
        }
        
    }

    
    public void viderTout(){
        
       /* daoInstanceBox.deleteAll();
        daoProduitBaked.deleteAll();
        daoCommandeDetails.deleteAll();
        daoBox.deleteAll();
        daoCommande.deleteAll();
        daoLigneProduction.deleteAll();
        daoProduit.deleteAll();*/

        
        daoProduitBaked.close();
        daoInstanceBox.close();
        daoCommandeDetails.close();
        daoCommande.close();
        daoProduit.close();
        daoBox.close();
        daoLigneProduction.close();
        
        jpaDaoFactory.resetToNull();
        
        jpaDaoFactory = null;
        daoProduitBaked = null;
        daoInstanceBox = null;
        daoCommandeDetails = null;
        daoCommande = null;
        daoProduit = null;
        daoBox = null;
        daoLigneProduction = null;
        
        
        jpaDaoFactory = (JPADAOFactory) DAOFactory.getDaoFactory(DAOFactory.PersistType.JPA);
        daoProduit = jpaDaoFactory.getProduitDao();
        daoBox = jpaDaoFactory.getBoxDao();
        daoLigneProduction = jpaDaoFactory.getLigneProductionDao();
        daoCommande = jpaDaoFactory.getCommandeDao();
        daoCommandeDetails = jpaDaoFactory.getCommandeDetailDao();
        daoInstanceBox = jpaDaoFactory.getInstanceBoxDao();
        daoProduitBaked = jpaDaoFactory.getProduitBaked();
       
        
    }
    
    
}
