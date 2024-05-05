package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.security.PublicKey;

import java.util.List;

public class FormInvitePeopleToOrg extends HomePage{
    @FindBy(xpath = "//input[@placeholder='Full Name']")
    WebElement full_name;
    @FindBy(xpath = "//*[@class='dropdown icon']")
    WebElement role_field;

    @FindBy(xpath = "//*[text()='Learner']")
    WebElement rolename;
    @FindBy(xpath = "//input[@placeholder='name@example.com']")
    WebElement mail_field;
    @FindBy(xpath = "//input[@placeholder='Search here...']")
    List<WebElement> dd_rolemanager;

    @FindBy(xpath = "//*[@data-testid='icon']")
    WebElement click_drop_down;
    @FindBy(xpath = "//button[@data-testid='normal-btn']")
    WebElement add_btn;
    @FindBy(xpath = "//*[@data-testid='invite-people-send-btn']")
    WebElement sendInvitation;
    public FormInvitePeopleToOrg()
    {

        PageFactory.initElements(driver,this);
    }

    public void Formdetails(){
        full_name.sendKeys("Poojithaa Bonthu");
        mail_field.sendKeys("poojitha.bonthu@atc.xyz");
        role_field.click();
        add_btn.click();
        sendInvitation.click();
//        rolename.click();
//        WebElement w = (WebElement) dd_rolemanager;
//        Select dropdown = new Select(w);
//        dropdown.selectByIndex(2);
    }
}
