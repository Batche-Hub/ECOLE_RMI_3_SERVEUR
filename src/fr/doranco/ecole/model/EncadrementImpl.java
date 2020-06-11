/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.ecole.model;

import fr.doranco.ecole.entity.Cours;
import fr.doranco.ecole.entity.Enseignant;
import fr.doranco.ecole.entity.Etudiant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Boule
 */
public class EncadrementImpl implements IEncadrement {
    
    
    //Constructeur
    public EncadrementImpl(){
    }
    
    //Méthodes de l'interface à redéfinir

    @Override
    public List<Etudiant> getListeEtudiantByEnseignant(Enseignant enseignant){
        List<Etudiant> listeEtudiants = new ArrayList<>();
       
        Connection connection = EcoleDataSource.getInstance();
       
        String requete = "SELECT etudiant_suivi_id FROM cours_suivi WHERE  enseignant_suivi_id=? ";
       
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, enseignant.getId());
            ResultSet rs = ps.executeQuery();
            EtudiantImpl etud = new EtudiantImpl();
            while (rs.next()) {  
                listeEtudiants.add(etud.getEtudiantById(rs.getInt(1)));
            }
           
        } catch (SQLException e) {
           
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    System.err.println("Erreur de connexion SQL : " + ex);
                }
            }
        }
        return listeEtudiants;
    }

    @Override
    public List<Enseignant> getListeEnseignantsByEtudiant(Etudiant etudiant){
        List<Enseignant> listeEnseignants = new ArrayList<>();
       
        Connection connection = EcoleDataSource.getInstance();
       
        String requete = "SELECT enseignant_suivi_id   FROM cours_suivi WHERE  etudiant_suivi_id=?";
       
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, etudiant.getId());
            ResultSet rs = ps.executeQuery();
            EnseignantImpl enseign = new EnseignantImpl();
            while (rs.next()) {  
                listeEnseignants.add(enseign.getEnseignantById(rs.getInt(1)));
            }
           
        } catch (Exception e) {
            System.err.println("Une erreur de connexion est survenue : "+e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    System.err.println("Erreur de connexion SQL : " + ex);
                }
            }
        }
        return listeEnseignants;
    }

    @Override
    public List<Cours> getListeCoursByEtudiant(Etudiant etudiant){
        System.err.println("Non implémenté.");
        return null;
    }

    @Override
    public List<Cours> getListeCoursByEnseignant(Enseignant enseignant){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Etudiant> getListeEtudiantsByCours(Cours cours){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Enseignant> getListeEnseignantsByCours(Cours cours){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
