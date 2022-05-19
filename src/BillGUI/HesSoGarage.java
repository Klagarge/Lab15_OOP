package BillGUI;

public class HesSoGarage {
    public static void main(String[] args) {
        GarageManager garageManager = new GarageManager();
        String name = "<html><body><i>Garage manager</i><br>Prestations</body></html>";
        String logoFilePath = "src/logo_garage.png"; //TODO redimensionnement automatique
        new ManagerGui(name, logoFilePath, garageManager.getServices(), garageManager); //TODO affichage sans redimensionnement
    }
}

