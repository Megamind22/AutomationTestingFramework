package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{


    @FindBy(id="Username")
    WebElement userNameTxtBx;

    @FindBy(id="Password")
    WebElement passwTxtBx;

    @FindBy(className="signinformsubmit")

    WebElement signBton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginUser(String usrName ,String password ){

        setTextElement(userNameTxtBx ,usrName);
        setTextElement(passwTxtBx ,password);
        clickButton(signBton);


    }
}
