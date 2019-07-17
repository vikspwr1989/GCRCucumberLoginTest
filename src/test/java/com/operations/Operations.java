package com.operations;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.config.Config;
import com.controller.Controller;
import com.results.ReportGenerator;
import com.utils.Screenshot;

public class Operations {
	
	public static Logger logger = Logger.getLogger(Operations.class);
	
	public static WebElement getElement(String xpath)
	{
		Config.wait = new WebDriverWait(Config.driver, 20);
		Config.wait.until(ExpectedConditions.visibilityOf(Config.driver.findElement(By.xpath(xpath))));
		return Config.driver.findElement(By.xpath(xpath));
	}

	
	public static void setup(String xpath,String[] input)  
	{
	   if(input[0].equalsIgnoreCase("CHROME"))
	   {
		   System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\drivers\\chromedriver.exe");
		   Config.driver = new ChromeDriver();
		   logger.info(input[0]+" browser started");
		   ReportGenerator.stepDetails("PASS", Controller.stepName, "Expected : "+input[0]+" browser should launched <br /> Actual Result: "+input[0]+" browser was launched", Screenshot.takesScreenshot("setup"));
		 
	   }
	   else
	   {
		   System.out.println("Browser Not Found");
		   logger.info("Browser Not Found");
		   ReportGenerator.stepDetails("FAIL", Controller.stepName, "Expected : "+input[0]+" browser should launched <br /> Actual Result: "+input[0]+" browser was not launched", Screenshot.takesScreenshot("setupError"));
	   }
	   
	   Config.driver.manage().window().maximize();
	   Config.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	   Config.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	    
	}

	
	public static void enterURL(String xpath,String[] input)  
	{
	    Config.driver.get(input[0]);
	    logger.info(input[0]+" URL Launched");
	    System.out.println(input[0]+" URL Launched");
	    ReportGenerator.stepDetails("PASS", Controller.stepName, "Expected Result: "+input[0]+" should entered <br /> Actual Result: "+input[0]+" was entered", Screenshot.takesScreenshot("URL"));
	    
	}

	
	public static void enterCredentials(String xpath,String[] input) 
	{
	    getElement(xpath).sendKeys(input[0]+Keys.TAB+input[1]);
	    System.out.println("Username and Password entered as "+input[0]+" and "+input[1]+" respectivally");
	    logger.info("Username and Password entered as "+input[0]+" and "+input[1]+" respectivally");
	    ReportGenerator.stepDetails("PASS", Controller.stepName, "Expected Result: Username "+input[0]+" and Password "+input[0]+" should entered <br /> Actual Result: Username "+input[0]+" and Password "+input[0]+" were entered", Screenshot.takesScreenshot("userpass"));
	    
	}


	public static void clickLogin(String xpath,String[] input)  
	{
	    getElement(xpath).click();
	    System.out.println("Clicked on Login");
	    logger.info("Clicked on Login Button");
	    ReportGenerator.stepDetails("PASS", Controller.stepName, "Expected Result: Login Should clicked <br /> Actual Result: Login was clicked", Screenshot.takesScreenshot("Login"));
	    
	}


	public static void onHomePage(String xpath,String[] input)  
	{
		boolean b = Config.driver.getCurrentUrl().contains("http://www.gcrit.com/build3/admin/index.php");
		Assert.assertTrue(b);
	   System.out.println("User moved to home Page"); 
	   logger.info("User moved to Home Page");
	   ReportGenerator.stepDetails("PASS", Controller.stepName, "Expected Result: Home Page should be displayed <br /> Actual Result: Home Page was displayed", Screenshot.takesScreenshot("HomePage"));
	    
	}
	
	public static void tearDown(String xpath,String[] input)
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(Config.driver!=null)
		{
			Config.driver.close();
			System.out.println("Browser closed");
			logger.info("Browser was closed");
			ReportGenerator.stepDetails("PASS", Controller.stepName, "Expected Result : Browser should closed <br /> Actual Result : Browser was closed", "");
		}
	}
	
}
