/**
 * Feb 5, 2018 8:59:14 PM
 */
package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;

/**
 * @author nandipinto
 *
 */
public class BillingSummaryDetails implements Serializable {

	private static final long serialVersionUID = -7375285428178259102L;

	private int id;
	private String invoiceDate;
	private String msisdn;
	private String invoicenumber;
	private double creditLimit = 0.0;
	private String startPeriod;
	private String endPeriod;
	private double depositMoney = 0.0;
	private double lastmonthBill = 0.0;
	private double paymentReceived = 0.0;
	private double outstandingBilling = 0.0;
	private double excessPayment = 0.0;
	private double balanceBroughtForward = 0.0;
	private double thismonthBill = 0.0;
	private double totalDue = 0.0;
	private String invoiceDueDate;
	private double monthlyFee = 0.0;
	private double localCharges = 0.0;
	private double longDistance = 0.0;
	private double iddCharges = 0.0;
	private double irCharges = 0.0;
	private double videoCharges = 0.0;
	private double mmsCharges = 0.0;
	private double dataCharges = 0.0;
	private double smsCharges = 0.0;
	private double totalCharge = 0.0;
	private double totalDiscount = 0.0;
	private double totalAdjustment = 0.0;
	private double totalVAT = 0.0;
	private double totalStampDuty = 0.0;
	private double charge = 0.0;
	private double discount = 0.0;
	private double usageVariance = 0.0;
	private double adjustment = 0.0;
	private double subtotal = 0.0;
	private double vat = 0.0;
	private double others = 0.0;
	private double othersVat = 0.0;
	private double stampDuty = 0.0;
	private double totalBilling = 0.0;
	private double contractPenaltyCharge = 0.0;
	private double printingCost = 0.0;
	private double totalPaymentReceived = 0.0;
	private double totalOutstandingBilling = 0.0;
	private double totalExcessPayment = 0.0;
	private double prediscount = 0.0;
	private double postdiscount = 0.0;
	private double monthlyCharge = 0.0;
	private double totalUsage = 0.0;
	private double minimumCommitmentCharge = 0.0;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the invoiceDate
	 */
	public String getInvoiceDate() {
		return invoiceDate;
	}
	/**
	 * @param invoiceDate the invoiceDate to set
	 */
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
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
	 * @return the creditLimit
	 */
	public double getCreditLimit() {
		return creditLimit;
	}
	/**
	 * @param creditLimit the creditLimit to set
	 */
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	/**
	 * @return the startPeriod
	 */
	public String getStartPeriod() {
		return startPeriod;
	}
	/**
	 * @param startPeriod the startPeriod to set
	 */
	public void setStartPeriod(String startPeriod) {
		this.startPeriod = startPeriod;
	}
	/**
	 * @return the endPeriod
	 */
	public String getEndPeriod() {
		return endPeriod;
	}
	/**
	 * @param endPeriod the endPeriod to set
	 */
	public void setEndPeriod(String endPeriod) {
		this.endPeriod = endPeriod;
	}
	/**
	 * @return the depositMoney
	 */
	public double getDepositMoney() {
		return depositMoney;
	}
	/**
	 * @param depositMoney the depositMoney to set
	 */
	public void setDepositMoney(double depositMoney) {
		this.depositMoney = depositMoney;
	}
	/**
	 * @return the lastmonthBill
	 */
	public double getLastmonthBill() {
		return lastmonthBill;
	}
	/**
	 * @param lastmonthBill the lastmonthBill to set
	 */
	public void setLastmonthBill(double lastmonthBill) {
		this.lastmonthBill = lastmonthBill;
	}
	/**
	 * @return the paymentReceived
	 */
	public double getPaymentReceived() {
		return paymentReceived;
	}
	/**
	 * @param paymentReceived the paymentReceived to set
	 */
	public void setPaymentReceived(double paymentRceived) {
		this.paymentReceived = paymentRceived;
	}
	/**
	 * @return the outstandingBilling
	 */
	public double getOutstandingBilling() {
		return outstandingBilling;
	}
	/**
	 * @param outstandingBilling the outstandingBilling to set
	 */
	public void setOutstandingBilling(double outstandingBilling) {
		this.outstandingBilling = outstandingBilling;
	}
	/**
	 * @return the excessPayment
	 */
	public double getExcessPayment() {
		return excessPayment;
	}
	/**
	 * @param excessPayment the excessPayment to set
	 */
	public void setExcessPayment(double excessPayment) {
		this.excessPayment = excessPayment;
	}
	/**
	 * @return the balanceBroughtForward
	 */
	public double getBalanceBroughtForward() {
		return balanceBroughtForward;
	}
	/**
	 * @param balanceBroughtForward the balanceBroughtForward to set
	 */
	public void setBalanceBroughtForward(double balanceBroughtForward) {
		this.balanceBroughtForward = balanceBroughtForward;
	}
	/**
	 * @return the thismonthBill
	 */
	public double getThismonthBill() {
		return thismonthBill;
	}
	/**
	 * @param thismonthBill the thismonthBill to set
	 */
	public void setThismonthBill(double thismonthBill) {
		this.thismonthBill = thismonthBill;
	}
	/**
	 * @return the totalDue
	 */
	public double getTotalDue() {
		return totalDue;
	}
	/**
	 * @param totalDue the totalDue to set
	 */
	public void setTotalDue(double totalDue) {
		this.totalDue = totalDue;
	}
	/**
	 * @return the invoiceDueDate
	 */
	public String getInvoiceDueDate() {
		return invoiceDueDate;
	}
	/**
	 * @param invoiceDueDate the invoiceDueDate to set
	 */
	public void setInvoiceDueDate(String invoiceDueDate) {
		this.invoiceDueDate = invoiceDueDate;
	}
	/**
	 * @return the monthlyFee
	 */
	public double getMonthlyFee() {
		return monthlyFee;
	}
	/**
	 * @param monthlyFee the monthlyFee to set
	 */
	public void setMonthlyFee(double monthlyFee) {
		this.monthlyFee = monthlyFee;
	}
	/**
	 * @return the localCharges
	 */
	public double getLocalCharges() {
		return localCharges;
	}
	/**
	 * @param localCharges the localCharges to set
	 */
	public void setLocalCharges(double localCharges) {
		this.localCharges = localCharges;
	}
	/**
	 * @return the longDistance
	 */
	public double getLongDistance() {
		return longDistance;
	}
	/**
	 * @param longDistance the longDistance to set
	 */
	public void setLongDistance(double longDistance) {
		this.longDistance = longDistance;
	}
	/**
	 * @return the iddCharges
	 */
	public double getIddCharges() {
		return iddCharges;
	}
	/**
	 * @param iddCharges the iddCharges to set
	 */
	public void setIddCharges(double iddCharges) {
		this.iddCharges = iddCharges;
	}
	/**
	 * @return the irCharges
	 */
	public double getIrCharges() {
		return irCharges;
	}
	/**
	 * @param irCharges the irCharges to set
	 */
	public void setIrCharges(double irCharges) {
		this.irCharges = irCharges;
	}
	/**
	 * @return the videoCharges
	 */
	public double getVideoCharges() {
		return videoCharges;
	}
	/**
	 * @param videoCharges the videoCharges to set
	 */
	public void setVideoCharges(double videoCharges) {
		this.videoCharges = videoCharges;
	}
	/**
	 * @return the mmsCharges
	 */
	public double getMmsCharges() {
		return mmsCharges;
	}
	/**
	 * @param mmsCharges the mmsCharges to set
	 */
	public void setMmsCharges(double mmsCharges) {
		this.mmsCharges = mmsCharges;
	}
	/**
	 * @return the dataCharges
	 */
	public double getDataCharges() {
		return dataCharges;
	}
	/**
	 * @param dataCharges the dataCharges to set
	 */
	public void setDataCharges(double dataCharges) {
		this.dataCharges = dataCharges;
	}
	/**
	 * @return the smsCharges
	 */
	public double getSmsCharges() {
		return smsCharges;
	}
	/**
	 * @param smsCharges the smsCharges to set
	 */
	public void setSmsCharges(double smsCharges) {
		this.smsCharges = smsCharges;
	}
	/**
	 * @return the totalCharge
	 */
	public double getTotalCharge() {
		return totalCharge;
	}
	/**
	 * @param totalCharge the totalCharge to set
	 */
	public void setTotalCharge(double totalCharge) {
		this.totalCharge = totalCharge;
	}
	/**
	 * @return the totalDiscount
	 */
	public double getTotalDiscount() {
		return totalDiscount;
	}
	/**
	 * @param totalDiscount the totalDiscount to set
	 */
	public void setTotalDiscount(double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}
	/**
	 * @return the totalAdjustment
	 */
	public double getTotalAdjustment() {
		return totalAdjustment;
	}
	/**
	 * @param totalAdjustment the totalAdjustment to set
	 */
	public void setTotalAdjustment(double totalAdjustment) {
		this.totalAdjustment = totalAdjustment;
	}
	/**
	 * @return the totalVAT
	 */
	public double getTotalVAT() {
		return totalVAT;
	}
	/**
	 * @param totalVAT the totalVAT to set
	 */
	public void setTotalVAT(double totalVAT) {
		this.totalVAT = totalVAT;
	}
	/**
	 * @return the totalStampDuty
	 */
	public double getTotalStampDuty() {
		return totalStampDuty;
	}
	/**
	 * @param totalStampDuty the totalStampDuty to set
	 */
	public void setTotalStampDuty(double totalStampDuty) {
		this.totalStampDuty = totalStampDuty;
	}
	/**
	 * @return the charge
	 */
	public double getCharge() {
		return charge;
	}
	/**
	 * @param charge the charge to set
	 */
	public void setCharge(double charge) {
		this.charge = charge;
	}
	/**
	 * @return the discount
	 */
	public double getDiscount() {
		return discount;
	}
	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	/**
	 * @return the usageVariance
	 */
	public double getUsageVariance() {
		return usageVariance;
	}
	/**
	 * @param usageVariance the usageVariance to set
	 */
	public void setUsageVariance(double usageVariance) {
		this.usageVariance = usageVariance;
	}
	/**
	 * @return the adjustment
	 */
	public double getAdjustment() {
		return adjustment;
	}
	/**
	 * @param adjustment the adjustment to set
	 */
	public void setAdjustment(double adjustment) {
		this.adjustment = adjustment;
	}
	/**
	 * @return the subtotal
	 */
	public double getSubtotal() {
		return subtotal;
	}
	/**
	 * @param subtotal the subtotal to set
	 */
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	/**
	 * @return the vat
	 */
	public double getVat() {
		return vat;
	}
	/**
	 * @param vat the vat to set
	 */
	public void setVat(double vat) {
		this.vat = vat;
	}
	/**
	 * @return the others
	 */
	public double getOthers() {
		return others;
	}
	/**
	 * @param others the others to set
	 */
	public void setOthers(double others) {
		this.others = others;
	}
	/**
	 * @return the othersVat
	 */
	public double getOthersVat() {
		return othersVat;
	}
	/**
	 * @param othersVat the othersVat to set
	 */
	public void setOthersVat(double othersVat) {
		this.othersVat = othersVat;
	}
	/**
	 * @return the stampDuty
	 */
	public double getStampDuty() {
		return stampDuty;
	}
	/**
	 * @param stampDuty the stampDuty to set
	 */
	public void setStampDuty(double stampDuty) {
		this.stampDuty = stampDuty;
	}
	/**
	 * @return the totalBilling
	 */
	public double getTotalBilling() {
		return totalBilling;
	}
	/**
	 * @param totalBilling the totalBilling to set
	 */
	public void setTotalBilling(double totalBilling) {
		this.totalBilling = totalBilling;
	}
	/**
	 * @return the contractPenaltyCharge
	 */
	public double getContractPenaltyCharge() {
		return contractPenaltyCharge;
	}
	/**
	 * @param contractPenaltyCharge the contractPenaltyCharge to set
	 */
	public void setContractPenaltyCharge(double contractPenaltyCharge) {
		this.contractPenaltyCharge = contractPenaltyCharge;
	}
	/**
	 * @return the printingCost
	 */
	public double getPrintingCost() {
		return printingCost;
	}
	/**
	 * @param printingCost the printingCost to set
	 */
	public void setPrintingCost(double printingCost) {
		this.printingCost = printingCost;
	}
	/**
	 * @return the totalPaymentReceived
	 */
	public double getTotalPaymentReceived() {
		return totalPaymentReceived;
	}
	/**
	 * @param totalPaymentReceived the totalPaymentReceived to set
	 */
	public void setTotalPaymentReceived(double totalPaymentReceived) {
		this.totalPaymentReceived = totalPaymentReceived;
	}
	/**
	 * @return the totalOutstandingBilling
	 */
	public double getTotalOutstandingBilling() {
		return totalOutstandingBilling;
	}
	/**
	 * @param totalOutstandingBilling the totalOutstandingBilling to set
	 */
	public void setTotalOutstandingBilling(double totalOutstandingBilling) {
		this.totalOutstandingBilling = totalOutstandingBilling;
	}
	/**
	 * @return the totalExcessPayment
	 */
	public double getTotalExcessPayment() {
		return totalExcessPayment;
	}
	/**
	 * @param totalExcessPayment the totalExcessPayment to set
	 */
	public void setTotalExcessPayment(double totalExcessPayment) {
		this.totalExcessPayment = totalExcessPayment;
	}
	/**
	 * @return the prediscount
	 */
	public double getPrediscount() {
		return prediscount;
	}
	/**
	 * @param prediscount the prediscount to set
	 */
	public void setPrediscount(double prediscount) {
		this.prediscount = prediscount;
	}
	/**
	 * @return the postdiscount
	 */
	public double getPostdiscount() {
		return postdiscount;
	}
	/**
	 * @param postdiscount the postdiscount to set
	 */
	public void setPostdiscount(double postdiscount) {
		this.postdiscount = postdiscount;
	}
	/**
	 * @return the monthlyCharge
	 */
	public double getMonthlyCharge() {
		return monthlyCharge;
	}
	/**
	 * @param monthlyCharge the monthlyCharge to set
	 */
	public void setMonthlyCharge(double monthlyCharge) {
		this.monthlyCharge = monthlyCharge;
	}
	/**
	 * @return the totalUsage
	 */
	public double getTotalUsage() {
		return totalUsage;
	}
	/**
	 * @param totalUsage the totalUsage to set
	 */
	public void setTotalUsage(double totalUsage) {
		this.totalUsage = totalUsage;
	}
	/**
	 * @return the minimumCommitmentCharge
	 */
	public double getMinimumCommitmentCharge() {
		return minimumCommitmentCharge;
	}
	/**
	 * @param minimumCommitmentCharge the minimumCommitmentCharge to set
	 */
	public void setMinimumCommitmentCharge(double minimumCommitmentCharge) {
		this.minimumCommitmentCharge = minimumCommitmentCharge;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BillingSummaryDetails [id=");
		builder.append(id);
		builder.append(", invoiceDate=");
		builder.append(invoiceDate);
		builder.append(", msisdn=");
		builder.append(msisdn);
		builder.append(", invoicenumber=");
		builder.append(invoicenumber);
		builder.append(", creditLimit=");
		builder.append(creditLimit);
		builder.append(", startPeriod=");
		builder.append(startPeriod);
		builder.append(", endPeriod=");
		builder.append(endPeriod);
		builder.append(", depositMoney=");
		builder.append(depositMoney);
		builder.append(", lastmonthBill=");
		builder.append(lastmonthBill);
		builder.append(", paymentReceived=");
		builder.append(paymentReceived);
		builder.append(", outstandingBilling=");
		builder.append(outstandingBilling);
		builder.append(", excessPayment=");
		builder.append(excessPayment);
		builder.append(", balanceBroughtForward=");
		builder.append(balanceBroughtForward);
		builder.append(", thismonthBill=");
		builder.append(thismonthBill);
		builder.append(", totalDue=");
		builder.append(totalDue);
		builder.append(", invoiceDueDate=");
		builder.append(invoiceDueDate);
		builder.append(", monthlyFee=");
		builder.append(monthlyFee);
		builder.append(", localCharges=");
		builder.append(localCharges);
		builder.append(", longDistance=");
		builder.append(longDistance);
		builder.append(", iddCharges=");
		builder.append(iddCharges);
		builder.append(", irCharges=");
		builder.append(irCharges);
		builder.append(", videoCharges=");
		builder.append(videoCharges);
		builder.append(", mmsCharges=");
		builder.append(mmsCharges);
		builder.append(", dataCharges=");
		builder.append(dataCharges);
		builder.append(", smsCharges=");
		builder.append(smsCharges);
		builder.append(", totalCharge=");
		builder.append(totalCharge);
		builder.append(", totalDiscount=");
		builder.append(totalDiscount);
		builder.append(", totalAdjustment=");
		builder.append(totalAdjustment);
		builder.append(", totalVAT=");
		builder.append(totalVAT);
		builder.append(", totalStampDuty=");
		builder.append(totalStampDuty);
		builder.append(", charge=");
		builder.append(charge);
		builder.append(", discount=");
		builder.append(discount);
		builder.append(", usageVariance=");
		builder.append(usageVariance);
		builder.append(", adjustment=");
		builder.append(adjustment);
		builder.append(", subtotal=");
		builder.append(subtotal);
		builder.append(", vat=");
		builder.append(vat);
		builder.append(", others=");
		builder.append(others);
		builder.append(", othersVat=");
		builder.append(othersVat);
		builder.append(", stampDuty=");
		builder.append(stampDuty);
		builder.append(", totalBilling=");
		builder.append(totalBilling);
		builder.append(", contractPenaltyCharge=");
		builder.append(contractPenaltyCharge);
		builder.append(", printingCost=");
		builder.append(printingCost);
		builder.append(", totalPaymentReceived=");
		builder.append(totalPaymentReceived);
		builder.append(", totalOutstandingBilling=");
		builder.append(totalOutstandingBilling);
		builder.append(", totalExcessPayment=");
		builder.append(totalExcessPayment);
		builder.append(", prediscount=");
		builder.append(prediscount);
		builder.append(", postdiscount=");
		builder.append(postdiscount);
		builder.append(", monthlyCharge=");
		builder.append(monthlyCharge);
		builder.append(", totalUsage=");
		builder.append(totalUsage);
		builder.append(", minimumCommitmentCharge=");
		builder.append(minimumCommitmentCharge);
		builder.append("]");
		return builder.toString();
	}
	
}
