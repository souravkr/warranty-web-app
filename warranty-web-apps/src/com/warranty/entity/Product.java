package com.warranty.entity;







import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="product")
public class Product {
	
	@ManyToOne()
	@JoinColumn(name="brand_id")
	private Brand productBrand;
	
	@Id
	@Column(name="product_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
    @Column(name="name")
	private String name;
	
    @Column(name="purchase_date")
    private Date purchaseDate;
	
    @Override
	public String toString() {
		return "Product [productBrand=" + productBrand + ", id=" + id + ", name=" + name + ", purchaseDate="
				+ purchaseDate + ", warrantyInMonth=" + warrantyInMonth + ", invoice=" + invoice + "]";
	}

	@Column(name="warranty_in_month")
	private int warrantyInMonth;
	
    @Column(name="invoice")
    private String invoice;

	public Brand getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(Brand productBrand) {
		this.productBrand = productBrand;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public int getWarrantyInMonth() {
		return warrantyInMonth;
	}

	public void setWarrantyInMonth(int warrantyInMonth) {
		this.warrantyInMonth = warrantyInMonth;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public Product(Brand productBrand, String name, Date purchaseDate, int warrantyInMonth, String invoice) {
		super();
		this.productBrand = productBrand;
		this.name = name;
		this.purchaseDate = purchaseDate;
		this.warrantyInMonth = warrantyInMonth;
		this.invoice = invoice;
	}
	
	public Product() {}
	
    
    

}
