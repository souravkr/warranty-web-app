  package com.warranty.controller;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.warranty.entity.Brand;
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
		
		List<Integer> productStatusList = customerUtil.getProductStatus(expireyDate);
		
		List<Brand> brandList = customerUtil.getBrandList(productList);
		
		System.out.println(productList.get(0).getProductBrand().getName());
		
		model.addAttribute("products",productList);
		
		model.addAttribute("imageName",imageUrlList);
		
		model.addAttribute("expiryDate",expireyDate);
		
		model.addAttribute("expirtyStatus",productStatusList);
		
		model.addAttribute("brand",brandList);
		
		return "home";
		
	}
	
	@GetMapping("/showForm")
	public String showForm(Model model) {
		
		Product product = new Product();
		
		List<Brand> brandsList = productservice.getBrandList();
		
		System.out.println(brandsList);	
		
		model.addAttribute("product", product);
		
		int i = 0;
		
		model.addAttribute("br",i );
		
	    model.addAttribute("brands",brandsList);
		
		return "register";
	}
	
	/*
	 * @GetMapping("/addCustomer") public String addCustomer(Model model) { Customer
	 * customer = new Customer(); model.addAttribute("customer",customer); return
	 * "customer-form"; }
	 */
	
	//, @ModelAttribute("brands") Brand brand
	
	@GetMapping(value = "/processForm")
	public String processForm(@ModelAttribute("product") Product product) {
		
		Brand brand = productservice.getBrandById(product.getBid());
		System.out.println("Brand to store is  " + brand);
		
		product.setProductBrand(brand);
		productservice.addProduct(product);
		
		System.out.println("------------add success-----------");
		
		System.out.println("productus  = " + product);
		
		return "redirect:/product/productList";
		
	}
	
	
	/*
	 * @GetMapping("/processForm") public String processForm(@ModelAttribute Product
	 * product) { System.out.println("Inside process from");
	 * 
	 * productservice.addProduct(product); System.out.println("add success");
	 * System.out.println(product);
	 * 
	 * return "redirect:/product/productList"; }
	 */
	
}
