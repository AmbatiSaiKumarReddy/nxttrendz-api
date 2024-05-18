package com.example.nxttrendz1.service;

import java.util.ArrayList;
import java.util.List;

import com.example.nxttrendz1.model.Product;
import com.example.nxttrendz1.repository.ProductJpaRepository;
import com.example.nxttrendz1.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here
@Service
public class ProductJpaService implements ProductRepository {

	@Autowired
	private ProductJpaRepository productJpaRepository;

	@Override
	public ArrayList<Product> getProducts() {

		List<Product> productList = productJpaRepository.findAll();
		ArrayList<Product> products = new ArrayList<Product>(productList);

		return products;
	}

	@Override
	public Product getProductById(int productId) {

		try {
			Product product = productJpaRepository.findById(productId).get();
			return product;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public Product addProduct(Product product) {

		productJpaRepository.save(product);

		return product;
	}

	@Override
	public Product updateProduct(int productId, Product product) {

		try {

			Product existingProduct = productJpaRepository.findById(productId).get();

			if (product.getProductName() != null) {
				existingProduct.setProductName(product.getProductName());
			}

			if (product.getPrice() != null) {
				existingProduct.setPrice(product.getPrice());
			}

			productJpaRepository.save(existingProduct);

			return existingProduct;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deleteProduct(int productId) {

		try {
			productJpaRepository.deleteById(productId);
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No Product content");

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

}