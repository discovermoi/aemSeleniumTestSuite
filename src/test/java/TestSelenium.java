import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium {
    public static void main(String[] args){
        FirefoxDriver driver=new FirefoxDriver();
        driver.get("http://localhost:4502/editor.html/content/flinders/en.html");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.id("submit-button")).click();
    }
}