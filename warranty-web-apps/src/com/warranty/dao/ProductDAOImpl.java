package com.warranty.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
