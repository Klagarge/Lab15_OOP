package BillGUI;

public class HesSoGarage {
    public static void main(String[] args) {
        GarageManager garageManager = new GarageManager();
        String name = "\033[3mGarage manager\033[0m\nPrestations"; //TODO résoudre en italique
        String logoFilePath = "src/logo_garage.png"; //TODO redimensionnement automatique
        new ManagerGui(name, logoFilePath, garageManager.getServices(), garageManager); //TODO affichage sans redimensionnement
    }
}

