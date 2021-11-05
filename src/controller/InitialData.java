package controller;

import access.DriverDAO;
import access.TripDAO;
import access.UserDAO;
import access.VehicleDAO;
import model.DriverModel;
import model.TripModel;
import model.UserModel;
import model.VehicleModel;

import java.util.ArrayList;

public class InitialData {

    private ArrayList<DriverModel> drivers = null;
    private ArrayList<TripModel> trips = null;
    private ArrayList<UserModel> users = null;
    private ArrayList<VehicleModel> vehicles = null;
    private ArrayList<DriverModel> driverModels = null;

    public InitialData(){
        DriverDAO driverDAO = new DriverDAO();
        this.drivers = driverDAO.getAllDrivers();

        DriverDAO driverDAOFiltered = new DriverDAO();
        this.driverModels = driverDAOFiltered.getAllDriversDistinct();
        this.driverModels.add(0, new DriverModel(0, "Select Driver to update", "", ""));

        VehicleDAO vehicleDAO = new VehicleDAO();
        this.vehicles = vehicleDAO.getAllVehicles();
        this.vehicles.add(0, new VehicleModel("All licenses", "", "", -1, -1, "", -1));

        TripDAO tripDAO = new TripDAO();
        this.trips = tripDAO. getAllTrips();
        this.trips.add(0, new TripModel(-1, -1, -1, "All dates"));

        UserDAO userDAO = new UserDAO();
        this.users = userDAO.getAllUsers();
        this.users.add(0, new UserModel("Select passenger"));
    }

    public ArrayList<DriverModel> getDrivers() {
        return drivers;
    }

    public ArrayList<UserModel> getUsers() {
        return users;
    }

     public ArrayList<TripModel> getTrips() {
        return trips;
    }

       public ArrayList<VehicleModel> getVehicles() {
        return vehicles;
    }

    public ArrayList<DriverModel> getDriverModels() {
        return driverModels;
    }

    public void setDriverModels(ArrayList<DriverModel> driverModels) {
        this.driverModels = driverModels;
    }
}
