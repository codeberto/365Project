/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.*;

/**
 *
 * @author cignx
 */
public class ConnectToMySQL {
   static Connection connect;
   public static void runConnection(){
       try {
           Class.forName("com.mysql.jdbc.Driver");
           connect = DriverManager.getConnection(
                   "jdbc:mysql://cslvm74.csc.calpoly.edu:3306/becarter?zeroDateTimeBehavior=convertToNull");
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
           
   }
   
   public void testQueryConnection(){
       
   }
   
   public void testInsertConnection(){
       
   }
   
   public void closeConnection(){
        try{
            connect.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
   }
}
