package script;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic.AUL;
import generic.BaseTest;
import generic.Excel;
import pages.LoginPage;

public class InvalidLogin extends BaseTest
{
	@DataProvider
	public String[][] getData()
	{
		int rc=Excel.getRowCount(XL_PATH, "InvalidLogin");
		String[][] data=new String[rc][2];
		for(int r=0;r<rc;r++)
		{
			for(int c=0;c<=1;c++)
				data[r][c]=Excel.getCellValue(XL_PATH, "InvalidLogin", r+1, c);
		}
		return data;
		
	}
	
	@Test(dataProvider="getData", priority=2, groups="login")
	public void testInvalidLogin(String un, String pw)
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(un);
		lp.setPassword(pw);
		lp.clickLogin();
		lp.verifyErrorMessageIsDisplayed(driver);
	}
	
}

