import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBaseMish{

    @Test
    public void loginNegative(){
        waitUntilElementIsLoaded(driver, By.xpath("//mat-icon[contains(text(),'lock')]"),45);

        WebElement login = driver.findElement(By
                .xpath("//span[contains(text(),'Login')]"));
        login.click();
        waitUntilElementIsLoaded(driver, By.xpath("//button[@type='button']"),45);
        WebElement email_field = driver.findElement(By
                .xpath("//input[@formcontrolname='email']"));
        WebElement password_field = driver.findElement(By
                .xpath("//input[@formcontrolname='password']"));
        email_field.click();
        email_field.sendKeys("2ool@gmail.com");
        password_field.click();
        password_field.sendKeys("123456");
        WebElement login_button=driver.findElement(By
                .xpath("//span[contains(text(),'Log in')]"));
        waitUntilElementIsLoaded(driver, By.xpath("//span[contains(text(),'Log in')]"),45);
        login_button.click();

        waitUntilElementIsLoaded(driver, By.xpath("//div[@class='alert alert-danger ng-star-inserted']"),45);
        WebElement alertText = driver.findElement(By.xpath("//div[@class='alert alert-danger ng-star-inserted']"));
       // Assert.assertTrue(alertText.getAttribute("class").equals("alert alert-danger ng-star-inserted"));
        Assert.assertTrue( alertText.getText().equals("Wrong authorization, login or password"));
    }
@Test
    public void loginPositive() {


        waitUntilElementIsLoaded(driver, By.xpath("//mat-icon[contains(text(),'lock')]"),20);

        WebElement login = driver.findElement(By
                .xpath("//span[contains(text(),'Login')]"));
        login.click();
        waitUntilElementIsLoaded(driver, By.xpath("//button[@type='button']"),45);
        WebElement email_field = driver.findElement(By
                .xpath("//input[@formcontrolname='email']"));
        email_field.click();
        email_field.sendKeys("1ooo@gmail.com");
        WebElement password_field = driver.findElement(By
                .xpath("//input[@formcontrolname='password']"));

        password_field.click();
        password_field.sendKeys("123456");
        WebElement login_button=driver.findElement(By
                .xpath("//span[contains(text(),'Log in')]"));
        waitUntilElementIsLoaded(driver, By.xpath("//span[contains(text(),'Log in')]"),45);
        login_button.click();
        waitUntilElementIsLoaded(driver, By.xpath("//mat-icon[@class='but mat-icon material-icons']"),45);
        WebElement icon = driver.findElement(By.xpath("//mat-icon[@class='but mat-icon material-icons']"));
        Assert.assertTrue(icon.getAttribute("class").equals("but mat-icon material-icons"));


    }
}
