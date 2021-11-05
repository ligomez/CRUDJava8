package controller;

import access.DriverDAO;
import model.DriverModel;
import model.TripModel;
import model.VehicleModel;
import view.AddNewUser;
import view.ControlsPanel;
import view.DeleteUser;
import view.UpdateUser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClickEvent implements ActionListener {

    private ControlsPanel controlsPanel;


    public ClickEvent(ControlsPanel controlsPanel){
        this.controlsPanel = controlsPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.controlsPanel.getBtnSearch()) {
            String vehLicense = ((VehicleModel)this.controlsPanel.getCbxLicensesList().getSelectedItem()).getVehLicense();
            int tripId = ((TripModel)this.controlsPanel.getCbxTripsList().getSelectedItem()).getTripId();
            String dateTrip = ((TripModel)this.controlsPanel.getCbxTripsList().getSelectedItem()).getDateTime();
            String driversName = (String)this.controlsPanel.getTxtName().getText();

            DriverDAO driverDAO = new DriverDAO();
            ArrayList<DriverModel> driverModels = driverDAO.getFilteredDrivers(tripId, vehLicense, driversName, dateTrip);

            this.controlsPanel.setTblResults(driverModels);
            this.controlsPanel.setLblRows();
        }
        else if(actionEvent.getSource() == this.controlsPanel.getBtnAddNewUser()) {
            AddNewUser addNewUser = new AddNewUser();
            addNewUser.setVisible(true);
        }
        else if (actionEvent.getSource() == this.controlsPanel.getBtnUpdateUser()) {
            UpdateUser updateUser = new UpdateUser();
            updateUser.setVisible(true);
        }
        else if (actionEvent.getSource() == this.controlsPanel.getBtnDeleteUser()) {
            DeleteUser deleteUser = new DeleteUser();
            deleteUser.setVisible(true);
        }
    }
}
