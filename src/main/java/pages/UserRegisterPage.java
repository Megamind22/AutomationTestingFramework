package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterPage extends PageBase {


    public UserRegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gender-male")
    WebElement genderRdoButon;
    @FindBy (id="LastName")
    WebElement lstName;

    @FindBy (id="FirstName")
    WebElement fstName;

    @FindBy(id="Email")
    WebElement emailTxtBox;
    @FindBy(id="Password")
    WebElement password;

    @FindBy(id="ConfirmPassword")
    WebElement confirmPassword;
    @FindBy(id="register-button")
    WebElement regiterBtn;
    @FindBy(css = ".result")
    public WebElement resultTxtBx;// to use in assertion

    @FindBy(className = "ico-logout")
    public WebElement logoutLink;

    public void userRegisteration(String firstName ,String lastName ,String pass ,String email){

        clickButton(genderRdoButon);
        setTextElement(fstName,firstName);
        setTextElement(lstName,lastName);
        setTextElement(emailTxtBox,email);
        setTextElement(password,pass);
        setTextElement(confirmPassword,pass);
        clickButton(regiterBtn);
    }

   public void logOut(){
        clickButton(logoutLink);
   }
}
