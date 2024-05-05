package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.TestBase;

public class LoginPage extends TestBase {

    @FindBy(xpath = "//*[@type='text']")
    WebElement username_field;
    @FindBy(xpath = "//*[@type='password']")
    WebElement password_field;

    @FindBy(xpath = "//*[@data-testid='login-submit-btn']")
    WebElement submit_field;

    public LoginPage()
    {
        PageFactory.initElements(driver,this);
    }

    public void logIn()
    {
        username_field.sendKeys("utaorg1ad1@mailinator.com");
        password_field.sendKeys("Test@123");
        submit_field.click();
    }
}
