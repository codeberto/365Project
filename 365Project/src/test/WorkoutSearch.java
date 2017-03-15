package test;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static test.Constants.TABLE_WORKOUTS;

public class WorkoutSearch {
    boolean byType, byDate, byDuration, byUserName, byName;
    String type, startDate, endDate, username, name;
    int startDuration, endDuration;

    public WorkoutSearch() {
        byType = false;
        byDate = false;
        byDuration = false;
        byUserName = true;
        byName = false;

        username = Main.CURRENT_USER;
    }

    public WorkoutSearch byType(String type) {
        this.byType = true;
        this.type = type;
        return this;
    }

    public WorkoutSearch byDate(String date) {
        this.startDate = date;
        this.endDate = date;
        this.byDate = true;
        return this;
    }

    public WorkoutSearch byDate(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate == null ? startDate : endDate;
        this.byDate = true;
        return this;
    }

    public WorkoutSearch byDuration(int duration) {
        this.byDuration = true;
        this.startDuration = duration;
        this.endDuration = duration;
        return this;
    }

    public WorkoutSearch byDuration(int startDuration, int endDuration) {
        this.byDuration = true;
        this.startDuration = startDuration;
        this.endDuration = endDuration;
        return this;
    }

    public WorkoutSearch byUsername(String username) {
        this.byUserName = true;
        this.username = username;
        return this;
    }

    public WorkoutSearch byName(String name) {
        this.byName = true;
        this.name = name;
        return this;
    }

    public WorkoutSearch searchAllUsers(boolean allUsers) {
        byUserName = false;
        username = null;
        return this;
    }

    List<Workout> getWorkouts() {
        List<Workout> workouts = new ArrayList<>();
        String selectCommand = "SELECT * ";
        String fromCommand = "FROM " + TABLE_WORKOUTS;
        String whereCommand = ((!byDate && !byName && !byType && !byDuration && !byUserName)
                ? ""
                : "WHERE "
                + (byUserName ? "username = '" + username + "'" : "")
                + (byName? " AND name = '" + name + "'" : "")
                + (byDuration? " AND startDuration = " + startDuration : "")
                + (byDate? " AND dateWorked >= " + startDate + " AND dateWorked <= " + endDate : "")
                + (byType? " AND type = " + type : ""));

        String orderByCommand = "";

        String command = selectCommand + fromCommand + whereCommand + orderByCommand;
        try {
            Statement statement = ConnectToMySQL.sendSelectStatement(selectCommand + fromCommand + whereCommand);
            Workout workout;
            if (statement != null) {
                ResultSet rs = statement.getResultSet();
                while (rs.next()) {
                    workout = new Workout()
                            .setDateWorked(rs.getDate("dateWorked").toString())
                            .setDuration(rs.getInt("duration"))
                            .setId(rs.getInt("id"))
                            .setWoType(rs.getString("woType"))
                            .setUsername(rs.getString("username"));
                    workouts.add(workout);
                }
            } else {
                System.out.println("Statement returned null for getWorkouts with command: " + command);
            }
        } catch (Exception e) {

        }

        return workouts;
    }
}