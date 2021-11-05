package view;

import access.UserDAO;
import controller.InitialData;
import model.DriverModel;
import model.UserModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UpdateUser extends JFrame implements ActionListener {

    private JLabel lblUserToUpdate;
    private JComboBox<DriverModel> cbxUserToUpdate;
    private JLabel lblUpdateName;
    private JTextField txtUpdateName;
    private JLabel lblUpdateSurname;
    private JTextField txtUpdateSurname;
    private JLabel lblUpdateEmail;
    private JTextField txtUpdateEmail;
    private JLabel lblUpdateLicense;
    private JTextField txtUpdateLicense;
    private JLabel lblUpdateDate;
    private JTextField txtUpdateDate;

    private JButton btnUpdate;

    public UpdateUser() {
        initComponents();
    }

    private void initComponents() {
        setTitle("My Luber App - Update information");
        setLayout(new GridLayout(10,2));
        InitialData initialData = new InitialData();

        this.lblUserToUpdate = new JLabel("Select the user you want to update then modify the information in the fields   ");
        add(this.lblUserToUpdate);

        this.cbxUserToUpdate = new JComboBox<>();
        this.cbxUserToUpdate.setModel(new DefaultComboBoxModel<>(initialData.getDriverModels()
                .toArray(new DriverModel[initialData.getDriverModels().size()])));
        this.cbxUserToUpdate.setSelectedIndex(0);
        add(this.cbxUserToUpdate);
        ChangeEventUpdate changeEventUpdate = new ChangeEventUpdate(this);
        this.getCbxUserToUpdate().addActionListener(changeEventUpdate);


        this.lblUpdateName = new JLabel("New name");
        add(this.lblUpdateName);

        this.txtUpdateName = new JTextField();
        add(this.txtUpdateName);

        this.lblUpdateSurname = new JLabel("New surname");
        add(this.lblUpdateSurname);

        this.txtUpdateSurname = new JTextField();
        add(this.txtUpdateSurname);

        this.lblUpdateEmail = new JLabel("New email");
        add(this.lblUpdateEmail);

        this.txtUpdateEmail = new JTextField();
        add(this.txtUpdateEmail);

        this.lblUpdateLicense = new JLabel("Car license");
        add(this.lblUpdateLicense);

        this.txtUpdateLicense = new JTextField();
        this.txtUpdateLicense.setEditable(false);
        add(this.txtUpdateLicense);

        this.lblUpdateDate = new JLabel("Trip date");
        add(this.lblUpdateDate);

        this.txtUpdateDate = new JTextField();
        this.txtUpdateDate.setEditable(false);
        add(this.txtUpdateDate);

        this.btnUpdate = new JButton("Update data");
        add(this.btnUpdate);
        this.btnUpdate.addActionListener(this);

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.btnUpdate) {
            int idWhere = ((DriverModel) this.cbxUserToUpdate.getSelectedItem()).getUserId();
            String name = (String) this.txtUpdateName.getText();
            String surname = (String) this.txtUpdateSurname.getText();
            String email = (String) this.txtUpdateEmail.getText();

            UserModel userModel = new UserModel(name, surname, email);

            UserDAO userDAO = new UserDAO();
            userDAO.updateUser(userModel, idWhere);
        }
    }

    public JComboBox<DriverModel> getCbxUserToUpdate() {
        return cbxUserToUpdate;
    }

    public void setCbxUserToUpdate(JComboBox<DriverModel> cbxUserToUpdate) {
        this.cbxUserToUpdate = cbxUserToUpdate;
    }

    public JTextField getTxtUpdateName(String t ) {
        return txtUpdateName;
    }

    public void setTxtUpdateName(String txtUpdateName) {
        this.txtUpdateName.setText(txtUpdateName);
    }

    public JTextField getTxtUpdateSurname() {
        return txtUpdateSurname;
    }

    public void setTxtUpdateSurname(String txtUpdateSurname) {
        this.txtUpdateSurname.setText(txtUpdateSurname);
    }

    public JTextField getTxtUpdateEmail() {
        return txtUpdateEmail;
    }

    public void setTxtUpdateEmail(String txtUpdateEmail) {
        this.txtUpdateEmail.setText(txtUpdateEmail);
    }

    public JLabel getLblUserToUpdate() {
        return lblUserToUpdate;
    }

    public void setLblUserToUpdate(JLabel lblUserToUpdate) {
        this.lblUserToUpdate = lblUserToUpdate;
    }

    public JLabel getLblUpdateLicense() {
        return lblUpdateLicense;
    }

    public void setLblUpdateLicense(JLabel lblUpdateLicense) {
        this.lblUpdateLicense = lblUpdateLicense;
    }

    public JTextField getTxtUpdateLicense() {
        return txtUpdateLicense;
    }

    public void setTxtUpdateLicense(String txtUpdateLicense) {
        this.txtUpdateLicense.setText(txtUpdateLicense);
    }

    public JLabel getLblUpdateDate() {
        return lblUpdateDate;
    }

    public void setLblUpdateDate(JLabel lblUpdateDate) {
        this.lblUpdateDate = lblUpdateDate;
    }

    public JTextField getTxtUpdateDate() {
        return txtUpdateDate;
    }

    public void setTxtUpdateDate(String txtUpdateDate) {
        this.txtUpdateDate.setText(txtUpdateDate);
    }

}
