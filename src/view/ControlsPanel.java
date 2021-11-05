package view;

import controller.ChangeEvent;
import controller.ClickEvent;
import controller.InitialData;
import model.DriverModel;
import model.TripModel;
import model.VehicleModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ControlsPanel extends JPanel {

    private JLabel lblCarLicense;
    private JComboBox<VehicleModel> cbxLicensesList;
    private JLabel lblTrips;
    private JComboBox<TripModel> cbxTripsList;
    private JLabel lblName;
    private JTextField txtName;
    private JButton btnSearch;
    private JButton btnAddNewUser;
    private JButton btnUpdateUser;
    private JButton btnDeleteUser;
    private JTable tblResults;
    private JLabel lblRows;
    private int rows;

    public ControlsPanel(ResultsPanel resultsPanel){
        this.tblResults = resultsPanel.getTblResults();
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridLayout(3,1));
        InitialData initialData = new InitialData();

        this.setTblResults(initialData.getDrivers());
        this.rows = getTblResults().getRowCount();

        this.lblCarLicense = new JLabel("Car licenses", JLabel.CENTER);
        add(this.getLblCarLicense());

        this.cbxLicensesList = new JComboBox();
        this.cbxLicensesList.setModel(new DefaultComboBoxModel<>(initialData.getVehicles()
                .toArray(new VehicleModel[initialData.getVehicles().size()])));
        this.cbxLicensesList.setSelectedIndex(0);
        add(this.getCbxLicensesList());
        ChangeEvent changeEvent = new ChangeEvent(this);
        this.getCbxLicensesList().addActionListener(changeEvent);

        this.lblTrips = new JLabel("Trip dates", JLabel.CENTER);
        add(this.getLblTrips());

        this.cbxTripsList = new JComboBox();
        this.setCbxTripsList(initialData.getTrips());
        add(this.getCbxTripsList());

        this.lblName = new JLabel("Driver's name", JLabel.CENTER);
        add(this.getLblName());

        this.txtName = new JTextField();
        add(this.getTxtName());

        this.btnSearch = new JButton("Search");
        add(this.btnSearch);
        ClickEvent clickEvent = new ClickEvent(this);
        this.btnSearch.addActionListener(clickEvent);

        this.lblRows = new JLabel();
        lblRows.setText(" Rows listed: " + rows);
        this.lblRows.setForeground(Color.blue);
        add(this.getLblRows());

        this.btnAddNewUser = new JButton("Add new Driver");
        add(this.getBtnAddNewUser());
        this.getBtnAddNewUser().addActionListener(clickEvent);

        this.btnUpdateUser = new JButton("Update Driver info");
        add(this.getBtnUpdateUser());
        this.getBtnUpdateUser().addActionListener(clickEvent);

        this.btnDeleteUser = new JButton("Delete Driver");
        add(this.getBtnDeleteUser());
        this.getBtnDeleteUser().addActionListener(clickEvent);
    }

    public void setLblRows() {
        this.lblRows.removeAll();
        this.rows = getTblResults().getRowCount();
        this.lblRows.setText("Rows listed: " + rows);
    }

    public void setTblResults(ArrayList<DriverModel> drivers) {
        String[] headers = { "TripId", "DriverId", "DriverName", "DriverSurname", "DriverEmail", "DateTime", "CarLicense"};
        this.tblResults.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResults.setModel(tableModel);
        for(int i=0; i<drivers.size(); i++){
            tableModel.addRow(drivers.get(i).toArray() );
        }
    }

    public JLabel getLblCarLicense() {
        return lblCarLicense;
    }

    public void setLblCarLicense(JLabel lblCarLicense) {
        this.lblCarLicense = lblCarLicense;
    }

    public JComboBox<VehicleModel> getCbxLicensesList() {
        return cbxLicensesList;
    }

    public void setCbxLicensesList(JComboBox<VehicleModel> cbxLicensesList) {
        this.cbxLicensesList = cbxLicensesList;
    }

    public JLabel getLblTrips() {
        return lblTrips;
    }

    public void setLblTrips(JLabel lblTrips) {
        this.lblTrips = lblTrips;
    }

    public JComboBox<TripModel> getCbxTripsList() {
        return cbxTripsList;
    }

    public void setCbxTripsList(ArrayList<TripModel> trips) {
        this.cbxTripsList.setModel(new DefaultComboBoxModel<>(trips.toArray(new TripModel[trips.size()])));
        this.getCbxTripsList().setSelectedIndex(0);
    }

    public JLabel getLblName() {
        return lblName;
    }

    public void setLblName(JLabel lblName) {
        this.lblName = lblName;
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public void setTxtName(JTextField txtName) {
        this.txtName = txtName;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public void setBtnSearch(JButton btnSearch) {
        this.btnSearch = btnSearch;
    }

    public JButton getBtnAddNewUser() {
        return btnAddNewUser;
    }

    public void setBtnAddNewUser(JButton btnAddNewUser) {
        this.btnAddNewUser = btnAddNewUser;
    }

    public JTable getTblResults() {
        return tblResults;
    }

    public JLabel getLblRows() {
        this.rows = getTblResults().getRowCount();
        return lblRows;
    }

    public int getRows() {
        return rows;
    }

    public void setRows() {
        this.rows = getTblResults().getRowCount();
    }

    public JButton getBtnUpdateUser() {
        return btnUpdateUser;
    }

    public void setBtnUpdateUser(JButton btnUpdateUser) {
        this.btnUpdateUser = btnUpdateUser;
    }

    public JButton getBtnDeleteUser() {
        return btnDeleteUser;
    }

    public void setBtnDeleteUser(JButton btnDeleteUser) {
        this.btnDeleteUser = btnDeleteUser;
    }

}
