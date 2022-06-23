package com.warranty.dao;

import java.util.List;

import com.warranty.entity.Brand;
import com.warranty.entity.Product;

public interface ProductDAO {

	public List<Product> getProductList();

	public List<Brand> getBrandList();

	public void addProduct(Product product);

	public Brand getBrandById(int id);

	public Product getProductByid(int id);

	public void deletProductByid(int id);
	
}
