package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy( id = "Email")
    WebElement emailTxtBx;

    @FindBy( id = "Password")
    WebElement passTxtBx;

    @FindBy(xpath = "//*[contains(@class ,'login-button')]")
    WebElement logintBtn;

    public void userLogin(String email ,String password){

        setTextElement(emailTxtBx,email);
        setTextElement(passTxtBx,password);
        clickButton(logintBtn);

    }




}
