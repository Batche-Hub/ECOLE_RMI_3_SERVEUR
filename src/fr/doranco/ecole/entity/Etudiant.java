/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.ecole.entity;

import fr.doranco.ecole.utils.enums.Specialite;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Boule
 */
public class Etudiant implements Serializable {
    //Serial
    private static final long serialVersionUID = 11L;
    
    
    //propriétés
    private int id;
    private String nom;
    private String prenom;
    private int age;
    private String telephone;
    private String email;
    private Adresse adresse;
    private String specialite;
    private String section;
    private String groupe;
    private List<Cours> listeCoursSuivis; // = new ArrayList<Cours>();
    
    
    //Constructeurs
    //vide
    public Etudiant() {
    }
    //plein

    public Etudiant(String nom, String prenom, int age, String telephone, String email, Adresse adresse, String specialite, String section, String groupe, List<Cours> listeCoursSuivis) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.telephone = telephone;
        this.email = email;
        this.adresse = adresse;
        this.specialite = specialite;
        this.section = section;
        this.groupe = groupe;
        this.listeCoursSuivis = listeCoursSuivis;
    }
    
    //celui dont on aura besoin

    public Etudiant(String nom, String prenom, String specialite) {
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
    }
    
    
    
    //Get et Set

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

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public List<Cours> getListeCoursSuivis() {
        return listeCoursSuivis;
    }

    public void setListeCoursSuivis(List<Cours> listeCoursSuivis) {
        this.listeCoursSuivis = listeCoursSuivis;
    }

    @Override
    public String toString() {
        return "Etudiant{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", specialite=" + specialite + '}';
    }
    
}
