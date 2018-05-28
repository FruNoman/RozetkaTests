package pages;

import enums.SubCategories;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CategoryPage extends BasePage{
    private WebDriver driver;
    @FindBy(css = ".pab-h3>a")
    private List<WebElement> subCategories;

    public CategoryPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
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
