package test;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static test.Constants.TABLE_FRIENDS;
import static test.Constants.TABLE_USERS;
import static test.Constants.TABLE_WORKOUTS;

public class Queries {

    public static boolean insertWorkout(String type, String date, int duration) {
        String command = "INSERT INTO " + TABLE_WORKOUTS + " (username, dateWorked, woType, duration) VALUES ('"
               + Main.CURRENT_USER + "', '" + date + "'" + ", " + "'" + type + "'" + ", " + duration + ")";

        return ConnectToMySQL.sendInsertStatement(command) != null;
    }

    public static String createNewUser(String username, String password, String name, double weight, double age) {
        String command = "INSERT INTO " + TABLE_USERS + "(username, password, name, weight, age) VALUES ("
                + "'" + username + "', " + "'" + password + "', " + "'" + name + "', " + weight + ", " + age + ")";

        try {
            Statement statement = ConnectToMySQL.sendInsertStatement(command);
            if (statement != null) {
                System.out.println("Username " + username + " is available!");
                return username;
            } else {
                System.out.println("Username " + username + " already exists!");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String logIn(String username, String password) {
        String command = "SELECT username FROM " + TABLE_USERS + " WHERE username = '" + username
                + "' AND password = '" + password + "'";

        try {
            Statement statement = ConnectToMySQL.sendSelectStatement(command);
            if (statement != null && statement.getResultSet().next()) {
                return statement.getResultSet().getString("username");
            } else {
                System.out.println("No user found with username and password: " + username + ", " + password);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean addFriend(String friend) {
        if (Main.CURRENT_USER.equals(friend)) {
            System.out.println("You can't add yourself as a friend!");
            return false;
        }

        String command = "INSERT INTO " + TABLE_FRIENDS + " (username, friend) VALUES ('"
                + Main.CURRENT_USER + "', '" + friend + "')";

        try {
            Statement statement = ConnectToMySQL.sendInsertStatement(command);
            System.out.println((statement != null
                    ? friend + " was added as a friend!"
                    : friend + " is already your friend!"));

            return statement != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<User> getFriends() {
        List<User> users = new ArrayList<>();
        String command = "SELECT name, age FROM " + TABLE_FRIENDS + " as F, " + TABLE_USERS + " as U WHERE F.username = '"
                + Main.CURRENT_USER + "' and F.username = U.username";

        try {
            Statement statement = ConnectToMySQL.sendSelectStatement(command);
            if (statement != null) {
                ResultSet rs = statement.getResultSet();
                User user;
                while (rs.next()) {
                    user = new User()
                            .setName(rs.getString("name"))
                            .setAge(rs.getDouble("age"));
                    users.add(user);
                }
            } else {
                System.out.println("Statement returned null for getFriends... " + Main.CURRENT_USER);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    public static List<Workout> getWorkoutByType(String type) {
        List<Workout> workouts = new ArrayList<>();
        String command = "SELECT * FROM " + TABLE_WORKOUTS + " WHERE username = '" + Main.CURRENT_USER
                + "' and woType = '" + type + "' ORDER BY dateWorked DESC";

        try {
            Statement statement = ConnectToMySQL.sendSelectStatement(command);
            if (statement != null) {
                ResultSet rs = statement.getResultSet();
                Workout workout;
                while (rs.next()) {
                    workout = new Workout()
                            .setId(rs.getInt("id"))
                            .setUsername(rs.getString("username"))
                            .setWoType(rs.getString("woType"))
                            .setDateWorked(rs.getDate("dateWorked").toString())
                            .setDuration(rs.getInt("startDuration"));
                    workouts.add(workout);
                }
            } else {
                System.out.println("Statement returned null for type: " + type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return workouts;
    }

}
