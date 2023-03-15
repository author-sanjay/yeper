package com.example.yeper.yeper.entity;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Deals {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	public String product_name;
	@Column(length = 5000)
	public String description;
	public long actual_price;
	public long offer_price;
	public String card;
	public long user_earning;
	public long phonenumber;
	public String photourl;
	public int countleft;
	public boolean active;
	public String offerlink;
	public String platform;
	public String name;

	public String deliverto;
	public String addresssfordelivery;
	public long pincode;

	public String offerdetails;



	@OneToMany(mappedBy = "deals",cascade = CascadeType.ALL)
	public List<Orders> orders;
	public Deals() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Deals(long id, String product_name, String description, long actual_price, long offer_price, String card, long user_earning, long phonenumber, String photourl, int countleft, boolean active, String offerlink, String platform, String name, String deliverto, String addresssfordelivery, long pincode, String offerdetails, List<Orders> orders) {
		this.id = id;
		this.product_name = product_name;
		this.description = description;
		this.actual_price = actual_price;
		this.offer_price = offer_price;
		this.card = card;
		this.user_earning = user_earning;
		this.phonenumber = phonenumber;
		this.photourl = photourl;
		this.countleft = countleft;
		this.active = active;
		this.offerlink = offerlink;
		this.platform = platform;
		this.name = name;
		this.deliverto = deliverto;
		this.addresssfordelivery = addresssfordelivery;
		this.pincode = pincode;
		this.offerdetails = offerdetails;
		this.orders = orders;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getActual_price() {
		return actual_price;
	}

	public void setActual_price(long actual_price) {
		this.actual_price = actual_price;
	}

	public long getOffer_price() {
		return offer_price;
	}

	public void setOffer_price(long offer_price) {
		this.offer_price = offer_price;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public long getUser_earning() {
		return user_earning;
	}

	public void setUser_earning(long user_earning) {
		this.user_earning = user_earning;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getPhotourl() {
		return photourl;
	}

	public void setPhotourl(String photourl) {
		this.photourl = photourl;
	}

	public int getCountleft() {
		return countleft;
	}

	public void setCountleft(int countleft) {
		this.countleft = countleft;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getOfferlink() {
		return offerlink;
	}

	public void setOfferlink(String offerlink) {
		this.offerlink = offerlink;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeliverto() {
		return deliverto;
	}

	public void setDeliverto(String deliverto) {
		this.deliverto = deliverto;
	}

	public String getAddresssfordelivery() {
		return addresssfordelivery;
	}

	public void setAddresssfordelivery(String addresssfordelivery) {
		this.addresssfordelivery = addresssfordelivery;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public String getOfferdetails() {
		return offerdetails;
	}

	public void setOfferdetails(String offerdetails) {
		this.offerdetails = offerdetails;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
}
