/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.rmi.interfaces;


import fr.doranco.ecole.entity.Enseignant;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Boule
 */
public interface IRmiEnseignant extends Remote{
    
    public Enseignant getEnseignantById(int id) throws RemoteException;
    public Enseignant addEnseignant(Enseignant enseignant) throws RemoteException;
    public void updateEnseignant(Enseignant enseignant) throws RemoteException;
    public void removeEnseignant(int id) throws RemoteException;
    public List<Enseignant> getListeEnseignantByPoste(String poste) throws RemoteException;
}
