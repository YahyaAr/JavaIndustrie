/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Commande;
import model.CommandeDetails;

/**
 *
 * @author yahyaz_rif
 */
public interface DAOCommandeDetails extends DAO<CommandeDetails>{
    
    public List<CommandeDetails> findProduitByCommande(Commande c); // renvoie les 
                                                                /// produits d'une commande

}
