package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {
    BrowserActions browserObj=new BrowserActions();
    AmazonHomePage homeObj=new AmazonHomePage();
    UiActions uiObj =new UiActions();






    public  void login(String mobileNo,String Pass)
    {
        WebElement mobileOrEmailTextBox=uiObj.findElement(By.id("ap_email"));
        uiObj.setTextField(mobileOrEmailTextBox,mobileNo);
        WebElement continueButton=uiObj.findElement(By.id("continue"));
        uiObj.click(continueButton);
        WebElement passwordTextBox=uiObj.findElement(By.id("ap_password"));
        uiObj.setTextField(passwordTextBox,Pass);
        WebElement signInButton=uiObj.findElement(By.id("signInSubmit"));
        uiObj.click(signInButton);
    }


}
