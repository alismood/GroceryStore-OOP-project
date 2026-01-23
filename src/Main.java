import menu.Menu;
import menu.Storage;

public class Main {
    public static void main(String[] args) {
        Menu inventorySystem = new Storage();
        inventorySystem.run();
    }
}