package skeleton;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class demowebshop {
    WebDriver D;
    String expmsg; 
     @Given("^demoWebshop site is open$")
     public void demowebshop_site_is_open() throws Throwable {
     System.setProperty("webdriver.chrome.driver","C:\\SONALI\\chrome\\chromedriver.exe");
       //ClassName Obj = new Classname();
       D = new ChromeDriver(); 
       D.get("http://demowebshop.tricentis.com/");
       D.findElement(By.linkText("Log in")).click();
       Thread.sleep(2000); 
    }
     
    @When("^demowebshop \"(.*?)\" plus \"(.*?)\" is provided$")
    public void demowebshop_plus_is_provided(String un, String pwd) throws Throwable {
    D.findElement(By.id("Email")).sendKeys(un);
    D.findElement(By.name("Password")).sendKeys(pwd);
    D.findElement(By.cssSelector("input[value='Log in']")).click();
       Thread.sleep(2000); 
    expmsg=un;
    }

    @Then("^demowebshop login page should be displayed$")
    public void demowebshop_login_page_should_be_displayed() throws Throwable {
    String msg =D.findElement(By.cssSelector("a[class='account']")).getText();
    Assert.assertEquals(msg, expmsg);
    System.out.println("Test is passed"); 
    D.findElement(By.linkText("Log out")).click();
    D.close();
    }
}
