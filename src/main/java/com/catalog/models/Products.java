package com.catalog.models;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Products {
//	private Long id;
	@Id
	private String itemNo;
	private String productName;
	private String amount;
	private String inventoryCode;
	
	
//	public Products(String itemNo) {
//		
//		this.itemNo = itemNo;
//	}
	
	public Products() {
		// TODO Auto-generated constructor stub
	}
	
	public Products(String itemNo, String productName, String amount, String inventoryCode) {
		this.itemNo = itemNo;
		this.productName = productName;
		this.amount = amount;
		this.inventoryCode = inventoryCode;
	}


	public String getItemNo() {
		return itemNo;
	}


	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}


	public String getName() {
		return productName;
	}


	public void setName(String productName) {
		this.productName = productName;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	public String getInventoryCode() {
		return inventoryCode;
	}


	public void setInventoryCode(String inventoryCode) {
		this.inventoryCode = inventoryCode;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Products other = (Products) obj;
		if (itemNo != other.itemNo)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Products [itemNo=" + itemNo + ", name=" + productName + ", amount=" + amount + ", inventoryCode="
				+ inventoryCode + "]";
	}


//	public Long getId() {
//		return id;
//	}
//
//
//	public void setId(Long id) {
//		this.id = id;
//	}





	
	
	
	
	
	
	
}
