package access;

import model.VehicleModel;
import utils.ConnectionDB;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;


public class VehicleDAO {
    private Connection conn = null;

    public ArrayList<VehicleModel> getAllVehicles() {
        ArrayList<VehicleModel> vehicles = new ArrayList<>();
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            String sql = "SELECT * FROM vehiculo";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()){
            VehicleModel vehicle = new VehicleModel(result.getString(1), result.getString(2), result.getString(3),
                    result.getInt(4), result.getInt(5), result.getString(6), result.getInt(7) );
            vehicles.add(vehicle);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Code : " + ex.getErrorCode()
                    + " Error :" + ex.getMessage());
        }
        return vehicles;
    }

    public VehicleModel selectVehicle(String vehLicense) {
        VehicleModel vehicle = null;
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "SELECT * FROM vehiculo WHERE veh_placa=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, vehLicense);
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                vehicle = new VehicleModel(result.getString(1), result.getString(2), result.getString(3),
                        result.getInt(4), result.getInt(5), result.getString(6), result.getInt(7));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Code : " + ex.getErrorCode()
                    + " Error :" + ex.getMessage());
        }
        return vehicle;
    }

    public void insertNewVehicle(VehicleModel vehicle) {
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            String sql = "INSERT INTO vehiculo(veh_placa, veh_marca, veh_modelo, veh_anio, veh_capacidad, " +
                    "veh_color, veh_kilometros) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, vehicle.getVehLicense());
            statement.setString(2, vehicle.getVehMake());
            statement.setString(3, vehicle.getVehModel());
            statement.setInt(4, vehicle.getVehYear());
            statement.setInt(5, vehicle.getVehSeater());
            statement.setString(6, vehicle.getVehColour());
            statement.setInt(7, vehicle.getVehKilometers());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("New vehicle successfully inserted");
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Code : " + ex.getErrorCode()
                    + " Error :" + ex.getMessage());
        }
    }

    public void updateVehicle(VehicleModel vehicle, int idWhere) {
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "UPDATE vehiculo SET veh_placa = ? WHERE veh_placa =(SELECT veh_placa FROM conductor WHERE usu_cc = ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, vehicle.getVehLicense());
            statement.setInt(2, idWhere);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Vehicle successfully updated");
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Code : " + ex.getErrorCode()
                    + " Error :" + ex.getMessage());
        }
    }

    public void updateColourVehicle(VehicleModel vehicle) {
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            String sql = "UPDATE vehiculo SET veh_color = ? WHERE veh_placa=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, vehicle.getVehColour());
            statement.setString(2, vehicle.getVehLicense());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Colour vehicle successfully updated");
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Code : " + ex.getErrorCode()
                    + " Error :" + ex.getMessage());
        }
    }

    public void deleteVehicle(String vehLicense) {
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            String sql = "DELETE FROM vehiculo WHERE veh_placa=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, vehLicense);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Delete successful");
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Code : " + ex.getErrorCode()
                    + " Error :" + ex.getMessage());
        }
    }

}
