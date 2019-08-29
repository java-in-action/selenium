package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// Using FindBy for locating elements
	@FindBy(xpath = "//table//tr[@class='heading3']")
	WebElement homePageUserName;

	// Defining all the user actions (Methods) that can be performed in the home
	// page

	// Get the User name from Home Page
	public String getHomePageDashboardUserName() {

		return homePageUserName.getText();

	}

}