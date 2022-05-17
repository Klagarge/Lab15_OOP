package BillGUI;

public class App {
    public static void main(String[] args) {
        int rows = 9;
        int cols = 2;
        String name = "Garage manager \n Prestations";
        String logoFilePath = "src/logo_garage.png";
        new ManagerGui(rows, cols, name, logoFilePath);
    }
}
