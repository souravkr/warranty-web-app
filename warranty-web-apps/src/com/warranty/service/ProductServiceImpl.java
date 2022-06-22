package com.warranty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.warranty.dao.ProductDAO;
import com.warranty.entity.Brand;
import com.warranty.entity.Product;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO productDao;
	
	@Override
	@Transactional
	public List<Product> getProductList() {
		
		return productDao.getProductList();
	}

	@Override
	@Transactional
	public List<Brand> getBrandList() {
		
		return productDao.getBrandList();
	}

	@Override
	@Transactional
	public void addProduct(Product product) {
		productDao.addProduct(product);
		
	}

}
