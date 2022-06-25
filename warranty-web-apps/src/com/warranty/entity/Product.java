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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;



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
    @NotNull(message="Name is required")
    @Size(min=1, max=20,message="Name should be min of length 1 and max of 20")
	private String name;
	
    @Column(name="purchase_date")
    @PastOrPresent
    private Date purchaseDate;
	
    @Transient 
    private int bid;

	@Override
	public String toString() {
		return "Product [productBrand=" + productBrand + ", id=" + id + ", name=" + name + ", purchaseDate="
				+ purchaseDate + ", warrantyInMonth=" + warrantyInMonth + ", invoice=" + invoice + ", bid=" + bid + "]";
	}

	@Column(name="warranty_in_month")
	@NotNull(message="Warrany could not be Blank")
	private Integer warrantyInMonth;
	
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

	public Integer getWarrantyInMonth() {
		return warrantyInMonth;
	}

	public void setWarrantyInMonth(Integer warrantyInMonth) {
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
	
	

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}
    

}
