package com.simplilearn.workshop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_CATEGORY")
public class ProductCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CATEGORY_ID")
	private long longCategoryId;

	@Column(name = "CATEGORY_NAME")
	private String strCategoryName;

	public ProductCategory() {}

	public ProductCategory(String strCategoryName) {
		this.strCategoryName = strCategoryName;
	}

	public long getLongCategoryId() {
		return longCategoryId;
	}

	public void setLongCategoryId(long longCategoryId) {
		this.longCategoryId = longCategoryId;
	}

	public String getStrCategoryName() {
		return strCategoryName;
	}

	public void setStrCategoryName(String strCategoryName) {
		this.strCategoryName = strCategoryName;
	}
}
