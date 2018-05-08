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
import org.openqa.selenium.chrome.ChromeDriver;

public class FlindersPVTChrome {
    ChromeDriver driver=new ChromeDriver();

    @Test
    public void Case1_OpenHomePageTest(){

        driver.get("http://www.flinders.edu.au");
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

    @Test
    public void Case2_SearchBarTest() {
        driver.get("http://www.flinders.edu.au");
        driver.findElement(By.id("searchbarq")).clear();
        driver.findElement(By.id("searchbarq")).sendKeys("Accounting");
        driver.findElement(By.id("searchbarq")).sendKeys(Keys.ENTER); // Unable to access Search Icon so used ENTER key
    }


}