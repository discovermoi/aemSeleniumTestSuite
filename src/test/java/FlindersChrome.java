/* Started on 18th of April 2018 === >> Tryst with set up activity.
This Project aims at:
= building up test cases for aem applications run against aem instances
= work against aem instances irrespective of environments
= attempts to be not so specific - selectors not based on IDs
= attempts integrating Cucumber BDD
= attempts integrating TestNG
= attempts integrating BOBCAT which is more friendly for testing aem authoring activities thru SiteAdmin APIs
    = it helps in creating pages for authoring and destroys it after testing.
*/
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class FlindersChrome {
    @Test
    public void HelloWorld() {
        try {
            FirefoxOptions options = new FirefoxOptions();
            WebDriver driverJ = new RemoteWebDriver(new URL("http://10.24.44.52:4444/wd/hub"), options);
            driverJ.get("http://stage.flinders.edu.au");
            driverJ.close();
        } catch (MalformedURLException exception) {
            throw new RuntimeException(exception);
        }
    }
}