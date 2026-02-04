package database.tests;

import database.ProductDAO;
import model.FreshProduct;

public class TestInsert {
    public static void main(String[] args) {
// Create staff object
        FreshProduct product = new FreshProduct(1, "Apples", 300, 3, "11-02-2026", 4);
// Insert into database
        ProductDAO dao = new ProductDAO();
        dao.insertFreshProduct(product);
// Check in pgAdmin or psql:
// SELECT * FROM staff;
    }
}