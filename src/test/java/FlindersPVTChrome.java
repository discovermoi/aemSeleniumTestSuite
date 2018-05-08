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
import org.openqa.selenium.chrome.ChromeDriver;

public class FlindersPVTChrome {

    @Test
    public void Case1_OpenHomePageTest(){
        ChromeDriver driver=new ChromeDriver();
        driver.get("http://www.flinders.edu.au");
    }

    @Test
    public void Case19_checkLegacyCMSTest(){
        ChromeDriver driver=new ChromeDriver();
        driver.get("http://www.flinders.edu.au/library");
        driver.get("http://www.flinders.edu.au/ehl");
        driver.get("http://www.flinders.edu.au/medicine");
        driver.get("http://www.flinders.edu.au/nursing");
        driver.get("http://www.flinders.edu.au/sohs");
        driver.get("http://www.flinders.edu.au/sabs");
        driver.get("http://www.flinders.edu.au/science_engineering");
    }

    @Test
    public void Case20_keyApplicationsOutofScope(){
        ChromeDriver driver=new ChromeDriver();
        driver.get("http://events.flinders.edu.au");
        driver.get("http://www.flinders.edu.au/directory/main-display-search-form.cfm");
        driver.get("http://www.flinders.edu.au/people/john.roddick ");
    }




}