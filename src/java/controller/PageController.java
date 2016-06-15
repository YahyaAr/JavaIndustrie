/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOCommandeDetails;
import DAO.DAOFactory;
import DAO.DAOProduitBaked;
import DAO.JPADAOFactory;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;
import metier.SoluceFile;
import metier.Solution1;
import model.Commande;
import model.CommandeDetails;
import model.InstanceBox;
import model.ProduitBaked;

/**
 *
 * @author achrafdahmani
 */
@SessionScoped
public class PageController implements Serializable {
    private Part file;
    private Commande commande;
    private List<InstanceBox> bakedProductsOfCommande;
    private List<InstanceBox> boxesOfAllCommandes;
    private DAOCommandeDetails daoCommandeDetails;
    private ProduitBaked lastInProd;

    public List<InstanceBox> getBoxesOfAllCommandes() {
        return boxesOfAllCommandes;
    }

    public void setBoxesOfAllCommandes(List<InstanceBox> boxesOfAllCommandes) {
        this.boxesOfAllCommandes = boxesOfAllCommandes;
    }

    public ProduitBaked getLastInProd() {
        return lastInProd;
    }

    public void setLastInProd(ProduitBaked lastInProd) {
        this.lastInProd = lastInProd;
    }
    

    private String nameFile;
    public Commande getCommande() {
        return commande;
    }

    
    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public List<InstanceBox> getBakedProductsOfCommande() {
        return bakedProductsOfCommande;
    }

    public void setBakedProductsOfCommande(List<InstanceBox> bakedProductsOfCommande) {
        this.bakedProductsOfCommande = bakedProductsOfCommande;
    }
    
    /**
     * Creates a new instance of PageController
     */
    public PageController() {
    }
    
    public String doUploadAndSolution1(){
        TraitementInstance i = new TraitementInstance();
        i.setFichier(this.getFile());
        nameFile = this.getFile().getName();
        i.uploadFichier();
        Solution1 s = new Solution1();
        s.solve();
        return "index?faces-redirect=true";

    }
    public String downloadSoluce() throws IOException{
        SoluceFile sf = new SoluceFile();
        sf.setNameFile(file.getSubmittedFileName());
        sf.generate();
        
        return "index?faces-redirect=true";
    }
    
    public String Home(){
        return "index?faces-redirect=true";
    }
    
    public String Stats() {
        return "stats?faces-redirect=true";
    }
    
    public String Tests() {
        return "tests?faces-redirect=true";
    }
    
    public String Commande(Commande commande) {
        this.commande = commande;
        System.out.println("1");
        this.bakedProductsOfCommande = new ArrayList<>();
        System.out.println(bakedProductsOfCommande);
        List<InstanceBox> e = new ArrayList<>();
        for (int h = 0; h < commande.getCommandeDetailsList().size(); h++) {
            System.out.println("FOR 1 "+h);
            CommandeDetails cd = commande.getCommandeDetailsList().get(h);
            System.out.println("cd "+cd);
            e= cd.getInstanceBoxList();
            System.out.println("E :"+e+" "+commande.getCommandeDetailsList());
            
        }   
        for (int i = 0; i < e.size(); i++) {
                
                System.out.println(2 + i);
                this.bakedProductsOfCommande.add(e.get(i));
            }
        System.out.println(" dfd "+this.bakedProductsOfCommande);
        return "commande?faces-redirect=true";
    }
    
    
        public String Gants() {
        this.boxesOfAllCommandes = new ArrayList<>();
       // System.out.println(bakedProductsOfCommande);
        
        JPADAOFactory jpaDaoFactory = (JPADAOFactory) DAOFactory.getDaoFactory(DAOFactory.PersistType.JPA);
        daoCommandeDetails = jpaDaoFactory.getCommandeDetailDao();
        DAOProduitBaked daoProduitBaked = jpaDaoFactory.getProduitBaked();
        this.lastInProd  = daoProduitBaked.findLastOne();
        List<CommandeDetails> LesCommandesDetails = daoCommandeDetails.findAll();
        
        
        for (int h = 0; h < LesCommandesDetails.size(); h++) {
            
            for (int i = 0; i < LesCommandesDetails.get(h).getInstanceBoxList().size(); i++) {
                boxesOfAllCommandes.add(LesCommandesDetails.get(h).getInstanceBoxList().get(i));
            }
        }
//        System.out.println(this.bakedProductsOfCommande);
        return "gants?faces-redirect=true";
    }
}
