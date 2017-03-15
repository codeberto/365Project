package test.queries;

import test.ConnectToMySQL;

import static test.Constants.TABLE_USERS;
import static test.Constants.TABLE_WORKOUTS;

public class InsertQueries {

    public static boolean insertWorkoutType(String type, String date, int duration) {
        String command = "INSERT INTO " + TABLE_WORKOUTS + " (type, date, duration) VALUES ("
                + "'" + type + "'" + ", " + "'" + date + "'" + ", " + duration + ")";

        return ConnectToMySQL.sendInsertSatement(command);
    }

    public static boolean createNewUser(String name, int weight, int age) {
        String command = "INSERT INTO " + TABLE_USERS + "(name, weight, age) VALUES ("
                + "'" + name + "', " + weight + ", " + age + ")";

        return ConnectToMySQL.sendInsertSatement(command);
    }
}
