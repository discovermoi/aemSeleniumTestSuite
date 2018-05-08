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
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FlindersPVTChrome {
    ChromeDriver driver=new ChromeDriver();
    Actions builder = new Actions(driver);
    WebDriverWait webDriverWait = new WebDriverWait(driver,10);

    @Test
    public void Case1_OpenHomePageTest(){

        driver.get("http://www.flinders.edu.au");
    }

    @Test
    public void Case2_SearchBarTest() {
        driver.get("http://www.flinders.edu.au");
        driver.findElement(By.id("searchbarq")).clear();
        driver.findElement(By.id("searchbarq")).sendKeys("Accounting");
        driver.findElement(By.id("searchbarq")).sendKeys(Keys.ENTER);
        // Unable to access Search Icon so used ENTER key
    }

    @Test
    public void Case3_NavMenuAndContainedLinksTest() {
        driver.get("http://www.flinders.edu.au");
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
        // Need to check if the links are functional
    }

    @Test
    public void Case4_WebsiteSearch() {
        driver.get("http://www.flinders.edu.au");
        WebElement topsearch = driver.findElement(By.className("header_search_top"));
        topsearch.click();
        driver.findElement(By.id("gsc-i-id1")).sendKeys("Psychology");
        driver.findElement(By.id("gsc-i-id1")).sendKeys(Keys.ENTER);
    }

    @Test
    public void Case5_NewsPageTest(){
        driver.get("http://news.flinders.edu.au");
    }

    @Test
    public void Case6_StudyAndInternational(){
        driver.get("https://www.flinders.edu.au/study");
        driver.get("https://www.flinders.edu.au/study/arts");
        driver.get("https://www.flinders.edu.au/study/business-commerce-management");
        driver.get("https://www.flinders.edu.au/international");
        driver.get("https://www.flinders.edu.au/international/arts");
        driver.get("https://www.flinders.edu.au/international/business-commerce-management");
    }

    @Test
    public void Case7_ReserachAreaPagesTest(){
        driver.get("https://www.flinders.edu.au/research");
        driver.get("https://www.flinders.edu.au/research/engineering-and-technology");
        driver.get("https://www.flinders.edu.au/research/research-impact");
    }

    @Test
    public void Case8_IFrameContentTest(){
        driver.get("https://www.flinders.edu.au/international/contact-us");
        driver.get("https://www.flinders.edu.au/employment/professional");
        driver.get("https://www.flinders.edu.au/study/apply/credit-transfer");
    }

    @Test
    public void Case9To10_SearchForCommerceinCoursePagesTest(){
        driver.get("http://www.flinders.edu.au/courses/");
        driver.findElement(By.id("q")).sendKeys("Commerce");
        driver.findElement(By.id("q")).sendKeys(Keys.ENTER);
        driver.findElement(By.partialLinkText("Bachelor of Commerce")).click();
        webDriverWait.until(ExpectedConditions.urlContains("courses"));
        driver.findElement(By.partialLinkText("Study")).click();
    }

    @Test
    public void Case11_ClickOnBusinessCourse() {
        driver.get("http://www.flinders.edu.au/study");
        builder.moveToElement(driver.findElement(By.id("main-item"))).pause(10).perform();
        driver.findElement(By.partialLinkText("Business, commerce and management")).click();
    }

    @Test
    public void Case19_LegacyCMSTest(){
        driver.get("http://www.flinders.edu.au/library");
        driver.get("http://www.flinders.edu.au/ehl");
        driver.get("http://www.flinders.edu.au/medicine");
        driver.get("http://www.flinders.edu.au/nursing");
        driver.get("http://www.flinders.edu.au/sohs");
        driver.get("http://www.flinders.edu.au/sabs");
        driver.get("http://www.flinders.edu.au/science_engineering");
    }

    @Test
    public void Case20_KeyApplicationsOutofScopeTest(){
        driver.get("http://events.flinders.edu.au");
        driver.get("http://www.flinders.edu.au/directory/main-display-search-form.cfm");
        driver.get("http://www.flinders.edu.au/people/john.roddick ");
    }

}