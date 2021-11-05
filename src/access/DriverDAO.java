package access;

import model.DriverModel;
import model.UserModel;
import utils.ConnectionDB;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class DriverDAO {

    private Connection conn = null;

    public ArrayList<DriverModel> getAllDrivers(){
        ArrayList<DriverModel> driverModels = new ArrayList<>();
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "SELECT via_id, con_cc, usu_nombre, usu_apellido, usu_email, fecha, veh_placa " +
                    "FROM usuario " +
                    "NATURAL JOIN conductor " +
                    "JOIN viaje ON viaje.con_cc = usuario.usu_cc " +
                    "NATURAL JOIN vehiculo ORDER BY via_id;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                DriverModel driverModel = new DriverModel(result.getInt(1), result.getInt(2),
                        result.getString(3), result.getString(4), result.getString(5),
                        result.getString(6), result.getString(7));
                driverModels.add(driverModel);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Code : " + ex.getErrorCode()
                    + " Error :" + ex.getMessage());
        }
        return driverModels;
    }

    public ArrayList<DriverModel> getAllDriversDistinct(){
        ArrayList<DriverModel> driverModels = new ArrayList<>();
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "SELECT DISTINCT con_cc, usu_nombre, usu_apellido, usu_email " +
                    "FROM usuario " +
                    "NATURAL JOIN conductor " +
                    "JOIN viaje ON viaje.con_cc = usuario.usu_cc " +
                    "NATURAL JOIN vehiculo;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                DriverModel driverModel = new DriverModel(result.getInt(1), result.getString(2),
                        result.getString(3), result.getString(4));
                driverModels.add(driverModel);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Code : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return driverModels;
    }

    public ArrayList<DriverModel> getFilteredDrivers(int tripId, String vehLicense, String name, String dateTime){
        ArrayList<DriverModel> driverModels = new ArrayList<>();
        int cases = -1;
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "SELECT via_id, con_cc, usu_nombre as con_nombre, usu_apellido as con_apellido, " +
                    "usu_email as con_email, fecha, veh_placa " +
                    "FROM usuario " +
                    "NATURAL JOIN conductor " +
                    "JOIN viaje ON viaje.con_cc = usuario.usu_cc " +
                    "NATURAL JOIN vehiculo " +
                    "WHERE usu_nombre LIKE ? ";

            if (vehLicense != "All licenses") {
                if (tripId != -1) {
                    sql += "AND veh_placa=? AND viaje.fecha=? ORDER BY fecha;";
                    cases = 1;
                } else {
                    sql += " AND veh_placa=? ORDER BY fecha;";
                    cases = 2;
                }
            } else if (tripId != -1) {
                    sql += " AND viaje.fecha=? ORDER BY fecha";
                    cases = 3;
            }
            System.out.println(cases);
            PreparedStatement statement = conn.prepareStatement(sql);
            System.out.println(sql);
            statement.setString(1, "%"+name+"%");
            switch(cases){
                case 1: statement.setString(2, vehLicense); statement.setString(3, dateTime); break;
                case 2: statement.setString(2, vehLicense); break;
                case 3: statement.setString(2, dateTime); break;
            }
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                DriverModel driverModel = new DriverModel(result.getInt(1), result.getInt(2),
                        result.getString(3), result.getString(4), result.getString(5),
                        result.getString(6), result.getString(7));
                driverModels.add(driverModel);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Code : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return driverModels;
    }

    public void insertNewDriver(DriverModel driver){
        try {
            if(conn == null)
            conn = ConnectionDB.getConnection();

            String sql = "INSERT INTO conductor(usu_cc, veh_placa) VALUES(?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, driver.getUserIdFk());
            statement.setString(2, driver.getVehLicenseFk());

            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0)
                JOptionPane.showMessageDialog(null, "New driver successfully inserted.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Code : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void updateDriver(DriverModel driver, int id) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "UPDATE conductor SET usu_cc = ?, veh_placa = ? WHERE usu_cc = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, driver.getUserId());
            statement.setString(2, driver.getVehLicense());
            statement.setInt(3, id);

            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0)
                JOptionPane.showMessageDialog(null, "Driver successfully updated");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Code : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void deleteDriver(int userId) {
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "DELETE FROM conductor WHERE usu_cc=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, userId);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Driver successfully deleted");
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Code : " + ex.getErrorCode()
                    + " Error :" + ex.getMessage());
        }
    }

    public DriverModel getDriverById(int id) {
        DriverModel user = null;
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "SELECT con_cc, usu_nombre, usu_apellido, usu_email, veh_placa, fecha FROM usuario " +
                    "NATURAL JOIN conductor JOIN viaje ON viaje.con_cc = usuario.usu_cc " +
                    "NATURAL JOIN vehiculo WHERE con_cc = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                user = new DriverModel(result.getInt(1), result.getString(2), result.getString(3),
                        result.getString(4), result.getString(5), result.getString(6));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Code : " + ex.getErrorCode()
                    + " Error :" + ex.getMessage());
        }
        return user;
    }

}
