package view;

import access.DriverDAO;
import model.DriverModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeEventUpdate implements ActionListener {
    private UpdateUser updateUser;
    private JTextField txtPrueba;

    public ChangeEventUpdate(UpdateUser updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.updateUser.getCbxUserToUpdate()) {
            DriverDAO driverDAO = new DriverDAO();
            DriverModel driverModel;
            int id = ((DriverModel)this.updateUser.getCbxUserToUpdate().getSelectedItem()).getUserId();
            driverModel = driverDAO.getDriverById(id);

            String name = driverModel.getUserName();
            String surname = driverModel.getUserSurname();
            String email = driverModel.getUserEmail();
            String date = driverModel.getDateTime();
            String license = driverModel.getVehLicense();

            this.updateUser.setTxtUpdateName(name);
            this.updateUser.setTxtUpdateSurname(surname);
            this.updateUser.setTxtUpdateEmail(email);
            this.updateUser.setTxtUpdateLicense(license);
            this.updateUser.setTxtUpdateDate(date);

        }
    }
}
