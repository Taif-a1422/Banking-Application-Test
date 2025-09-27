package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountManagementPage {
    WebDriver driver;

    By openAccountBtn = By.xpath("//button[contains(text(),'Open Account')]");
    By customerDropdown = By.id("userSelect");
    By currencyDropdown = By.id("currency");
    By processBtn = By.xpath("//button[contains(text(),'Process')]");

    public AccountManagementPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openAccountForCustomer(String customerName, String currency) {
        driver.findElement(openAccountBtn).click();
        driver.findElement(customerDropdown).click();
        driver.findElement(By.xpath("//select[@id='userSelect']/option[text()='" + customerName + "']")).click();

        driver.findElement(currencyDropdown).click();
        driver.findElement(By.xpath("//select[@id='currency']/option[text()='" + currency + "']")).click();

        driver.findElement(processBtn).click();
    }
}