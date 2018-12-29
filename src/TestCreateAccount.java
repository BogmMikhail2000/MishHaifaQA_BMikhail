import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCreateAccount extends TestBaseMish {

    HomePageHelper homePage;
    CreateAccountPageHelper createAccountHelper;
    RegistrationPageHelper pageRegistration;
    FieldMenuHelper menuHelper;
    LoginPageHelper loginPage;


    @BeforeMethod
    public void initPage(){

        homePage = PageFactory.initElements(driver, HomePageHelper.class);
        createAccountHelper = PageFactory.initElements(driver,  CreateAccountPageHelper.class);
        pageRegistration = PageFactory.initElements(driver, RegistrationPageHelper.class);
        menuHelper = PageFactory.initElements(driver,  FieldMenuHelper.class);
        loginPage =  PageFactory.initElements(driver,  LoginPageHelper.class);
    }



        @Test
        public void createNewAccount(){
            String email1 = latinDigitString(8) + "@gmail.com";
            homePage.waitUntilPageLoad();
            homePage.PressCreateAccountButton();
            createAccountHelper.EnterEmailField(email1);
            createAccountHelper.EnterPasswordField();
            createAccountHelper.EnterRepPasswordField();
            createAccountHelper.PressButtonRegistration();
            pageRegistration.waitUntilRegistrationPageLoad();
            pageRegistration.PressMenuButton();
            menuHelper.PressLogOut();


            Assert.assertEquals("Go to Event list", homePage.FindGoToEventButton());



    }

        @Test
        public void newAccountAndLogin(){
            String email2 = latinDigitString(8) + "@gmail.com";
            homePage.waitUntilPageLoad();
            homePage.PressCreateAccountButton();
            createAccountHelper.EnterEmailField(email2);
            createAccountHelper.EnterPasswordField();
            createAccountHelper.EnterRepPasswordField();
            createAccountHelper.PressButtonRegistration();
            pageRegistration.waitUntilRegistrationPageLoad();
            pageRegistration.PressMenuButton();
            menuHelper.PressLogOut();
            homePage.FindGoToEventButton();
            //------------------------------Login created user----------
            homePage.pressLoginButton();
            loginPage.EnterEmailField(email2);
            loginPage.EnterValueToFieldPassword("123456");
            loginPage.PressLogInButton();
            loginPage.PressLogInButton();
            pageRegistration.getHeader();
             Assert.assertEquals("Registration",  pageRegistration.getHeader());












        }
    }



