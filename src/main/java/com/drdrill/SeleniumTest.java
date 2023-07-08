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

        // Define the critical and non-critical WebLogic URLs
        String criticalWebLogicURL = "https://localhost:8001/console/login/LoginForm.jsp";
        String nonCriticalWebLogicURL = "https://localhost:7001/console/login/LoginForm.jsp";

        // Check if Critical WebLogic is running
        boolean isCriticalWebLogicRunning = isWebLogicRunning(driver, criticalWebLogicURL, "Critical");

        if (isCriticalWebLogicRunning) {
            // Perform actions specific to the Critical WebLogic console
            performWebLogicActions(driver, "admin", "admin123");

            // Close the Critical application console
            driver.quit();
        } else {
            System.out.println("Critical WebLogic is not running");

            // Add command line commands or actions to perform when Critical WebLogic is not running
            executeShellScript("D:\\Oracle\\Middleware\\Oracle_Home\\user_projects\\domains\\CRITICAL\\bin",
                    "/StartNodeManager.sh", "/StartComponent.sh");
        }

        // Check if Non-Critical WebLogic is running
        boolean isNonCriticalWebLogicRunning = isWebLogicRunning(driver, nonCriticalWebLogicURL, "Non-Critical");

        if (isNonCriticalWebLogicRunning) {
            // Perform actions specific to the Non-Critical WebLogic console
            performWebLogicActions(driver, "admin", "admin123");

            // Close the Non-Critical application console
            driver.quit();
        } else {
            System.out.println("Non-Critical WebLogic is not running");

            // Add command line commands or actions to perform when Non-Critical WebLogic is not running
            executeShellScript("D:\\Oracle\\Middleware\\Oracle_Home\\user_projects\\domains\\CRITICAL\\bin",
                    "/StartNodeManager.sh", "/StartComponent.sh");
        }
    }

    // Method to check if WebLogic is running by verifying the presence of a specific element
    public static boolean isWebLogicRunning(WebDriver driver, String url, String type) {
        driver.get(url);
        boolean isWebLogicRunning = driver.findElement(By.id("username")).isDisplayed();
        if (isWebLogicRunning) {
            System.out.println(type + " WebLogic is running");
        }
        return isWebLogicRunning;
    }

    // Method to perform actions specific to the WebLogic console login
    public static void performWebLogicActions(WebDriver driver, String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.name("Submit")).click();
        // Add further steps specific to the WebLogic console after login
        // ...
    }

    // Method to execute a shell script
    public static void executeShellScript(String directory, String... scriptPaths) {
        try {
            String command = "cmd /c cd /d " + directory;
            Process process = Runtime.getRuntime().exec(command);
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("Navigated to the specified directory: " + directory);
                for (String scriptPath : scriptPaths) {
                    ProcessBuilder processBuilder = new ProcessBuilder("sh", scriptPath);
                    Process scriptProcess = processBuilder.start();
                    int scriptExitCode = scriptProcess.waitFor();
                    if (scriptExitCode == 0) {
                        System.out.println("Shell script " + scriptPath + " executed successfully");
                    } else {
                        System.out.println("Shell script " + scriptPath + " execution failed");
                    }
                }
            } else {
                System.out.println("Failed to navigate to the specified directory: " + directory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
