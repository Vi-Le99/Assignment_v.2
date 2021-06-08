package pomAssignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ProjectVDPage {
	WebDriver driver;

	@FindBy(css = "span[class='dropdown-caret ml-1']")
	WebElement addFile;

	@FindBy(linkText = "Create new file")
	WebElement createNewFileElement;

	@FindBy(linkText = "Upload files")
	WebElement uploadFileElement;

	public ProjectVDPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 20);
		PageFactory.initElements(factory, this);
	}

	public void createFile() {
		addFile.click();
		createNewFileElement.click();
	}

	public void uploadFile() {
		addFile.click();
		uploadFileElement.click();
	}

}
