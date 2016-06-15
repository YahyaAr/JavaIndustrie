/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOBox;
import DAO.DAOCommande;
import DAO.DAOFactory;
import DAO.DAOInstanceBox;
import DAO.JPADAOBox;
import DAO.JPADAOFactory;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.lang.String;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.Box;
import model.Commande;
import tables.RenderBox;
import tables.RenderCommande;
 
/**  
 *
 * @author achrafdahmani
 */

public class DBManager implements Serializable {

    List<Commande> List ;
    List<RenderBox> renderBox;
    List<RenderCommande> renderC;
    private JPADAOFactory jpaDaoFactory;
    /**
     * 
     * Creates a new instance of DBManager
     */
    public DBManager() {
        List = new ArrayList();
        jpaDaoFactory = (JPADAOFactory) DAOFactory.getDaoFactory(DAOFactory.PersistType.JPA);

        
    }

    public List<Commande> getList() {
        return List;
    }

    public void setList(List<Commande> List) {
        this.List = List;
    }

    public List<RenderBox> getRenderBox() {
        return renderBox;
    }

    public void setRenderBox(List<RenderBox> renderBox) {
        this.renderBox = renderBox;
    }

    public List<RenderCommande> getCommandes() {
        return renderC;
    }

    public void setCommandes(List<RenderCommande> commandes) {
        this.renderC = commandes;
    }

    public JPADAOFactory getJpaDaoFactory() {
        return jpaDaoFactory;
    }

    public void setJpaDaoFactory(JPADAOFactory jpaDaoFactory) {
        this.jpaDaoFactory = jpaDaoFactory;
    }
    
        
    public List<Commande> commandesList(){
       
      // jpaDaoFactory.resetToNull();
       jpaDaoFactory = (JPADAOFactory) DAOFactory.getDaoFactory(DAOFactory.PersistType.JPA);
       
       DAOCommande jpaDaoCommande = jpaDaoFactory.getCommandeDao();
        List<Commande> List = jpaDaoCommande.findAll();
         System.out.println("listxx");
        System.out.println(List);
       
       return List;
   }
    
    public List<RenderBox> boxAchetesList(){
       //jpaDaoFactory.resetToNull();
       jpaDaoFactory = (JPADAOFactory) DAOFactory.getDaoFactory(DAOFactory.PersistType.JPA);
       DAOBox daoBox = jpaDaoFactory.getBoxDao();
       DAOInstanceBox daoInstanceBox = jpaDaoFactory.getInstanceBoxDao();
       List<Box> typeBoxs = new ArrayList();
              typeBoxs = daoBox.findAll();
        System.out.println("typeBoxs");
        System.out.println(typeBoxs);
       
        renderBox = new ArrayList<>();
        typeBoxs.stream().map((box) -> {
            RenderBox b = new RenderBox();
            b.setBox(box);
            b.setAchat(daoInstanceBox.compteurDeBox(box));
            double cout = box.getPrixBox() * daoInstanceBox.compteurDeBox(box);
            b.setCout(cout);
            return b;
        }).forEach((b) -> {
            renderBox.add(b);
            System.out.println("//////////////////1111111");
            System.out.println(b);
        });
       return renderBox;
   }
    
    public List<RenderCommande> commandesTable(){
        
      // JPADAOFactory jpaDaoFactory = (JPADAOFactory) DAOFactory.getDaoFactory(DAOFactory.PersistType.JPA);
        jpaDaoFactory.resetToNull();
       jpaDaoFactory = (JPADAOFactory) DAOFactory.getDaoFactory(DAOFactory.PersistType.JPA);
       DAOCommande daoCommande = jpaDaoFactory.getCommandeDao();
       List<Commande> lesCommandes = new ArrayList();
       lesCommandes = daoCommande.findAll();
       renderC = new ArrayList<>();
       System.out.println("lescommandes");
       System.out.println(lesCommandes);
       Iterator<Commande> it = lesCommandes.iterator();
       while(it.hasNext()){
           System.out.println("type :"+it.next().getClass());
            // Commande c = it.next();
            RenderCommande r = new RenderCommande();
            r.setCommande(it.next());
            r.setdEnvoi(r.getCommande().getDEnvoi());
            r.setdEnvoiprevue(r.getCommande().getDEnvoiPrevue());
            r.setEcart(r.getCommande().getDEnvoi()- r.getCommande().getDEnvoiPrevue());
            r.setPenalite(r.getCommande().getPenalite());
            r.setCout(r.getEcart()* r.getCommande().getPenalite());
            renderC.add(r);
       }
     
        System.out.println("Commandes "+renderC);
       return renderC;
   }
   
    
}



