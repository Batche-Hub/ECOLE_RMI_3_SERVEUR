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
public enum Poste {
  MAITRE_CONF("Maître.sse de conférence"),
  INGENIEUR ("Ingénieur.e"),
  DOCTEUR ("Docteur.e"),
  PROF ("Professeur.e");
  
  private String poste ="";
  
  //Constructeur
  Poste(String poste){
    this.poste = poste;
  }

    public String getPoste() {
        return poste;
    }

  
}
