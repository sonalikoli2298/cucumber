
package skeleton;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class OnlineTestMeApp {
WebDriver d;
@Given("OnlineTestMe is opened")
public void onlinetestmeapp_is_opened() {
	System.setProperty("webdriver.chrome.driver","C:\\SONALI\\chrome\\chromedriver.exe");
	d=new ChromeDriver();
	d.navigate().to("https://10.232.237.143/TestMeApp/fetchcat.htm");
	d.findElement(By.linkText("SignIn")).click();
}

@When("I provide valid online login password") 
public void  I_provide_valid_online_login_password() { 
	
	d.findElement(By.name("userName")).sendKeys("Lalitha");
	d.findElement((By.name("password"))).sendKeys("Password123");
	d.findElement(By.name("Login")).click();
}

@Then("the online user can login")
public void the_online_user_can_login() {
	String msg=d.findElement(By.cssSelector("ul.nav")).getText();
	String msg2="Hi, Lalitha";
	Assert.assertTrue(msg.contains(msg2));
	d.findElement(By.linkText("SignOut")).click();
}
}

/*
package skeleton;
 
import org.junit.Assert; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver; 
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then; 
import cucumber.api.java.en.When;

public class OnlineTestMeApp {
 
WebDriver driver;

 
@Given("OnlineTestMe is opened")
public void OnlineTestMe_is_opened() {
System.setProperty("webdriver.chrome.driver","C:\\\\SONALI\\\\chrome\\\\chromedriver.exe"); 
driver = new ChromeDriver(); 
driver.get("https://10.232.237.143/TestMeApp/fetchcat.htm"); 
driver.findElement(By.linkText("SignIn")).click();
}

 
@When("I provide valid online login password") 
public void I_provide_valid_online_login_password() { 
driver.findElement(By.name("userName")).sendKeys("Lalitha"); 
driver.findElement(By.name("password")).sendKeys("Password123"); 
driver.findElement(By.name("Login")).click();
}
 
@Then("the online user can login")
public void the_online_user_can_login() {
String msg=driver.findElement(By.cssSelector("ul.nav")).getText();
String msg2="Hi, Lalitha";
Assert.assertTrue(msg.contains(msg2));
driver.findElement(By.linkText("SignOut")).click();
}
}
*/

