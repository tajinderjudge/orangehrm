package com.orangehrm.qa.utilities;



	import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;

	public class Utils {

		public static long pageLoadTimeout=20;
		public static long implicitlyWait=20;
		
		
		public static void takeImage(WebDriver driver,String imageName)
		{
			try 
			{
			  TakesScreenshot ts=(TakesScreenshot)driver;
			  File src=ts.getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFile(src,new File("./Image/"+imageName+".png"));
			  System.out.println("Testcase Failed Image genrated");
			}
			catch(Exception e)
			{
				System.out.println("Something went wrong so can be able to genrate image");
			}
		}

	}


