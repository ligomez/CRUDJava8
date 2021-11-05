package view;

import access.DriverDAO;
import access.TripDAO;
import access.UserDAO;
import access.VehicleDAO;
import controller.InitialData;
import model.DriverModel;
import model.TripModel;
import model.UserModel;
import model.VehicleModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNewUser extends JFrame implements ActionListener {
    private JLabel lblId;
    private JTextField txtId;
    private JLabel lblName;
    private JTextField txtName;
    private JLabel lblSurname;
    private JTextField txtSurname;
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JLabel lblLicense;
    private JTextField txtLicense;
    private JLabel lblDate;
    private JTextField txtDate;
    private JLabel lblPassengerId;
    private JComboBox<UserModel> cbxPassengerId;
    private JButton btnInsertNewUser;

    public AddNewUser() {
        initComponents();
    }

    private void initComponents() {
        setTitle("My Luber App - Add New Driver");
        setLayout(new GridLayout(8,2));
        InitialData initialData = new InitialData();

        this.lblId = new JLabel("Driver Id");
        add(this.lblId);
        this.txtId = new JTextField();
        add(this.txtId);

        this.lblName = new JLabel("Driver Name");
        add(this.lblName);
        this.txtName = new JTextField();
        add(this.txtName);

        this.lblSurname = new JLabel("Driver Surname");
        add(this.lblSurname);
        this.txtSurname = new JTextField();
        add(this.txtSurname);

        this.lblEmail = new JLabel("Driver Email");
        add(this.lblEmail);
        this.txtEmail = new JTextField();
        add(this.txtEmail);

        this.lblLicense = new JLabel("Car License");
        add(this.lblLicense);
        this.txtLicense = new JTextField();
        add(this.txtLicense);

        this.lblDate = new JLabel("Trip date (YYYY-MM-DD HH:MM:SS)");
        add(this.lblDate);
        this.txtDate = new JTextField();
        add(this.txtDate);

        this.lblPassengerId = new JLabel("Passenger Id");
        add(this.lblPassengerId);

        this.cbxPassengerId = new JComboBox<>();
        this.cbxPassengerId.setModel(new DefaultComboBoxModel<>(initialData.getUsers()
                .toArray(new UserModel[initialData.getUsers().size()])));
        this.cbxPassengerId.setSelectedIndex(0);
        add(this.cbxPassengerId);

        this.btnInsertNewUser = new JButton("Add new Driver");
        add(this.btnInsertNewUser);
        this.btnInsertNewUser.addActionListener(this);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.btnInsertNewUser) {
            int id = Integer.parseInt((String) this.txtId.getText());
            String name = (String) this.txtName.getText();
            String surname = (String) this.txtSurname.getText();
            String email = (String) this.txtEmail.getText();
            String license = (String) this.txtLicense.getText();
            String date = (String) this.txtDate.getText();
            int passengerId = ((UserModel)this.cbxPassengerId.getSelectedItem()).getUserId();

            UserModel userModel = new UserModel(id,name,surname,email);
            VehicleModel vehicleModel = new VehicleModel(license);
            DriverModel driverModel = new DriverModel(id, license);
            TripModel tripModel = new TripModel(passengerId, id, date);

            UserDAO userDAO = new UserDAO();
            userDAO.insertNewUser(userModel);

            VehicleDAO vehicleDAO = new VehicleDAO();
            vehicleDAO.insertNewVehicle(vehicleModel);

            DriverDAO driverDAO = new DriverDAO();
            driverDAO.insertNewDriver(driverModel);

            TripDAO tripDAO = new TripDAO();
            tripDAO.insertNewTrip(tripModel);
        }
    }
}
