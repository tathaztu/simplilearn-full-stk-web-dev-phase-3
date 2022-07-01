package com.simplilearn.workshop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PURCHASE")
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PURCHASE_ID")
	private long longPurchaseId;

	@Column(name = "USER_ID")
	private String strUserId;

	@Column(name = "GROSS_TOTAL")
	private float flGrossTotal;

	@OneToMany(mappedBy = "purchase", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PurchaseItem> listPurchasedItems = new ArrayList<>();

	public Purchase() {}

	public Purchase(long longPurchaseId, String strUserId, float flGrossTotal) {
		super();
		this.longPurchaseId = longPurchaseId;
		this.strUserId = strUserId;
		this.flGrossTotal = flGrossTotal;
	}

	public long getLongPurchaseId() {
		return longPurchaseId;
	}

	public void setLongPurchaseId(long longPurchaseId) {
		this.longPurchaseId = longPurchaseId;
	}

	public String getStrUserId() {
		return strUserId;
	}

	public void setStrUserId(String strUserId) {
		this.strUserId = strUserId;
	}

	public float getFlGrossTotal() {
		return flGrossTotal;
	}

	public void setFlGrossTotal(float flGrossTotal) {
		this.flGrossTotal = flGrossTotal;
	}

	public List<PurchaseItem> getListPurchasedItems() {
		return listPurchasedItems;
	}

	public void setListPurchasedItems(List<PurchaseItem> listPurchasedItems) {
		this.listPurchasedItems = listPurchasedItems;

		this.listPurchasedItems.stream().forEach(e -> e.setPurchase(this));
//		if(null != this.listPurchasedItems) {
//			for(PurchaseItem purchaseItem : this.listPurchasedItems) {
//				purchaseItem.setPurchase(this);
//			}
//		}
	}

//	@Override
//	public String toString() {
//		return "Purchase [longPurchaseId=" + longPurchaseId + ", strUserId=" + strUserId + ", flGrossTotal="
//				+ flGrossTotal + ", listPurchasedItems=" + listPurchasedItems + "]";
//	}


}
