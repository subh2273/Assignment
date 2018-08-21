package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Steps {
	WebDriver driver;

	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page(){
		//System.setProperty("webdriver.chrome.driver","D:\\Interview Prep\\Automation\\Selenium Installer\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.amazon.com");
	}

	@When("^he search for “item”$")
	public void he_search_for_item() throws Throwable {
		Select drpdwnItem = new Select(driver.findElement(By.id("searchDropdownBox")));
		drpdwnItem.selectByVisibleText("Books");
		WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
		searchBox.sendKeys("data catalog");
		WebElement submit=driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input"));
		submit.click();
		
	}

	@When("^choose to buy the first item$")
	public void choose_to_buy_the_first_item() {
		List<WebElement> items = driver.findElements(By.cssSelector("div.a-fixed-left-grid-col.a-col-left "));
		items.get(0).click();

				
	}

	@When("^extract details of the product$")
	public void extract_details_of_the_product(){
		List<WebElement> allElements = driver.findElements(By.xpath("//*[@id=\"productDetailsTable\"]/tbody/tr/td/div/ul/li")); 

		for (WebElement element: allElements) {
		      System.out.println(element.getText());
		}	
	}

	

	@When("^close the browser$")
	public void close_the_browser() {
		driver.close();
	}	

}