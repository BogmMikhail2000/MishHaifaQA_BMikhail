import Pages.EventsAuthPageHelper;
import Pages.EventsUnAuthPageHelper;
import Pages.HomePageHelper;
import Pages.LoginPageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBaseMish{

    HomePageHelper homePage;
    LoginPageHelper loginPage;
    EventsAuthPageHelper eventsAuthPage;
    @BeforeMethod
    public void initPage() {
        homePage = PageFactory
                .initElements(driver, HomePageHelper.class);
        loginPage =  PageFactory
                .initElements(driver,  LoginPageHelper.class);
        eventsAuthPage =  PageFactory
                .initElements(driver,  EventsAuthPageHelper.class);

    }


    @Test
    public void loginPositive() {
        homePage.waitUntilPageLoad();
        homePage.pressLoginButton();
        loginPage.waitUntilPageLoad();
        loginPage.EnterValueToFieldEmail("1ooo@gmail.com");
        loginPage.EnterValueToFieldPassword("123456");
        loginPage.PressLogInButton();
        eventsAuthPage.waitUntilPageLoad();

        Assert.assertEquals("Find event", eventsAuthPage.getHeader() );




    }

    @Test
    public void negativeTest(){
        homePage.waitUntilPageLoad();
        homePage.pressLoginButton();
        loginPage.waitUntilPageLoad();
        loginPage.EnterValueToFieldEmail("ooo13@gmail.com");
        loginPage.EnterValueToFieldPassword("123456");
        loginPage.PressLogInButton();
        loginPage.getAlertText();
        waitUntilElementIsLoaded(driver, By.xpath("//div[@class='alert alert-danger ng-star-inserted']"),20);
        WebElement alertText = driver.findElement(By.xpath(("//div[@class='alert alert-danger ng-star-inserted']")));
        Assert.assertTrue(alertText.getText().equals("Wrong authorization, login or password"));
    }
}
