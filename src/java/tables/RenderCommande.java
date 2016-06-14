/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import model.Commande;

/**
 *
 * @author achrafdahmani
 */
public class RenderCommande {
    private Commande commande;
    private int dEnvoiprevue;
    private int dEnvoi;
    private double penalite;
    private double ecart;
    private double cout;

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public int getdEnvoiprevue() {
        return dEnvoiprevue;
    }

    public void setdEnvoiprevue(int dEnvoiprevue) {
        this.dEnvoiprevue = dEnvoiprevue;
    }

    public int getdEnvoi() {
        return dEnvoi;
    }

    public void setdEnvoi(int dEnvoi) {
        this.dEnvoi = dEnvoi;
    }

    public double getPenalite() {
        return penalite;
    }

    public void setPenalite(double penalite) {
        this.penalite = penalite;
    }

    public double getEcart() {
        return ecart;
    }

    public void setEcart(double ecart) {
        this.ecart = ecart;
    }

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }

    @Override
    public String toString() {
        return "RenderCommande{" + "commande=" + commande + ", dEnvoiprevue=" + dEnvoiprevue + ", dEnvoi=" + dEnvoi + ", penalite=" + penalite + ", ecart=" + ecart + ", cout=" + cout + '}';
    }

}
