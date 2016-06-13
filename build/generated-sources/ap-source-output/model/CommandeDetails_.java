package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Commande;
import model.Produit;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-13T12:08:00")
@StaticMetamodel(CommandeDetails.class)
public class CommandeDetails_ { 

    public static volatile SingularAttribute<CommandeDetails, Produit> idProduit;
    public static volatile SingularAttribute<CommandeDetails, Integer> id;
    public static volatile SingularAttribute<CommandeDetails, Commande> idCommande;
    public static volatile SingularAttribute<CommandeDetails, Integer> quantite;

}