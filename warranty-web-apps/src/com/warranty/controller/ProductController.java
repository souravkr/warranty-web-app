  package com.warranty.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.warranty.entity.Product;
import com.warranty.service.ProductService;
import com.warranty.util.CustomerUtil;


@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productservice;

	@Autowired
	CustomerUtil customerUtil;
	
	@GetMapping("/productList")
	public String displayListOfProducts(Model model) {
		
		List<Product> productList =  productservice.getProductList();
		
		List<String> imageUrlList = customerUtil.getImageURL(productList);
		
		List<Date> expireyDate = customerUtil.getExpirtyDate(productList);
		
		System.out.println(productList.get(0).getProductBrand().getName());
		
		model.addAttribute("products",productList);
		
		model.addAttribute("imageName",imageUrlList);
		
		model.addAttribute("expiryDate",expireyDate);
		
		return "home";
		
	}
	
	
}
