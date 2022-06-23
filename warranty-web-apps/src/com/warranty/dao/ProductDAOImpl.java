package com.warranty.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.warranty.entity.Brand;
import com.warranty.entity.Product;


@Repository
public class ProductDAOImpl implements ProductDAO {
	

   @Autowired
   SessionFactory sessionFactory;

	@Override
	public List<Product> getProductList() {
	
		Session session = sessionFactory.getCurrentSession();
		
		List<Product> products = session.createQuery( "from Product",Product.class).getResultList();
		
		return products;
	}

	@Override
	public List<Brand> getBrandList() {
		
		Session session = sessionFactory.getCurrentSession();
		
		List<Brand> brands = session.createQuery("from Brand order by name", Brand.class).getResultList();
		
		return brands;
	}

	@Override
	public void addProduct(Product product) {
		
		Session session = sessionFactory.getCurrentSession();
		
		
		session.save(product);

		
	}

	@Override
	public Brand getBrandById(int id) {
	
		Session session = sessionFactory.getCurrentSession();
		
		return session.get(Brand.class, id);
		
	}
	
	

}
