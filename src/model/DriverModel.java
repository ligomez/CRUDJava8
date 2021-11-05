package model;

public class DriverModel {
    private int userIdFk;
    private String vehLicenseFk;

    private int userId;
    private String userName;
    private String userSurname;
    private String userEmail;
    private String vehLicense;
    private int tripId;
    private String dateTime;

    public DriverModel(int userIdFk, String vehLicenseFk) {
        this.userIdFk = userIdFk;
        this.vehLicenseFk = vehLicenseFk;
    }

    public DriverModel(int tripId, int userId, String userName, String userSurname, String userEmail, String dateTime,
                     String vehLicense) {
        this.tripId = tripId;
        this.userId = userId;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userEmail = userEmail;
        this.dateTime = dateTime;
        this.vehLicense = vehLicense;
    }

    public DriverModel(int userId, String userName, String userSurname, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userEmail = userEmail;
    }

    public DriverModel(int userId, String userName, String userSurname, String userEmail, String vehLicense, String dateTime) {
        this.userId = userId;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userEmail = userEmail;
        this.vehLicense = vehLicense;
        this.dateTime = dateTime;
    }

    public int getUserIdFk() {
        return userIdFk;
    }

    public void setUserIdFk(int userIdFk) {
        this.userIdFk = userIdFk;
    }

    public String getVehLicenseFk() {
        return vehLicenseFk;
    }

    public void setVehLicenseFk(String vehLicenseFk) {
        this.vehLicenseFk = vehLicenseFk;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getVehLicense() {
        return vehLicense;
    }

    public void setVehLicense(String vehLicense) {
        this.vehLicense = vehLicense;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Object[] toArray() {
        Object[] data = {tripId, userId, userName, userSurname, userEmail, dateTime, vehLicense};
        return data;
    }

    @Override
    public String toString() {
        return userId +"-" + userName + " " + userSurname + " ";
    }
}
