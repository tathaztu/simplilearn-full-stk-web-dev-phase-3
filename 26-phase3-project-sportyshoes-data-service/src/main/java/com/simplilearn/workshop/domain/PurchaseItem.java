package com.simplilearn.workshop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PURCHASE_ITEMS")
public class PurchaseItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PURCHASE_ITEM_ID")
	private long longPurchaseItemId;

//	@Column(name = "PURCHASE_ID")
//	private long longPurchaseId;

	@Column(name = "PRODUCT_ID")
	private long longProductId;

	@Column(name = "QUANTITY")
	private int nQuantity;

	@ManyToOne
	@JoinColumn(name = "PURCHASE_ID")
	@JsonIgnore
	private Purchase purchase;

	public PurchaseItem() {}

	public PurchaseItem(long longPurchaseItemId, long longProductId, int nQuantity,
			Purchase purchase) {
		this.longPurchaseItemId = longPurchaseItemId;
		//this.longPurchaseId = longPurchaseId;
		this.longProductId = longProductId;
		this.nQuantity = nQuantity;
		this.purchase = purchase;
	}

	public long getLongPurchaseItemId() {
		return longPurchaseItemId;
	}

	public void setLongPurchaseItemId(long longPurchaseItemId) {
		this.longPurchaseItemId = longPurchaseItemId;
	}

//	public long getLongPurchaseId() {
//		return longPurchaseId;
//	}
//
//	public void setLongPurchaseId(long longPurchaseId) {
//		this.longPurchaseId = longPurchaseId;
//	}

	public long getLongProductId() {
		return longProductId;
	}

	public void setLongProductId(long longProductId) {
		this.longProductId = longProductId;
	}

	public int getnQuantity() {
		return nQuantity;
	}

	public void setnQuantity(int nQuantity) {
		this.nQuantity = nQuantity;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
//
//	@Override
//	public String toString() {
//		return "PurchaseItem [longPurchaseItemId=" + longPurchaseItemId + ", longProductId=" + longProductId
//				+ ", nQuantity=" + nQuantity + ", purchase=" + purchase + "]";
//	}

}
