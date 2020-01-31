/**
 * Jan 22, 2018 9:46:33 AM
 */
package com.gnv.vnm.selfcare.core.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService;
import com.gnv.vnm.selfcare.core.utils.AppUtils;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.dao.entity.RptInvoiceSummary;
import com.gnv.vnm.selfcare.dao.repo.RptInvoiceSummaryRepository;

/**
 * @author nandipinto
 *
 */

@Component
public class XprintFileProcessor {

	private static final Logger logger = LoggerFactory.getLogger(XprintFileProcessor.class);

	@Autowired
	private RptInvoiceSummaryRepository invoiceSummaryRepository;

	@Autowired
	private ApplicationConfigurationService applicationConfigurationService;
	@Autowired
	private TaskScheduler taskScheduler;
	@Autowired
	private ThreadPoolTaskExecutor taskExecutor;

	@PostConstruct
	public void initService() throws Exception {

		String cronExpr = applicationConfigurationService.get("xprintprocessor.cronexpr", "0 0 1 * * *").toString();

		LoggingUtil.debug(logger, "#initService --- starting XPrint file processor...");
		taskScheduler.schedule(new Runnable() {

			@Override
			public void run() {
				processXprintFiles();
			}
		}, new CronTrigger(cronExpr));

	}

	@PreDestroy
	public void stopService() {
		taskExecutor.shutdown();
	}

	public void processXprintFiles() {

		String tmpDir = System.getProperty("java.io.tmpdir");
		File landingDir = null;
		String inputDir = applicationConfigurationService.get("xprintprocessor.dir.input", "").toString();
		if (StringUtils.hasText(inputDir)) {
			landingDir = new File(inputDir);
			if (!landingDir.exists())
				landingDir.mkdirs();
		} else {
			// fall back to tmp dir?
			landingDir = new File(tmpDir);
		}

		String adir = applicationConfigurationService.get("xprintprocessor.dir.archive", tmpDir).toString();
		File archiveDir = new File(adir);
		if (!archiveDir.exists())
			archiveDir.mkdirs();

		if (landingDir != null) {
			File[] files = landingDir.listFiles();
			if (files != null && files.length > 0) {
				for (File f : files) {

					taskExecutor.submit(new Runnable() {

						@Override
						public void run() {
							List<RptInvoiceSummary> data = handleXprintFile(f);
							if (!data.isEmpty()) {
								invoiceSummaryRepository.save(data);
							}
						}
					});
				}
			}
		}
	}

	private List<RptInvoiceSummary> handleXprintFile(File input) {

		List<RptInvoiceSummary> data = new ArrayList<>();

		if (input == null)
			return data;
		if (input.isDirectory())
			return data;

		String tmpDir = System.getProperty("java.io.tmpdir");
		String archiveDir = applicationConfigurationService.get("xprintprocessor.dir.archive", tmpDir).toString();
		String datePattern = applicationConfigurationService.get("xprintprocessor.parser.datepattern", "dd MMM yyyy").toString();

		Scanner scanner = null;
		try {

			RptInvoiceSummary rptInvoiceSummary = new RptInvoiceSummary();

			scanner = new Scanner(input, "UTF-8");

			while (scanner.hasNextLine()) {
				String next = scanner.nextLine();
				String nexts[] = next.split(" ");
				String head = nexts[0];
				String tail = next.replace(head, "").trim();

				if (next.contains("START====="))
					rptInvoiceSummary = new RptInvoiceSummary();

				if (head.contains("INVOICEDATE")) {
					rptInvoiceSummary.setInvoicedate(AppUtils.stringToDate(tail, datePattern));
				}

				if (head.contains("MSISDN")) {
					rptInvoiceSummary.setMsisdn(tail);
				}
				if (head.contains("INVOICENUMBER"))
					rptInvoiceSummary.setInvoicenumber(tail);
				if (head.contains("CUSTOMERTYPE"))
					rptInvoiceSummary.setCustomertype(tail);
				if (head.contains("SUMMARYCORPID"))
					rptInvoiceSummary.setSummarycorpid(tail);
				if (head.contains("CONTRACTNUM"))
					rptInvoiceSummary.setContractnum(tail);
				if (head.contains("TAXID"))
					rptInvoiceSummary.setTaxid(tail);
				if (head.contains("ADDRESSNAME"))
					rptInvoiceSummary.setAddressname(tail);
				if (head.contains("ADDRESS1"))
					rptInvoiceSummary.setAddress1(tail);
				if (head.contains("ADDRESS2"))
					rptInvoiceSummary.setAddress2(tail);
				if (head.contains("CITY"))
					rptInvoiceSummary.setCity(tail);
				if (head.contains("POSTCODE"))
					rptInvoiceSummary.setPostcode(tail);
				if (head.contains("STARTPERIOD")) {
					rptInvoiceSummary.setStartperiod(AppUtils.stringToDate(tail, datePattern));
				}
				if (head.contains("ENDPERIOD")) {
					rptInvoiceSummary.setEndperiod(AppUtils.stringToDate(tail, datePattern));
				}

				if (head.contains("DEPOSITMONEY")) {
					try {
						rptInvoiceSummary.setDepositmoney(Double.parseDouble(tail.replaceAll(",", "")));
					} catch (Exception e) {
					}
				}

				if (head.contains("LASTMONTHBILL")) {
					try {
						rptInvoiceSummary.setLastmonthbill(Double.parseDouble(tail.replaceAll(",", "")));
					} catch (Exception e) {
					}
				}

				if (head.contains("PAYMENTRECEIVED")) {
					try {
						rptInvoiceSummary.setPaymentreceived(Double.parseDouble(tail.replaceAll(",", "")));
					} catch (Exception e) {
					}
				}

				if (head.contains("OUTSTANDINGBILLING")) {
					try {
						rptInvoiceSummary.setOutstandingbilling(Double.parseDouble(tail.replaceAll(",", "")));
					} catch (Exception e) {
					}
				}

				if (head.contains("EXCESSPAYMENT")) {
					try {
						rptInvoiceSummary.setExcesspayment(Double.parseDouble(tail.replaceAll(",", "")));
					} catch (Exception e) {
					}
				}

				if (head.contains("BALANCEBROUGHTFORWARD")) {
					try {
						rptInvoiceSummary.setBalancebroughtforward(Double.parseDouble(tail.replaceAll(",", "")));
					} catch (Exception e) {
					}
				}

				if (head.contains("THISMONTHBILL")) {
					try {
						rptInvoiceSummary.setThismonthbill(Double.parseDouble(tail.replaceAll(",", "")));
					} catch (Exception e) {
					}
				}

				if (head.contains("TOTALDUE")) {
					try {
						rptInvoiceSummary.setTotaldue(Double.parseDouble(tail.replaceAll(",", "")));
					} catch (Exception e) {
					}
				}

				if (head.contains("INVOICEDUEDATE"))
					rptInvoiceSummary.setInvoiceduedate(AppUtils.stringToDate(tail, datePattern));

				if (head.contains("TOTALCHARGE")) {
					try {
						rptInvoiceSummary.setTotalcharge(Double.parseDouble(tail.replaceAll(",", "")));
					} catch (Exception e) {
					}
				}

				if (head.contains("TOTALDISCOUNT")) {
					try {
						rptInvoiceSummary.setTotaldiscount(Double.parseDouble(tail.replaceAll(",", "")));
					} catch (Exception e) {
					}
				}

				if (head.contains("TOTALADJUSTMENT")) {
					try {
						rptInvoiceSummary.setTotaladjustment(Double.parseDouble(tail.replaceAll(",", "")));
					} catch (Exception e) {
					}
				}

				if (head.contains("TOTALSUBTOTAL")) {
					try {
						rptInvoiceSummary.setTotalsubtotal(Double.parseDouble(tail.replaceAll(",", "")));
					} catch (Exception e) {
					}
				}

				if (head.contains("TOTALVAT")) {
					try {
						rptInvoiceSummary.setTotalvat(Double.parseDouble(tail.replaceAll(",", "")));
					} catch (Exception e) {
					}
				}

				if (head.contains("TOTALSTAMPDUTY")) {
					try {
						rptInvoiceSummary.setTotalstampduty(Double.parseDouble(tail.replaceAll(",", "")));
					} catch (Exception e) {
					}
				}

				if (head.contains("CONTRACTPENALTYCHARGE")) {
					try {
						rptInvoiceSummary.setContractpenaltycharge(Double.parseDouble(tail.replaceAll(",", "")));
					} catch (Exception e) {
					}
				}

				if (next.contains("END=====")) {
					data.add(rptInvoiceSummary);
				}

			}

			scanner.close();

			LoggingUtil.debug(logger,
					"#handleXprintFile --- extracted " + data.size() + " record(s) from file " + input.getName());

			input.renameTo(new File(archiveDir,
					"processed_" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss") + input.getName()));

		} catch (Exception e) {
			logger.error("#processXprintFile --- error processing input file " + input.getName(), e);

			input.renameTo(new File(archiveDir,
					"error_" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss") + input.getName()));
		} finally {
			if (scanner != null)
				scanner.close();
		}

		return data;
	}

}
