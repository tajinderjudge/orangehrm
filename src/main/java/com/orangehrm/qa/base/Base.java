package com.orangehrm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.orangehrm.qa.utilities.Utils;


public class Base {
	
	public static String propertiesPath="D:\\selenium2\\orangehrm\\src\\main\\java\\com\\orangehrm\\qa\\configruration\\config.properties";
	public WebDriver driver=null;
	//public Properties prop;
	public static Properties prop;
	public static FileInputStream fis;
	public Base()
	{
		try
		{
			fis= new FileInputStream(propertiesPath);
			prop=new Properties();
			prop.load(fis);			
		}
		catch(FileNotFoundException f)
		{
			System.out.println("Please check your properties file location ");
		}
		catch(IOException i)
		{
			System.out.println("Please check write and read permission");
		}

	}
	public void initialization()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			System.setProperty("webdriver.chrome.driver","D:\\liveproject\\Banking\\chromedriver.exe");
			driver = new ChromeDriver(options);
		}
		if(browserName.equalsIgnoreCase("edge"))
		{
			driver= new EdgeDriver();
		}
		if(browserName.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utils.pageLoadTimeout));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utils.implicitlyWait));
		driver.get(prop.getProperty("url"));
	}
}

	



