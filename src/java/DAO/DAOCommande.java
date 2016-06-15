/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Commande;

/**
 *
 * @author yahyaz_rif
 */
public interface DAOCommande extends DAO<Commande>{
    
    public List<Commande> findAllOrderByDEnvoiPrevue(); //Lister les commandes par ordre d'envoi prévu 
    public List<Commande> findAllOrderByDEnvoi(); //Lister les commandes par ordre d'envoi

}
