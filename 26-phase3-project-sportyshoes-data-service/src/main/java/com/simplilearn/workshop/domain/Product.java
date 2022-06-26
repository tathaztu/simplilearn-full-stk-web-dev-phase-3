package com.simplilearn.workshop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID")
	private long longProductId;

	@Column(name = "CATEGORY_ID")
	private long longCategoryId;

	@Column(name = "PRODUCT_NAME")
	private String strProductName;

	@Column(name = "PRICE")
	private float flPrice;

	public long getLongProductId() {
		return longProductId;
	}

	public void setLongProductId(long longProductId) {
		this.longProductId = longProductId;
	}

	public long getLongCategoryId() {
		return longCategoryId;
	}

	public void setLongCategoryId(long longCategoryId) {
		this.longCategoryId = longCategoryId;
	}

	public String getStrProductName() {
		return strProductName;
	}

	public void setStrProductName(String strProductName) {
		this.strProductName = strProductName;
	}

	public float getFlPrice() {
		return flPrice;
	}

	public void setFlPrice(float flPrice) {
		this.flPrice = flPrice;
	}
}
