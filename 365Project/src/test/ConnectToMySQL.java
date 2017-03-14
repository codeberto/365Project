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
           connect = DriverManager.getConnection("jdbc:mysql://cslvm74.csc.calpoly.edu:3306/becarter?user=becarter&password=3x5Dipl4caiT");
           connect.setAutoCommit(false);
       } catch (Exception e) {
           System.out.println("connection prob: " + e.getMessage());
       }
           
   }
   
   public static void testQueryConnection(){
       ResultSet rs;
       Statement statement;
       String workoutName;
            
       try{
            statement = connect.createStatement();
       
            rs = statement.executeQuery("SELECT * FROM Workouts");
            
            while(rs.next()) {
                workoutName = rs.getString(2);      // use column number
                System.out.println("Username = " + workoutName);
            }
            
       } catch (Exception e) {
            System.out.println("query prob: " + e.getMessage());
       }
       
       
       
       
   }
   
   public void testInsertConnection(){
       
   }
   
   public static void closeConnection(){
        try{
            connect.close();
        } catch (Exception e) {
            System.out.println("close prob: " + e.getMessage());
        }
   }
}
