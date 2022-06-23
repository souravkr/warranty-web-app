package com.warranty.service;

import java.util.List;

import com.warranty.entity.Brand;
import com.warranty.entity.Product;

public interface ProductService {
	
	public List<Product> getProductList();

	public List<Brand> getBrandList();

	public void addProduct(Product product);

	public Brand getBrandById(int bid);

	public Product getProductById(int id);

	public void deleteProductById(int id);

}
