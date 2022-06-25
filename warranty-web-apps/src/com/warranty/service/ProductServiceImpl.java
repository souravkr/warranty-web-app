package com.warranty.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.warranty.dao.ProductDAO;
import com.warranty.entity.Brand;
import com.warranty.entity.Product;
import com.warranty.filestore.FileOperations;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO productDao;
	
	@Autowired
	FileOperations fileOperation;
	
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

	@Override
	@Transactional
	public Brand getBrandById(int bid) {
		// TODO Auto-generated method stub
		return productDao.getBrandById(bid);
	}

	@Override
	@Transactional
	public Product getProductById(int id) {
		
		return productDao.getProductByid(id);
	}

	@Override
	@Transactional
	public void deleteProductById(int id) {
		productDao.deletProductByid(id);
		
	}

	@Override
	public void writeFile(CommonsMultipartFile file, HttpSession session, String fileName) throws Exception {
		 fileOperation.writeFile(file,session,fileName);
		
	}

}
