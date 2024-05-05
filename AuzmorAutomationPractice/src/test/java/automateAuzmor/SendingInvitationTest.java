package automateAuzmor;

import PageObjects.FormInvitePeopleToOrg;
import PageObjects.HomePage;
import PageObjects.InvitePeople;
import PageObjects.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testBase.TestBase;

public class SendingInvitationTest extends TestBase {
    @BeforeMethod
    public void login() throws Exception {
        launchBrowserAndNavigate();
        LoginPage loginPage = new LoginPage();
        loginPage.logIn();
        HomePage homePage = new HomePage();
        homePage.CompanyHover();
        homePage.clickcompany();
        InvitePeople invitePeople = new InvitePeople();
        invitePeople.click_add_people();
        FormInvitePeopleToOrg obj = new FormInvitePeopleToOrg();
        obj.Formdetails();
    }
    @Test
    public void SendInvitation()
    {
        System.out.println(driver.getCurrentUrl());
    }
}
