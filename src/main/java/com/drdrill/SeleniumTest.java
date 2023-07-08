package com.drdrill;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
  public static void main(String[] args) {
    // Set the path to chromedriver executable
    System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
  
    // Create a new instance of the Chrome driver
    WebDriver driver = new ChromeDriver();
  
    // Navigate to the login page
    driver.get("http://10.192.21.214/login");
  
    // Enter the username and password
    driver.findElement(By.id("username")).sendKeys("Administrator");
    driver.findElement(By.id("password")).sendKeys("pass@123");
  
    // Submit the login form
    driver.findElement(By.id("login-button")).click();
  
    // Add assertions or verification steps here to check if login is successful
  
    // Close the browser
    driver.quit();
  }
}
