package pomAssignment;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CreatePullRequestPage {
	WebDriver driver;

	@FindBy(id = "pull_request_title")
	WebElement titleElement;

	@FindBy(xpath = "//*[@id='labels-select-menu']/summary")
	WebElement labelElement;

	@FindBy(id = "label-filter-field")
	WebElement fieldLabelElement;

	@FindBy(id = "pull_request_body")
	WebElement commentElement;

	@FindBy(xpath = "//*[@id='new_pull_request']/div/div[1]/div/div[2]/div/div[2]/div/button")
	WebElement submitElement;

	public CreatePullRequestPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 20);
		PageFactory.initElements(factory, this);
	}

	public void writeTitle(String titleString) {
		titleElement.clear();
		titleElement.sendKeys(titleString);
	}

	public void chooseLabel(String labelString) {
		Actions actions = new Actions(driver);
		Action mouseAction = actions.moveToElement(labelElement).click().sendKeys(fieldLabelElement, labelString)
				.sendKeys(fieldLabelElement, Keys.ENTER).sendKeys(fieldLabelElement, Keys.ESCAPE).build();
		mouseAction.perform();
	}

	public void leaveComment(String commentString) {
		commentElement.sendKeys(commentString);
	}

	public void submit() {
		submitElement.click();
	}

}
