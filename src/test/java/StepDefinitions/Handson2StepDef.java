package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Handson2StepDef {

	WebDriver driver;

	@Before
	public void startBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@After
	public void closebrowser() {
		driver.quit();
	}

	@Given("^User is on homepage of myContactForm$")
	public void user_is_on_homepage_of_myContactForm() {
		// Write code here that turns the phrase above into concrete actions
		driver.get("https://www.mycontactform.com/samples/basiccontact.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Then("^user needs to click on here button for signup$")
	public void user_needs_to_click_on_here_button_for_signup() {
		// Write code here that turns the phrase above into concrete actions
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//*[@id=\"center_col\"]/p/a")).click();

	}

	@Then("^enter the details of user$")
	public void enter_the_details_of_user(DataTable credentials)  {
		List<List<String>> userData = credentials.asLists();
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(userData.get(0).get(0));
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(userData.get(0).get(1));
		driver.findElement(By.xpath("//*[@id=\"user_signup\"]")).sendKeys("abc");
		driver.findElement(By.xpath("//*[@id=\"pass_signup\"]")).sendKeys("abcd@308");
		driver.findElement(By.xpath("//*[@id=\"pass2\"]")).sendKeys("abcd@308");
	}

	@Then("^after giving details submit the form$")
	public void after_giving_details_submit_the_form() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"useragree\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"center_col\"]/form/div[7]/input")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, 5);
		try {
			wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"success_status\"]"))));
		}catch (Exception e){
			System.out.println(driver.findElement(By.xpath("//div[@id='error_status']/span")).getText());
			System.out.println(driver.findElement(By.xpath("//div[@id='error_status']/ul/li")).getText());

		}

	}

}
