/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.*;
import model.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.Part;
import metier.Solution1;


/**
 *
 * @author aDahmani
 */
@Named(value = "traitementInstance")
@SessionScoped
public class TraitementInstance implements Serializable {

    private Part fichier;
    private List<String> typesProduitValues;
    private int nbLignesProd;
    private String fileName,nom;

    private JPADAOFactory jpaDaoFactory;// = (JPADAOFactory) DAOFactory.getDaoFactory(DAOFactory.PersistType.JPA);
    private DAOProduit daoProduit;
    private DAOBox daoBox;
    private DAOLigneProduction daoLigneProduction;
    private DAOCommande daoCommande;
    private DAOCommandeDetails daoCommandeDetail;
    private DAOInstanceBox daoInstanceBox;
    private DAOProduitBaked daoProduitBaked;


    public TraitementInstance() {
        jpaDaoFactory = (JPADAOFactory) DAOFactory.getDaoFactory(DAOFactory.PersistType.JPA);
        daoProduit = jpaDaoFactory.getProduitDao();
        daoBox = jpaDaoFactory.getBoxDao();
        daoLigneProduction = jpaDaoFactory.getLigneProductionDao();
        daoCommande = jpaDaoFactory.getCommandeDao();
        daoCommandeDetail = jpaDaoFactory.getCommandeDetailDao();
        daoInstanceBox = jpaDaoFactory.getInstanceBoxDao();
        typesProduitValues = new ArrayList();
        daoProduitBaked = jpaDaoFactory.getProduitBaked();
        
        // initialisation de la BDD ( suppression des anciennes données ) /////////
        
        
    }

     public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getNom() {
        return "Yahya";
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Part getFichier() {
        return fichier;
    }

    public void setFichier(Part fichier) {
        this.fichier = fichier;
    }
 
    public void uploadFichier() {
       viderTout();
            try {
            BufferedReader in = new BufferedReader(new InputStreamReader(fichier.getInputStream()));
            String line;
            while((line = in.readLine()) != null) {
                line = line.replaceAll("\\s+", " ");
                String [] lineTab = line.split(" ");
                String firstWord = lineTab[0];
                if (isNumber(firstWord)) {
                    nbLignesProd = Integer.valueOf(line.split(" ")[3]);
                    for(int i = 1 ; i <= nbLignesProd ; i++) {
                        LigneProduction ligneProduction = new LigneProduction();
                        ligneProduction.setId(i);
                        ligneProduction.setNbLignes(i);
                        daoLigneProduction.create(ligneProduction);

                    }
                }
                if(firstWord.length() >= 1) {
                   switch (firstWord.substring(0, 1)) {
                        case "P" : ///// Ligne commençant par P //////
                           String [] typeProduitTab = line.split(" ");
                           Produit produit = new Produit();
                           System.out.println(typeProduitTab[0]);
                           produit.setId(typeProduitTab[0]);
                           produit.setTSetup(Integer.valueOf(typeProduitTab[1]));
                           produit.setTProduction(Integer.valueOf(typeProduitTab[2]));
                           produit.setHauteur(Integer.valueOf(typeProduitTab[3]));
                           produit.setLongueur(Integer.valueOf(typeProduitTab[4]));
                           produit.setNbEmpileMax(Integer.valueOf(typeProduitTab[5]));
                           typesProduitValues.add(typeProduitTab[0]);
                           daoProduit.create(produit);
                           break;
                       case "C": ///// Ligne commençant par C //////
                           String [] commandeTab = line.split(" ");
                           Commande commande = new Commande();
                           commande.setId(commandeTab[0]);
                           commande.setStockMin(Integer.valueOf(commandeTab[1]));
                           commande.setDEnvoiPrevue(Integer.valueOf(commandeTab[2]));
                           commande.setPenalite(Double.valueOf(commandeTab[3]));
                           daoCommande.create(commande);

                           for(int i = 4 ; i < commandeTab.length; i++) {
                               if(Integer.valueOf(commandeTab[i]) != 0){
                                   CommandeDetails produitdeCommande = new CommandeDetails();
                                   produitdeCommande.setIdCommande(commande);
                                   Produit p = (Produit) daoProduit.findByIdString(typesProduitValues.get(i - 4));
                                   produitdeCommande.setIdProduit(p);
                                   produitdeCommande.setQuantite(Integer.valueOf(commandeTab[i]));
                                   daoCommandeDetail.create(produitdeCommande);

                                   commande.getCommandeDetailsList().add(produitdeCommande);
                                   daoCommande.update(commande);

                                   p.getCommandeDetailsList().add(produitdeCommande);
                                   daoProduit.update(p);
                               }
                           }
                           break;
                       case "B": ////// ligne commençant par B
                           String [] typeBoxTab = line.split(" ");
                           Box box = new Box();
                           box.setId(typeBoxTab[0]);
                           box.setHauteur(Integer.valueOf(typeBoxTab[1]));
                           box.setLongueur(Integer.valueOf(typeBoxTab[2]));
                           box.setPrixBox(Double.valueOf(typeBoxTab[3]));
                           daoBox.create(box);
                           break;
                   }
                }
            }
        } catch (IOException e) {
            System.out.println("excp: "+e);
        }
//Add Comment Col
       
    }

    public void viderTout(){
        
        daoInstanceBox.deleteAll();
        daoProduitBaked.deleteAll();
        daoCommandeDetail.deleteAll();
        daoBox.deleteAll();
        daoCommande.deleteAll();
        daoLigneProduction.deleteAll();
        daoProduit.deleteAll();

        
        daoProduitBaked.close();
        daoInstanceBox.close();
        daoCommandeDetail.close();
        daoCommande.close();
        daoProduit.close();
        daoBox.close();
        daoLigneProduction.close();
        
        jpaDaoFactory.resetToNull();
        
        jpaDaoFactory = null;
        daoProduitBaked = null;
        daoInstanceBox = null;
        daoCommandeDetail = null;
        daoCommande = null;
        daoProduit = null;
        daoBox = null;
        daoLigneProduction = null;
        
        
        jpaDaoFactory = (JPADAOFactory) DAOFactory.getDaoFactory(DAOFactory.PersistType.JPA);
        daoProduit = jpaDaoFactory.getProduitDao();
        daoBox = jpaDaoFactory.getBoxDao();
        daoLigneProduction = jpaDaoFactory.getLigneProductionDao();
        daoCommande = jpaDaoFactory.getCommandeDao();
        daoCommandeDetail = jpaDaoFactory.getCommandeDetailDao();
        daoInstanceBox = jpaDaoFactory.getInstanceBoxDao();
        daoProduitBaked = jpaDaoFactory.getProduitBaked();
       
        
    }
    public Boolean isNumber(String val) {
        //source :
        //http://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
        try  {
            double d = Double.parseDouble(val);
        }
        catch(NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
