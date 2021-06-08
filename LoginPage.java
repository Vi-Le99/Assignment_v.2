package pomAssignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {
	WebDriver driver;

	@FindBy(name = "login")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "commit")
	WebElement signIn;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 20);
		PageFactory.initElements(factory, this);
	}

	public void setUsername(String usernameString) {
		username.sendKeys(usernameString);
	}

	public void setPassword(String passwordString) {
		password.sendKeys(passwordString);
	}

	public void loginPageGithub(String usernameString, String passwordString) {
		this.setUsername(usernameString);
		this.setPassword(passwordString);
		signIn.click();
	}

}
