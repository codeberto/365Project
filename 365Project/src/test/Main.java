package test;

import java.util.List;

public class Main {
    
    static MainPage main_runner;
    static String CURRENT_USER = "mlsteinh";
    
    public static void main(String args[]) {
        main_runner= new MainPage();
        main_runner.setVisible(true);
        ConnectToMySQL.runConnection();
        ConnectToMySQL.createTables();
        List<Workout> workouts = Queries.getWorkoutByDate("2017-03-12", "2017-03-13");
        for (Workout w : workouts) {
            System.out.println(w.dateWorked + ": " + w.duration + " minutes");
        }
        ConnectToMySQL.closeConnection();
        
    }
}
