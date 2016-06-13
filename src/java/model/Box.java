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
@Table(name = "box")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Box.findFirstByLH", query = "SELECT b FROM Box b WHERE b.hauteur >= :hbox AND b.longueur >= :lbox"),
    @NamedQuery(name = "Box.findAll", query = "SELECT b FROM Box b"),
    @NamedQuery(name = "Box.deleteAll", query = "DELETE FROM Box b"),
    @NamedQuery(name = "Box.findById", query = "SELECT b FROM Box b WHERE b.id = :id"),
    @NamedQuery(name = "Box.findByHauteur", query = "SELECT b FROM Box b WHERE b.hauteur = :hauteur"),
    @NamedQuery(name = "Box.findByLongueur", query = "SELECT b FROM Box b WHERE b.longueur = :longueur"),
    @NamedQuery(name = "Box.findByPrixBox", query = "SELECT b FROM Box b WHERE b.prixBox = :prixBox"),
    @NamedQuery(name = "Box.findByQuantite", query = "SELECT b FROM Box b WHERE b.quantite = :quantite")})
public class Box implements Serializable {
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prixBox")
    private Double prixBox;
    @Column(name = "quantite")
    private Integer quantite;
    @OneToMany(mappedBy = "idBox")
    private List<InstanceBox> instanceBoxList;

    public Box() {
        instanceBoxList = new ArrayList();
    }

    public Box(String id) {
        this.id = id;
        instanceBoxList = new ArrayList();
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

    public Double getPrixBox() {
        return prixBox;
    }

    public void setPrixBox(Double prixBox) {
        this.prixBox = prixBox;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public List<InstanceBox> getInstanceBoxList() {
        return instanceBoxList;
    }

    public void setInstanceBoxList(List<InstanceBox> instanceBoxList) {
        this.instanceBoxList = instanceBoxList;
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
        if (!(object instanceof Box)) {
            return false;
        }
        Box other = (Box) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Box[ id=" + id + " ]";
    }
    
}
