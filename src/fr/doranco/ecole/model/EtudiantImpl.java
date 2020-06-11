/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.ecole.model;


import fr.doranco.ecole.entity.Etudiant;
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
public class EtudiantImpl implements IEtudiant {

    //Constructeur
    public EtudiantImpl() {
    }
    
    //Méthodes de l'interface à redéfinir
    @Override
    public Etudiant getEtudiantById(int id) {
        Etudiant etudiant = new Etudiant();
        Connection connection = EcoleDataSource.getInstance();

        String requete = "SELECT * FROM etudiant WHERE id = ?";
        PreparedStatement ps = null;
        try {
            
            ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            
            
            ResultSet rs = ps.executeQuery();
            

            if (rs.next()) {
                
                etudiant.setId(rs.getInt("id"));
                etudiant.setNom(rs.getString("nom"));
                etudiant.setPrenom(rs.getString("prenom"));
                etudiant.setSpecialite(rs.getString("specialite"));
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
        return etudiant;
    }

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        //Je fais la connection via la classe DataSource qui contient toutes les informations nécessaires pour fair ele lien avec la BDD
        Connection connexion = EcoleDataSource.getInstance();

        //J'écris ma requête vers la BDD. INSERT INTO pour insérer l'objet Etudiant (passé en paramètre pour rappel)
        //ensuite je dois entourer d'un try catch car ça peut générer une erreur (je suis throws remote exception)
        String requete = "INSERT INTO etudiant(nom, prenom, specialite) VALUE(?,?,?)";
        PreparedStatement ps = null;
        try {
            
            ps = connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
            //Je spécifie à quoi correspond dans Java les points d'interrogation de ma requête.
            ps.setString(1, etudiant.getNom());
            ps.setString(2, etudiant.getPrenom());
            ps.setString(3, etudiant.getSpecialite());
            // Je mets à jour
            ps.executeUpdate();
            //Je mets l'id de ma BDD dans l'étudiant (qui ne possède donc pas encore d'Id vu qu'elle est créée lors de la création de l'étudiant dans la BDD

            ResultSet resultSet = ps.getGeneratedKeys();
            //Ici je parcours ma ligne et je spécifie que mon id se trouve à la colonne 1 (getInt(1)).
            if (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                etudiant.setId(id);
            }

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
        return etudiant;
    }

    @Override
    public void updateEtudiant(Etudiant etudiant) {
        
        if (getEtudiantById(etudiant.getId()).getId() > 0){
        Connection connexion = EcoleDataSource.getInstance();

        //J'écris ma requête vers la BDD. INSERT INTO pour insérer l'objet Etudiant (passé en paramètre pour rappel)
        //ensuite je dois entourer d'un try catch car ça peut générer une erreur (je suis throws remote exception)
        String requete = "UPDATE etudiant SET nom = ?, prenom=?, specialite=? WHERE id=?";
        PreparedStatement ps = null;
        try {
            ps = connexion.prepareStatement(requete);
            //Je spécifie à quoi correspond dans Java les points d'interrogation de ma requête.
            ps.setString(1, etudiant.getNom());
            ps.setString(2, etudiant.getPrenom());
            ps.setString(3, etudiant.getSpecialite());
            ps.setInt(4, etudiant.getId());
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
            System.err.println("Vous ne pouvez pas changer les propriétés d'une personne qui n'existe pas !");
        }
    }

    @Override
    public void removeEtudiant(int id) {
        System.err.println(this.getEtudiantById(id));
        if (this.getEtudiantById(id).getId() > 0){
            System.err.println("Remove");
        Connection connection = EcoleDataSource.getInstance();

        String requete = "DELETE FROM etudiant WHERE id = " + id;
        
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
            System.err.println("Cet étudiant n'existe pas !");
        }
        
    }

    @Override
    public List<Etudiant> getListeEtudiantByGroupe(String groupe) {
        List<Etudiant> listeEtudiants = new ArrayList<>();
       
        Connection connection = EcoleDataSource.getInstance();
       
        String requete = "SELECT * FROM etudiant WHERE section = ? ";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(requete);
            ps.setString(1, groupe);
            ResultSet rs = ps.executeQuery();
            
           
            while (rs.next()) {
               
                Etudiant etudiant = new Etudiant();
               
                etudiant.setId(rs.getInt("id"));
                etudiant.setNom(rs.getString("nom"));
                etudiant.setPrenom(rs.getString("prenom"));
                etudiant.setSpecialite(rs.getString("groupe"));
               
                listeEtudiants.add(etudiant);
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
    public List<Etudiant> getListeEtudiantBySection(String section) {
                List<Etudiant> listeEtudiants = new ArrayList<>();
       
        Connection connection = EcoleDataSource.getInstance();
       
        String requete = "SELECT * FROM etudiant WHERE section = ? ";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(requete);
            ps.setString(1, section);
            ResultSet rs = ps.executeQuery();
            
           
            while (rs.next()) {
               
                Etudiant etudiant = new Etudiant();
               
                etudiant.setId(rs.getInt("id"));
                etudiant.setNom(rs.getString("nom"));
                etudiant.setPrenom(rs.getString("prenom"));
                etudiant.setSpecialite(rs.getString("section"));
               
                listeEtudiants.add(etudiant);
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
    public List<Etudiant> getListeEtudiantBySpecialite(String specialite) {
        List<Etudiant> listeEtudiants = new ArrayList<>();
       
        Connection connection = EcoleDataSource.getInstance();
       
        String requete = "SELECT * FROM etudiant WHERE specialite = ? ";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(requete);
            ps.setString(1, specialite);
            ResultSet rs = ps.executeQuery();
            
           
            while (rs.next()) {
               
                Etudiant etudiant = new Etudiant();
               
                etudiant.setId(rs.getInt("id"));
                etudiant.setNom(rs.getString("nom"));
                etudiant.setPrenom(rs.getString("prenom"));
                etudiant.setSpecialite(rs.getString("specialite"));
               
                listeEtudiants.add(etudiant);
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



}
