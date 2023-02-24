package com.example.yeper.yeper.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Users {

	@Id
	public String uid;

	public String password;
	public String role;
	public String name;

	public String email;

	public String phonenumber;

	public String address;

	public String referalCode;

	public boolean isuser;

	public String referralof;

	public String acnumber;

	public String bankname;

	public String idfc;

	public String photo;

	public String gst;
	public String pan;

	public String upi;

	public float referralcontribution;

	public String accountholdername;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	public List<Orders> orders;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	public Wallet wallet;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	public List<Referrals> referrals;

	@ManyToMany(cascade = CascadeType.ALL)
	// @JsonIgnore
	public List<Cards> cards;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(String uid, String password, String role, String name, String email, String phonenumber, String address, String referalCode, boolean isuser, String referralof, String acnumber, String bankname, String idfc, String photo, String gst, String pan, String upi, float referralcontribution, String accountholdername, List<Orders> orders, Wallet wallet, List<Referrals> referrals, List<Cards> cards) {
		this.uid = uid;
		this.password = password;
		this.role = role;
		this.name = name;
		this.email = email;
		this.phonenumber = phonenumber;
		this.address = address;
		this.referalCode = referalCode;
		this.isuser = isuser;
		this.referralof = referralof;
		this.acnumber = acnumber;
		this.bankname = bankname;
		this.idfc = idfc;
		this.photo = photo;
		this.gst = gst;
		this.pan = pan;
		this.upi = upi;
		this.referralcontribution = referralcontribution;
		this.accountholdername = accountholdername;
		this.orders = orders;
		this.wallet = wallet;
		this.referrals = referrals;
		this.cards = cards;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getReferalCode() {
		return referalCode;
	}

	public void setReferalCode(String referalCode) {
		this.referalCode = referalCode;
	}

	public boolean isIsuser() {
		return isuser;
	}

	public void setIsuser(boolean isuser) {
		this.isuser = isuser;
	}

	public String getReferralof() {
		return referralof;
	}

	public void setReferralof(String referralof) {
		this.referralof = referralof;
	}

	public String getAcnumber() {
		return acnumber;
	}

	public void setAcnumber(String acnumber) {
		this.acnumber = acnumber;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getIdfc() {
		return idfc;
	}

	public void setIdfc(String idfc) {
		this.idfc = idfc;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getGst() {
		return gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getUpi() {
		return upi;
	}

	public void setUpi(String upi) {
		this.upi = upi;
	}

	public float getReferralcontribution() {
		return referralcontribution;
	}

	public void setReferralcontribution(float referralcontribution) {
		this.referralcontribution = referralcontribution;
	}

	public String getAccountholdername() {
		return accountholdername;
	}

	public void setAccountholdername(String accountholdername) {
		this.accountholdername = accountholdername;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public List<Referrals> getReferrals() {
		return referrals;
	}

	public void setReferrals(List<Referrals> referrals) {
		this.referrals = referrals;
	}

	public List<Cards> getCards() {
		return cards;
	}

	public void setCards(List<Cards> cards) {
		this.cards = cards;
	}
}
