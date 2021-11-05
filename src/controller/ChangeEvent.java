package controller;

import access.TripDAO;
import model.TripModel;
import model.VehicleModel;
import view.ControlsPanel;
import view.UpdateUser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChangeEvent implements ActionListener {

    private ControlsPanel controlsPanel;

    public ChangeEvent(ControlsPanel controlsPanel){
        this.controlsPanel = controlsPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.controlsPanel.getCbxLicensesList()) {
            TripDAO tripDAO = new TripDAO();
            ArrayList<TripModel> trips = null;
            String vehLicense = ((VehicleModel)this.controlsPanel.getCbxLicensesList().getSelectedItem()).getVehLicense();
            if(vehLicense == "All licenses") {
                trips = tripDAO.getAllTrips();
                trips.add(0, new TripModel(-1, "All dates"));
            }
            else {
                trips = tripDAO.getDateTripsFilteredByLicense(vehLicense);
                trips.add(0, new TripModel(-1, "All dates"));
            }
            this.controlsPanel.setCbxTripsList(trips);
        }
    }
}
