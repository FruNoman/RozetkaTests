package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import products.Product;
import products.Smartphone;
import utils.RozetkaUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SubCategoryPage extends BasePage {
    private WebDriver driver;
    private List<Product> products;

    @FindBy(css = "div.g-i-tile-i-box")
    private List<WebElement> productsElements;
    @FindBy(css=".g-i-more-link-text")
    private WebElement moreProductsButton;
    @FindBy(id = "price[min]")
    private WebElement minimalPrice;
    @FindBy(id = "price[max]")
    private WebElement maximumPrice;
    @FindBy(id = "submitprice")
    private WebElement submitPriceButton;

    public SubCategoryPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public void clickOnMoreButton(int count) throws InterruptedException {
        for(int i=0;i<count;i++){Thread.sleep(5000);
            new WebDriverWait(driver, 3000).until(ExpectedConditions.elementToBeClickable(moreProductsButton));
            moreProductsButton.click();
        }
    }

    public List<Product> collectAllProducts(){
        products = new ArrayList<Product>();
        for(WebElement element:productsElements){
            Product product = new Smartphone();
            product.setName(element.findElement(By.cssSelector(".g-i-tile-i-title>a")).getText());
            product.setPrice(RozetkaUtils.formatPriceToInteger(element.findElement(By.cssSelector(".g-price-uah")).getText()));
            products.add(product);
        }
        return products;
    }

    public void setMinimalPrice(int price) {
        waitForElementIsClickable(minimalPrice);
        minimalPrice.clear();
        minimalPrice.sendKeys(String.valueOf(price));
        maximumPrice.sendKeys(Keys.ENTER);
    }

    public void setMaximumPrice(int price){
        waitForElementIsClickable(maximumPrice);
        maximumPrice.clear();
        maximumPrice.sendKeys(String.valueOf(price));
        maximumPrice.sendKeys(Keys.ENTER);
    }

    public void submitPrice(){
        waitForElementIsClickable(submitPriceButton);
        submitPriceButton.click();
        waitForElementStaleness(productsElements.get(0));
    }
}
