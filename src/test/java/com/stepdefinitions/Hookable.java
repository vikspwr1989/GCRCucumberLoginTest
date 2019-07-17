package com.stepdefinitions;

import java.net.UnknownHostException;

import org.apache.log4j.Logger;

import com.results.HTMLReportGenerator;
import com.results.ReportGenerator;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hookable {
	
	public static int scenarioCount;
	public static int stepCount;
	public static Logger logger = Logger.getLogger(Hookable.class);
	
	@Before
	public void beforeScenario(Scenario scenario)
	{
		ReportGenerator.startTestSuite("./src/test/resources/Reports/HTMLReport.html", "Pooja");
		ReportGenerator.startTestCase(scenario.getName(), "");
	
		scenarioCount++;
		System.out.println("Suite Name :"+scenario.getSourceTagNames());
		System.out.println("Scenario "+scenarioCount+" "+scenario.getName());
		logger.info("Suite Name :"+scenario.getSourceTagNames());
		logger.info("Scenario "+scenarioCount+" "+scenario.getName());
		
		
		
	}
	
	@After
	public void afterScenario(Scenario scenario)
	{
		stepCount=0;
		System.out.println("======================== End of Scenario "+scenarioCount+" ================================");
		logger.info("======================== End of Scenario "+scenarioCount+" ================================");
		ReportGenerator.endTestCase();
		ReportGenerator.entTestSuite();
		
	}

}
