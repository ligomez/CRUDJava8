package model;

public class VehicleModel {
    private String vehLicense;
    private String vehMake;
    private String vehModel;
    private int vehYear;
    private int vehSeater;
    private String vehColour;
    private int vehKilometers;


    public VehicleModel(String vehLicense, String vehMake, String vehModel, int vehYear, int vehSeater,
                        String vehColour, int vehKilometers) {
        this.vehLicense = vehLicense;
        this.vehMake = vehMake;
        this.vehModel = vehModel;
        this.vehYear = vehYear;
        this.vehSeater = vehSeater;
        this.vehColour = vehColour;
        this.vehKilometers = vehKilometers;
    }

    public VehicleModel(String vehLicense) {
        this.vehLicense = vehLicense;
    }

    public String getVehLicense() {
        return vehLicense;
    }

    public void setVehLicense(String vehLicense) {
        this.vehLicense = vehLicense;
    }

    public String getVehMake() {
        return vehMake;
    }

    public void setVehMake(String vehMake) {
        this.vehMake = vehMake;
    }

    public String getVehModel() {
        return vehModel;
    }

    public void setVehModel(String vehModel) {
        this.vehModel = vehModel;
    }

    public int getVehYear() {
        return vehYear;
    }

    public void setVehYear(int vehYear) {
        this.vehYear = vehYear;
    }

    public int getVehSeater() {
        return vehSeater;
    }

    public void setVehSeater(int vehSeater) {
        this.vehSeater = vehSeater;
    }

    public String getVehColour() {
        return vehColour;
    }

    public void setVehColour(String vehColour) {
        this.vehColour = vehColour;
    }

    public int getVehKilometers() {
        return vehKilometers;
    }

    public void setVehKilometers(int vehKilometers) {
        this.vehKilometers = vehKilometers;
    }



    public String toString() {return this.vehLicense;}

}
