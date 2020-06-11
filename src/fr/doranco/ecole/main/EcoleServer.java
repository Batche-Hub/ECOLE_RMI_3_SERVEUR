/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.ecole.main;

import fr.doranco.ecole.rmi.server.RmiEnseignant;
import fr.doranco.ecole.rmi.server.RmiEtudiant;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Boule
 */
public class EcoleServer {

    public static void main(String[] args) {

        try {
            RmiEtudiant rmiEtudiant = new RmiEtudiant();
            RmiEnseignant rmiEnseignant = new RmiEnseignant();
            Registry registre = LocateRegistry.createRegistry(4050);
            registre.bind("Etudiant", rmiEtudiant);
            registre.bind("Enseignant", rmiEnseignant);
            
            System.err.println("Le serveur de l'école est prêt.");
        } catch (Exception e) {

            System.err.println("Le serveur a connu l'erreur suivante : " + e);
            System.exit(1);
        }

    }
}
