package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class CustomerLoginPage {

    WebDriver driver;

    By customerLoginBtn = By.xpath("//button[contains(text(),'Customer Login')]");
    By yourNameDropdown = By.id("userSelect");
    By loginBtn = By.xpath("//button[contains(text(),'Login')]");

    public CustomerLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginAsCustomer(String customerName) {
        driver.findElement(customerLoginBtn).click();
        driver.findElement(yourNameDropdown).click();
        driver.findElement(By.xpath("//select[@id='userSelect']/option[text()='" + customerName + "']")).click();
        driver.findElement(loginBtn).click();
    }
}
