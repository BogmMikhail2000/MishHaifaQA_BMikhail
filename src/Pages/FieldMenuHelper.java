package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FieldMenuHelper extends PageBase {
    public FieldMenuHelper(WebDriver driver) {
        super(driver);
    }


    public void PressLogOut() {

        waitUntilElementIsLoaded(driver, By.xpath("//span[@class='marginLeft']"), 20);
        WebElement logOutMenu = driver.findElement(By.xpath("//span[@class='marginLeft']"));
        logOutMenu.click();
    }
}
