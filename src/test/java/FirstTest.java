import enums.Categories;
import enums.SubCategories;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SubCategoryPage;
import utils.FileUtils;
import utils.MailSender;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;

public class FirstTest extends BaseTest{

    @Test
    public void testOne() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.hoverOnCategory(Categories.SMARTPHONES_AND_TV);
        mainPage.clickOnSubCategory(SubCategories.SMARTPHONES);
        SubCategoryPage subCategoryPage = new SubCategoryPage(driver);
        subCategoryPage.clickOnMoreButton(3);
        products=subCategoryPage.collectAllProducts();
    }

    @AfterMethod
    public void mailSend() throws IOException, MessagingException {
        File describeFile= FileUtils.writeProductToTXTFile(products);
        MailSender.sendMail(describeFile);
    }

}
