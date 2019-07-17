package com.config;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Config {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static FileInputStream fileInputStream;
	public static Properties properties;
	public static Logger logger = Logger.getLogger(Config.class);
	
	public static String getXpath(String objectLogicalName)
	{
		try {
			fileInputStream = new FileInputStream("D:\\EclipseRun\\WS_Temp\\GCRLoginCucumber\\src\\test\\resources\\Repository.properties");
			properties = new Properties();
			properties.load(fileInputStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return properties.getProperty(objectLogicalName);
		
	}

}
