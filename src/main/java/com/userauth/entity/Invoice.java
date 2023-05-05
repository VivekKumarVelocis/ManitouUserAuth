package com.userauth.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

 
 

@Entity	
public class Invoice extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	 
	private String supplierGstin;
	private String supplierLegalName;
	private String supplierTradingName;
	private String supplierCity;
	private String supplierAddress1;
	private String supplierAddress2;
	private String supplierState;
	private String supplierPincode;
	private String supplierCountryCode;
	 
	
	private String billingName;
	private String billingTradeName;
	private String billingPOS;
	private String billingGstin;
	private String billingAddress1;
	private String billingAddress2;
	private String billingCity;
	private String billingState;
	private String billingCountryCode;
	
	private String shippingtoName;
	private String shippingtoTradeName;
	private String shippingtoGstin;
	private String shippingtoAddress1;
	private String shippingtoAddress2;
	private String shippingtoPlace;
	private String shippingtoState;
	private String shippingtoStateCode;
	private String shippingtoCountryCode;
	private String shippingtoPincode;
	private String shippingBillDate;
	private String shippingBillNo;
 
	@JsonProperty
	private String TransporterName;
	@JsonProperty
	private String TransporterGSTNo;
	@JsonProperty
	private String TransporterState;
	@JsonProperty
	private String TransporterPin;
	@JsonProperty
	private String TransporterDocNo;
	@JsonProperty
	private String TransporterDocDate;
	@JsonProperty
	private String TransportVehicleNo;
	@JsonProperty
	private String TransportDate;
	 
	
	private String invoiceSubtypeCode;
	private String invoiceNum;
	private String invoiceDate;
	private String plant;
	
	private String productType;
	private String invoiceTypeCode; 	
	
	private String companyName;
	private String companyAddress1;
	private String companyAddress2;
	private String companyCity;
	private String companyState;
	private String companyPincode;
	
	private String portCode;
	private String currencyCode;
	private String cntCode; 
	  
	private String totalInvoiceValue;
	private String orderType;
	private String manitouOrderNo; 
	private String packingListNo; 
	@JsonProperty
	private String CustPoNumber;
	@JsonProperty
	private String CustPoDate;
	private String orderDate;
	
	@OneToMany(targetEntity=InvoiceItemDetails.class,cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="invoice_id")
	private List<InvoiceItemDetails> items;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSupplierGstin() {
		return supplierGstin;
	}

	public void setSupplierGstin(String supplierGstin) {
		this.supplierGstin = supplierGstin;
	}

	public String getSupplierLegalName() {
		return supplierLegalName;
	}

	public void setSupplierLegalName(String supplierLegalName) {
		this.supplierLegalName = supplierLegalName;
	}

	public String getSupplierTradingName() {
		return supplierTradingName;
	}

	public void setSupplierTradingName(String supplierTradingName) {
		this.supplierTradingName = supplierTradingName;
	}

	public String getSupplierCity() {
		return supplierCity;
	}

	public void setSupplierCity(String supplierCity) {
		this.supplierCity = supplierCity;
	}

	public String getSupplierAddress1() {
		return supplierAddress1;
	}

	public void setSupplierAddress1(String supplierAddress1) {
		this.supplierAddress1 = supplierAddress1;
	}

	public String getSupplierAddress2() {
		return supplierAddress2;
	}

	public void setSupplierAddress2(String supplierAddress2) {
		this.supplierAddress2 = supplierAddress2;
	}

	public String getSupplierState() {
		return supplierState;
	}

	public void setSupplierState(String supplierState) {
		this.supplierState = supplierState;
	}

	public String getSupplierPincode() {
		return supplierPincode;
	}

	public void setSupplierPincode(String supplierPincode) {
		this.supplierPincode = supplierPincode;
	}

	public String getSupplierCountryCode() {
		return supplierCountryCode;
	}

	public void setSupplierCountryCode(String supplierCountryCode) {
		this.supplierCountryCode = supplierCountryCode;
	}

	public String getBillingName() {
		return billingName;
	}

	public void setBillingName(String billingName) {
		this.billingName = billingName;
	}

	public String getBillingTradeName() {
		return billingTradeName;
	}

	public void setBillingTradeName(String billingTradeName) {
		this.billingTradeName = billingTradeName;
	}

	public String getBillingPOS() {
		return billingPOS;
	}

	public void setBillingPOS(String billingPOS) {
		this.billingPOS = billingPOS;
	}

	public String getBillingGstin() {
		return billingGstin;
	}

	public void setBillingGstin(String billingGstin) {
		this.billingGstin = billingGstin;
	}

	public String getBillingAddress1() {
		return billingAddress1;
	}

	public void setBillingAddress1(String billingAddress1) {
		this.billingAddress1 = billingAddress1;
	}

	public String getBillingAddress2() {
		return billingAddress2;
	}

	public void setBillingAddress2(String billingAddress2) {
		this.billingAddress2 = billingAddress2;
	}

	public String getBillingCity() {
		return billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	public String getBillingState() {
		return billingState;
	}

	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}

	public String getBillingCountryCode() {
		return billingCountryCode;
	}

	public void setBillingCountryCode(String billingCountryCode) {
		this.billingCountryCode = billingCountryCode;
	}

	public String getShippingtoName() {
		return shippingtoName;
	}

	public void setShippingtoName(String shippingtoName) {
		this.shippingtoName = shippingtoName;
	}

	public String getShippingtoTradeName() {
		return shippingtoTradeName;
	}

	public void setShippingtoTradeName(String shippingtoTradeName) {
		this.shippingtoTradeName = shippingtoTradeName;
	}

	public String getShippingtoGstin() {
		return shippingtoGstin;
	}

	public void setShippingtoGstin(String shippingtoGstin) {
		this.shippingtoGstin = shippingtoGstin;
	}

	public String getShippingtoAddress1() {
		return shippingtoAddress1;
	}

	public void setShippingtoAddress1(String shippingtoAddress1) {
		this.shippingtoAddress1 = shippingtoAddress1;
	}

	public String getShippingtoAddress2() {
		return shippingtoAddress2;
	}

	public void setShippingtoAddress2(String shippingtoAddress2) {
		this.shippingtoAddress2 = shippingtoAddress2;
	}

	public String getShippingtoPlace() {
		return shippingtoPlace;
	}

	public void setShippingtoPlace(String shippingtoPlace) {
		this.shippingtoPlace = shippingtoPlace;
	}

	public String getShippingtoState() {
		return shippingtoState;
	}

	public void setShippingtoState(String shippingtoState) {
		this.shippingtoState = shippingtoState;
	}

	public String getShippingtoStateCode() {
		return shippingtoStateCode;
	}

	public void setShippingtoStateCode(String shippingtoStateCode) {
		this.shippingtoStateCode = shippingtoStateCode;
	}

	public String getShippingtoCountryCode() {
		return shippingtoCountryCode;
	}

	public void setShippingtoCountryCode(String shippingtoCountryCode) {
		this.shippingtoCountryCode = shippingtoCountryCode;
	}

	public String getShippingtoPincode() {
		return shippingtoPincode;
	}

	public void setShippingtoPincode(String shippingtoPincode) {
		this.shippingtoPincode = shippingtoPincode;
	}

	public String getShippingBillDate() {
		return shippingBillDate;
	}

	public void setShippingBillDate(String shippingBillDate) {
		this.shippingBillDate = shippingBillDate;
	}

	public String getShippingBillNo() {
		return shippingBillNo;
	}

	public void setShippingBillNo(String shippingBillNo) {
		this.shippingBillNo = shippingBillNo;
	}

	public String getTransporterName() {
		return TransporterName;
	}

	public void setTransporterName(String transporterName) {
		TransporterName = transporterName;
	}

	public String getTransporterGSTNo() {
		return TransporterGSTNo;
	}

	public void setTransporterGSTNo(String transporterGSTNo) {
		TransporterGSTNo = transporterGSTNo;
	}

	public String getTransporterState() {
		return TransporterState;
	}

	public void setTransporterState(String transporterState) {
		TransporterState = transporterState;
	}

	public String getTransporterPin() {
		return TransporterPin;
	}

	public void setTransporterPin(String transporterPin) {
		TransporterPin = transporterPin;
	}

	public String getTransporterDocNo() {
		return TransporterDocNo;
	}

	public void setTransporterDocNo(String transporterDocNo) {
		TransporterDocNo = transporterDocNo;
	}

	public String getTransporterDocDate() {
		return TransporterDocDate;
	}

	public void setTransporterDocDate(String transporterDocDate) {
		TransporterDocDate = transporterDocDate;
	}

	public String getTransportVehicleNo() {
		return TransportVehicleNo;
	}

	public void setTransportVehicleNo(String transportVehicleNo) {
		TransportVehicleNo = transportVehicleNo;
	}

	public String getTransportDate() {
		return TransportDate;
	}

	public void setTransportDate(String transportDate) {
		TransportDate = transportDate;
	}

	public String getInvoiceSubtypeCode() {
		return invoiceSubtypeCode;
	}

	public void setInvoiceSubtypeCode(String invoiceSubtypeCode) {
		this.invoiceSubtypeCode = invoiceSubtypeCode;
	}

	public String getInvoiceNum() {
		return invoiceNum;
	}

	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getPlant() {
		return plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getInvoiceTypeCode() {
		return invoiceTypeCode;
	}

	public void setInvoiceTypeCode(String invoiceTypeCode) {
		this.invoiceTypeCode = invoiceTypeCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress1() {
		return companyAddress1;
	}

	public void setCompanyAddress1(String companyAddress1) {
		this.companyAddress1 = companyAddress1;
	}

	public String getCompanyAddress2() {
		return companyAddress2;
	}

	public void setCompanyAddress2(String companyAddress2) {
		this.companyAddress2 = companyAddress2;
	}

	public String getCompanyCity() {
		return companyCity;
	}

	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}

	public String getCompanyState() {
		return companyState;
	}

	public void setCompanyState(String companyState) {
		this.companyState = companyState;
	}

	public String getCompanyPincode() {
		return companyPincode;
	}

	public void setCompanyPincode(String companyPincode) {
		this.companyPincode = companyPincode;
	}

	public String getPortCode() {
		return portCode;
	}

	public void setPortCode(String portCode) {
		this.portCode = portCode;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCntCode() {
		return cntCode;
	}

	public void setCntCode(String cntCode) {
		this.cntCode = cntCode;
	}

	public String getTotalInvoiceValue() {
		return totalInvoiceValue;
	}

	public void setTotalInvoiceValue(String totalInvoiceValue) {
		this.totalInvoiceValue = totalInvoiceValue;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getManitouOrderNo() {
		return manitouOrderNo;
	}

	public void setManitouOrderNo(String manitouOrderNo) {
		this.manitouOrderNo = manitouOrderNo;
	}

	public String getPackingListNo() {
		return packingListNo;
	}

	public void setPackingListNo(String packingListNo) {
		this.packingListNo = packingListNo;
	}

	public String getCustPoNumber() {
		return CustPoNumber;
	}

	public void setCustPoNumber(String custPoNumber) {
		CustPoNumber = custPoNumber;
	}

	public String getCustPoDate() {
		return CustPoDate;
	}

	public void setCustPoDate(String custPoDate) {
		CustPoDate = custPoDate;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public List<InvoiceItemDetails> getItems() {
		return items;
	}

	public void setItems(List<InvoiceItemDetails> items) {
		this.items = items;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	 
	
}
