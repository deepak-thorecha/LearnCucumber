package sample.LearnCucumber.TestDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EbayLoginStepDefinition {

	WebDriver driver;
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	}
	
	@Given("^Browser is opened$")
	public void browser_is_opened() throws Throwable {
		driver.get("https://www.ebay.com.au/");
	}

	@Given("^I am on LoginPage$")
	public void i_am_on_LoginPage() throws Throwable {
		driver.findElement(By.cssSelector("span#gh-ug > a")).click();
	}
	
	@When("^I enter username$")
	public void i_enter_username_as_testaunone() throws Throwable {
		driver.findElement(By.cssSelector("input[name='userid']")).sendKeys("testaunone");
	}

	@When("^Password$")
	public void password_as_N_wBuy_t() throws Throwable {
		driver.findElement(By.cssSelector("input[name='pass']")).sendKeys("N0wBuy1t!");
	}
	
	@When("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_and(String uName, String pswd) throws Throwable {
		driver.findElement(By.cssSelector("input[name='userid']")).sendKeys(uName);
		driver.findElement(By.cssSelector("input[name='pass']")).sendKeys(pswd);
	}
	
	@When("^I click signIn button$")
	public void i_click_signIn_button() throws Throwable {
		driver.findElement(By.cssSelector("#btnWrapper2 input[name='sgnBt']")).click();
	}

	@Then("^I check if Login is successful$")
	public void i_check_if_Login_is_successful() throws Throwable {
		try{
			Assert.assertTrue("Logged in Username is missing...!", driver.findElement(By.cssSelector("button#gh-ug > b")).isDisplayed());
			System.out.println("<["+driver.findElement(By.cssSelector("button#gh-ug > b")).getText()+"]> is the Logged in Username");
		}catch(NoSuchElementException ex) {
			System.out.println("Failed to Login...!!!");
		}
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
}
