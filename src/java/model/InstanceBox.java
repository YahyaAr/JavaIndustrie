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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yahyaz_rif
 */
@Entity
@Table(name = "instanceBox")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstanceBox.compteurBox", query = "SELECT COUNT(b) FROM InstanceBox b WHERE b.idBox=:Box"),
    @NamedQuery(name = "InstanceBox.findAllAchete", query = "SELECT b FROM InstanceBox b ORDER BY b.idBox"),
    @NamedQuery(name = "InstanceBox.findBoxById", query = "SELECT b FROM InstanceBox b WHERE b.id = :id"),
    @NamedQuery(name = "InstanceBox.deleteAll", query = "DELETE FROM InstanceBox i"),
    @NamedQuery(name = "InstanceBox.findAll", query = "SELECT i FROM InstanceBox i"),
    @NamedQuery(name = "InstanceBox.findById", query = "SELECT i FROM InstanceBox i WHERE i.id = :id"),
    @NamedQuery(name = "InstanceBox.findByLibre", query = "SELECT i FROM InstanceBox i WHERE i.libre = :libre"),
    @NamedQuery(name = "InstanceBox.findByNumBox", query = "SELECT i FROM InstanceBox i WHERE i.numBox = :numBox"),
    @NamedQuery(name = "InstanceBox.findByIdProduit", query = "SELECT i FROM InstanceBox i WHERE i.idProduit = :id_Produit")})
public class InstanceBox implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "libre")
    private Integer libre;
    @Column(name = "num_box")
    private Integer numBox;
    @Size(max = 255)
    @JoinColumn(name = "idProduit", referencedColumnName = "id")
    private Produit idProduit;
    @Size(max = 255)
    @JoinColumn(name = "idBox", referencedColumnName = "id")
    @ManyToOne
    private Box idBox;

    public InstanceBox() {
    }

    public InstanceBox(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLibre() {
        return libre;
    }

    public void setLibre(Integer libre) {
        this.libre = libre;
    }

    public Integer getNumBox() {
        return numBox;
    }

    public void setNumBox(Integer numBox) {
        this.numBox = numBox;
    }

    public Produit getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Produit idProduit) {
        this.idProduit = idProduit;
    }

    public Box getIdBox() {
        return idBox;
    }

    public void setIdBox(Box idBox) {
        this.idBox = idBox;
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
        if (!(object instanceof InstanceBox)) {
            return false;
        }
        InstanceBox other = (InstanceBox) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.InstanceBox[ id=" + id + " ]";
    }
    
}
