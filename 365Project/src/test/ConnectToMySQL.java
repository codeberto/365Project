/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectToMySQL {
    
    
    static Connection connect;
    static final String strSshPassword = "";                  // SSH login password
    static final String strSshUser = "";                                    // SSH loging username
    
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
    
    public static void createTables(){
        try {
            Statement statement = connect.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS Users(username varchar(30), password varchar(30), name varchar(30) not null, weight integer, age integer, primary key(username));");
            statement.close();
            connect.commit();
            
            statement = connect.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS Workouts(id integer auto_increment, username varchar(30) not null, dateWorked date, woType varchar(30), duration integer, foreign key(username) references Users(username), primary key(id));");
            statement.close();
            connect.commit();

            statement = connect.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS Friends(username varchar(30), friend varchar(30), foreign key(username) references Users(username), foreign key(friend) references Users(username), primary key (username, friend));");
            statement.close();
            connect.commit();
            
            
            statement = connect.createStatement();
            statement.execute("DELIMITER $$ DROP TRIGGER IF EXISTS date_ex$$ CREATE TRIGGER date_ex BEFORE INSERT ON Workouts FOR EACH ROW BEGIN"
                    + " IF new.dateWorked > current_date() THEN signal sqlstate '45002'; END IF; END $$ DELIMITER ; ");
            statement.close();
            connect.commit();



        } catch (SQLException ex) {
            Logger.getLogger(ConnectToMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    CREATE TABLE IF NOT EXISTS Users(
        CREATE TABLE IF NOT EXISTS Users(
	id integer auto_increment,
        name varchar(30) not null,
        weight integer,
        age integer,
        primary key(id)
    );
    
*/

    public void testInsertConnection(){

    }

    public static void closeConnection(){
         try{
             connect.close();
         } catch (Exception e) {
             System.out.println("close prob: " + e.getMessage());
         }
    }

    public static Statement sendInsertStatement(String command) {
        try {
            Statement statement = connect.createStatement();
            statement.executeUpdate(command, Statement.RETURN_GENERATED_KEYS);
            connect.commit();

            return statement;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Statement sendSelectStatement(String command) {
        try {
            Statement statement = connect.createStatement();
            statement.executeQuery(command);
            connect.commit();

            return statement;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


//    public static void testQueryConnection(){
//        ResultSet rs;
//        Statement statement;
//        String workoutName;
//
//        try{
//             statement = connect.createStatement();
//
//             rs = statement.executeQuery("SELECT * FROM Workouts");
//
//             while(rs.next()) {
//                 workoutName = rs.getString(2);      // use column number
//                 System.out.println("Username = " + workoutName);
//             }
//
//        } catch (Exception e) {
//             System.out.println("query prob: " + e.getMessage());
//        }
//    }
}
