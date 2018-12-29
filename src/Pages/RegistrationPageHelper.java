package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPageHelper extends PageBase {


    public RegistrationPageHelper(WebDriver driver) {
        super(driver);
    }


    public void waitUntilRegistrationPageLoad() {

        waitUntilElementIsLoaded(driver,By.xpath("//span[contains(text(),'Cancel')]"),40 );
        waitUntilElementIsLoaded(driver,By.xpath("//mat-icon[@mattooltip='Menu']"),40 );
        waitUntilElementIsLoaded(driver,By.xpath("//h1[@class='classCentr']"),40 );
    }

    public void PressMenuButton() {

        WebElement menuButton = driver.findElement(By.xpath("//mat-icon[@mattooltip='Menu']"));
        menuButton.click();
    }

    public String getHeader() {
        waitUntilElementIsLoaded(driver,By.xpath("//h1[@class='classCentr']"),40 );
        WebElement titlePage = driver.findElement(By
                .xpath("//h1[@class='classCentr']"));
        return titlePage.getText();

    }
}
