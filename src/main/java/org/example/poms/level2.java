package org.example.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class level2 {
    WebDriver driver;

    @FindBy(tagName = "dd")
    List<WebElement> ddList;

    @FindBy(xpath = "//input[@type='checkbox']")
    List<WebElement> checkBoxes;

    @FindBy(name = "input1")
    WebElement dropdownElement;

    @FindBy(name = "dateInput")
    WebElement dateInput;


    public level2(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillForm() {
        String dropDownValue = ddList.get(0).getText();
        String radioValue = ddList.get(2).getText();
        String date = ddList.get(3).getText();
        String[] dateList = date.split("-");
        String buttonToSubmit = ddList.get(4).getText();

        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(dropDownValue);

        for (WebElement checkBox : checkBoxes) {
            checkBox.click();
        }

        WebElement radio = driver.findElement(By.xpath("//input[@type='radio' and @value='" + radioValue + "']"));
        radio.click();

        dateInput.sendKeys(dateList[1] + dateList[2] + dateList[0]);

        WebElement button = driver.findElement(By.xpath("//button[text()='" + buttonToSubmit + "']"));
        button.click();

    }


}
