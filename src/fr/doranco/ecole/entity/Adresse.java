/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.ecole.entity;

import java.io.Serializable;

/**
 *
 * @author Boule
 */
public class Adresse implements Serializable {
    //Serial
    private static final long serialVersionUID = 12L;
    
    //Propriétés
    private int id;
    private int numeroRue;
    private String rue;
    private String ville;
    private int codePostal;
    
    //Constructeurs
    //Vide

    public Adresse() {
    }
    //Plein

    public Adresse(int id, int numeroRue, String rue, String ville, int codePostal) {
        this.id = id;
        this.numeroRue = numeroRue;
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
    }
    
    //Celui dont aura besoin

    public Adresse(int id, String ville) {
        this.id = id;
        this.ville = ville;
    }
    
    
    
    //Get et Set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroRue() {
        return numeroRue;
    }

    public void setNumeroRue(int numeroRue) {
        this.numeroRue = numeroRue;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }
    
    
}
