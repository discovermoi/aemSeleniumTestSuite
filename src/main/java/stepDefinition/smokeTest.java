package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class smokeTest {
    WebDriver driver;
    @Given("^Open browser and start the aem instance$")
    public void open_browser_and_start_the_aem_instance() throws Throwable {
        driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:4502/editor.html/content/flinders/en.html");
    }

    @When("^I enter valid username and valid password$")
    public void i_enter_valid_username_and_valid_password() throws Throwable {
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("admin");

    }

    @Then("^user should be able to login successfully$")
    public void user_should_be_able_to_login_successfully() throws Throwable {
        driver.findElement(By.id("submit-button")).click();
    }
}
