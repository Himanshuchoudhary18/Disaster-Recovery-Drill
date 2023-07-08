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


        // Navigate to the critical application weblogic console login page
        driver.get("https://localhost:8001/console/login/LoginForm.jsp");

        // Perform actions specific to the critical application login
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin123");
        driver.findElement(By.name("Submit")).click();

        // Add further steps specific to the critical application after login
        // ...

        // Close the critical application console
        driver.quit();

        // Create a new instance of the Chrome driver
        driver = new ChromeDriver();

        // Navigate to the non-critical application weblogic console login page
        driver.get("https://localhost:7001/console/login/LoginForm.jsp");

        // Perform actions specific to the non-critical application login
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin456");
        driver.findElement(By.name("Submit")).click();

        // Add further steps specific to the non-critical application after login
        // ...
  
    // Close the browser
    driver.quit();
  }
}
