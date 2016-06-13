package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.CommandeDetails;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-13T12:08:00")
@StaticMetamodel(Produit.class)
public class Produit_ { 

    public static volatile SingularAttribute<Produit, Integer> longueur;
    public static volatile SingularAttribute<Produit, Integer> tProduction;
    public static volatile SingularAttribute<Produit, Integer> tSetup;
    public static volatile SingularAttribute<Produit, String> id;
    public static volatile SingularAttribute<Produit, Integer> nbEmpileMax;
    public static volatile ListAttribute<Produit, CommandeDetails> commandeDetailsList;
    public static volatile SingularAttribute<Produit, Integer> hauteur;

}