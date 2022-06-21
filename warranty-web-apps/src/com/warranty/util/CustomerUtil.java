package com.warranty.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;

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
			
			Date purchasedDate = temp.getPurchaseDate();
			
			System.out.println("purchased date = " + purchasedDate );
			
			LocalDate localDate = purchasedDate.toInstant()
				      .atZone(ZoneId.systemDefault())
				      .toLocalDate();
			
			System.out.println("warranty to be addded = " + temp.getWarrantyInMonth());
			
			localDate = localDate.plusMonths(temp.getWarrantyInMonth());
			
			System.out.println("Expired date calculated = " +localDate);
			
			expiryDate.add(java.sql.Date.valueOf(localDate));
			
		}
		
		
		
		return expiryDate;
	}
	
	
	
	

}
