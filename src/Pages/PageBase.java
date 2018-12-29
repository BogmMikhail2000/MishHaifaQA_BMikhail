package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public abstract class PageBase {
    protected WebDriver driver;

    public PageBase(WebDriver driver){

        this.driver = driver;
    }


    public void waitUntilElementIsLoaded(WebDriver driver, By locator, int time) {

        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.presenceOfElementLocated(locator));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void waitUntilElementIsLoaded(WebDriver driver,
                                         WebElement element, int time)
    {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions
                    .visibilityOf(element));
        }
        catch(Exception e){
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
