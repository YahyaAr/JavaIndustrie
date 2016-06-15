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
    
    private final JPADAOFactory jpaDaoFactory;
    private final DAOCommande daoCommande;
    private final DAOLigneProduction daoLigneProduction;
    private final DAOProduit daoProduit;
    private final DAOProduitBaked daoProduitBaked;
    private final DAOCommandeDetails daoCommandeDetails;
    private final DAOBox daoBox;
    private final DAOInstanceBox daoInstanceBox;
    private Integer filTempsActuelProd, dateEnvoiBoxPleine;
    
    public Solution1() {
        jpaDaoFactory = (JPADAOFactory) DAOFactory.getDaoFactory(DAOFactory.PersistType.JPA);
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
    
}
