package com.stepdefinitions;



import com.controller.Controller;
import com.operations.OperationList;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Login {
	
	
	
	
	@Given("^user launch \"([^\"]*)\" browser$")
	public void user_launch_browser(String browserName)  {
	    Controller.forEachStep("", Controller.stepName, OperationList.setup, new String[] {browserName});
	   
	    
	}

	@Then("^user enters \"([^\"]*)\" as url$")
	public void user_enters_as_url(String url)  {
	  Controller.forEachStep("", Controller.stepName, OperationList.enterURL, new String[] {url});  
	    
	}

	@Then("^user enters \"([^\"]*)\" and \"([^\"]*)\" as username and password$")
	public void user_enters_and_as_username_and_password(String userName, String password)  {
	   
		Controller.forEachStep("username", Controller.stepName, OperationList.enterCredentials, new String[] {userName,password});
	    
	}

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button()  {
	   Controller.forEachStep("loginButton", Controller.stepName, OperationList.clickLogin, new String[0]); 
	    
	}

	@Then("^user directed to homepage$")
	public void user_directed_to_homepage()  {
	    Controller.forEachStep("", Controller.stepName, OperationList.onHomePage, new String[0]);
	    
	}
	
	@Then("^user close the browser$")
	public void user_close_the_browser() {
	   Controller.forEachStep("", Controller.stepName, OperationList.tearDown, new String[0]); 
	    
	}



}
