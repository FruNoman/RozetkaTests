import enums.Categories;
import enums.SubCategories;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import pages.MainPage;
import pages.SubCategoryPage;
import products.Product;
import utils.FileUtils;
import utils.MailSender;

import javax.mail.MessagingException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static sun.audio.AudioDevice.device;

public class BaseTest {
    protected WebDriver driver;
    protected List<Product> products;

    @BeforeClass
    public void init(){
        System.setProperty("webdriver.chrome.driver", "/Users/Admin/Downloads/chromedriver");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        driver = new ChromeDriver(desiredCapabilities);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        products=subCategoryPage.collectAllProducts();
    }

    @AfterClass
    public void tearDown() throws IOException, MessagingException {
        File describeFile=FileUtils.writeProductToFile(products);
        MailSender mailSender = new MailSender();
        mailSender.sendMail(describeFile);
        driver.close();
    }
}
