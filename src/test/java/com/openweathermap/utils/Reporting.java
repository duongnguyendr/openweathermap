package com.openweathermap.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

public class Reporting {
	private static final String PROJECT_NAME = "OpenWeatherMap";
	public static Reportable generateReport(String execTime) {
		Reportable report = null;
		try {
			File reportDir = new File("Reports/HTML/Report_" + execTime);
			List<String> jsonFiles = new ArrayList<>();
			jsonFiles.add("./target/cucumber.json");
			
			Configuration config = createConfiguration(reportDir, PROJECT_NAME);
			ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, config);
			report = reportBuilder.generateReports();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return report;
	}
	
	private static Configuration createConfiguration(File reportFodler, String projectName) {
		Configuration configuration = new Configuration(reportFodler, projectName);
		configuration.addClassifications("API Verion", "2.5");
		configuration.addClassifications("Technology", "Java/Cucumber/RestAssured");
        configuration.addClassifications("Created by", "Duong Nguyen");
        return configuration;
	}

}
