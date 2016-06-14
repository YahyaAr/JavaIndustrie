/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Commande;
import model.CommandeDetails;
import model.InstanceBox;
import model.ProduitBaked;

/**
 *
 * @author achrafdahmani
 */
@Named(value = "pageController")
@SessionScoped
public class PageController implements Serializable {

    private Commande commande;
    private List<InstanceBox> bakedProductsOfCommande;

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
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
    
    public String Gants(){
        return "gants?faces-redirect=true";
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
        
        for (int h = 0; h < commande.getCommandeDetailsList().size(); h++) {
            System.out.println("FOR 1 "+h);
            List<InstanceBox> e = new ArrayList();
            CommandeDetails cd = commande.getCommandeDetailsList().get(h);
            System.out.println("cd "+cd);
            e= cd.getInstanceBoxList();
            System.out.println("E :"+e+" "+commande.getCommandeDetailsList());
            for (int i = 0; i < e.size(); i++) {
                
                System.out.println(2 + i);
                this.bakedProductsOfCommande.add(e.get(i));
            }
        }      
//        System.out.println(this.bakedProductsOfCommande);
        return "commande?faces-redirect=true";
    }
    
}
