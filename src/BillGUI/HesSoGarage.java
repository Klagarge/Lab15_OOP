package BillGUI;

public class HesSoGarage {
    public static void main(String[] args) {
        GarageManager garageManager = new GarageManager();
        ManagerGui managerGui;
        String name = "<em>Garage manager</em> <br> Prestations";
        String logoFilePath = "src/logo_garage.png";
        managerGui = new ManagerGui(name, logoFilePath, garageManager.getServices());
    }
}

