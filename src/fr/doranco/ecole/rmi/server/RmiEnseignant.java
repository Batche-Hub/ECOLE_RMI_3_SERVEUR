/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.ecole.rmi.server;

import fr.doranco.ecole.entity.Enseignant;
import fr.doranco.ecole.model.EnseignantImpl;
import fr.doranco.rmi.interfaces.IRmiEnseignant;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Boule
 */
public class RmiEnseignant extends UnicastRemoteObject implements IRmiEnseignant {

    public RmiEnseignant() throws RemoteException {
        super();
    }

    
    
    
    @Override
    public Enseignant getEnseignantById(int id) throws RemoteException {
        try{
            return new EnseignantImpl().getEnseignantById(id);
        }catch(Exception e){
            System.err.println("Une erreur de connexion est survenue.");
        }
        return null;
    }

    @Override
    public Enseignant addEnseignant(Enseignant enseignant) throws RemoteException {
        try{
            return new EnseignantImpl().addEnseignant(enseignant);
        }catch(Exception e){
            System.err.println("Une erreur de connexion est survenue.");
        }
        return null;
    }

    @Override
    public void updateEnseignant(Enseignant enseignant) throws RemoteException {
        try{
            new EnseignantImpl().updateEnseignant(enseignant);
        }catch(Exception e){
            System.err.println("Une erreur de connexion est survenue.");
        }
    }

    @Override
    public void removeEnseignant(int id) throws RemoteException {
        try{
            new EnseignantImpl().removeEnseignant(id);
        }catch(Exception e){
            System.err.println("Une erreur de connexion est survenue.");
        }

    }

    @Override
    public List<Enseignant> getListeEnseignantByPoste(String poste) throws RemoteException {
        try{
            return new EnseignantImpl().getListeEnseignantByPoste(poste);
        }catch(Exception e){
            System.err.println("Une erreur de connexion est survenue.");
        }
        return null;
    }
    
}
