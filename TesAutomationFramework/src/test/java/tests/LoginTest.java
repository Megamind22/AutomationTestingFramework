package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends TestBase{


    @Test
    public void verifyUserLoginSuccess()
    {

        System.out.println("Login Successfully");

    }
}

