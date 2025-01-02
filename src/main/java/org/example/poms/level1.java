package org.example.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class level1 {
    WebDriver driver;

    @FindBy(id = "randomString")
    WebElement randomString;

    @FindBy(id = "nameInput")
    WebElement nameInput;

    @FindBy(tagName = "button")
    WebElement submitButton;

    public level1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillForm() {
        nameInput.sendKeys(randomString.getText());
        submitButton.click();
    }
}