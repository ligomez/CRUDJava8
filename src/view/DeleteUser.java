package view;

import access.DriverDAO;
import access.TripDAO;
import access.UserDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteUser extends JFrame implements ActionListener {

    private JLabel lblIntro;
    private JTextField txtUserIdDelete;
    private JButton btnDeleteUser;

    public DeleteUser() {
        initComponents();
    }

    private void initComponents() {
        setTitle("My Luber App - Delete Driver");
        setLayout(new GridLayout(10,2));

        this.lblIntro = new JLabel("\nPlease enter Id number from the driver you want to delete.");
        add(this.lblIntro);

        this.txtUserIdDelete = new JTextField();
        add(this.txtUserIdDelete);

        this.btnDeleteUser = new JButton("Delete User");
        add(this.btnDeleteUser);
        this.btnDeleteUser.addActionListener(this);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.btnDeleteUser) {
            int id = Integer.parseInt((String) this.txtUserIdDelete.getText());

            TripDAO tripDAO = new TripDAO();
            tripDAO.deleteTrip(id);

            DriverDAO driverDAO = new DriverDAO();
            driverDAO.deleteDriver(id);

            UserDAO userDAO = new UserDAO();
            userDAO.deleteUser(id);
        }
    }
}
