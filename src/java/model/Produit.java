/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yahyaz_rif
 */
@Entity
@Table(name = "produit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produit.deleteAll", query = "DELETE FROM Produit p"),
    @NamedQuery(name = "Produit.findAll", query = "SELECT p FROM Produit p"),
    @NamedQuery(name = "Produit.findById", query = "SELECT p FROM Produit p WHERE p.id = :id"),
    @NamedQuery(name = "Produit.findByHauteur", query = "SELECT p FROM Produit p WHERE p.hauteur = :hauteur"),
    @NamedQuery(name = "Produit.findByLongueur", query = "SELECT p FROM Produit p WHERE p.longueur = :longueur"),
    @NamedQuery(name = "Produit.findByNbEmpileMax", query = "SELECT p FROM Produit p WHERE p.nbEmpileMax = :nbEmpileMax"),
    @NamedQuery(name = "Produit.findByTProduction", query = "SELECT p FROM Produit p WHERE p.tProduction = :tProduction"),
    @NamedQuery(name = "Produit.findByTSetup", query = "SELECT p FROM Produit p WHERE p.tSetup = :tSetup")})
public class Produit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id")
    private String id;
    @Column(name = "hauteur")
    private Integer hauteur;
    @Column(name = "longueur")
    private Integer longueur;
    @Column(name = "nbEmpileMax")
    private Integer nbEmpileMax;
    @Column(name = "t_production")
    private Integer tProduction;
    @Column(name = "t_setup")
    private Integer tSetup;
    @OneToMany(mappedBy = "idProduit")
    private List<CommandeDetails> commandeDetailsList;

    public Produit() {
        commandeDetailsList = new ArrayList();
    }

    public Produit(String id) {
        this.id = id;
        commandeDetailsList = new ArrayList();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getHauteur() {
        return hauteur;
    }

    public void setHauteur(Integer hauteur) {
        this.hauteur = hauteur;
    }

    public Integer getLongueur() {
        return longueur;
    }

    public void setLongueur(Integer longueur) {
        this.longueur = longueur;
    }

    public Integer getNbEmpileMax() {
        return nbEmpileMax;
    }

    public void setNbEmpileMax(Integer nbEmpileMax) {
        this.nbEmpileMax = nbEmpileMax;
    }

    public Integer getTProduction() {
        return tProduction;
    }

    public void setTProduction(Integer tProduction) {
        this.tProduction = tProduction;
    }

    public Integer getTSetup() {
        return tSetup;
    }

    public void setTSetup(Integer tSetup) {
        this.tSetup = tSetup;
    }

    @XmlTransient
    public List<CommandeDetails> getCommandeDetailsList() {
        return commandeDetailsList;
    }

    public void setCommandeDetailsList(List<CommandeDetails> commandeDetailsList) {
        this.commandeDetailsList = commandeDetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Produit[ id=" + id + " ]";
    }
    
}
