package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    UiActions uiObj=new UiActions();
    public  String getNoOfItemsInCart()  {
        //Enter Cart Page
        WebElement cartNo= uiObj.findElement(By.id("nav-cart-count"));
        uiObj.click(cartNo);
        WebDriverWait wait=new WebDriverWait(BrowserActions.driver, Duration.ofSeconds(20));

        //Get NO. of items in cart and return it
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nav-cart-count")));
        WebElement cartNo2= uiObj.findElement(By.id("nav-cart-count"));
        System.out.println(cartNo2.getText());
        return cartNo2.getText();
    }
    public  void ProceedToBuy()  {
        //entering checkout page

        WebElement proceedToBuyBtn= uiObj.findElement(By.cssSelector("#sc-buy-box-ptc-button > span > input"));
        uiObj.click(proceedToBuyBtn);
    }
}
