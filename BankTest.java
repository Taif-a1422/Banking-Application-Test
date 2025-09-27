package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CustomerManagementPage;
import pages.ManagerLoginPage;

import java.time.Duration;

public class BankTest {

    WebDriver driver;
    ManagerLoginPage managerLoginPage;
    CustomerManagementPage customerManagementPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        managerLoginPage = new ManagerLoginPage(driver);
        customerManagementPage = new CustomerManagementPage(driver);
    }

    @Test(priority = 1)
    public void openFiveNewCustomerAccounts() {
        managerLoginPage.clickManagerLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for (int i = 1; i <= 5; i++) {
            customerManagementPage.addCustomer("TestFirstName" + i, "TestLastName" + i, "12345");

            // التعامل مع التنبيه بعد الإضافة
            try {
                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
                System.out.println("Alert message: " + alert.getText());
                alert.accept();  // إغلاق التنبيه
            } catch (Exception e) {
                System.out.println("لم يظهر تنبيه بعد إضافة العميل رقم " + i);
            }
        }
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

