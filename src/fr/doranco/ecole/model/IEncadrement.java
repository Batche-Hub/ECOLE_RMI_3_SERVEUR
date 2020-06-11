/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.ecole.model;

import fr.doranco.ecole.entity.Cours;
import fr.doranco.ecole.entity.Enseignant;
import fr.doranco.ecole.entity.Etudiant;
import java.rmi.Remote;
import java.util.List;

/**
 *
 * @author Boule
 */
public interface IEncadrement extends Remote{
    
    public List<Etudiant> getListeEtudiantByEnseignant(Enseignant enseignant);
    public List<Enseignant> getListeEnseignantsByEtudiant(Etudiant etudiant);
    public List<Cours> getListeCoursByEtudiant(Etudiant etudiant);
    public List<Cours> getListeCoursByEnseignant(Enseignant enseignant);
    public List<Etudiant> getListeEtudiantsByCours(Cours cours);
    public List<Enseignant> getListeEnseignantsByCours(Cours cours);
}
