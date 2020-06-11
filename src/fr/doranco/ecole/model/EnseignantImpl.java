/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.ecole.model;

import fr.doranco.ecole.entity.Enseignant;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Boule
 */
public class EnseignantImpl implements IEnseignant {


    //Constructeur
    public EnseignantImpl(){
    }

    //Méthodes de l'interface à implémenter
    @Override
    public Enseignant getEnseignantById(int id) {
        Enseignant enseignant = new Enseignant();
        Connection connection = EcoleDataSource.getInstance();

        String requete = "SELECT * FROM enseignant WHERE id = ?";
        PreparedStatement ps = null;
        try {
            
            ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            
            //La valeur de retour de la tbale qui est égale à la requête qui a été préparée et exécutée.
            ResultSet rs = ps.executeQuery();
            

            if (rs.next()) {
                
                enseignant.setId(rs.getInt("id"));
                enseignant.setNom(rs.getString("nom"));
                enseignant.setPrenom(rs.getString("prenom"));
                enseignant.setPoste(rs.getString("poste"));
            }
        } catch (Exception e) {
            System.out.println("Une erreur est survenue : " + e);
            return null;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    System.err.println("Une erreur Sql est survenue : " + ex);
                    
                }

            }

        }
        return enseignant;
    }

    @Override
    public Enseignant addEnseignant(Enseignant enseignant) {
        //Je fais la connection via la classe DataSource qui contient toutes les informations nécessaires pour fair ele lien avec la BDD
        Connection connexion = EcoleDataSource.getInstance();

        //J'écris ma requête vers la BDD. INSERT INTO pour insérer l'objet Etudiant (passé en paramètre pour rappel)
        //ensuite je dois entourer d'un try catch car ça peut générer une erreur (je suis throws remote exception)
        String requete = "INSERT INTO etudiant(nom, prenom, poste) VALUE(?,?,?)";
        PreparedStatement preparedState = null;
        try {
            preparedState = connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
            //Je spécifie à quoi correspond dans Java les points d'interrogation de ma requête.
            preparedState.setString(1, enseignant.getNom());
            preparedState.setString(2, enseignant.getPrenom());
            preparedState.setString(3, enseignant.getPoste());
            // Je mets à jour
            preparedState.executeUpdate();
            //Je mets l'id de ma BDD dans l'étudiant (qui ne possède donc pas encore d'Id vu qu'elle est créée lors de la création de l'étudiant dans la BDD

            ResultSet resultSet = preparedState.getGeneratedKeys();
            //Ici je parcours ma ligne et je spécifie que mon id se trouve à la colonne 1 (getInt(1)).
            if (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                enseignant.setId(id);
            }

        } catch (Exception e) {
            System.err.println("Une erreur de connexion est survenue. :\\(\\" + e);
        }finally {
            if (connexion != null) {
                try {
                    connexion.close();
                } catch (SQLException ex) {
                    System.err.println("Une erreur SQL est survenue : "+ex);
                }
            }

        }
        return enseignant;
    }

    @Override
    public void updateEnseignant(Enseignant enseignant) {
        
        if (getEnseignantById(enseignant.getId()).getId() > 0){
        Connection connexion = EcoleDataSource.getInstance();
        String requete = "UPDATE enseignant SET nom = ?, prenom=?, poste=? WHERE id=?";
        PreparedStatement ps = null;
        try {
            ps = connexion.prepareStatement(requete);
            //Je spécifie à quoi correspond dans Java les points d'interrogation de ma requête.
            ps.setString(1, enseignant.getNom());
            ps.setString(2, enseignant.getPrenom());
            ps.setString(3, enseignant.getPoste());
            ps.setInt(4, enseignant.getId());
            // Je mets à jour
            ps.executeUpdate();


        } catch (Exception e) {
            System.err.println("Une erreur de connexion est survenue." + e);
        } finally {
            if (connexion != null) {
                try {
                    connexion.close();
                } catch (SQLException ex) {
                    System.err.println("Une erreur SQL est survenue : "+ex);
                }
            }
        }
        }else{
            System.err.println("Vous ne pouvez pas changer les propriétés d'une personne qui n'existe pas.");
        }
    }

    @Override
    public void removeEnseignant(int id) {
        if (this.getEnseignantById(id).getId() > 0){
        Connection connection = EcoleDataSource.getInstance();

        String requete = "DELETE FROM enseignant WHERE id = " + id;
        
            try {
                PreparedStatement ps = connection.prepareStatement(requete);
                ps.executeUpdate();
            } catch (Exception e) {
                System.err.println("Une erreur de connexion est survenue." + e);
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        System.err.println("Erreur de connexion SQL : " + ex);
                    }
                }
            }
        }else{
            System.err.println("Cet enseignant n'existe pas !");
        }
    }

    @Override
    public List<Enseignant> getListeEnseignantByPoste(String poste) {
        List<Enseignant> listeEnseignants = new ArrayList<>();
       
        Connection connection = EcoleDataSource.getInstance();
       
        String requete = "SELECT * FROM enseignant WHERE poste = ? ";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(requete);
            ps.setString(1, poste);
            ResultSet rs = ps.executeQuery();
            
           
            while (rs.next()) {
               
                Enseignant enseignant = new Enseignant();
               
                enseignant.setId(rs.getInt("id"));
                enseignant.setNom(rs.getString("nom"));
                enseignant.setPrenom(rs.getString("prenom"));
                enseignant.setPoste(rs.getString("poste"));
               
                listeEnseignants.add(enseignant);
            }
           
        } catch (SQLException e) {
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

}
