package com.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"src/test/resources/MyFeatures"},
		monochrome = true,
		//dryRun = true
		glue = {"com.stepdefinitions"}
		
		)
public class TestRunner {

}

/*public class TestRunner extends AbstractTestNGCucumberTests{
         Execution by using TestNG
}*/
