package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Box;
import model.Produit;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-13T12:08:00")
@StaticMetamodel(InstanceBox.class)
public class InstanceBox_ { 

    public static volatile SingularAttribute<InstanceBox, Produit> idProduit;
    public static volatile SingularAttribute<InstanceBox, Box> idBox;
    public static volatile SingularAttribute<InstanceBox, Integer> id;
    public static volatile SingularAttribute<InstanceBox, Integer> libre;
    public static volatile SingularAttribute<InstanceBox, Integer> numBox;

}