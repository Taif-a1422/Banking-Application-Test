package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class ManagerLoginPage {
    WebDriver driver;
    WebDriverWait wait;

    By managerLoginBtn = By.xpath("//button[contains(text(),'Bank Manager Login')]");

    public ManagerLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickManagerLogin() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(managerLoginBtn));
        btn.click();
    }
}
