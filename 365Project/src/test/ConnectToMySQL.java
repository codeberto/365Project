/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.*;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.util.Properties;

public class ConnectToMySQL {          
    static Connection connect;
    static final String strSshPassword = "YOUR_CAL_POLY_PASSWORD";                      // SSH login password
    static final String strSshUser = "YOUR_CAL_POLY_USERNAME";                                // SSH loging username
    
    private static void doSshTunnel(String strSshUser, String strSshPassword, String strSshHost, int nSshPort,
            String strRemoteHost, int nLocalPort, int nRemotePort) throws JSchException {
        final JSch jsch = new JSch();
        Session session = jsch.getSession(strSshUser, strSshHost, 22);
        session.setPassword(strSshPassword);

        final Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);

        session.connect();
        session.setPortForwardingL(nLocalPort, strRemoteHost, nRemotePort);
    }
    
    public static void runConnection() {
        try {
            String strSshHost = "unix12.csc.calpoly.edu";                       // hostname or ip or SSH server
            int nSshPort = 22;                                                  // remote SSH host port number
            String strRemoteHost = "cslvm74.csc.calpoly.edu";                   // hostname
            int nLocalPort = 3366;                                              // local port number use to bind SSH tunnel
            int nRemotePort = 3306;                                             // remote port number of your database
            String strDbUser = "becarter";                                      // database loging username
            String strDbPassword = "3x5Dipl4caiT";                              // database login password

            ConnectToMySQL.doSshTunnel(strSshUser, strSshPassword, strSshHost, nSshPort, strRemoteHost, nLocalPort,
                    nRemotePort);

            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:" + nLocalPort, strDbUser,
                       strDbPassword);
            connect.setCatalog(strDbUser);
            connect.setAutoCommit(false);
        } catch(Exception e) {
            System.out.println("connection prob: " + e.toString());
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
