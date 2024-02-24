package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterPage;

public class UserRegisterTest extends TestBase
{

    HomePage homeObj;
    UserRegisterPage regObj;
    LoginPage loginObj;
    @Test(priority = 1,alwaysRun = true)
    public void verifyUserRegiserSuccess(){

        homeObj=new HomePage(driver);
        regObj=new UserRegisterPage(driver);

        homeObj.clickRigisterPage();

        regObj.userRegisteration("Mohamed","Shaker","ss99867","s@gmail.com");

        Assert.assertTrue(regObj.resultTxtBx.getText().contains("completed"));

    }

    @Test(dependsOnMethods = {"verifyUserRegiserSuccess"})
    public void registeredUserCanLogin(){
        homeObj.clickLoginPage();
        loginObj=new LoginPage(driver);
        loginObj.userLogin("s@gmail.com","ss99867");
        Assert.assertTrue(regObj.logoutLink.isDisplayed());

    }

}
