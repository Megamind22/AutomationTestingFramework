package tests;

import Data.DataProviderClass;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.TrackersPage;
import pages.WorkflowPage;
import Data.DataProviderClass;

import java.util.List;

public class WorkflowTest extends TestBase{


    HomePage home;
    TrackersPage tracker;
    WorkflowPage workflow;
    SoftAssert soft_assert;

    @Test(alwaysRun = true ,priority = 1)
    public void openWorkflowPage() throws InterruptedException {
        home=new HomePage(driver);
        tracker=new TrackersPage(driver);
        workflow=new WorkflowPage(driver);
        soft_assert=new SoftAssert();
        Thread.sleep(3000);
        home.clickTrackersPage();
        tracker.openWorkflowPage();

        soft_assert.assertEquals(workflow.getHeaderPage(),"Workflow");

    }

    @Test(dependsOnMethods = {"openWorkflowPage"},dataProvider = "testDataForWorkflow",dataProviderClass= DataProviderClass.class)
    public void createWorkflowSuccessfully(String templateName,String active,String close) throws InterruptedException {
        Thread.sleep(3000);
        workflow.addNewTemplateName(templateName);
        workflow.addNewActiveStatusName(active);
        workflow.addNewCloseStatusName(close);
        workflow.clickSave();
        if(templateName.contains("#")){
            soft_assert.assertTrue(workflow.get_reply_of_system().contains("mplate name should not be a space or special characters"));
            System.out.println("1");
        }else
        {
            System.out.println("2");
            soft_assert.assertTrue(workflow.get_reply_of_system().contains("saved"));
        }

        System.out.println(workflow.get_reply_of_system());
        soft_assert.assertAll();

    }

    @Test(dependsOnMethods = {"openWorkflowPage"})
    public void verifyMoreOneWorkflowWithSameName() {
        String firstExistingTmplt =workflow.getListElementOFWorkflow().get(0).getText();

        workflow.clearWorkflowNameTxtBx();
        workflow.addNewTemplateName(firstExistingTmplt);
        System.out.println(workflow.get_reply_of_system());
        soft_assert.assertTrue(workflow.get_reply_of_system().contains("exists"));
        soft_assert.assertAll();
    }



}
