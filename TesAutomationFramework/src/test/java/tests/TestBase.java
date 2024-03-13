package tests;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.LoginPage;
import utilities.Helper;

import java.time.Duration;

public class TestBase
{
    public static WebDriver driver;


    @Parameters({"browser","userName","password"})
    @BeforeSuite //Optional if i want run class alone without xml testng so it see Optional not value of xml
    public void startDriver(@Optional("chrome") String browser,
                            @Optional("username") String userName,
                            @Optional("password") String password  ){

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
        driver.get("url");
        login(userName,password);
        System.out.println("System under test"+browser);
    }

    private void login(String usrname,String password){
        LoginPage loginObj=new LoginPage(driver);
        loginObj.loginUser(usrname,password);

    }

    @AfterSuite
    public void stopDriver(){
        driver.quit();
    }

    @AfterMethod //take screenshot when TC failed
    public void screenshotOnFailure(ITestResult result){

        if (result.getStatus()==ITestResult.FAILURE){
            System.out.println("Failed..!!");
            Helper.captureScreenshot(driver,result.getName());
        }
    }

}
