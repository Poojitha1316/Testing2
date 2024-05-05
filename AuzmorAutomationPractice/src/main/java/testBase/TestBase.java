package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import reusableComponent.PropertiesOperation;

public class TestBase {
    public static WebDriver driver;

    public void launchBrowserAndNavigate() throws Exception {

        String browser = PropertiesOperation.getPropertyy("browser");
        String url = PropertiesOperation.getPropertyy("url");

        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("fire")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.get(url);
    }
}
