package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Change password")
    WebElement changePassLik;

    @FindBy(id = "OldPassword")
    WebElement oldPassTxtBx;

    @FindBy(id = "NewPassword")
    WebElement newPassTxtBx;

    @FindBy(id = "ConfirmNewPassword")
    WebElement confirmPassTxtBx;

    @FindBy(className = "change-password-button")
    WebElement changePassBtn;

    @FindBy(xpath = "//div[@id='bar-notification']/div[1]/p")
    WebElement chhangedPassMssg;


    public void clickChangePassword(){
        clickButton(changePassLik);
    }
    public void changePassword(String old,String newed ){
        setTextElement(oldPassTxtBx,old);
        setTextElement(newPassTxtBx,newed);
        setTextElement(confirmPassTxtBx,newed);
        clickButton(changePassBtn);
    }
    public String getChangedPassMssg(){
        return this.chhangedPassMssg.getText();
    }



}
