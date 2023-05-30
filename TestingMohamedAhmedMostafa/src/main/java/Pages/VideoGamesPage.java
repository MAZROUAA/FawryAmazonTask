package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class VideoGamesPage {
    UiActions uiObj=new UiActions();
    BrowserActions browserObj=new BrowserActions();
    public  void ChooseFreeShippingAndNew()  {
        //choosing free shipping filter
        WebElement freeShippingFilter = uiObj.findElement(By.xpath("//*[@id=\"s-refinements\"]/div[2]/ul/li/span/a/div[1]/label/i"));
        uiObj.click(freeShippingFilter);
        //choosing new filter
        WebElement newFilter = uiObj.findElement(By.xpath("//*[@id=\"p_n_condition-type/28071525031\"]/span/a/span"));
        uiObj.click(newFilter);

    }

    public  void sortFromHighToLow()  {
        WebDriverWait wait=new WebDriverWait(BrowserActions.driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#a-autoid-0-announce > span.a-dropdown-label")));

        WebElement sortByDropDownList = uiObj.findElement(By.cssSelector("#a-autoid-0-announce > span.a-dropdown-label"));
        uiObj.click(sortByDropDownList);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("s-result-sort-select_2")));

        WebElement HighToLow = uiObj.findElement(By.id("s-result-sort-select_2"));
        uiObj.click(HighToLow);
    }
    public  void AddProductsBelow15K()  {

        WebDriverWait wait=new WebDriverWait(BrowserActions.driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='a-price-whole' and translate(., ',', '') < 15000]/ancestor::div[@class='sg-col sg-col-4-of-12 sg-col-8-of-16 sg-col-12-of-20 sg-col-12-of-24 s-list-col-right']")));

        //Get all items in this page which have price less than 5000 and put it in list
        List<WebElement> products = uiObj.findElements(By.xpath("//span[@class='a-price-whole' and translate(., ',', '') < 15000]/ancestor::div[@class='sg-col sg-col-4-of-12 sg-col-8-of-16 sg-col-12-of-20 sg-col-12-of-24 s-list-col-right']"));
        System.out.println(products.size());
        int loops= products.size();
        for(int i=0;i<loops; i++)
        {
            //Accessing each element and navigate to it's link
            System.out.println(products.get(i));
            WebElement product =products.get(i);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='a-price-whole' and translate(., ',', '') < 15000]/ancestor::div[@class='sg-col sg-col-4-of-12 sg-col-8-of-16 sg-col-12-of-20 sg-col-12-of-24 s-list-col-right']")));
            WebElement productLink=product.findElement(By.tagName("a"));

            System.out.println(productLink.getAttribute("href"));
            BrowserActions.driver.get(productLink.getAttribute("href"));

            //Adding the element to cart
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-to-cart-button")));

            WebElement addToCartButton= uiObj.findElement(By.id("add-to-cart-button"));
            uiObj.click(addToCartButton);
            //Navigate back to add new element to cart
            browserObj.navigateBack();
            browserObj.navigateBack();
            //Make sure you got back to products page before next loop
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='a-price-whole' and translate(., ',', '') < 15000]/ancestor::div[@class='sg-col sg-col-4-of-12 sg-col-8-of-16 sg-col-12-of-20 sg-col-12-of-24 s-list-col-right']")));
            products = uiObj.findElements(By.xpath("//span[@class='a-price-whole' and translate(., ',', '') < 15000]/ancestor::div[@class='sg-col sg-col-4-of-12 sg-col-8-of-16 sg-col-12-of-20 sg-col-12-of-24 s-list-col-right']"));

        }




    }

}
