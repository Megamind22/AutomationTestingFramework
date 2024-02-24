package tests;

import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.time.Duration;

public class TestBase
{
    public static WebDriver driver;


    @Parameters("browser")
    @BeforeSuite //Optional if i want run class alone without xml testng so it see Optional not value of xml
    public void startDriver(@Optional("chrome") String browser){

        //System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demo.nopcommerce.com/");
        System.out.println(browser);
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
