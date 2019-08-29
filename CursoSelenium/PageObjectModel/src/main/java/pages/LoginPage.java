package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Using FindBy for locating elements
	@FindBy(how = How.XPATH, using = "//input[@name='uid']")
	WebElement userNameTextBox;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordTextBox;
	
	@FindBy(name="btnLogin")
	WebElement signinButton;

	// Defining all the user actions (Methods) that can be performed in the login page

	// This method is to set Email in the email text box
	public void setUserName(String userName) {
		userNameTextBox.sendKeys(userName);
	}

	// This method is to set Password in the password text box
	public void setPassword(String strPassword) {
		passwordTextBox.sendKeys(strPassword);
	}

	// This method is to click on Login Button
	public void clickOnLoginButton() {
		signinButton.click();
	}
}