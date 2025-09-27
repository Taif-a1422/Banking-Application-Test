package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransactionPage {
    WebDriver driver;

    By depositTab = By.xpath("//button[contains(text(),'Deposit')]");
    By withdrawlTab = By.xpath("//button[contains(text(),'Withdrawl')]");
    By amountInput = By.xpath("//input[@placeholder='amount']");
    By submitDepositBtn = By.xpath("//button[contains(text(),'Deposit') and @type='submit']");
    By submitWithdrawBtn = By.xpath("//button[contains(text(),'Withdraw') and @type='submit']");
    By messageLabel = By.xpath("//span[@ng-show='message']");

    public TransactionPage(WebDriver driver) {
        this.driver = driver;
    }

    public void deposit(int amount) {
        driver.findElement(depositTab).click();
        driver.findElement(amountInput).sendKeys(String.valueOf(amount));
        driver.findElement(submitDepositBtn).click();
    }

    public void withdraw(int amount) {
        driver.findElement(withdrawlTab).click();
        driver.findElement(amountInput).sendKeys(String.valueOf(amount));
        driver.findElement(submitWithdrawBtn).click();
    }

    public String getMessage() {
        return driver.findElement(messageLabel).getText();
    }
}
