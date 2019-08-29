package testng;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import utils.excelutils.ExcelUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public static WebDriver driver = null;

	@BeforeTest
	public void initialize() throws Exception {
		ExcelUtil.setTestDataExcelFileName("testdata.xlsx");
		ExcelUtil.setExcelFileSheet("LoginData");
		System.setProperty("webdriver.chrome.driver", "C://selenium//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		// To maximize browser
		driver.manage().window().maximize();
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// To open http://demo.guru99.com/V4/
		driver.get("http://demo.guru99.com/V4/");

	}

	@AfterTest
	// Test cleanup
	public void TeardownTest() {
		TestBase.driver.quit();
	}

}