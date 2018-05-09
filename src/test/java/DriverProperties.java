import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverProperties {

    public static void main(String argsp[]) {
        // Create object of DesiredCapabilities class
        DesiredCapabilities cap = DesiredCapabilities.chrome();

// Set ACCEPT_SSL_CERTS  variable to true
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

// Set the driver path
        System.setProperty("webdriver.chrome.driver", "Chrome driver path");
        // Open browser with capability
        ChromeDriver driver = new ChromeDriver(cap);
    }
}
