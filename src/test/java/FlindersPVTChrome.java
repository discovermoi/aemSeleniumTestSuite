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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class FlindersPVTChrome {
    /*FirefoxDriver driver=new FirefoxDriver();
    Actions builder = new Actions(driver);
    WebDriverWait webDriverWait = new WebDriverWait(driver,10);
    WebDriverWait webDriverWaitForAuthor = new WebDriverWait(driver,20);*/

    @Test
    public void Case1_OpenHomePageTest(){
        DesiredCapabilities capability = DesiredCapabilities.firefox();
        capability.setCapability("platform", Platform.ANY);
        try {
            WebDriver driverJ = new RemoteWebDriver(new URL("http://fuaemci.australiasoutheast.cloudapp.azure.com:4444/wd/hub"), capability);
            driverJ.get("http://stage.flinders.edu.au");
            driverJ.close();
        }catch (MalformedURLException exception){
            throw new RuntimeException(exception);
        }
    }

    /*@Test
    public void Case2_SearchBarTest() {
        driver.get("http://stage.flinders.edu.au");
        driver.findElement(By.id("searchbarq")).clear();
        driver.findElement(By.id("searchbarq")).sendKeys("Accounting");
        driver.findElement(By.id("searchbarq")).sendKeys(Keys.ENTER);
        //webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.current")));
        //driver.findElement(By.cssSelector("div.current")).click();
        driver.close();
        // Unable to access Search Icon so used ENTER key
    }

    @Test
    public void Case3_NavMenuAndContainedLinksTest() {
        driver.get("http://stage.flinders.edu.au");

        WebElement study = driver.findElement(By.partialLinkText("Study"));
        WebElement research = driver.findElement(By.partialLinkText("Research"));
        WebElement engage = driver.findElement(By.partialLinkText("Engage"));
        WebElement alumni = driver.findElement(By.partialLinkText("Alumni"));
        WebElement about = driver.findElement(By.partialLinkText("About"));
        WebElement quicklinks = driver.findElement(By.partialLinkText("Quick"));
        WebElement topsearch = driver.findElement(By.className("header_search_top"));

        builder.moveToElement(study).pause(100).perform();
        builder.moveToElement(research).pause(100).perform();
        builder.moveToElement(engage).pause(100).perform();
        builder.moveToElement(alumni).pause(100).perform();
        builder.moveToElement(about).pause(100).perform();
        builder.moveToElement(quicklinks).pause(100).perform();
        topsearch.click();
        driver.close();
        // Need to check if the links are functional
    }

    @Test
    public void Case4_WebsiteSearch() {
        driver.get("http://stage.flinders.edu.au");
        WebElement topsearch = driver.findElement(By.className("header_search_top"));
        topsearch.click();
        driver.findElement(By.id("gsc-i-id1")).sendKeys("Psychology");
        driver.findElement(By.id("gsc-i-id1")).sendKeys(Keys.ENTER);
        driver.close();
    }

    @Test
    public void Case5_NewsPageTest(){
        driver.get("http://stage.news.flinders.edu.au");
        driver.close();
    }

    @Test
    public void Case6_StudyAndInternational(){
        driver.get("https://stage.flinders.edu.au/study");
        driver.get("https://stage.flinders.edu.au/study/arts");
        driver.get("https://stage.flinders.edu.au/study/business-commerce-management");
        driver.get("https://stage.flinders.edu.au/international");
        driver.get("https://stage.flinders.edu.au/international/arts");
        driver.get("https://stage.flinders.edu.au/international/business-commerce-management");
        driver.close();
    }

    @Test
    public void Case7_ReserachAreaPagesTest(){
        driver.get("https://stage.flinders.edu.au/research");
        driver.get("https://stage.flinders.edu.au/research/engineering-and-technology");
        driver.get("https://stage.flinders.edu.au/research/research-impact");
        driver.close();
    }

    @Test
    public void Case8_IFrameContentTest(){
        driver.get("https://stage.flinders.edu.au/international/contact-us");
        driver.get("https://stage.flinders.edu.au/employment/professional");
        driver.get("https://stage.flinders.edu.au/study/apply/credit-transfer");
        driver.close();
    }

    @Test
    public void Case9To10_SearchForCommerceinCoursePagesTest(){
        driver.get("http://stage.flinders.edu.au/courses");
        driver.findElement(By.id("q")).sendKeys("Commerce");
        driver.findElement(By.id("q")).sendKeys(Keys.ENTER);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".sj-result-title a")));
        String courseURL = driver.findElement(By.cssSelector(".sj-result-title a")).getAttribute("href");
        driver.get(courseURL);
        webDriverWait.until(ExpectedConditions.urlContains("courses"));
        driver.findElement(By.partialLinkText("Study")).click();
        driver.close();
    }

    @Test
    public void Case11_ClickOnBusinessCourseTest() {
        driver.get("http://stage.flinders.edu.au/study");
        builder.moveToElement(driver.findElement(By.id("main-item"))).pause(5).perform();
        driver.findElement(By.partialLinkText("Business, commerce and management")).click();
        driver.close();
    }

    @Test
    public void Case12To14_ViewallCoursesTest() {
        driver.get("http://stage.flinders.edu.au/international/arts");
        driver.findElement(By.partialLinkText("View all courses")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".course_information_list li a")));
        String courseURL = driver.findElement(By.cssSelector(".course_information_list li a")).getAttribute("href");
        driver.get(courseURL);
        driver.navigate().back();
        driver.navigate().refresh();
        driver.findElement(By.partialLinkText("Postgraduate")).click();
        driver.get(courseURL);
        driver.close();
    }

    @Test
    public void Case17_FeedbackSubmit() {
        driver.get("https://stage.flinders.edu.au/website-feedback");
        WebElement iframeSwitch = driver.findElement(By.id("73321130540844"));
        driver.switchTo().frame(iframeSwitch);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".form-all")));
        Select areYouDropdown = new Select(driver.findElement(By.id("input_2")));
        areYouDropdown.selectByIndex(1);
        driver.findElement(By.id("input_36_5")).click();
        driver.findElement(By.id("input_37_5")).click();
        driver.findElement(By.id("input_41_5")).click();
        driver.findElement(By.id("input_18")).sendKeys("General Comments and feedback inputed from machine");
        driver.findElement(By.id("label_input_19_1")).click();
        driver.findElement(By.id("input_33")).click();
        webDriverWait.until(ExpectedConditions.urlContains("thank-you"));
        driver.close();
    }

    @Test
    public void Case18_ContactUs() {
        driver.get("https://stage.flinders.edu.au/study-online/contact-us");
        WebElement iframeSwitch = driver.findElement(By.id("73197275973875"));
        driver.switchTo().frame(iframeSwitch);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".form-all")));
        driver.findElement(By.id("input_2")).sendKeys("Web Transformation");
        driver.findElement(By.id("input_4")).sendKeys("someemail@someemail.com");
        driver.findElement(By.id("input_5")).sendKeys("0808080808");
        driver.findElement(By.id("input_7")).sendKeys("Thursday After 5 PM");
        driver.findElement(By.id("input_3")).sendKeys("5042");
        driver.findElement(By.id("label_input_8_1")).click();
        Select courseOfInterest = new Select(driver.findElement(By.id("input_10")));
        courseOfInterest.selectByIndex(1);
        driver.findElement(By.id("input_12")).sendKeys("No I dont have any questions");
        // Second Dropdown Population - wait time...
        webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.id("input_15"),By.tagName("option")));
        Select studyPeriod = new Select(driver.findElement(By.id("input_15")));
        studyPeriod.selectByIndex(1);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("input_13")));
        driver.findElement(By.id("input_13")).click();
        webDriverWait.until(ExpectedConditions.urlContains("thank-you"));
        driver.close();
    }

    @Test
    public void Case19_LegacyCMSTest(){
        driver.get("http://stage.flinders.edu.au/library");
        driver.get("http://stage.flinders.edu.au/ehl");
        driver.get("http://stage.flinders.edu.au/medicine");
        driver.get("http://stage.flinders.edu.au/nursing");
        driver.get("http://stage.flinders.edu.au/sohs");
        driver.get("http://stage.flinders.edu.au/sabs");
        driver.get("http://stage.flinders.edu.au/science_engineering");
        driver.close();
    }

    @Test
    public void Case20_KeyApplicationsOutofScopeTest(){
        driver.get("http://stage.events.flinders.edu.au");
        driver.get("http://stage.flinders.edu.au/directory/main-display-search-form.cfm");
        driver.get("http://stage.flinders.edu.au/people/john.roddick ");
        driver.close();
    }

    // Author Tests

    /*@Test
    public void ProdAuthorTests(){
        //driver.get("https://stage.author.flinders.edu.au/projects.html/content/projects");
        //webDriverWaitForAuthor.until(ExpectedConditions.urlToBe("https://stage.author.flinders.edu.au/projects.html/content/projects"));
        driver.get("https://stage-author.flinders.edu.au/editor.html/content/flinders/en/about.html");
        //builder.pause(10).perform();
        // Insert Accordion - Issue is the parsys found is random; need to control it...
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-text='Drag components here']")));
        driver.findElement(By.cssSelector("div[data-text='Drag components here']")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-action='INSERT']")));
        driver.findElement(By.cssSelector("button[data-action='INSERT']")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".coral-SelectList-sublist button[data-path='/apps/flinders/components/content/accordion']")));
        driver.findElement(By.cssSelector(".coral-SelectList-sublist button[data-path='/apps/flinders/components/content/accordion']")).click();
    }*/

}