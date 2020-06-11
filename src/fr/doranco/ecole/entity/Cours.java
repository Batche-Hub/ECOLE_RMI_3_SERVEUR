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
public class Cours implements Serializable {
    //Serial
    private static final long serialVersionUID = 13L;
    
    
    
    //propriétés
    private int id;
    private String titre;
    private int duree;
    private String type;
    
    //Constructeurs
    //Vide
    public Cours() {
    }
    
    //Celui dont on aura besoin (plein)

    public Cours(int id, String titre, int duree, String type) {
        this.id = id;
        this.titre = titre;
        this.duree = duree;
        this.type = type;
    }
    
    
    
    
    //Get et Set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
