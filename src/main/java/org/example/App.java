package org.example;

import org.example.poms.level1;
import org.example.poms.level2;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class App 
{
    public static void main( String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        level1 level1Page = new level1(driver);
        level2 level2Page = new level2(driver);
        try {
            // level 1
            driver.get("C:\\Users\\micke\\OneDrive\\Desktop\\Revature Paid Training\\practice-exercises-environment\\src\\main\\resources\\level-1.html");
            level1Page.fillForm();
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();

            // level 2
            driver.get("C:\\Users\\micke\\OneDrive\\Desktop\\Revature Paid Training\\practice-exercises-environment\\src\\main\\resources\\level-2.html");
            level2Page.fillForm();
            wait.until(ExpectedConditions.alertIsPresent());
            alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
        } finally {
            driver.quit();
        }
    }
}
