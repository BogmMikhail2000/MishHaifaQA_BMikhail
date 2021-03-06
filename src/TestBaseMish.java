import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import java.util.Random;

public class TestBaseMish {

    public WebDriver driver;// = new ChromeDriver();

    @BeforeMethod
    public void initWebDriver() {
        driver = new ChromeDriver();
        driver.get("https://mish.sheygam.com/#/wellcome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void TearDown() {
        driver.quit();
    }


    public void waitUntilElementIsLoaded(WebDriver driver, By locator, int time) {

        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.presenceOfElementLocated(locator));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    protected String latinDigitString(int length) {
        String str = "";

        int number;
        Random gen = new Random();

        do {
            number = '0' + gen.nextInt('z' - '0' + 1);
            if ((number <= '9') || (number >= 'A' && number <= 'Z') || (number >= 'a')) {
                str = str + (char) number;
            }
        } while (str.length() < length);
        return str;

    }
    }





