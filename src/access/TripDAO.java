package access;

import model.TripModel;
import utils.ConnectionDB;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;


public class TripDAO {

    private Connection conn = null;

    public ArrayList<TripModel> getAllTrips(){
        ArrayList<TripModel> tripModels = new ArrayList<>();
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "SELECT via_id, usu_cc, con_cc, fecha FROM viaje;";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                TripModel tripModel = new TripModel(result.getInt(1), result.getInt(2),
                        result.getInt(3), result.getString(4));
                tripModels.add(tripModel);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Code : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return tripModels;
    }

    public ArrayList<TripModel> getAllTripDates(){
        ArrayList<TripModel> tripModels = new ArrayList<>();
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "SELECT via_id, fecha FROM viaje;";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                TripModel tripModel = new TripModel(result.getInt(1), result.getString(2));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Code : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return tripModels;
    }

    public ArrayList<TripModel> getTripsFilteredByDriver(int userIdFk){
        ArrayList<TripModel> tripModels = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "SELECT via_id, usu_cc, con_cc, fecha FROM viaje WHERE con_cc=?;";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, userIdFk);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                TripModel tripModel = new TripModel(result.getInt(1), result.getInt(2), result.getInt(3),
                        result.getString(4) );
                tripModels.add(tripModel);
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return tripModels;
    }

    public ArrayList<TripModel> getDateTripsFilteredByLicense(String vehLicense){
        ArrayList<TripModel> tripModels = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "SELECT fecha " +
                    "FROM usuario " +
                    "NATURAL JOIN conductor " +
                    "JOIN viaje ON viaje.con_cc = usuario.usu_cc " +
                    "NATURAL JOIN vehiculo " +
                    "WHERE veh_placa=? " +
                    "ORDER BY fecha;";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, vehLicense);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                TripModel tripModel = new TripModel(result.getString(1));
                tripModels.add(tripModel);
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return tripModels;
    }

    public ArrayList<TripModel> getTripsFilteredByDate(String dateTime){
        ArrayList<TripModel> tripModels = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "SELECT via_id, usu_cc, con_cc, fecha FROM viaje WHERE fecha=?;";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, dateTime);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                TripModel tripModel = new TripModel(result.getInt(1), result.getInt(2), result.getInt(3),
                        result.getString(4) );
                tripModels.add(tripModel);
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return tripModels;
    }

    public void insertNewTrip(TripModel tripModel) {
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "INSERT INTO viaje(via_id, usu_cc, con_cc, fecha) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, tripModel.getTripId());
            statement.setInt(2, tripModel.getUserIdFk());
            statement.setInt(3, tripModel.getDriverIdFk());
            statement.setString(4, tripModel.getDateTime());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("New vehicle successfully inserted");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Code : " + ex.getErrorCode()
                    + " Error :" + ex.getMessage());
        }
    }

    public void updateTrip(TripModel tripModel, int idWhere) {
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "UPDATE viaje SET usu_cc = ?, con_cc = ?, fecha = ? WHERE con_cc=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, tripModel.getUserIdFk());
            statement.setInt(2, tripModel.getDriverIdFk());
            statement.setString(3, tripModel.getDateTime());
            statement.setInt(4, idWhere);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User successfully updated");
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Code : " + ex.getErrorCode()
                    + " Error :" + ex.getMessage());
        }
    }

    public void deleteTrip(int userId) {
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "DELETE FROM viaje WHERE con_cc=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, userId);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("User successfully deleted");
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Code : " + ex.getErrorCode()
                    + " Error :" + ex.getMessage());
        }
    }
}
