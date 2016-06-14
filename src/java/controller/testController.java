/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author achrafdahmani
 */
@Named(value = "testController")
@ManagedBean (name= "testController")
@SessionScoped
public class testController {
        
    /**
     * Creates a new instance of testController
     */
    public testController() {
    }
    
    private String name;

    /**
     * Get the value of name
     *
     * @return the value of name 
     */
    public String getNom() {
        return "Achraf";
    }

    /**
     * Set the value of name
     *
     * @param nom new value of name
     */
    public void setNom(String nom) {
        this.name = nom;
    }
    
    public void test(String test){
        System.out.println("Achraf le PDbhh" + test);
        
        
    }
    
}
