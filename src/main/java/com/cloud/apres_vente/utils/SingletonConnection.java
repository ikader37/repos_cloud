package com.cloud.apres_vente.utils;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class SingletonConnection {
    
    
    private static Connection connecter;
    static{//Sexecute au moment du chargement de la classe en memoire
       try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        connecter=DriverManager.getConnection("jdbc:mysql://localhost:3306/cloud_db", "root","");
       }
       catch(ClassNotFoundException e)
       {
           
       } catch (SQLException ex) {
            Logger.getLogger(SingletonConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnecter() {
        System.out.println(connecter);
        
        return connecter;
    }
    
    
}
