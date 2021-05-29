package extensions.org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestExtensions {

    WebDriver driver;

    @BeforeSuite
    public void init() {
        driver = new ChromeDriver();
    }

    @Test
    public void testSwitchWithTitle() {
        driver.get("https://www.w3schools.com");
        driver.findElement(By.className("tryit-button")).click();
        driver.switchToTab("Tryit");
        Assert.assertTrue(driver.getTitle().contains("Tryit Editor v"));
    }

    @AfterSuite
    public void end(){
        driver.quit();
    }
}
