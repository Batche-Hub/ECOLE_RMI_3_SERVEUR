/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.rmi.interfaces;

import fr.doranco.ecole.entity.Etudiant;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Boule
 */
public interface IRmiEtudiant extends Remote{
    public Etudiant getEtudiantById(int id) throws RemoteException;
    public Etudiant addEtudiant(Etudiant etudiant)throws RemoteException;
    public void updateEtudiant(Etudiant etudiant) throws RemoteException;
    public void removeEtudiant(int id) throws RemoteException;
    public List<Etudiant> getListeEtudiantByGroupe(String groupe) throws RemoteException;
    public List<Etudiant> getListeEtudiantBySection(String section) throws RemoteException;
    public List<Etudiant> getListeEtudiantBySpecialite(String specialite) throws RemoteException;
    
}
