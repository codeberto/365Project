package test;

import java.util.List;

public class Main {
    
    static MainPage main_runner;
    static LandingPage landing;
    static String CURRENT_USER = "mlsteinh";
    
    public static void main(String args[]) {
        ConnectToMySQL.runConnection();
        ConnectToMySQL.createTables();
        landing = new LandingPage();
        landing.setVisible(true);
        //main_runner= new MainPage();
        //main_runner.setVisible(true);
        /*
        List<Workout> workouts = Queries.getWorkoutByDate("2017-03-12", "2017-03-13");
        for (Workout w : workouts) {
            System.out.println(w.dateWorked + ": " + w.duration + " minutes");
        }*/
        //ConnectToMySQL.closeConnection();
        
    }
}
