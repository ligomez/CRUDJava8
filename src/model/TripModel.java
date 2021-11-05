package model;

public class TripModel {
    private int tripId;
    private int userIdFk;
    private int driverIdFk;
    private String dateTime;

    public TripModel(int tripId, int userIdFk, int driverIdFk, String dateTime) {
        this.tripId = tripId;
        this.userIdFk = userIdFk;
        this.driverIdFk = driverIdFk;
        this.dateTime = dateTime;
    }

    public TripModel(int tripId, String dateTime) {
        this.tripId = tripId;
        this.dateTime = dateTime;
    }

    public TripModel(String dateTime) {
        this.dateTime = dateTime;
    }

    public TripModel(int userIdFk, int driverIdFk, String dateTime) {
        this.userIdFk = userIdFk;
        this.driverIdFk = driverIdFk;
        this.dateTime = dateTime;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public int getUserIdFk() {
        return userIdFk;
    }

    public void setUserIdFk(int userIdFk) {
        this.userIdFk = userIdFk;
    }

    public int getDriverIdFk() {
        return driverIdFk;
    }

    public void setDriverIdFk(int driverIdFk) {
        this.driverIdFk = driverIdFk;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return dateTime;
    }
}
