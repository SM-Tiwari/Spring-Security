package com.gnv.vnm.selfcare.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * <pre>
 * id.gnvsolution.d3.api.model.RptInvoiceSummary
 * </pre>
 *
 * @author edwin < edwinkun at gmail dot com > May 7, 2017 2:21:47 PM
 *
 */
@Entity
@Table(name = "RPT_INVOICE_SUMMARY")
//, indexes = { @Index(columnList = "MSISDN"), @Index(columnList = "INVOICEDATE"), @Index(columnList = "STARTPERIOD") }
@SequenceGenerator(name = "RPT_INVOICE_SUMMARY_SEQ", sequenceName = "RPT_INVOICE_SUMMARY_SEQ", allocationSize = 1)
public class RptInvoiceSummary implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RPT_INVOICE_SUMMARY_SEQ")
	private Integer id;

	@Column(name = "INVOICEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date invoicedate;
	
	@Column(name = "MSISDN")
	private String msisdn;
	
	@Column(name = "INVOICENUMBER")
	private String invoicenumber;
	
	@Column(name = "ACCOUNTNUMBER")
	private String accountnumber;
	
	@Column(name = "CUSTOMERTYPE")
	private String customertype;
	
	@Column(name = "CREDITLIMIT")
	private Double creditlimit = 0.0;
	
	@Column(name = "CALLINGPLAN")
	private String callingplan;
	
	@Column(name = "ACCOUNTNAME")
	private String accountname;
	
	@Column(name = "SUMMARYCORPID")
	private String summarycorpid;
	
	@Column(name = "CONTRACTNUM")
	private String contractnum;
	
	@Column(name = "TAXID")
	private String taxid;
	
	@Column(name = "ADDRESSNAME")
	private String addressname;
	
	@Column(name = "ADDRESS1")
	private String address1;
	
	@Column(name = "ADDRESS2")
	private String address2;
	
	@Column(name = "ADDRESS3")
	private String address3;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "POSTCODE")
	private String postcode;
	
	@Column(name = "STARTPERIOD")
	private Date startperiod;
	
	@Column(name = "ENDPERIOD")
	private Date endperiod;
	
	@Column(name = "DEPOSITMONEY")
	private Double depositmoney = 0.0;
	
	@Column(name = "LASTMONTHBILL")
	private Double lastmonthbill = 0.0;
	
	@Column(name = "PAYMENTRECEIVED")
	private Double paymentreceived = 0.0;
	
	@Column(name = "OUTSTANDINGBILLING")
	private Double outstandingbilling = 0.0;
	
	@Column(name = "EXCESSPAYMENT")
	private Double excesspayment = 0.0;
	
	@Column(name = "BALANCEBROUGHTFORWARD")
	private Double balancebroughtforward = 0.0;
	
	@Column(name = "THISMONTHBILL")
	private Double thismonthbill = 0.0;
	
	@Column(name = "TOTALDUE")
	private Double totaldue = 0.0;
	
	@Column(name = "INVOICEDUEDATE")
	private Date invoiceduedate;
	
	@Column(name = "MONTHLYFEE")
	private Double monthlyfee = 0.0;
	
	@Column(name = "FITURDATA")
	private String fiturdata;
	
	@Column(name = "FITURCALLBARING")
	private String fiturcallbaring;
	
	@Column(name = "DETAILRECORD")
	private String detailrecord;
	
	@Column(name = "LOCALCHARGES")
	private Double localcharges = 0.0;
	
	@Column(name = "LONGDISTANCE")
	private Double longdistance = 0.0;
	
	@Column(name = "IDDCHARGES")
	private Double iddcharges = 0.0;
	
	@Column(name = "IRCHARGES")
	private Double ircharges = 0.0;
	
	@Column(name = "VIDEOCHARGES")
	private Double videocharges = 0.0;
	
	@Column(name = "MMSCHARGES")
	private Double mmscharges = 0.0;
	
	@Column(name = "DATACHARGES")
	private Double datacharges = 0.0;
	
	@Column(name = "PLANET3CHARGES")
	private Double planet3charges = 0.0;
	
	@Column(name = "SMSCHARGES")
	private Double smscharges = 0.0;
	
	@Column(name = "TOTALCHARGE")
	private Double totalcharge = 0.0;
	
	@Column(name = "TOTALDISCOUNT")
	private Double totaldiscount = 0.0;
	
	@Column(name = "TOTALADJUSTMENT")
	private Double totaladjustment = 0.0;
	
	@Column(name = "TOTALSUBTOTAL")
	private Double totalsubtotal = 0.0;
	
	@Column(name = "TOTALVAT")
	private Double totalvat = 0.0;
	
	@Column(name = "TOTALSTAMPDUTY")
	private Double totalstampduty = 0.0;
	
	@Column(name = "CHARGE")
	private Double charge = 0.0;
	
	@Column(name = "DISCOUNT")
	private Double discount = 0.0;
	
	@Column(name = "USAGEVARIANCE")
	private Double usagevariance = 0.0;
	
	@Column(name = "ADJUSTMENT")
	private Double adjustment = 0.0;
	
	@Column(name = "SUBTOTAL")
	private Double subtotal = 0.0;
	
	@Column(name = "TRIPPLE_DISCOUNT")
	private String trippleDisc;
	
	@Column(name = "TRIPPLE_DISCONNET")
	private String trippleDiscNet;
	
	@Column(name = "TRIPPLE_DISCOTHERS")
	private String trippleDiscOthers;
	
	@Column(name = "VAT")
	private Double vat = 0.0;
	
	@Column(name = "OTHERS")
	private Double others = 0.0;
	
	@Column(name = "OTHERSVAT")
	private Double othersvat = 0.0;
	
	@Column(name = "STAMPDUTY")
	private Double stampduty = 0.0;
	
	@Column(name = "TOTALBILLING")
	private Double totalbilling = 0.0;
	
	@Column(name = "NPWPVALUE")
	private String npwpvalue;
	
	@Column(name = "CONTRACTPENALTYCHARGE")
	private Double contractpenaltycharge = 0.0;
	
	@Column(name = "PRINTINGCOST")
	private Double printingcost = 0.0;
	
	@Column(name = "TOTAL_PAYMENTRECEIVED")
	private Double totalPaymentreceived = 0.0;
	
	@Column(name = "TOTAL_OUTSTANDINGBILLING")
	private Double totalOutstandingbilling = 0.0;
	
	@Column(name = "TOTAL_EXCESSPAYMENT")
	private Double totalExcesspayment = 0.0;
	
	@Column(name = "PREDISCOUNT")
	private Double prediscount = 0.0;
	
	@Column(name = "POSTDISCOUNT")
	private Double postdiscount = 0.0;
	
	@Column(name = "MONTHLYCHARGE")
	private Double monthlycharge = 0.0;
	
	@Column(name = "TOTALUSAGE")
	private Double totalusage = 0.0;
	
	@Column(name = "MINIMUMCOMMITMENTCHARGE")
	private Double minimumcommitmentcharge = 0.0;
	
	@Column(name = "SEQ_ID", length = 15)
	private String seqId;
	
	

	public String getSeqId() {
		return seqId;
	}

	public void setSeqId(String seqId) {
		this.seqId = seqId;
	}

	@Transient
	private Double abodemen = 0.0;

	public RptInvoiceSummary() {
	}

	public RptInvoiceSummary(Integer id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the invoicedate
	 */
	public Date getInvoicedate() {
		return invoicedate;
	}

	/**
	 * @param invoicedate the invoicedate to set
	 */
	public void setInvoicedate(Date invoicedate) {
		this.invoicedate = invoicedate;
	}

	/**
	 * @return the msisdn
	 */
	public String getMsisdn() {
		return msisdn;
	}

	/**
	 * @param msisdn the msisdn to set
	 */
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	/**
	 * @return the invoicenumber
	 */
	public String getInvoicenumber() {
		return invoicenumber;
	}

	/**
	 * @param invoicenumber the invoicenumber to set
	 */
	public void setInvoicenumber(String invoicenumber) {
		this.invoicenumber = invoicenumber;
	}

	/**
	 * @return the accountnumber
	 */
	public String getAccountnumber() {
		return accountnumber;
	}

	/**
	 * @param accountnumber the accountnumber to set
	 */
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	/**
	 * @return the customertype
	 */
	public String getCustomertype() {
		return customertype;
	}

	/**
	 * @param customertype the customertype to set
	 */
	public void setCustomertype(String customertype) {
		this.customertype = customertype;
	}

	/**
	 * @return the creditlimit
	 */
	public Double getCreditlimit() {
		return creditlimit;
	}

	/**
	 * @param creditlimit the creditlimit to set
	 */
	public void setCreditlimit(Double creditlimit) {
		this.creditlimit = creditlimit;
	}

	/**
	 * @return the callingplan
	 */
	public String getCallingplan() {
		return callingplan;
	}

	/**
	 * @param callingplan the callingplan to set
	 */
	public void setCallingplan(String callingplan) {
		this.callingplan = callingplan;
	}

	/**
	 * @return the accountname
	 */
	public String getAccountname() {
		return accountname;
	}

	/**
	 * @param accountname the accountname to set
	 */
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	/**
	 * @return the summarycorpid
	 */
	public String getSummarycorpid() {
		return summarycorpid;
	}

	/**
	 * @param summarycorpid the summarycorpid to set
	 */
	public void setSummarycorpid(String summarycorpid) {
		this.summarycorpid = summarycorpid;
	}

	/**
	 * @return the contractnum
	 */
	public String getContractnum() {
		return contractnum;
	}

	/**
	 * @param contractnum the contractnum to set
	 */
	public void setContractnum(String contractnum) {
		this.contractnum = contractnum;
	}

	/**
	 * @return the taxid
	 */
	public String getTaxid() {
		return taxid;
	}

	/**
	 * @param taxid the taxid to set
	 */
	public void setTaxid(String taxid) {
		this.taxid = taxid;
	}

	/**
	 * @return the addressname
	 */
	public String getAddressname() {
		return addressname;
	}

	/**
	 * @param addressname the addressname to set
	 */
	public void setAddressname(String addressname) {
		this.addressname = addressname;
	}

	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * @return the address3
	 */
	public String getAddress3() {
		return address3;
	}

	/**
	 * @param address3 the address3 to set
	 */
	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * @return the startperiod
	 */
	public Date getStartperiod() {
		return startperiod;
	}

	/**
	 * @param startperiod the startperiod to set
	 */
	public void setStartperiod(Date startperiod) {
		this.startperiod = startperiod;
	}

	/**
	 * @return the endperiod
	 */
	public Date getEndperiod() {
		return endperiod;
	}

	/**
	 * @param endperiod the endperiod to set
	 */
	public void setEndperiod(Date endperiod) {
		this.endperiod = endperiod;
	}

	/**
	 * @return the depositmoney
	 */
	public Double getDepositmoney() {
		return depositmoney;
	}

	/**
	 * @param depositmoney the depositmoney to set
	 */
	public void setDepositmoney(Double depositmoney) {
		this.depositmoney = depositmoney;
	}

	/**
	 * @return the lastmonthbill
	 */
	public Double getLastmonthbill() {
		return lastmonthbill;
	}

	/**
	 * @param lastmonthbill the lastmonthbill to set
	 */
	public void setLastmonthbill(Double lastmonthbill) {
		this.lastmonthbill = lastmonthbill;
	}

	/**
	 * @return the paymentreceived
	 */
	public Double getPaymentreceived() {
		return paymentreceived;
	}

	/**
	 * @param paymentreceived the paymentreceived to set
	 */
	public void setPaymentreceived(Double paymentreceived) {
		this.paymentreceived = paymentreceived;
	}

	/**
	 * @return the outstandingbilling
	 */
	public Double getOutstandingbilling() {
		return outstandingbilling;
	}

	/**
	 * @param outstandingbilling the outstandingbilling to set
	 */
	public void setOutstandingbilling(Double outstandingbilling) {
		this.outstandingbilling = outstandingbilling;
	}

	/**
	 * @return the excesspayment
	 */
	public Double getExcesspayment() {
		return excesspayment;
	}

	/**
	 * @param excesspayment the excesspayment to set
	 */
	public void setExcesspayment(Double excesspayment) {
		this.excesspayment = excesspayment;
	}

	/**
	 * @return the balancebroughtforward
	 */
	public Double getBalancebroughtforward() {
		return balancebroughtforward;
	}

	/**
	 * @param balancebroughtforward the balancebroughtforward to set
	 */
	public void setBalancebroughtforward(Double balancebroughtforward) {
		this.balancebroughtforward = balancebroughtforward;
	}

	/**
	 * @return the thismonthbill
	 */
	public Double getThismonthbill() {
		return thismonthbill;
	}

	/**
	 * @param thismonthbill the thismonthbill to set
	 */
	public void setThismonthbill(Double thismonthbill) {
		this.thismonthbill = thismonthbill;
	}

	/**
	 * @return the totaldue
	 */
	public Double getTotaldue() {
		return totaldue;
	}

	/**
	 * @param totaldue the totaldue to set
	 */
	public void setTotaldue(Double totaldue) {
		this.totaldue = totaldue;
	}

	/**
	 * @return the invoiceduedate
	 */
	public Date getInvoiceduedate() {
		return invoiceduedate;
	}

	/**
	 * @param invoiceduedate the invoiceduedate to set
	 */
	public void setInvoiceduedate(Date invoiceduedate) {
		this.invoiceduedate = invoiceduedate;
	}

	/**
	 * @return the monthlyfee
	 */
	public Double getMonthlyfee() {
		return monthlyfee;
	}

	/**
	 * @param monthlyfee the monthlyfee to set
	 */
	public void setMonthlyfee(Double monthlyfee) {
		this.monthlyfee = monthlyfee;
	}

	/**
	 * @return the fiturdata
	 */
	public String getFiturdata() {
		return fiturdata;
	}

	/**
	 * @param fiturdata the fiturdata to set
	 */
	public void setFiturdata(String fiturdata) {
		this.fiturdata = fiturdata;
	}

	/**
	 * @return the fiturcallbaring
	 */
	public String getFiturcallbaring() {
		return fiturcallbaring;
	}

	/**
	 * @param fiturcallbaring the fiturcallbaring to set
	 */
	public void setFiturcallbaring(String fiturcallbaring) {
		this.fiturcallbaring = fiturcallbaring;
	}

	/**
	 * @return the detailrecord
	 */
	public String getDetailrecord() {
		return detailrecord;
	}

	/**
	 * @param detailrecord the detailrecord to set
	 */
	public void setDetailrecord(String detailrecord) {
		this.detailrecord = detailrecord;
	}

	/**
	 * @return the localcharges
	 */
	public Double getLocalcharges() {
		return localcharges;
	}

	/**
	 * @param localcharges the localcharges to set
	 */
	public void setLocalcharges(Double localcharges) {
		this.localcharges = localcharges;
	}

	/**
	 * @return the longdistance
	 */
	public Double getLongdistance() {
		return longdistance;
	}

	/**
	 * @param longdistance the longdistance to set
	 */
	public void setLongdistance(Double longdistance) {
		this.longdistance = longdistance;
	}

	/**
	 * @return the iddcharges
	 */
	public Double getIddcharges() {
		return iddcharges;
	}

	/**
	 * @param iddcharges the iddcharges to set
	 */
	public void setIddcharges(Double iddcharges) {
		this.iddcharges = iddcharges;
	}

	/**
	 * @return the ircharges
	 */
	public Double getIrcharges() {
		return ircharges;
	}

	/**
	 * @param ircharges the ircharges to set
	 */
	public void setIrcharges(Double ircharges) {
		this.ircharges = ircharges;
	}

	/**
	 * @return the videocharges
	 */
	public Double getVideocharges() {
		return videocharges;
	}

	/**
	 * @param videocharges the videocharges to set
	 */
	public void setVideocharges(Double videocharges) {
		this.videocharges = videocharges;
	}

	/**
	 * @return the mmscharges
	 */
	public Double getMmscharges() {
		return mmscharges;
	}

	/**
	 * @param mmscharges the mmscharges to set
	 */
	public void setMmscharges(Double mmscharges) {
		this.mmscharges = mmscharges;
	}

	/**
	 * @return the datacharges
	 */
	public Double getDatacharges() {
		return datacharges;
	}

	/**
	 * @param datacharges the datacharges to set
	 */
	public void setDatacharges(Double datacharges) {
		this.datacharges = datacharges;
	}

	/**
	 * @return the planet3charges
	 */
	public Double getPlanet3charges() {
		return planet3charges;
	}

	/**
	 * @param planet3charges the planet3charges to set
	 */
	public void setPlanet3charges(Double planet3charges) {
		this.planet3charges = planet3charges;
	}

	/**
	 * @return the smscharges
	 */
	public Double getSmscharges() {
		return smscharges;
	}

	/**
	 * @param smscharges the smscharges to set
	 */
	public void setSmscharges(Double smscharges) {
		this.smscharges = smscharges;
	}

	/**
	 * @return the totalcharge
	 */
	public Double getTotalcharge() {
		return totalcharge;
	}

	/**
	 * @param totalcharge the totalcharge to set
	 */
	public void setTotalcharge(Double totalcharge) {
		this.totalcharge = totalcharge;
	}

	/**
	 * @return the totaldiscount
	 */
	public Double getTotaldiscount() {
		return totaldiscount;
	}

	/**
	 * @param totaldiscount the totaldiscount to set
	 */
	public void setTotaldiscount(Double totaldiscount) {
		this.totaldiscount = totaldiscount;
	}

	/**
	 * @return the totaladjustment
	 */
	public Double getTotaladjustment() {
		return totaladjustment;
	}

	/**
	 * @param totaladjustment the totaladjustment to set
	 */
	public void setTotaladjustment(Double totaladjustment) {
		this.totaladjustment = totaladjustment;
	}

	/**
	 * @return the totalsubtotal
	 */
	public Double getTotalsubtotal() {
		return totalsubtotal;
	}

	/**
	 * @param totalsubtotal the totalsubtotal to set
	 */
	public void setTotalsubtotal(Double totalsubtotal) {
		this.totalsubtotal = totalsubtotal;
	}

	/**
	 * @return the totalvat
	 */
	public Double getTotalvat() {
		return totalvat;
	}

	/**
	 * @param totalvat the totalvat to set
	 */
	public void setTotalvat(Double totalvat) {
		this.totalvat = totalvat;
	}

	/**
	 * @return the totalstampduty
	 */
	public Double getTotalstampduty() {
		return totalstampduty;
	}

	/**
	 * @param totalstampduty the totalstampduty to set
	 */
	public void setTotalstampduty(Double totalstampduty) {
		this.totalstampduty = totalstampduty;
	}

	/**
	 * @return the charge
	 */
	public Double getCharge() {
		return charge;
	}

	/**
	 * @param charge the charge to set
	 */
	public void setCharge(Double charge) {
		this.charge = charge;
	}

	/**
	 * @return the discount
	 */
	public Double getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	/**
	 * @return the usagevariance
	 */
	public Double getUsagevariance() {
		return usagevariance;
	}

	/**
	 * @param usagevariance the usagevariance to set
	 */
	public void setUsagevariance(Double usagevariance) {
		this.usagevariance = usagevariance;
	}

	/**
	 * @return the adjustment
	 */
	public Double getAdjustment() {
		return adjustment;
	}

	/**
	 * @param adjustment the adjustment to set
	 */
	public void setAdjustment(Double adjustment) {
		this.adjustment = adjustment;
	}

	/**
	 * @return the subtotal
	 */
	public Double getSubtotal() {
		return subtotal;
	}

	/**
	 * @param subtotal the subtotal to set
	 */
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	/**
	 * @return the trippleDisc
	 */
	public String getTrippleDisc() {
		return trippleDisc;
	}

	/**
	 * @param trippleDisc the trippleDisc to set
	 */
	public void setTrippleDisc(String xdiscount) {
		this.trippleDisc = xdiscount;
	}

	/**
	 * @return the trippleDiscNet
	 */
	public String getTrippleDiscNet() {
		return trippleDiscNet;
	}

	/**
	 * @param trippleDiscNet the trippleDiscNet to set
	 */
	public void setTrippleDiscNet(String xdisconnet) {
		this.trippleDiscNet = xdisconnet;
	}

	/**
	 * @return the trippleDiscOthers
	 */
	public String getTrippleDiscOthers() {
		return trippleDiscOthers;
	}

	/**
	 * @param trippleDiscOthers the trippleDiscOthers to set
	 */
	public void setTrippleDiscOthers(String xdiscothers) {
		this.trippleDiscOthers = xdiscothers;
	}

	/**
	 * @return the vat
	 */
	public Double getVat() {
		return vat;
	}

	/**
	 * @param vat the vat to set
	 */
	public void setVat(Double vat) {
		this.vat = vat;
	}

	/**
	 * @return the others
	 */
	public Double getOthers() {
		return others;
	}

	/**
	 * @param others the others to set
	 */
	public void setOthers(Double others) {
		this.others = others;
	}

	/**
	 * @return the othersvat
	 */
	public Double getOthersvat() {
		return othersvat;
	}

	/**
	 * @param othersvat the othersvat to set
	 */
	public void setOthersvat(Double othersvat) {
		this.othersvat = othersvat;
	}

	/**
	 * @return the stampduty
	 */
	public Double getStampduty() {
		return stampduty;
	}

	/**
	 * @param stampduty the stampduty to set
	 */
	public void setStampduty(Double stampduty) {
		this.stampduty = stampduty;
	}

	/**
	 * @return the totalbilling
	 */
	public Double getTotalbilling() {
		return totalbilling;
	}

	/**
	 * @param totalbilling the totalbilling to set
	 */
	public void setTotalbilling(Double totalbilling) {
		this.totalbilling = totalbilling;
	}

	/**
	 * @return the npwpvalue
	 */
	public String getNpwpvalue() {
		return npwpvalue;
	}

	/**
	 * @param npwpvalue the npwpvalue to set
	 */
	public void setNpwpvalue(String npwpvalue) {
		this.npwpvalue = npwpvalue;
	}

	/**
	 * @return the contractpenaltycharge
	 */
	public Double getContractpenaltycharge() {
		return contractpenaltycharge;
	}

	/**
	 * @param contractpenaltycharge the contractpenaltycharge to set
	 */
	public void setContractpenaltycharge(Double contractpenaltycharge) {
		this.contractpenaltycharge = contractpenaltycharge;
	}

	/**
	 * @return the printingcost
	 */
	public Double getPrintingcost() {
		return printingcost;
	}

	/**
	 * @param printingcost the printingcost to set
	 */
	public void setPrintingcost(Double printingcost) {
		this.printingcost = printingcost;
	}

	/**
	 * @return the totalPaymentreceived
	 */
	public Double getTotalPaymentreceived() {
		return totalPaymentreceived;
	}

	/**
	 * @param totalPaymentreceived the totalPaymentreceived to set
	 */
	public void setTotalPaymentreceived(Double totalPaymentreceived) {
		this.totalPaymentreceived = totalPaymentreceived;
	}

	/**
	 * @return the totalOutstandingbilling
	 */
	public Double getTotalOutstandingbilling() {
		return totalOutstandingbilling;
	}

	/**
	 * @param totalOutstandingbilling the totalOutstandingbilling to set
	 */
	public void setTotalOutstandingbilling(Double totalOutstandingbilling) {
		this.totalOutstandingbilling = totalOutstandingbilling;
	}

	/**
	 * @return the totalExcesspayment
	 */
	public Double getTotalExcesspayment() {
		return totalExcesspayment;
	}

	/**
	 * @param totalExcesspayment the totalExcesspayment to set
	 */
	public void setTotalExcesspayment(Double totalExcesspayment) {
		this.totalExcesspayment = totalExcesspayment;
	}

	/**
	 * @return the prediscount
	 */
	public Double getPrediscount() {
		return prediscount;
	}

	/**
	 * @param prediscount the prediscount to set
	 */
	public void setPrediscount(Double prediscount) {
		this.prediscount = prediscount;
	}

	/**
	 * @return the postdiscount
	 */
	public Double getPostdiscount() {
		return postdiscount;
	}

	/**
	 * @param postdiscount the postdiscount to set
	 */
	public void setPostdiscount(Double postdiscount) {
		this.postdiscount = postdiscount;
	}

	/**
	 * @return the monthlycharge
	 */
	public Double getMonthlycharge() {
		return monthlycharge;
	}

	/**
	 * @param monthlycharge the monthlycharge to set
	 */
	public void setMonthlycharge(Double monthlycharge) {
		this.monthlycharge = monthlycharge;
	}

	/**
	 * @return the totalusage
	 */
	public Double getTotalusage() {
		return totalusage;
	}

	/**
	 * @param totalusage the totalusage to set
	 */
	public void setTotalusage(Double totalusage) {
		this.totalusage = totalusage;
	}

	/**
	 * @return the minimumcommitmentcharge
	 */
	public Double getMinimumcommitmentcharge() {
		return minimumcommitmentcharge;
	}

	/**
	 * @param minimumcommitmentcharge the minimumcommitmentcharge to set
	 */
	public void setMinimumcommitmentcharge(Double minimumcommitmentcharge) {
		this.minimumcommitmentcharge = minimumcommitmentcharge;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof RptInvoiceSummary)) {
			return false;
		}
		RptInvoiceSummary other = (RptInvoiceSummary) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nitipgenerateentity.RptInvoiceSummary[ id=" + id + " ]";
	}

	public Double getAbodemen() {
		/*
		try {
			if (abodemen != null && !abodemen.isEmpty()) {
				return new BigDecimal(abodemen);

			} else {
				if (getSubtotal() == null) {
					setSubtotal("0");
				}
				if (getLocalcharges() == null) {
					setLocalcharges("0");
				}
				if (getLongdistance() == null) {
					setLongdistance("0");
				}
				if (getIddcharges() == null) {
					setIddcharges("0");
				}

				long subtotal = Long.parseLong(getSubtotal().replaceAll(",", "")),
						localcharges = Long.parseLong(getLocalcharges().replaceAll(",", "")),
						longdistance = Long.parseLong(getLongdistance().replaceAll(",", "")),
						iddcharges = Long.parseLong(getIddcharges().replaceAll(",", ""));

				return new BigDecimal(subtotal - localcharges - longdistance - iddcharges);
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return new BigDecimal(0.0);
		*/
		return subtotal - localcharges - longdistance - iddcharges;
	}

	public void setAbodemen(Double abodemen) {
		this.abodemen = abodemen;
	}
}
