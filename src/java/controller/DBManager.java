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
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Arrays;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import model.Box;
import model.Commande;
import tables.RenderBox;
import tables.RenderCommande;

/**
 *
 * @author achrafdahmani
 */
@Named(value = "dBManager")
@SessionScoped
public class DBManager implements Serializable {

    /**
     * Creates a new instance of DBManager
     */
    public DBManager() {
    }
    
        
    public List<Commande> commandesList(){
        List<String> List;
       JPADAOFactory jpaDaoFactory = (JPADAOFactory) DAOFactory.getDaoFactory(DAOFactory.PersistType.JPA);

       DAOCommande jpaDaoCommande = jpaDaoFactory.getCommandeDao();
       return jpaDaoCommande.findAll();
   }
    
    public List<RenderBox> boxAchetesList(){
       JPADAOFactory jpaDaoFactory = (JPADAOFactory) DAOFactory.getDaoFactory(DAOFactory.PersistType.JPA);
       DAOBox daoBox = jpaDaoFactory.getBoxDao();
       DAOInstanceBox daoInstanceBox = jpaDaoFactory.getInstanceBoxDao();
       List<Box> typeBoxs = daoBox.findAll();
        System.out.println("typeBoxs");
        System.out.println(typeBoxs);
        ArrayList<RenderBox> boxes;
        boxes = new ArrayList<>();
        typeBoxs.stream().map((box) -> {
            RenderBox b = new RenderBox();
            b.setBox(box);
            b.setAchat(daoInstanceBox.compteurDeBox(box));
            double cout = box.getPrixBox() * daoInstanceBox.compteurDeBox(box);
            b.setCout(cout);
            return b;
        }).forEach((b) -> {
            boxes.add(b);
            System.out.println("//////////////////1111111");
            System.out.println(b);
        });
       return boxes;
   }  
      
}



