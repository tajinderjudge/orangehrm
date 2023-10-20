package com.orangehrm.qa.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.orangehrm.qa.action.actionDriver;
import com.orangehrm.qa.base.Base;

public class LoginPage extends Base{
actionDriver actionDriver= new actionDriver();
@FindBy(xpath="//span[contains(text(),'Username')]")
WebElement username;

@FindBy(xpath="//input[@name='txtPassword']")
WebElement password;

@FindBy(xpath="//input[@type='submit']")
WebElement submit;

public LoginPage()
{
	PageFactory.initElements(driver,this);
}

public void verifyLogin(String userid, String pass)
{
	
	
actionDriver.sendKeys(username, userid);
actionDriver.sendKeys(password, pass);
actionDriver.actionClick(driver,submit);

}


}
