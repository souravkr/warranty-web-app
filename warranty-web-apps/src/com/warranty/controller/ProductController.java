package com.warranty.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.warranty.entity.Brand;
import com.warranty.entity.Product;
import com.warranty.service.ProductService;
import com.warranty.util.CustomerUtil;

@Controller
@RequestMapping("/product")
public class ProductController {

	private static final String UPLOAD_DIRECTORY = "/images";

	@Autowired
	ProductService productservice;

	@Autowired
	CustomerUtil customerUtil;

	@GetMapping("/productList")
	public String displayListOfProducts(Model model) {

		List<Product> productList = productservice.getProductList();

		List<String> imageUrlList = customerUtil.getImageURL(productList);

		List<Date> expireyDate = customerUtil.getExpirtyDate(productList);

		List<Integer> productStatusList = customerUtil.getProductStatus(expireyDate);

		List<Brand> brandList = customerUtil.getBrandList(productList);

		System.out.println(productList.get(0).getProductBrand().getName());

		model.addAttribute("products", productList);

		model.addAttribute("imageName", imageUrlList);

		model.addAttribute("expiryDate", expireyDate);

		model.addAttribute("expirtyStatus", productStatusList);

		model.addAttribute("brand", brandList);

		return "home";

	}

	@GetMapping("/showForm")
	public String showForm(Model model) {

		Product product = new Product();

		List<Brand> brandsList = productservice.getBrandList();

		System.out.println(brandsList);

		model.addAttribute("product", product);

		model.addAttribute("brands", brandsList);

		return "register";
	}

	/*
	 * @GetMapping("/addCustomer") public String addCustomer(Model model) { Customer
	 * customer = new Customer(); model.addAttribute("customer",customer); return
	 * "customer-form"; }
	 */

	// , @ModelAttribute("brands") Brand brand

	@PostMapping(value = "/processForm")
	public String processForm(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult,
			@RequestParam CommonsMultipartFile file, HttpSession session,Model model) throws Exception {

		
		 if(bindingResult.hasErrors()) {
		 
		 List<Brand> brandsList = productservice.getBrandList();
		 
		  System.out.println(brandsList);
		  
		 model.addAttribute("brands",brandsList); 
		 return "register";
		  
		 }
		 

		if (file.isEmpty() == false) {
			System.out.println("-------File is blank");
			String filename = customerUtil.getUniqueFileName(file);
			product.setInvoice(filename);
			productservice.writeFile(file, session, filename);
		}

		Brand brand = productservice.getBrandById(product.getBid());
		product.setProductBrand(brand);

		productservice.addProduct(product);

		System.out.println("------------add success-----------");

		return "redirect:/product/productList";

	}

	@GetMapping(value = "/updateProduct")
	public String updateProduct(Model model, @RequestParam("id") int id) {

		List<Brand> brandsList = productservice.getBrandList();

		System.out.println(brandsList);

		Product product = productservice.getProductById(id);

		model.addAttribute("product", product);

		model.addAttribute("brands", brandsList);

		return "register";
	}

	@GetMapping(value = "/deleteProduct")
	public String deleteProductById(@RequestParam int id) {

		productservice.deleteProductById(id);

		return "redirect:/product/productList";
	}

}
