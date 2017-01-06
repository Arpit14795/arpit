package com.psl.bean;

import com.psl.enums.ProductType;

public abstract class Product {

	private int productId;
	private int serialNo;
	private String productName;
	
	private ProductType category;
	
	public ProductType getCategory() {
		return category;
	}

	public void setCategory(ProductType category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", serialNo=" + serialNo
				+ ", productName=" + productName + ", category=" + category
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result + productId;
		result = prime * result
				+ ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + serialNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (category != other.category)
			return false;
		if (productId != other.productId)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (serialNo != other.serialNo)
			return false;
		return true;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

}
