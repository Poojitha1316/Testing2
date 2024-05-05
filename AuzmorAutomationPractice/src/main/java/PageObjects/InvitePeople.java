package PageObjects;

import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class InvitePeople extends HomePage{
    @FindBy(xpath = "//*[@data-testid='fab-btn']")
    WebElement submit_field;

    @FindBy(xpath = "//*[@data-testid='invite-people-section']")
    WebElement invitepeople_hover;

    @FindBy(xpath = "//*[@data-testid='invite-people-btn']")
    WebElement addPeople_field;

    public InvitePeople()
    {
        PageFactory.initElements(driver,this);
    }
    public void click_add_people() throws InterruptedException
    {
        submit_field.click();
        Actions action = new Actions(driver);
        Thread.sleep(1000);
        action.moveToElement(invitepeople_hover).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));
        addPeople_field.click();
    }
}
