/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.ecole.entity;

import fr.doranco.ecole.utils.enums.Poste;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Boule
 */
public class Enseignant implements Serializable {
    //Serial
    private static final long serialVersionUID = 10L;
    
    //propriétés
    private int id;
    private String nom;
    private String prenom;
    private int age;
    private String telephone;
    private String email;
    private Adresse adresse;
    private String poste;
    private List<Cours> listeCoursDonnes; // = new ArrayList<Cours>();

    
    //Constructeurs
    
    //vide
    public Enseignant() {
    }
    //plein

    public Enseignant(int id, String nom, String prenom, int age, String telephone, String email, Adresse adresse, String poste, List<Cours> listeCoursDonnes) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.telephone = telephone;
        this.email = email;
        this.adresse = adresse;
        this.poste = poste;
        this.listeCoursDonnes = listeCoursDonnes;
    }
    
    //celui dont aura besoin

    public Enseignant(int id, String nom, String prenom, String poste) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
    }
    
    
    
    //get et set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public List<Cours> getListeCoursDonnes() {
        return listeCoursDonnes;
    }

    public void setListeCoursDonnes(List<Cours> listeCoursDonnes) {
        this.listeCoursDonnes = listeCoursDonnes;
    }
    
    
   
    
    
    
    
    
    
    
}
