package com.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.config.Config;

public class Screenshot {
	
	
		public static String takesScreenshot(String ssName)
		{
			TakesScreenshot screenshot = (TakesScreenshot) Config.driver;
			
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			
			File dest = new File("src/test/resources/SS/"+ssName+".png");
			
			try {
				FileUtils.copyFile(src, dest);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return dest.getAbsolutePath();
		}
		
	}


