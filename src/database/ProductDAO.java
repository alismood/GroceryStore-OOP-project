package database;
import model.FreshProduct;
import model.Product;

import java.sql.*;

public class ProductDAO {
    public void insertFreshProduct(FreshProduct product){
        String sql = "INSERT INTO freshproduct (productid, name, stockquantity, price, expirationdate, storagetemperature) VALUES (?, ?, ?, ?, ?, ?)";
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, product.getProductId());
            statement.setString(2, product.getName());
            statement.setInt(3, product.getStockQuantity());
            statement.setDouble(4, product.getPrice());
            statement.setString(5, product.getExpirationDate());
            statement.setDouble(6, product.getStorageTemperature());

            int rowInserted = statement.executeUpdate();

            if (rowInserted > 0){
                System.out.println("Product inserted successfully");
            }
            statement.close();
        } catch (SQLException e){
            System.out.println("Insert failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public void getAllFreshProduct(){
        String sql = "SELECT * FROM FreshProduct";

        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("\n--- ALL PRODUCT FROM DATABASE ---");

            while (resultSet.next()){
                int id = resultSet.getInt("productid");
                String name = resultSet.getString("name");
                int quantity = resultSet.getInt("stockquantity");
                double price = resultSet.getDouble("price");
                String date = resultSet.getString("expirationdate");
                double temp = resultSet.getDouble("storagetemperature");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Quantity: " + quantity);
                System.out.println("Price: " + price);
                System.out.println("ExpirationDate: " + date);
                System.out.println("StorageTemp: " + temp);
                System.out.println("_________");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Select failed");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
}
