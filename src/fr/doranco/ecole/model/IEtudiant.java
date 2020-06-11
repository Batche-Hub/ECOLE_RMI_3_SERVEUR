/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.ecole.model;

import fr.doranco.ecole.entity.Etudiant;
import java.util.List;

/**
 *
 * @author Boule
 */
public interface IEtudiant {
    
    public Etudiant getEtudiantById(int id);
    public Etudiant addEtudiant(Etudiant etudiant);
    public void updateEtudiant(Etudiant etudiant);
    public void removeEtudiant(int id);
    public List<Etudiant> getListeEtudiantByGroupe(String groupe);
    public List<Etudiant> getListeEtudiantBySection(String section);
    public List<Etudiant> getListeEtudiantBySpecialite(String specialite);
}
