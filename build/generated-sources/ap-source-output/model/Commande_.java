package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.CommandeDetails;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-13T12:08:00")
@StaticMetamodel(Commande.class)
public class Commande_ { 

    public static volatile SingularAttribute<Commande, Double> penalite;
    public static volatile SingularAttribute<Commande, Integer> nb;
    public static volatile SingularAttribute<Commande, Integer> stockMin;
    public static volatile SingularAttribute<Commande, Integer> dEnvoi;
    public static volatile SingularAttribute<Commande, String> id;
    public static volatile SingularAttribute<Commande, Integer> dEnvoiPrevue;
    public static volatile ListAttribute<Commande, CommandeDetails> commandeDetailsList;

}