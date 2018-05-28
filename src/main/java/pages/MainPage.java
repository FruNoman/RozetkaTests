package pages;

import enums.Categories;
import enums.SubCategories;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class MainPage extends BasePage {
    private WebDriver driver;
    @FindBy(css = "li.f-menu-l-i>a")
    private List<WebElement> mainCategories;
    @FindBy(css = "li.f-menu-sub-l-i>a")
    private List<WebElement> subCategories;

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void hoverOnCategory(Categories category) {
        waitForElements(mainCategories);
        for(WebElement element:mainCategories){
            if(element.getText().equals(category.toString())){
                Actions actions = new Actions(driver);
                actions.moveToElement(element).build().perform();
                break;
            }
        }
    }

    public void clickOnCategory(Categories category) {
        waitForElements(mainCategories);
        for(WebElement element:mainCategories){
            if(element.getText().equals(category.toString())){
                element.click();
                break;
            }
        }
    }

    public void clickOnSubCategory(SubCategories subCategory){
        waitForElements(subCategories);
        for(WebElement element:subCategories){
            if((element.getText()).trim().equals(subCategory.toString())){
                element.click();
                break;
            }
        }
    }

}
