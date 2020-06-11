/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.ecole.main;

import fr.doranco.ecole.entity.Etudiant;
import fr.doranco.ecole.model.EcoleDataSource;
import fr.doranco.ecole.model.EtudiantImpl;
import fr.doranco.ecole.utils.enums.Specialite;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Boule
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("Début du test");
        
        
        Connection connect = EcoleDataSource.getInstance();
        System.out.println("Ma connexion : " + connect);
        
        

        
        EtudiantImpl etudiantImpl = new EtudiantImpl();
        
        System.err.println(etudiantImpl.getEtudiantById(15));
        

        List<Etudiant> etud = etudiantImpl.getListeEtudiantBySpecialite(Specialite.HISTOIRE.getSpecialite());
        System.out.println("Boucle");
        for (Etudiant etudiant : etud) {
            System.err.println(etudiant.getNom());
        }
        
        
        
    }
}
