package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.TestBase;

import java.time.Duration;

public class HomePage extends TestBase {
    @FindBy(xpath = "//*[@data-testid='filter-by-company']")
    WebElement company;
    @FindBy(xpath = "//*[@data-testid='peoples-menu']")
    WebElement click_company;

    public HomePage()
    {
        PageFactory.initElements(driver,this);
    }
    public void CompanyHover() throws InterruptedException {
        Actions a= new Actions(driver);
        Thread.sleep(6000);
        a.moveToElement(company).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));
    }

    public void clickcompany()
    {
        click_company.click();
    }
}
