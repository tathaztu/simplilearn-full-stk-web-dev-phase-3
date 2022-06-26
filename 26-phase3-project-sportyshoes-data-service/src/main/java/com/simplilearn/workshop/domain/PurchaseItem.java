package com.simplilearn.workshop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PURCHASE_ITEMS")
public class PurchaseItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PURCHASE_ITEM_ID")
	private long longPurchaseItemId;

	@Column(name = "PURCHASE_ID")
	private long longPurchaseId;

	@Column(name = "PRODUCT_ID")
	private long longProductId;

	@Column(name = "QUANTITY")
	private int nQuantity;

	@ManyToOne
	private Purchase purchase;

	public PurchaseItem() {}

	public PurchaseItem(long longPurchaseItemId, long longPurchaseId, long longProductId, int nQuantity,
			Purchase purchase) {
		this.longPurchaseItemId = longPurchaseItemId;
		this.longPurchaseId = longPurchaseId;
		this.longProductId = longProductId;
		this.nQuantity = nQuantity;
		this.purchase = purchase;
	}

	public long getLongPurchaseItemId() {
		return longPurchaseItemId;
	}

	public long getLongPurchaseId() {
		return longPurchaseId;
	}

	public long getLongProductId() {
		return longProductId;
	}

	public int getnQuantity() {
		return nQuantity;
	}

	public Purchase getPurchase() {
		return purchase;
	}

}
