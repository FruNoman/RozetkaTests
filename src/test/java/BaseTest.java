import enums.Categories;
import enums.SubCategories;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;
import pages.MainPage;
import pages.SubCategoryPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void init(){
        System.setProperty("webdriver.chrome.driver", "/Users/Admin/Downloads/chromedriver");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        driver = new ChromeDriver(desiredCapabilities);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void openBrowser(){
        driver.get("http://rozetka.com.ua");
    }

    @Test
    public void testOne() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.hoverOnCategory(Categories.SMARTPHONES_AND_TV);
        mainPage.clickOnSubCategory(SubCategories.SMARTPHONES);
        SubCategoryPage subCategoryPage = new SubCategoryPage(driver);
        subCategoryPage.clickOnMoreButton(3);
    }

    @AfterClass
    public void tearDown(){
//        driver.close();
    }
}
