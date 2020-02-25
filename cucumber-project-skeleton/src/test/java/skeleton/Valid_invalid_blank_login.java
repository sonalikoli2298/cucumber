package skeleton;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Valid_invalid_blank_login {
	/*
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
	}
*/
	WebDriver d;
	@Given("user is on the testme app")
	public void user_is_on_the_testme_app() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\SONALI\\\\chrome\\\\chromedriver.exe");
		d=new ChromeDriver();
	    d.navigate().to("https://10.232.237.143/TestMeApp/fetchcat.htm");
	    d.findElement(By.linkText("SignIn")).click();
	}

	@When("the user provides valid username and password")
	public void the_user_provides_valid_username_and_password() {
	    d.findElement(By.name("userName")).sendKeys("Lalitha");
	    d.findElement(By.name("password")).sendKeys("Password123");
	    d.findElement(By.name("Login")).click();
	}

	@Then("the user is redirected to next page")
	public void the_user_is_redirected_to_next_page() {
	    String msg=d.findElement(By.cssSelector("ul.nav")).getText();
	    String msg1="Hi, Lalitha";
	    Assert.assertTrue(msg.contains(msg1));
	    d.findElement(By.linkText("SignOut")).click();
	}

	@When("the user provides invalid username and password")
	public void the_user_provides_invalid_username_and_password() {
		d.findElement(By.name("userName")).sendKeys("Sonali");
	    d.findElement(By.name("password")).sendKeys("Koli");
	    d.findElement(By.name("Login")).click();
	}

	@Then("the user gets error message")
	public void the_user_gets_error_message() {
		d.findElement(By.id("errormsg")).getText();
	    System.out.println("Invalid username and password");
	}

	@When("the user does not provide username and password and clicks login")
	public void the_user_does_not_provide_username_and_password_and_clicks_login() {
		//d.findElement(By.name("userName")).click();;
	    //d.findElement(By.name("password")).click();;
	    d.findElement(By.name("Login")).click();
	}
	@Then("error is blank username and password")
	public void error_is_blank_username_and_password() {
		d.findElement(By.id("errormsg")).getText();
	    System.out.println("blank username and password");
	}
	
}
