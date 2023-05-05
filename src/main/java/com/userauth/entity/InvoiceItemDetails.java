package com.userauth.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="INVOICE_ITEMDETAILS")
public class InvoiceItemDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String siNo;
	private String itemNo;
	private String itemDescription;
	private String hsnCode;
	private String batchName;
	private String barcode;
	private String quantity; 
	private String uqc;
	private String rate;
	private String itemTotal;
	private String ordlineref;
	private String originCountry; 
	private String Machine_No;
	private String engine_no;
	private String Chasis_no;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSiNo() {
		return siNo;
	}
	public void setSiNo(String siNo) {
		this.siNo = siNo;
	}
	public String getItemNo() {
		return itemNo;
	}
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getHsnCode() {
		return hsnCode;
	}
	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUqc() {
		return uqc;
	}
	public void setUqc(String uqc) {
		this.uqc = uqc;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getItemTotal() {
		return itemTotal;
	}
	public void setItemTotal(String itemTotal) {
		this.itemTotal = itemTotal;
	}
	public String getOrdlineref() {
		return ordlineref;
	}
	public void setOrdlineref(String ordlineref) {
		this.ordlineref = ordlineref;
	}
	public String getOriginCountry() {
		return originCountry;
	}
	public void setOriginCountry(String originCountry) {
		this.originCountry = originCountry;
	}
	public String getMachine_No() {
		return Machine_No;
	}
	public void setMachine_No(String machine_No) {
		Machine_No = machine_No;
	}
	public String getEngine_no() {
		return engine_no;
	}
	public void setEngine_no(String engine_no) {
		this.engine_no = engine_no;
	}
	public String getChasis_no() {
		return Chasis_no;
	}
	public void setChasis_no(String chasis_no) {
		Chasis_no = chasis_no;
	}
	
	
	
}
