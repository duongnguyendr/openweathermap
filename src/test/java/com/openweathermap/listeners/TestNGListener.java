package com.openweathermap.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.testng.IExecutionListener;

import com.openweathermap.utils.Reporting;
import com.openweathermap.utils.Utils;

public class TestNGListener implements IExecutionListener {

	public static File sHtmlReports;
	private static Logger logger = Logger.getLogger(TestNGListener.class.getSimpleName());
	
	@Override
	public void onExecutionStart() {
		initReportsFolder();
	}

	@Override
	public void onExecutionFinish() {
		logger.info("***** Generating Report *****");
		String timeStamp = Utils.GetTimeStampValue();
		Reporting.generateReport(timeStamp);
	}

	private void initReportsFolder() {
		try {
			logger.info("***** Start initialize Report folders *****\n");
			sHtmlReports = new File(System.getProperty("user.dir") + "/Reports/HTML");
			if (!sHtmlReports.exists()) {
				FileUtils.forceMkdir(sHtmlReports);
			}
		} catch (IOException e) {
			logger.info("***** Unable to create report folders: " + e.getMessage());
		}
	}
}
