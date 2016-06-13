/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yahyaz_rif
 */
@Entity
@Table(name = "commandeDetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommandeDetails.findAllOfCommande", query = "SELECT p FROM CommandeDetails p WHERE p.idCommande = :commande"),
    @NamedQuery(name = "CommandeDetails.deleteAll", query = "DELETE FROM CommandeDetails c"),
    @NamedQuery(name = "CommandeDetails.findAll", query = "SELECT c FROM CommandeDetails c"),
    @NamedQuery(name = "CommandeDetails.findById", query = "SELECT c FROM CommandeDetails c WHERE c.id = :id"),
    @NamedQuery(name = "CommandeDetails.findByQuantite", query = "SELECT c FROM CommandeDetails c WHERE c.quantite = :quantite")})
public class CommandeDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "quantite")
    private Integer quantite;
    @JoinColumn(name = "idCommande", referencedColumnName = "id")
    @ManyToOne
    private Commande idCommande;
    @JoinColumn(name = "idProduit", referencedColumnName = "id")
    @ManyToOne
    private Produit idProduit;

    public CommandeDetails() {
    }

    public CommandeDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Commande getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Commande idCommande) {
        this.idCommande = idCommande;
    }

    public Produit getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Produit idProduit) {
        this.idProduit = idProduit;
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
        if (!(object instanceof CommandeDetails)) {
            return false;
        }
        CommandeDetails other = (CommandeDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CommandeDetails[ id=" + id + " ]";
    }
    
}
