package com.warranty.util;


import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.warranty.entity.Brand;
import com.warranty.entity.Product;

@Controller
public class CustomerUtil {

	public List<String> getImageURL(List<Product> productList) {

		List<String> url = new ArrayList<String>();
		
		for(Product temp : productList ) {
			
			url.add(temp.getProductBrand().getImageName());
			
		}
		
		
		return url;
	}

	public List<Date> getExpirtyDate(List<Product> productList) {
		
     List<Date> expiryDate = new ArrayList<Date>();
		
		for(Product temp : productList ) {
			
			Date purchasedDate =  temp.getPurchaseDate();
			
			System.out.println("purchased date = " + purchasedDate );
			
			LocalDate localDate = purchasedDate.toLocalDate();
			
			System.out.println("warranty to be addded = " + temp.getWarrantyInMonth());
			
			localDate = localDate.plusMonths(temp.getWarrantyInMonth());
			
			System.out.println("Expired date calculated = " +localDate);
			
			expiryDate.add(java.sql.Date.valueOf(localDate));
			
		}
		
		
		
		return expiryDate;
	}

	public List<Integer> getProductStatus(List<Date> expireyDate) {
		
		 List<Integer> status = new ArrayList<Integer>();
		
		 // 0 status means expired 1 means in warranty
		 
		for(Date expireDate : expireyDate ) {
			
			System.out.println("Expirty Date " + expireDate);
			
			if(1 > System.currentTimeMillis()) {
				
				System.out.println("Expired");
				status.add(0);			
			}
			
			else {status.add(1);
			System.out.println("active");
			}				
		}		
		return status;
	}

	public List<Brand> getBrandList(List<Product> productList) {
		
	   List<Brand> brand = new ArrayList<Brand>();
		
		for(Product temp : productList ) {
			
			brand.add(temp.getProductBrand());
			
		}
		
		
		return brand;
	}
	
	
	
	

}
