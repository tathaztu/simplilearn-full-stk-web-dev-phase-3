package com.simplilearn.workshop.domain;

public class ProductCategory {

	private long longCategoryId;

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
