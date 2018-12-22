import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomePageTests extends TestBaseMish {

    @Test
    public void HomePageOpen() throws InterruptedException {


        waitUntilElementIsLoaded(driver, By.xpath("//span[contains(text(),'Go to Event list')]"),20);
        List<WebElement> topLinksList = driver.findElements(By.cssSelector(".mat-button-wrapper .mat-button-wrapper"));
        System.out.println("Login:" + topLinksList.get(0).getText());
        System.out.println("Create Account:" + topLinksList.get(1).getText());
        WebElement goToEventsButton = driver.findElement(
                By.className("mat-stroked-button"));

        Assert.assertTrue(goToEventsButton.getText().equals("Go to Event list"));


    }

    @Test
    public void goToEventsTest() throws InterruptedException {
        waitUntilElementIsLoaded(driver,
                By.xpath("//span[contains(text(),'Login')]"),
                45);


        WebElement goToEventsButton = driver.findElement(
                By.className("mat-stroked-button"));
        System.out.println("Text of button: " + goToEventsButton.getText());
        goToEventsButton.click();
        waitUntilElementIsLoaded(driver,
                By.xpath("//span[contains(text(),'Filters')]"),
                20 );

        WebElement titlePage = driver.findElement(By.xpath("//h1[@class='gorisontal-center']"));
        Assert.assertTrue(titlePage.getText().equals("Find event"));
    }



}