/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.nxttrendz1.repository;

import com.example.nxttrendz1.model.Product;
import java.util.ArrayList;

public interface ProductRepository {

    public ArrayList<Product> getProducts();

    public Product getProductById(int productId);

    public Product addProduct(Product product);

    public Product updateProduct(int productId, Product product);

    public void deleteProduct(int productId);

}