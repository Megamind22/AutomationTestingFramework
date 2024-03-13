package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//li[@id='TrackersVrmenu']/a")
    WebElement trackersLink;

    public void clickTrackersPage(){

        clickButton(trackersLink);
    }



}
