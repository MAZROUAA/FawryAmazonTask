package Pages;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonHomePage {
    //locating elements i  home page
    UiActions uiObj=new UiActions();




    public  void GoToLoginPage() {
        WebElement signInLink = uiObj.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/a[2]"));
        uiObj.click(signInLink);

    }

    public  void GoToVideoGamesPage()  {
        WebDriverWait wait=new WebDriverWait(BrowserActions.driver, Duration.ofSeconds(20));

       // Accessing burgerMenu
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nav-hamburger-menu")));
        WebElement AllMenu = uiObj.findElement(By.id("nav-hamburger-menu"));
        uiObj.click(AllMenu);



        //Accessing SeeAllMenu
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[14]/a[1]")));
        WebElement seeAllMenu = uiObj.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[14]/a[1]"));
        uiObj.click(seeAllMenu);

        uiObj.scroll();
        //Accessing VideoGames
        wait.until(ExpectedConditions.elementToBeClickable(uiObj.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/ul/li[11]/a/i"))));
        WebElement VideoGamesArrow = uiObj.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/ul/li[11]/a/i"));
        uiObj.click(VideoGamesArrow);

        //Accessing AllVideoGames
        wait.until(ExpectedConditions.elementToBeClickable(uiObj.findElement(By.xpath("/html/body/div[3]/div[2]/div/ul[16]/li[3]/a"))));
        WebElement AllVideoGamesLink = uiObj.findElement(By.xpath("/html/body/div[3]/div[2]/div/ul[16]/li[3]/a"));
        uiObj.click(AllVideoGamesLink);

    }



}
