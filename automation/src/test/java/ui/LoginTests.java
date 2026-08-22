package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public void testValidLogin() {
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        boolean isDashboardDisplayed = wait.until(ExpectedConditions.urlContains("dashboard"));
        Assert.assertTrue(isDashboardDisplayed, "Dashboard should be displayed after valid login");
    }

    @Test
    public void testInvalidLogin() {
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("wrongpassword");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        
        WebElement errorMessage = driver.findElement(By.cssSelector(".oxd-alert-content-text"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message should be displayed");
        Assert.assertEquals(errorMessage.getText(), "Invalid credentials");
    }

    @Test
    public void testEmptyUsername() {
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        
        WebElement requiredMessage = driver.findElement(By.xpath("//span[contains(text(),'Required')]"));
        Assert.assertTrue(requiredMessage.isDisplayed(), "Required validation should appear for empty username");
    }
    
    @Test
    public void testEmptyPassword() {
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        
        WebElement requiredMessage = driver.findElement(By.xpath("//span[contains(text(),'Required')]"));
        Assert.assertTrue(requiredMessage.isDisplayed(), "Required validation should appear for empty password");
    }
    
    @Test
    public void testEmptyCredentials() {
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        
        int requiredMessages = driver.findElements(By.xpath("//span[contains(text(),'Required')]")).size();
        Assert.assertEquals(requiredMessages, 2, "Both username and password should show Required");
    }
}
