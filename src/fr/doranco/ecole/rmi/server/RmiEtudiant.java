/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.ecole.rmi.server;

import fr.doranco.ecole.entity.Etudiant;
import fr.doranco.ecole.model.EtudiantImpl;
import fr.doranco.rmi.interfaces.IRmiEtudiant;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Boule
 */
public class RmiEtudiant extends UnicastRemoteObject implements IRmiEtudiant {
//Constructeur
    public RmiEtudiant() throws RemoteException {
        super();
    }
    
    

//Méthodes
    @Override
    public Etudiant getEtudiantById(int id) throws RemoteException {
        try{
            return new EtudiantImpl().getEtudiantById(id);
        }catch(Exception e){
            System.err.println("Une erreur de connexion est survenue.");
        }
        return null;
    }

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) throws RemoteException {
        try{
            return new EtudiantImpl().addEtudiant(etudiant);
        }catch(Exception e){
            System.err.println("Une erreur de connexion est survenue.");
        }
        return null;
    }

    @Override
    public void updateEtudiant(Etudiant etudiant) throws RemoteException {
        try{
            new EtudiantImpl().updateEtudiant(etudiant);
        }catch(Exception e){
            System.err.println("Une erreur de connexion est survenue.");
        }
    }

    @Override
    public void removeEtudiant(int id) throws RemoteException {
        try{
            new EtudiantImpl().removeEtudiant(id);
        }catch(Exception e){
            System.err.println("Une erreur de connexion est survenue.");
        }
    }

    @Override
    public List<Etudiant> getListeEtudiantByGroupe(String groupe) throws RemoteException {
        try{
            return new EtudiantImpl().getListeEtudiantByGroupe(groupe);
        }catch(Exception e){
            System.err.println("Une erreur de connexion est survenue.");
        }
        return null;
    }

    @Override
    public List<Etudiant> getListeEtudiantBySection(String section) throws RemoteException {
        try{
            return new EtudiantImpl().getListeEtudiantBySection(section);
        }catch(Exception e){
            System.err.println("Une erreur de connexion est survenue.");
        }
        return null;
    }

    @Override
    public List<Etudiant> getListeEtudiantBySpecialite(String specialite) throws RemoteException {
        try{
            return new EtudiantImpl().getListeEtudiantBySpecialite(specialite);
        }catch(Exception e){
            System.err.println("Une erreur de connexion est survenue.");
        }
        return null;
    }
    
}
