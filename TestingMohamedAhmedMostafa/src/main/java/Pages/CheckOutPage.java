package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage {
    UiActions uiObj=new UiActions();

    public void chooseCashOnDelivery(){
        //choosing Cash on delivery (NOTE: the id and all the locators of the checkbox changes frequently)
        WebDriverWait wait=new WebDriverWait(BrowserActions.driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pp-G75qum-72")));

        WebElement CODcheckBox= uiObj.findElement(By.id("pp-G75qum-72"));
        uiObj.click(CODcheckBox);

        WebElement useThisPaymentMethodBTN= uiObj.findElement(By.xpath("//*[@id=\"pp-r3ZSuf-73\"]/span/input"));
        uiObj.click(useThisPaymentMethodBTN);

        WebElement orderWithoutPrimeBTN= uiObj.findElement(By.xpath("//*[@id=\"no-thanks-container\"]/span/span/span"));
        uiObj.click(orderWithoutPrimeBTN);

    }
    public String getTotalAmount(){

        WebElement totalAmount= uiObj.findElement(By.xpath("//*[@id=\"subtotals-marketplace-table\"]/tbody/tr[5]/td[2]"));
        return totalAmount.getText();

    }

}
