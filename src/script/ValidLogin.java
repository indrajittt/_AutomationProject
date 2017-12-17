package script;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic.AUL;
import generic.BaseTest;
import generic.Excel;
import pages.LoginPage;

public class ValidLogin extends BaseTest
{
	
	@DataProvider
	public String[][] getData()
	{
		int rc=Excel.getRowCount(XL_PATH, "ValidLogin");
		String[][] data=new String[rc][3];
		for(int r=0;r<rc;r++)
		{
			for(int c=0;c<=2;c++)
				data[r][c]=Excel.getCellValue(XL_PATH, "ValidLogin", r+1, c);
		}
		return data;
		
	}
	
	@Test(dataProvider="getData", priority=1, groups="login")
	public void testValidLogin(String un, String pw, String eTitle)
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(un);
		lp.setPassword(pw);
		lp.clickLogin();
		AUL.verifyTitle(driver, eTitle);
	}
	
}
