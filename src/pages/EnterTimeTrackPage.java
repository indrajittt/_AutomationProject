package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import generic.AUL;
import generic.IAutoConst;

public class EnterTimeTrackPage {
	@FindBy(xpath="//div[contains(text(),'Help')]")
	private WebElement help;
	
	@FindBy(linkText="About your actiTIME")
	private WebElement aboutActiTIME;
	
	@FindBy(xpath="//span[starts-with(.,'actiTIME')]")
	private WebElement productVersion;
	
	@FindBy(id="aboutPopupCloseButtonId")
	private WebElement closeBTN;
	
	@FindBy(id="logoutLink")
	private WebElement logoutLink;
	
	public EnterTimeTrackPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	public void clickHelp(){
		help.click();
	}
	
	public void clickAboutActiTIME(){
		aboutActiTIME.click();
	}
	
	public void verifyVersion(String eVersion){
		String aVersion=productVersion.getText();
		Assert.assertEquals(aVersion, eVersion);
	}
	
	public void clickClose(){
		closeBTN.click();
	}
	
	public void clickLogout(){
		logoutLink.click();
	}
	
	public void verifyTitle(WebDriver driver,String eTitle){
		String strETO=AUL.getProperty(IAutoConst.SETTING_PATH, "ETO");
		long ETO=Long.parseLong(strETO);
		WebDriverWait wait=new WebDriverWait(driver,ETO);
		try{
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log("Title is Matching",true);
		}
		catch(Exception e){
			Reporter.log("Title is NOT Matching",true);
			Assert.fail();
		}
		
	}
}












