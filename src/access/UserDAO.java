package access;

import model.UserModel;
import model.VehicleModel;
import utils.ConnectionDB;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class UserDAO {

    private Connection conn = null;

    public ArrayList<UserModel> getAllUsers(){
        ArrayList<UserModel> userModels = new ArrayList<>();
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "SELECT usu_cc, usu_nombre, usu_apellido, usu_email FROM usuario";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()){
                UserModel user = new UserModel(result.getInt(1), result.getString(2), result.getString(3),
                        result.getString(4) );
                userModels.add(user);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Code : " + ex.getErrorCode()
                    + " Error :" + ex.getMessage());
        }
        return userModels;
    }

    public ArrayList<UserModel> getAllUsersDrivers(){
        ArrayList<UserModel> userModels = new ArrayList<>();
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "SELECT con_cc, usu_nombre as con_nombre, usu_apellido as con_apellido, " +
                    "usu_email as con_email\n" +
                    "FROM usuario\n" +
                    "NATURAL JOIN conductor\n" +
                    "JOIN viaje ON viaje.con_cc = usuario.usu_cc\n" +
                    "NATURAL JOIN vehiculo;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()){
                UserModel user = new UserModel(result.getInt(1), result.getString(2),
                        result.getString(3), result.getString(4)) ;
                userModels.add(user);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Code : " + ex.getErrorCode()
                    + " Error :" + ex.getMessage());
        }
        return userModels;
    }

    public void insertNewUser(UserModel user) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "INSERT INTO usuario(usu_cc, usu_nombre, usu_apellido, usu_email) VALUES(?, ?, ?, ? );";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, user.getUserId());
            statement.setString(2, user.getUserName());
            statement.setString(3, user.getUserSurname());
            statement.setString(4, user.getUserEmail());

            int rowsInserted = statement.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Code : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void updateUser(UserModel user, int idWhere){
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            String sql = "UPDATE usuario SET usu_nombre = ?, usu_apellido =?, usu_email =? WHERE usu_cc=?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getUserSurname());
            statement.setString(3, user.getUserEmail());
            statement.setInt(4, idWhere);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Driver successfully updated");
                System.out.println("User successfully updated");
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Code : " + ex.getErrorCode()
                    + " Error :" + ex.getMessage());
        }
    }

    public void deleteUser(int userId) {
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            String sql = "DELETE FROM usuario WHERE usu_cc=?";

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

    public void reviewForeignKeysOFF() {
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            String sql = "SET FOREIGN_KEY_CHECKS=0;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.executeUpdate();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Code : " + ex.getErrorCode()
                    + " Error :" + ex.getMessage());
        }
    }

    public void reviewForeignKeysON() {
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            String sql = "SET FOREIGN_KEY_CHECKS=1;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.executeUpdate();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Code : " + ex.getErrorCode()
                    + " Error :" + ex.getMessage());
        }
    }
}
