package test;

public class Workout {
    int duration, id;
    String dateWorked, woType, username;

    public Workout() {}

    public Workout setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public Workout setId(int id) {
        this.id = id;
        return this;
    }

    public Workout setDateWorked(String dateWorked) {
        this.dateWorked = dateWorked;
        return this;
    }

    public Workout setWoType(String woType) {
        this.woType = woType;
        return this;
    }

    public Workout setUsername(String username) {
        this.username = username;
        return this;
    }

    @Override
    public String toString() {
        return id + " " + username + " " + dateWorked + " " + woType + " " + duration;
    }
}
