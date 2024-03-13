package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrackersPage extends HomePage{
    public  TrackersPage(WebDriver driver){

            super(driver);
    }

    @FindBy(xpath = "//button[@class='z2actionbtnA mr-03']")
    WebElement hideFilterBtn;

    @FindBy(xpath = "//div[@class='d-flex align-items-center justify-content-between mb-05']/div/div[2]/button")
    WebElement exportBtn;

    @FindBy(xpath = "//div[@class='d-flex align-items-center justify-content-between mb-05']/div/button[1]")
    WebElement archiveBtn;

    @FindBy(xpath = "//div[@class='d-flex align-items-center justify-content-between mb-05']/div/button[2]")
    WebElement pinToTopBtn;

    @FindBy(xpath = "//ul[ @class='z2-leftpanel-ullinks nav h-fit']/li[10]/a")
    WebElement workflowLink;

    public void clickExportButton(){
        clickButton(exportBtn);
    }

    public void openWorkflowPage(){
        clickButton(workflowLink);
    }











}
