package tests;

import db.AppConfig;
import db.entities.ProductEntitty;
import db.service.ProductService;
import enums.Categories;
import enums.SubCategories;
import enums.SubCategoriesHeaders;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.MainPage;
import pages.SubCategoryPage;
import products.Product;
import utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class SecondTest extends BaseTest{
    private List<Product> products;

    @Test
    public void testTwo() throws InterruptedException {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        ProductService productService = context.getBean(ProductService.class);

        // Add Users
        productService.add(new ProductEntitty( "Bora", 1000));
        productService.add(new ProductEntitty("Miller", 2000));

        context.close();


//        MainPage mainPage = new MainPage(driver);
//        mainPage.hoverOnCategory(Categories.PRODUCTS_FOR_HOME);
//        mainPage.clickOnSubCategoryHeader(SubCategoriesHeaders.DOMESTIC_CHEMICAL);
//        CategoryPage categoryPage = new CategoryPage(driver);
//        categoryPage.clickOnSubCategory(SubCategories.DETERGENTS_FOR_WASHING);
//        SubCategoryPage subCategoryPage = new SubCategoryPage(driver);
//        subCategoryPage.setMaximumPrice(300);
//        subCategoryPage.submitPrice();
//        subCategoryPage.setMinimalPrice(100);
//        subCategoryPage.submitPrice();
//        subCategoryPage.clickOnMoreButton(4);
//        products = subCategoryPage.collectAllProducts();
    }

    @AfterMethod
    public void saveToDB() throws IOException {
//        File all= FileUtils.writeProductToEXCELFile(products);
    }

}
