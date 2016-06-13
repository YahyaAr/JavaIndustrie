/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Box;
import model.InstanceBox;

/**
 *
 * @author yahyaz_rif
 */
public interface DAOInstanceBox extends DAO<InstanceBox> {
    public List<InstanceBox> findLesBoxById(Box b); // renvoie les box par son ID
    public List<InstanceBox> findToutesLesBoxAchetees(); // renvoie les box achetee
    public int compteurDeBox(Box b);

}
