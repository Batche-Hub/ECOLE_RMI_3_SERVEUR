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
public enum TypeCours {
  TD("Travaux Dirigés"),
  TP ("Travaux pratiques"),
  COURS ("Cours"),
  CONF ("Conférences");
  
  private String name ="";
  
  //Constructeur
  TypeCours(String name){
    this.name = name;
  }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
  
  
}
