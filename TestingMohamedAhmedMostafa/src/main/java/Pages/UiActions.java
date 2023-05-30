package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static Pages.BrowserActions.*;

public class UiActions {


    public WebElement findElement(By by){

        WebElement element= driver.findElement(by);
        return element;

    }
    public List<WebElement> findElements(By by){

       List<WebElement> element= driver.findElements(by);
        return element;

    }

    public void setTextField(WebElement element, String str){

        if(element.isDisplayed()){
            element.clear();
            element.sendKeys(str);}


    }

    public void click(WebElement element){

        if(element.isDisplayed()){
            element.click();
        }
        else{throw new RuntimeException();}

    }

    public void scroll(){


        js.executeScript("window.scrollBy(0,1000)");
    }
}
