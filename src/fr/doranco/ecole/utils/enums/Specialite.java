/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.ecole.utils.enums;

/**
 *
 * @author Boule
 */
public enum Specialite {
    
  MECANIQUE("Mécanique"),
  INFORMATIQUE ("Informatique"),
  SOCIOLOGIE ("Sociologie"),
  HISTOIRE ("Histoire");
  
  private String specialite ="";
  
  //Constructeur
  Specialite(String specialite){
    this.specialite = specialite;
  }

    public String getSpecialite() {
        return specialite;
    }

}
