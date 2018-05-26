package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public void waitForElement(WebElement element) {
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementStaleness(WebElement element) {
            new WebDriverWait(driver, 10).until(ExpectedConditions.stalenessOf(element));
    }

}
