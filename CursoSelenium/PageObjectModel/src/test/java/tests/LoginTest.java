package tests;

import org.openqa.selenium.support.PageFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.junit.Assert;
import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;
import utils.excelutils.ExcelUtil;

public class LoginTest extends TestBase {

	@Test
	public void init() throws Exception {

		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		
		loginpage.setUserName(getUserName());
		loginpage.setPassword(getPassword());
		loginpage.clickOnLoginButton();

		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		Assert.assertTrue(homepage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
	}
	
	public String getUserName() throws Exception
	{
		XSSFRow row = ExcelUtil.getRowData(1);
		return row.getCell(1).toString();
	}
	
	public String getPassword() throws Exception
	{
		XSSFRow row = ExcelUtil.getRowData(1);
		return row.getCell(2).toString();
	}

}
