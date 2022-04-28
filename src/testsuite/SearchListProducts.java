package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class SearchListProducts extends Utility {
    String baseUrl = "https://www.amazon.co.uk/";
    //1. Open the URL https://www.amazon.co.uk/
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldDisplay30ProductList(){
        //accept the cookie
        clickOnElement(By.id("sp-cc-accept"));
        //2. Type "Dell Laptop" in the search box
        sendTextToElement(By.id("twotabsearchtextbox"),"Dell Laptop");
        //press enter or click on search
        //   Button.
        clickOnElement(By.id("nav-search-submit-button"));
        //3. Click on the checkbox brand dell on the left side.
        clickOnElement(By.xpath("//li[@id=\"p_89/Dell\"]/descendant::label"));
        //4. Verify that the  30(May be different) products are displayed on the page.
        List<WebElement> productList = driver.findElements(By.xpath("//span[@class=\"a-size-medium a-color-base a-text-normal\"]"));
        for(WebElement element : productList){
            System.out.println(element.getText());
        }
    }


    @After
    public void tearDown(){
        //close the browser
        closeBrowser();
    }

}
