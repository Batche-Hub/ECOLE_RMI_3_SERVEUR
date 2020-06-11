/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.ecole.model;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author Boule
 */
public class EcoleDataSource implements DataSource{
    
    //URL de connexion
    private String url = "jdbc:mysql://127.0.0.1:3306/doranco_db?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
  //Nom du user
    private String user = "root";
  //Mot de passe de l'utilisateur
    private String passwd = "root";
  //Objet Connection
    private static Connection connection;

    private EcoleDataSource() {
        try {
      connection = DriverManager.getConnection(url, user, passwd);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    }

    //private Connection getConnectionBis() {
      //  try {
        //    connection = DriverManager.getConnection(url, user, passwd);
            
    //    } catch (Exception e) {
      //      System.err.println("Un problème de connexion est survenu." + e);

        //}
        //return connection;
    //}
    
    public static Connection getInstance(){
    if(connection == null){
      new EcoleDataSource();
    }
    return connection;   
  } 
    
    

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        Connection connection = null;
        try {
             //username = "root";
             //password = "root";
            String url = "jdbc:mysql://127.0.0.1:3306/doranco_db?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";

            connection = DriverManager.getConnection(url, username, password);
            
        } catch (Exception e) {
            System.err.println("Un problème de connexion est survenu." + e);

        }
        return connection;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Connection getConnection() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
