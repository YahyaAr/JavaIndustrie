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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yahyaz_rif
 */
@Entity
@Table(name = "produitBaked")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProduitBaked.deleteAll", query = "DELETE FROM ProduitBaked p"),
    @NamedQuery(name = "ProduitBaked.findAll", query = "SELECT p FROM ProduitBaked p"),
    @NamedQuery(name = "ProduitBaked.findById", query = "SELECT p FROM ProduitBaked p WHERE p.id = :id"),
    @NamedQuery(name = "ProduitBaked.findByDateDebutProd", query = "SELECT p FROM ProduitBaked p WHERE p.dateDebutProd = :dateDebutProd")})
public class ProduitBaked implements Serializable {

    @OneToMany(mappedBy = "idProduitBaked")
    private List<InstanceBox> instanceBoxList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dateDebutProd")
    private Integer dateDebutProd;
    @JoinColumn(name = "nbLigne", referencedColumnName = "id")
    @ManyToOne
    private LigneProduction nbLigne;
    @JoinColumn(name = "idCommandeDetails", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CommandeDetails idCommandeDetails;

    public ProduitBaked() {
        instanceBoxList = new ArrayList();
    }

    public ProduitBaked(Integer id) {
        this.id = id;
        instanceBoxList = new ArrayList();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDateDebutProd() {
        return dateDebutProd;
    }

    public void setDateDebutProd(Integer dateDebutProd) {
        this.dateDebutProd = dateDebutProd;
    }

    public LigneProduction getNbLigne() {
        return nbLigne;
    }

    public void setNbLigne(LigneProduction nbLigne) {
        this.nbLigne = nbLigne;
    }

    public CommandeDetails getIdCommandeDetails() {
        return idCommandeDetails;
    }

    public void setIdCommandeDetails(CommandeDetails idCommandeDetails) {
        this.idCommandeDetails = idCommandeDetails;
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
        if (!(object instanceof ProduitBaked)) {
            return false;
        }
        ProduitBaked other = (ProduitBaked) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ProduitBaked[ id=" + id + " ]";
    }

    @XmlTransient
    public List<InstanceBox> getInstanceBoxList() {
        return instanceBoxList;
    }

    public void setInstanceBoxList(List<InstanceBox> instanceBoxList) {
        this.instanceBoxList = instanceBoxList;
    }
    
}
