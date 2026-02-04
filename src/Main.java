import menu.Menu;
import menu.Storage;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        Menu inventorySystem = new Storage();
        inventorySystem.run();
    }
}