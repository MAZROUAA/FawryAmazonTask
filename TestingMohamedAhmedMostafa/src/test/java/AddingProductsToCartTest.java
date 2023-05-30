import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddingProductsToCartTest {

    BrowserActions browserObj=new BrowserActions();
    UiActions uiObj=new UiActions();
    SignInPage signinObj=new SignInPage();
    AmazonHomePage homeObj=new AmazonHomePage();
    VideoGamesPage vGamesObj =new VideoGamesPage();
    CartPage cartObj=new CartPage();
    CheckOutPage checkOutObj=new CheckOutPage();


    //SingIn Data for My account
    @DataProvider(name = "SinginData")
    public static Object[][] siginData(){
        return new Object[][]{
                {
                        "01033359194", "123456"
                }
        };}


    @Test(dataProvider ="SinginData")
    public void addingProductsToCart(String mobile, String pass) throws InterruptedException {
        browserObj.openBrowser();

        browserObj.navigate("https://www.amazon.eg/");

        homeObj.GoToLoginPage();

        signinObj.login(mobile,pass);

        homeObj.GoToVideoGamesPage();

        vGamesObj.ChooseFreeShippingAndNew();

        vGamesObj.sortFromHighToLow();

        vGamesObj.AddProductsBelow15K();

        Assert.assertEquals(cartObj.getNoOfItemsInCart(),"4");

        cartObj.ProceedToBuy();
        //checkOutObj.chooseCashOnDelivery();

        //Assert.assertEquals(checkOutObj.getTotalAmount(),"");

    }
}
