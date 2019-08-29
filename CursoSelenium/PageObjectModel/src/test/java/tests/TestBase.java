package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.junit.After;
import org.junit.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.excelutils.ExcelUtil;

public class TestBase {

	public static WebDriver driver = null;

	@Before
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

	@After
	// Test cleanup
	public void TeardownTest() {
		TestBase.driver.quit();
	}

}