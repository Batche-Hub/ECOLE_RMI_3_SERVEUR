/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.ecole.model;

import fr.doranco.ecole.entity.Enseignant;
import java.util.List;

/**
 *
 * @author Boule
 */
public interface IEnseignant{
    
    public Enseignant getEnseignantById(int id);
    public Enseignant addEnseignant(Enseignant enseignant);
    public void updateEnseignant(Enseignant enseignant);
    public void removeEnseignant(int id);
    public List<Enseignant> getListeEnseignantByPoste(String poste);
}
