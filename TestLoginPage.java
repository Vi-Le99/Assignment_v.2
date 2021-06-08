package pomAssignment;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLoginPage {
	public String url = "https://github.com/";
	public String path = "C:\\Selenium\\driver\\chromedriver.exe";
	public WebDriver driver;

	LoginPage objLogin;
	ProjectVDPage objProjectVD;
	CreatePullRequestPage objCreatePullRequest;

	String expectualString = "GitHub";

	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.get(url);

		objLogin = new LoginPage(driver);
		objProjectVD = new ProjectVDPage(driver);
		objCreatePullRequest = new CreatePullRequestPage(driver);
	}

	@Test(priority = 0)
	public void testLogin() {
		driver.findElement(By.linkText("Sign in")).click();
		objLogin.loginPageGithub("lelythuyvi.h214cla@gmail.com", "Ami@Khongconhom1");
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), expectualString);
	}

	@Test(priority = 1)
	public void testCreatePullRequest() throws InterruptedException {
		driver.get("https://github.com/AMI-99/VD");
		Thread.sleep(1500);

		objProjectVD.uploadFile();

		WebElement chooseFileElement = driver.findElement(By.id("upload-manifest-files-input"));
		chooseFileElement.sendKeys("G:\\Java\\mavenSample\\src\\test\\java\\parameter\\HaveParameter.java");
		Thread.sleep(7000);

		driver.findElement(By.cssSelector("input[value='quick-pull']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"repo-content-pjax-container\"]/form/button")).click();

		objCreatePullRequest.writeTitle("Bổ sung file HaveParameter.java");
		Thread.sleep(1500);
		objCreatePullRequest.leaveComment("this is a test create a pull request");
		Thread.sleep(1500);
		objCreatePullRequest.chooseLabel("documentation");
		Thread.sleep(1500);
		objCreatePullRequest.submit();

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
