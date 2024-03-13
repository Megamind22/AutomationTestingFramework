package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.PublicKey;
import java.time.Duration;
import java.util.List;

public class WorkflowPage extends PageBase{


    public WorkflowPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//div[@class=\"status-card border bg-white height-350 min-width-200\"]/div[2]/button")
    WebElement addNewtmplBtn;

    @FindBy(xpath = "//input[contains(@class,'form-control form-control-sm mr-05 ng-')]")
    WebElement nameTxtBx;

    @FindBy(xpath = "//app-workflow/div[2]/div[1]/div[1]/div[2]/div[2]/div/button[1]")
    WebElement addNameTmpltBtn;

    @FindBy(xpath = "//app-workflow/div[2]/div[1]/div[2]/div[2]/div[2]/div/button[1]")
    WebElement addNameActiveBtn;



    @FindBy(xpath = "//app-workflow/div[2]/div[1]/div[2]/div[2]/div[2]/button")
    WebElement addActiveStatusBtn;

    @FindBy(xpath="//app-workflow/div[2]/div[2]/div[2]/div[2]/div[2]/button")
    WebElement addCloseStatusBtn;
    @FindBy(xpath = "//app-workflow/div[2]/div[2]/div[2]/div[2]/div[2]/div/button[1]")
    WebElement addNameCloseBtn;

    @FindBy(xpath = "//app-workflow/div[2]/div[3]/button")
    WebElement saveBtn;

    @FindBy(id = "toast-container")
    WebElement systemMesg;

    @FindBy(xpath = "//div[@class='z2page-head-title']/h1")
    WebElement headerPage;

    @FindBy(xpath="//div[@class='status-card border bg-white height-350 min-width-200']/div[1]/div/span")
    List<WebElement> listOFWorkflowTmplt;




    public void addNewTemplateName(String name){
        clickButton(addNewtmplBtn);
        setTextElement(nameTxtBx,name);
        clickButton(addNameTmpltBtn);

    }
    public void addNewActiveStatusName(String name){
        clickButton(addActiveStatusBtn);
        setTextElement(nameTxtBx,name);
        clickButton(addNameActiveBtn);

    }
    public void addNewCloseStatusName(String name)   {

        hoverAndClick(addCloseStatusBtn);
        setTextElement(nameTxtBx,name);

        clickButton(addNameCloseBtn);

    }
    public String get_reply_of_system(){

        return systemMesg.getText();
    }
    public void clickSave(){
        hoverAndClick(saveBtn);
    }
    public String getHeaderPage(){
        return headerPage.getText();
    }

    public List<WebElement> getListElementOFWorkflow(){

        return listOFWorkflowTmplt;
    }
    public void clearWorkflowNameTxtBx() {
        clearTextBox(nameTxtBx);
    }






}
