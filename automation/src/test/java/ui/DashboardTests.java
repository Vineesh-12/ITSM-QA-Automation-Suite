package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DashboardTests extends BaseTest {

    @BeforeMethod
    public void loginToDashboard() {
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("dashboard"));
    }

    @Test
    public void testNavigationToAdminPanel() {
        driver.findElement(By.xpath("//span[text()='Admin']")).click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        boolean isAdminPageDisplayed = wait.until(ExpectedConditions.urlContains("admin/viewSystemUsers"));
        Assert.assertTrue(isAdminPageDisplayed, "Should navigate to Admin panel");
    }

    @Test
    public void testSearchMenu() {
        driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys("Leave");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        boolean isLeaveMenuVisible = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//a[contains(@href, 'leave')]"), "Leave"));
        Assert.assertTrue(isLeaveMenuVisible, "Search should filter the menu items");
    }

    @Test
    public void testUserProfileDropdown() {
        driver.findElement(By.cssSelector(".oxd-userdropdown-name")).click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        boolean isLogoutVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout"))).isDisplayed();
        Assert.assertTrue(isLogoutVisible, "User dropdown should open and display Logout option");
    }
    
    @Test
    public void testLogout() {
        driver.findElement(By.cssSelector(".oxd-userdropdown-name")).click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout"))).click();
        
        boolean isLoginPageDisplayed = wait.until(ExpectedConditions.urlContains("auth/login"));
        Assert.assertTrue(isLoginPageDisplayed, "Should navigate back to login page after logout");
    }
    
    @Test
    public void testDashboardWidgetsVisible() {
        boolean isTimeAtWorkVisible = driver.findElement(By.xpath("//p[text()='Time at Work']")).isDisplayed();
        Assert.assertTrue(isTimeAtWorkVisible, "Time at Work widget should be visible on Dashboard");
    }
}
