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
import javax.persistence.Id;
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
@Table(name = "ligne_production")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LigneProduction.deleteAll", query = "DELETE FROM LigneProduction l"),
    @NamedQuery(name = "LigneProduction.findAll", query = "SELECT l FROM LigneProduction l"),
    @NamedQuery(name = "LigneProduction.findById", query = "SELECT l FROM LigneProduction l WHERE l.id = :id"),
    @NamedQuery(name = "LigneProduction.findByNbLignes", query = "SELECT l FROM LigneProduction l WHERE l.nbLignes = :nbLignes")})
public class LigneProduction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "nbLignes")
    private Integer nbLignes;

    public LigneProduction() {
    }

    public LigneProduction(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNbLignes() {
        return nbLignes;
    }

    public void setNbLignes(Integer nbLignes) {
        this.nbLignes = nbLignes;
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
        if (!(object instanceof LigneProduction)) {
            return false;
        }
        LigneProduction other = (LigneProduction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.LigneProduction[ id=" + id + " ]";
    }
    
}
