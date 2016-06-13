/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Box;

/**
 *
 * @author yahyaz_rif
 */
public interface DAOBox extends DAO<Box>{
    
    public Box findFirstBylh(int l, int h); // trouve la premiére box avec les 
                                                      // dimensions requises

}
