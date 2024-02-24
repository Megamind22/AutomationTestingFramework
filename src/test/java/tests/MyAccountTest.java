package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegisterPage;

public class MyAccountTest extends TestBase{

    HomePage homeObj;
    UserRegisterPage regObj;
    LoginPage loginObj;
    String firstName="Mohamed";
    String lastName="Shhaker";
    String email="s@mmm.com";
    String passord="smmm12345";
    String newPassword="smmm12344";

    @Test(priority = 1,alwaysRun = true)
    public void verifyUserRegiserSuccess(){

        homeObj=new HomePage(driver);
        regObj=new UserRegisterPage(driver);

        homeObj.clickRigisterPage();

        regObj.userRegisteration(firstName,lastName,passord,email);

        Assert.assertTrue(regObj.resultTxtBx.getText().contains("completed"));

    }

    @Test(dependsOnMethods = {"verifyUserRegiserSuccess"})
    public void registeredUserCanLogin() throws InterruptedException {
        Thread.sleep(3000);
        homeObj.clickLoginPage();
        loginObj=new LoginPage(driver);
        loginObj.userLogin(email,passord);
        Assert.assertTrue(regObj.logoutLink.isDisplayed());

    }
    @Test(dependsOnMethods = {"registeredUserCanLogin"})
    public void verifyUserCanChangePassword() throws InterruptedException {

        homeObj.clickAccountPage();
        MyAccountPage myAccount=new MyAccountPage(driver);
        myAccount.clickChangePassword();
        myAccount.changePassword(passord,newPassword);
        System.out.println(myAccount.getChangedPassMssg());
        Assert.assertTrue(myAccount.getChangedPassMssg().equals("Password was changed"));
    }





}
