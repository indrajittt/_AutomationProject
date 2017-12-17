package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;



//Automation Utility Library
public class AUL implements IAutoConst
{
	public static String getProperty(String path, String key)
	{
		String v="";
		try
		{	
			Properties p=new Properties();
			p.load(new FileInputStream(path));
			v=p.getProperty(key);
		} catch (Exception e)
		{
		}			
		return v;
	}
	
	public static void takePhoto(String folder, String testName, WebDriver driver)
	{
		String dateTime=new Date().toString().replaceAll(":", "_");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		String destPath=folder+testName+dateTime+".png";
		try
		{
			FileUtils.copyFile(srcFile, new File(destPath));
		} catch (IOException e)
		{
		}
	}
	
	public static void verifyTitle(WebDriver driver, String eTitle)
	{
		WebDriverWait wait=new WebDriverWait(driver, Long.parseLong(getProperty(SETTING_PATH, "ETO")));
		try{
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log(eTitle + " page is displayed", true);
		}
		catch(Exception e)
		{
			Reporter.log(eTitle + " page is not displayed", true);
			Assert.fail();
		}
	}
}
