package com.drdrill;

import java.io.IOException;

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

        // Check if WebLogic is running by verifying the presence of a specific element
        boolean isCriticalWebLogicRunning = driver.findElement(By.id("username")).isDisplayed();

        if (isCriticalWebLogicRunning) {
            // WebLogic is running
            System.out.println("Critical WebLogic is running");

            // Perform actions specific to the WebLogic console login
            driver.findElement(By.id("username")).sendKeys("admin");
            driver.findElement(By.id("password")).sendKeys("admin123");
            driver.findElement(By.name("Submit")).click();

            // Add further steps specific to the WebLogic console after login
            // ...

            // Close the critical application console
            driver.quit();
        } else {
            // WebLogic is not running
            System.out.println("Critical WebLogic is not running");
            // Add command line commands or actions to perform when WebLogic is not running
            // For example, navigate to a specific file on the D drive
            try {
                String command = "cmd /c cd /d D:\\Oracle\\Middleware\\Oracle_Home\\user_projects\\domains\\CRITICAL\\bin";
                Process process = Runtime.getRuntime().exec(command);
                int exitCode = process.waitFor();

                if (exitCode == 0) {
                    // Command executed successfully
                    System.out.println("Navigated to the specified file on the D drive");

                    try {
                        // Specify the path to the .sh file
                        String scriptPath1 = "/StartNodeManager.sh";
                        String scriptPath2 = "/StartComponent.sh";

                        // Create a process builder for running the shell script
                        ProcessBuilder processBuilder1 = new ProcessBuilder("sh", scriptPath1);
                        ProcessBuilder processBuilder2 = new ProcessBuilder("sh", scriptPath2);
            
                        // Run the shell script
                        Process scriptProcess1 = processBuilder1.start();
                        Process scriptProcess2 = processBuilder2.start();

                        // Wait for the script to finish executing
                        int scriptExitCode1 = scriptProcess1.waitFor();
                        int scriptExitCode2 = scriptProcess2.waitFor();
            
                        if (scriptExitCode1 == 0 && scriptExitCode2 ==0) {
                            System.out.println("Shell script executed successfully");

                        } else {
                            System.out.println("Shell script execution failed");
                        }
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    // Command failed to execute
                    System.out.println("Failed to navigate to the specified file on the D drive");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Create a new instance of the Chrome driver
        driver = new ChromeDriver();

        // Navigate to the Non critical application weblogic console login page
        driver.get("https://localhost:7001/console/login/LoginForm.jsp");

        // Check if WebLogic is running by verifying the presence of a specific element
        boolean isNonCriticalWebLogicRunning = driver.findElement(By.id("username")).isDisplayed();

        if (isNonCriticalWebLogicRunning) {
            // WebLogic is running
            System.out.println("Non Critical WebLogic is running");

            // Perform actions specific to the WebLogic console login
            driver.findElement(By.id("username")).sendKeys("admin");
            driver.findElement(By.id("password")).sendKeys("admin123");
            driver.findElement(By.name("Submit")).click();

            //Add further steps specific to the WebLogic console after login
            // ...


            // Close the critical application console
            driver.quit();
        } else {
            // Non Critical WebLogic is not running
            System.out.println("Non Critical WebLogic is not running");
            // Add command line commands or actions to perform when WebLogic is not running
            // For example, navigate to a specific file on the D drive
            try {
                String command = "cmd /c cd /d D:\\Oracle\\Middleware\\Oracle_Home\\user_projects\\domains\\CRITICAL\\bin";
                Process process = Runtime.getRuntime().exec(command);
                int exitCode = process.waitFor();

                if (exitCode == 0) {
                    // Command executed successfully
                    System.out.println("Navigated to the specified file on the D drive");

                    try {
                        // Specify the path to the .sh file
                        String scriptPath1 = "/StartNodeManager.sh";
                        String scriptPath2 = "/StartComponent.sh";

                        // Create a process builder for running the shell script
                        ProcessBuilder processBuilder1 = new ProcessBuilder("sh", scriptPath1);
                        ProcessBuilder processBuilder2 = new ProcessBuilder("sh", scriptPath2);
            
                        // Run the shell script
                        Process scriptProcess1 = processBuilder1.start();
                        Process scriptProcess2 = processBuilder2.start();

                        // Wait for the script to finish executing
                        int scriptExitCode1 = scriptProcess1.waitFor();
                        int scriptExitCode2 = scriptProcess2.waitFor();
            
                        if (scriptExitCode1 == 0 && scriptExitCode2 ==0) {
                            System.out.println("Shell script executed successfully");

                        } else {
                            System.out.println("Shell script execution failed");
                        }
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    // Command failed to execute
                    System.out.println("Failed to navigate to the specified file on the D drive");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

    
  }
}
}
