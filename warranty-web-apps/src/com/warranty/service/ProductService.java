package com.warranty.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.warranty.entity.Brand;
import com.warranty.entity.Product;

public interface ProductService {
	
	public List<Product> getProductList();

	public List<Brand> getBrandList();

	public void addProduct(Product product);

	public Brand getBrandById(int bid);

	public Product getProductById(int id);

	public void deleteProductById(int id);

	public void writeFile(CommonsMultipartFile file, HttpSession session, String filename) throws Exception;

}
