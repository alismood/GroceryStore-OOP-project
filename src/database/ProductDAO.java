package database;
import model.FreshProduct;
import model.Product;
import java.util.ArrayList;
import java.util.List;
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
        String sql = "SELECT * FROM freshproduct";

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

    public  boolean updateFreshProduct(FreshProduct product){
        String sql = "UPDATE freshproduct SET name = ?, stockquantity = ?, price = ?, expirationdate = ?, storagetemperature = ? WHERE productid = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1, product.getProductId());
            statement.setString(1, product.getName());
            statement.setInt(2, product.getStockQuantity());
            statement.setDouble(3, product.getPrice());
            statement.setString(4, product.getExpirationDate());
            statement.setDouble(5, product.getStorageTemperature());
            statement.setInt(6, product.getProductId());

            int rowsUpdated = statement.executeUpdate();
            statement.close();

            if (rowsUpdated > 0){
                System.out.println("Product updated: " + product.getName());
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Update failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }

    public FreshProduct getFreshProductById(int productId){
        String sql = "SELECT * FROM freshproduct WHERE productid = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return  null;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, productId);

            ResultSet resultSet =statement.executeQuery();

            if (resultSet.next()){
                FreshProduct product = extractFreshProductFromResulSet(resultSet);

                resultSet.close();
                statement.close();

                if (product != null) {
                    System.out.println("Found Product with ID: " + productId);
                }

                return product;
            }
            System.out.println("No staff with ID: " + productId);

            resultSet.close();
            statement.close();

        } catch (SQLException e){
            System.out.println("Select by ID failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return null;
    }

    private FreshProduct extractFreshProductFromResulSet(ResultSet resultSet) throws SQLException {
        int productId = resultSet.getInt("productid");
        String name = resultSet.getString("name");
        int stockQuantity = resultSet.getInt("stockquantity");
        double price = resultSet.getDouble("price");
        String date = resultSet.getString("expirationdate");
        double temp = resultSet.getDouble("storagetemperature");

        FreshProduct product = null;

        product = new FreshProduct(productId, name, price , stockQuantity, date, temp);
        return product;
    }

    public  boolean deleteFreshProduct(int productId){
        String sql = "DELETE FROM freshproduct WHERE productid = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement =connection.prepareStatement(sql);
            statement.setInt(1,productId);

            int rowsDeleted = statement.executeUpdate();
            statement.close();

            if (rowsDeleted >0) {
                System.out.println("Fresh Product deleted with ID: " + productId);
                return true;
            } else {
                System.out.println("No Fresh Product was deleted with ID: " + productId);
            }

        } catch (SQLException e){
            System.out.println("Delete failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }

    public List<FreshProduct> searchByName(String name){
        List<FreshProduct> freshProductList = new ArrayList<>();

        String sql = "SELECT * FROM freshproduct WHERE name ILIKE ? ORDER BY name";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return freshProductList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                FreshProduct freshProduct = extractFreshProductFromResulSet(resultSet);
                if (freshProduct != null) {
                    freshProductList.add(freshProduct);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("Found " + freshProductList.size() + "fresh products");
        } catch (SQLException e){
            System.out.println("Search failed");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return freshProductList;
    }

    public List<FreshProduct> searchByPriceRange(double minPrice, double maxPrice){
        List<FreshProduct> freshProductList = new ArrayList<>();

        String sql = "SELECT * FROM freshproduct WHERE price BETWEEN ? AND ? ORDER BY price DESC";

        Connection connection = DatabaseConnection.getConnection();
        if(connection==null) return freshProductList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, minPrice);
            statement.setDouble(2, maxPrice);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                FreshProduct freshProduct = extractFreshProductFromResulSet(resultSet);
                if(freshProduct != null){
                    freshProductList.add(freshProduct);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("Found " + freshProductList.size() + " Fresh Products");

        } catch (SQLException e) {
            System.out.println("Search failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return  freshProductList;
    }

    public List<FreshProduct> searchByMinPrice(Double minPrice){
        List<FreshProduct> freshProductList = new ArrayList<>();

        String sql = "SELECT * FROM freshproduct WHERE price >= ? ORDER BY price DESC";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return freshProductList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, minPrice);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                FreshProduct freshProduct = extractFreshProductFromResulSet(resultSet);
                if (freshProduct != null) {
                    freshProductList.add(freshProduct);
                }
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e){
            System.out.println(" Error: search by min price in dao");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return freshProductList;
    }

}
