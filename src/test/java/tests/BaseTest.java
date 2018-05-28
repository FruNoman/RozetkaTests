package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import products.Product;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    protected WebDriver driver;


    @BeforeClass
    public void init(){
//        System.setProperty("webdriver.chrome.driver", "/Users/Admin/Downloads/chromedriver");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        driver = new ChromeDriver(desiredCapabilities);
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void openBrowser(){
        driver.get("http://rozetka.com.ua");
    }


    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
