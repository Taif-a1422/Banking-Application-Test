package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerManagementPage {
    WebDriver driver;

    By addCustomerBtn = By.xpath("//button[contains(text(),'Add Customer')]");
    By firstNameInput = By.xpath("//input[@placeholder='First Name']");
    By lastNameInput = By.xpath("//input[@placeholder='Last Name']");
    By postCodeInput = By.xpath("//input[@placeholder='Post Code']");
    By submitAddCustomerBtn = By.xpath("//button[@type='submit']");
    By customersList = By.xpath("//button[contains(text(),'Customers')]");

    public CustomerManagementPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addCustomer(String firstName, String lastName, String postCode) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // الضغط على زر Add Customer
        wait.until(ExpectedConditions.elementToBeClickable(addCustomerBtn)).click();

        // إدخال بيانات العميل
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput)).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(postCodeInput).sendKeys(postCode);

        // الضغط على زر الإضافة
        driver.findElement(submitAddCustomerBtn).click();
    }

    public void openCustomersList() {
        driver.findElement(customersList).click();
    }
}
