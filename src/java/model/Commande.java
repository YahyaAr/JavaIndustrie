/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yahyaz_rif
 */
@Entity
@Table(name = "commande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commande.deleteAll", query = "DELETE FROM Commande c"),
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c"),
    @NamedQuery(name = "Commande.findById", query = "SELECT c FROM Commande c WHERE c.id = :id"),
    @NamedQuery(name = "Commande.findByDEnvoiPrevue", query = "SELECT c FROM Commande c WHERE c.dEnvoiPrevue = :dEnvoiPrevue"),
    @NamedQuery(name = "Commande.findByDEnvoi", query = "SELECT c FROM Commande c WHERE c.dEnvoi = :dEnvoi"),
    @NamedQuery(name = "Commande.findByNb", query = "SELECT c FROM Commande c WHERE c.nb = :nb"),
    @NamedQuery(name = "Commande.findByPenalite", query = "SELECT c FROM Commande c WHERE c.penalite = :penalite"),
    @NamedQuery(name = "Commande.findByStockMin", query = "SELECT c FROM Commande c WHERE c.stockMin = :stockMin")})
public class Commande implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id")
    private String id;
    @Column(name = "dEnvoiPrevue")
    private int dEnvoiPrevue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dEnvoi")
    private int dEnvoi;
    @Column(name = "nb")
    private Integer nb;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "penalite")
    private Double penalite;
    @Column(name = "stockMin")
    private Integer stockMin;
    @OneToMany(mappedBy = "idCommande")
    private List<CommandeDetails> commandeDetailsList;

    public Commande() {
        commandeDetailsList = new ArrayList();

    }

    public Commande(String id) {
        this.id = id;
        commandeDetailsList = new ArrayList();
    }

    public Commande(String id, int dEnvoi) {
        this.id = id;
        this.dEnvoi = dEnvoi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDEnvoiPrevue() {
        return dEnvoiPrevue;
    }

    public void setDEnvoiPrevue(int dEnvoiPrevue) {
        this.dEnvoiPrevue = dEnvoiPrevue;
    }

    public int getDEnvoi() {
        return dEnvoi;
    }

    public void setDEnvoi(int dEnvoi) {
        this.dEnvoi = dEnvoi;
    }

    public Integer getNb() {
        return nb;
    }

    public void setNb(Integer nb) {
        this.nb = nb;
    }

    public Double getPenalite() {
        return penalite;
    }

    public void setPenalite(Double penalite) {
        this.penalite = penalite;
    }

    public Integer getStockMin() {
        return stockMin;
    }

    public void setStockMin(Integer stockMin) {
        this.stockMin = stockMin;
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
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Commande[ id=" + id + " ]";
    }
    
}
