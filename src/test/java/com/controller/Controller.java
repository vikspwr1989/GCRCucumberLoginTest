package com.controller;

import java.lang.reflect.Method;
import java.util.Collection;

import org.apache.log4j.Logger;

import com.config.Config;
import com.operations.OperationList;
import com.stepdefinitions.Hookable;

public class Controller {
	
	public static Logger logger = Logger.getLogger(Controller.class);
	
	public static String stepName;
	public static String methodName;
	public static String xpath;
	
	
	public static void forEachStep(String objectLogicalName,String stepName,Enum<OperationList> operationName,String[] input)
	{
		Hookable.stepCount++;
		Controller.stepName = stepName;
		
		
		System.out.println("ObjectLogicalName is :"+objectLogicalName);
		
		methodName = operationName.toString();
		xpath = Config.getXpath(objectLogicalName);
		
		try {
			Class<?> object = Class.forName("com.operations.Operations");
			Method[] methods = object.getDeclaredMethods();
			
			for (Method method : methods) {
				
				if(method.getName().equalsIgnoreCase(methodName))
				{
					System.out.println(Hookable.stepCount+" "+method.getName()+" invoked");
					logger.info(Hookable.stepCount+" "+method.getName()+" invoked");
					method.invoke(null, xpath, input);
					
				}
				
			}
			
		} catch (Exception e) {
			System.out.println("Class Not Found : [Operations]");
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	public static void forEachScenario(String scenarioName,Collection<String> suiteName)
	{
		logger.info("Scenario :"+scenarioName);
		logger.info("SuiteName :"+suiteName);
		System.out.println(scenarioName);
		System.out.println(suiteName);
	}

}
