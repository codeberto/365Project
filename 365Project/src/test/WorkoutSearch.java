package test;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static test.Constants.TABLE_WORKOUTS;

public class WorkoutSearch {
    public static final int ASC = 0;
    public static final int DESC = 1;

    private boolean byType, byDate, byDuration, byUserName, byName;
    private boolean orderByDate, orderByDuration, orderByUserName, orderByName, orderByType;
    private String type, startDate, endDate, username, name;
    private int startDuration, endDuration;
    private int order;

    public WorkoutSearch() {
        byType = false;
        byDate = false;
        byDuration = false;
        byUserName = true;
        byName = false;
        orderByDate = false;
        orderByDuration = false;
        orderByName = false;
        orderByUserName = true;
        orderByType = false;
        order = DESC;

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

    public WorkoutSearch descendingOrder() {
        this.order = DESC;
        return this;
    }

    public WorkoutSearch ascendingOrder() {
        this.order = ASC;
        return this;
    }

    public WorkoutSearch byName(String name) {
        this.byName = true;
        this.name = name;
        return this;
    }

    public WorkoutSearch searchAllUsers(boolean allUsers) {
        byUserName = !allUsers;
        return this;
    }

    public WorkoutSearch orderByDate(boolean orderByDate) {
        this.orderByDate = orderByDate;
        return this;
    }

    public WorkoutSearch orderByDuration(boolean orderByDuration) {
        this.orderByDuration = orderByDuration;
        return this;
    }

    public WorkoutSearch orderByUsername(boolean orderByUserName) {
        this.orderByUserName = orderByUserName;
        return this;
    }

    public WorkoutSearch orderByName(boolean orderByName) {
        this.orderByName = orderByName;
        return this;
    }

    public WorkoutSearch orderByWoType(boolean orderByType) {
        this.orderByType = orderByType;
        return this;
    }

    List<Workout> getWorkouts() {
        List<Workout> workouts = new ArrayList<>();
        String selectCommand = "SELECT * ";
        String fromCommand = "FROM " + TABLE_WORKOUTS;
        String whereCommand;

        if (byDate || byName || byType || byDuration || byUserName) {
            boolean firstQualifier = false;
            whereCommand = " WHERE ";
            if (byUserName) {
                whereCommand += "username = '" + username + "'";
                firstQualifier = true;
            }
            if (byName) {
                whereCommand += (firstQualifier ? " AND " : " ") + "name = '" + name + "'";
                firstQualifier = true;
            }
            if (byDate) {
                whereCommand += (firstQualifier ? " AND " : " ") + "dateWorked >= '" + startDate + "' AND dateWorked <= '" + endDate + "'";
                firstQualifier = true;
            }
            if (byDuration) {
                whereCommand += (firstQualifier ? " AND " : " ") + "duration >= " + startDuration + " AND duration <= " + endDuration;
                firstQualifier = true;
            }
            if (byType) {
                whereCommand += (firstQualifier ? " AND " : " ") + "woType = '" + type + "'";
            }
        } else {
            whereCommand = "";
        }

        String orderCommand;
        if (orderByDate || orderByDuration || orderByName || orderByType || orderByUserName) {
            boolean firstOrder = false;
            orderCommand = " ORDER BY ";
            if (orderByDate) {
                orderCommand += "dateWorked";
                firstOrder = true;
            }
            if (orderByName) {
                orderCommand += (firstOrder ? ", name"  : "name");
                firstOrder = true;
            }
            if (orderByType) {
                orderCommand += (firstOrder ? ", woType" : "woType");
                firstOrder = true;
            }
            if (orderByUserName) {
                orderCommand += (firstOrder ? ", username" : "username");
                firstOrder = true;
            }
            if (orderByDuration) {
                orderCommand += (firstOrder ? ", duration" : "duration");
            }

            orderCommand += (order == DESC ? " DESC" : " ASC");
        } else {
            orderCommand = "";
        }


        String command = selectCommand + fromCommand + whereCommand + orderCommand;
        System.out.println(command);
        try {
            Statement statement = ConnectToMySQL.sendSelectStatement(command);
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