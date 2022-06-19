package com.warranty.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="brand")
public class Brand {

	@Id
	@Column(name="brand_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int brandId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="year")
	private String year;
	
	@Column(name="origin")
	private String origin;
	
	@Column(name="service_ceneter")
	private String serviceCeneter;
	
	@Column(name="toll_number")
	private String tollNumber;

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getServiceCeneter() {
		return serviceCeneter;
	}

	public void setServiceCeneter(String serviceCeneter) {
		this.serviceCeneter = serviceCeneter;
	}

	public String getTollNumber() {
		return tollNumber;
	}

	public void setTollNumber(String tollNumber) {
		this.tollNumber = tollNumber;
	}

	public Brand(String name, String year, String origin, String serviceCeneter, String tollNumber) {
		super();
		this.name = name;
		this.year = year;
		this.origin = origin;
		this.serviceCeneter = serviceCeneter;
		this.tollNumber = tollNumber;
	}

	@Override
	public String toString() {
		return "Brand [brandId=" + brandId + ", name=" + name + ", year=" + year + ", origin=" + origin
				+ ", serviceCeneter=" + serviceCeneter + ", tollNumber=" + tollNumber + "]";
	}
	
	public Brand() {}
	
	
}
