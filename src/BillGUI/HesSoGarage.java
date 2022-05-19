package BillGUI;

public class HesSoGarage {
    public static void main(String[] args) {
        //Create a new garage
        GarageManager garageManager = new GarageManager();
        String name = "<html><body><i>Garage manager</i><br>Prestations</body></html>";
        String logoFilePath = "src/logo_garage.png";
        //Create a new HMI for calculate and print the bill
        new ManagerGui(name, logoFilePath, garageManager.getServices(), garageManager); 
    }
}

