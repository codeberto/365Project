/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author cignx
 */
public class Main {
    
    static MainPage main_runner;
    
    public static void main(String args[]) {
              
        ConnectToMySQL.runConnection();
        ConnectToMySQL.createTables();
        main_runner= new MainPage();
        main_runner.setVisible(true);
        //ConnectToMySQL.testQueryConnection();
        ConnectToMySQL.closeConnection();
        
    }
}
