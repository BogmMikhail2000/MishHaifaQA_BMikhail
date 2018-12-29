package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountPageHelper extends PageBase{


    public CreateAccountPageHelper(WebDriver driver) {
        super(driver);
    }


    public void EnterEmailField(String value) {


        WebElement mailField = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
        mailField.click();
        mailField.sendKeys(value);
    }

    public void EnterPasswordField() {

        WebElement passwordField = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
        passwordField.click();
        passwordField.sendKeys("123456");
    }

    public void EnterRepPasswordField() {

        WebElement repPasswordField = driver.findElement(By.xpath("//input[@formcontrolname='passwordRep']"));
        repPasswordField.click();
        repPasswordField.sendKeys("123456");
    }

    public void PressButtonRegistration() {

        waitUntilElementIsLoaded(driver,By.xpath("//span[contains(text(),'Registration')]"),45);
        WebElement registrationButton = driver.findElement(By.xpath("//span[contains(text(),'Registration')]"));
        registrationButton.click();
    }
}
