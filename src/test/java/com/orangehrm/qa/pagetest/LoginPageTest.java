package com.orangehrm.qa.pagetest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.google.common.annotations.VisibleForTesting;
import com.orangehrm.qa.base.Base;
import com.orangehrm.qa.pageobject.LoginPage;

public class LoginPageTest extends Base {
         
	LoginPage login;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
	
		initialization();
		login = new LoginPage();
		
	}
	
	
	@Test
	public void login()
	{
	 //   System.out.printf(prop.getProperty("password"));
		//System.out.printf(prop.getProperty("userid"));
		
		login.verifyLogin(prop.getProperty("userid"),prop.getProperty("password"));	
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		//driver.close();
	}
}
