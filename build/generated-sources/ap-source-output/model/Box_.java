package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.InstanceBox;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-13T12:08:00")
@StaticMetamodel(Box.class)
public class Box_ { 

    public static volatile SingularAttribute<Box, Integer> longueur;
    public static volatile ListAttribute<Box, InstanceBox> instanceBoxList;
    public static volatile SingularAttribute<Box, String> id;
    public static volatile SingularAttribute<Box, Double> prixBox;
    public static volatile SingularAttribute<Box, Integer> hauteur;
    public static volatile SingularAttribute<Box, Integer> quantite;

}