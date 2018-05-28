import enums.Categories;
import enums.SubCategories;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SubCategoryPage;
import products.Product;
import utils.FileUtils;
import utils.MailSender;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ThirdTest  extends BaseTest{
    private List<Product> popularProducts;
    private List<Product> products;

    @Test
    public void testThree() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.hoverOnCategory(Categories.SMARTPHONES_AND_TV);
        mainPage.clickOnSubCategory(SubCategories.SMARTPHONES);
        SubCategoryPage subCategoryPage = new SubCategoryPage(driver);
        subCategoryPage.clickOnMoreButton(2);
        popularProducts=subCategoryPage.collectPopularProducts();
        subCategoryPage.setMaximumPrice(6000);
        subCategoryPage.submitPrice();
        subCategoryPage.setMinimalPrice(3000);
        subCategoryPage.submitPrice();
        subCategoryPage.clickOnMoreButton(4);
        products=subCategoryPage.collectAllProducts();
    }

    @AfterMethod
    public void mailSend() throws IOException, MessagingException {
        File all= FileUtils.writeProductToEXCELFile(products);
        File popular = FileUtils.writeProductToEXCELFile(popularProducts);
        List<File> filesForSend = new ArrayList<>();
        filesForSend.add(all);
        filesForSend.add(popular);
        MailSender.sendMail(filesForSend);
    }
}
