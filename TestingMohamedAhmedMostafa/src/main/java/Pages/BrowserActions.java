package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

public class BrowserActions {

    public static EdgeDriver driver;
    public static Actions action;
    public static JavascriptExecutor js;

    //open browser function
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new EdgeDriver(options);
        action=new Actions(driver);
        js= (JavascriptExecutor)driver;
    }
    //navigate to any url function
    public void navigate(String url){
        driver.navigate().to(url);
        driver.manage().window().maximize();
        if(!driver.getCurrentUrl().equals(url)){
            throw new RuntimeException();
        }
    }
    //navigate back function
    public void navigateBack(){
        String url=driver.getCurrentUrl();
        driver.navigate().back();
        if(driver.getCurrentUrl().equals(url)){
            throw new RuntimeException();
        }
    }




}
