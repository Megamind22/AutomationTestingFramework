package Data;

import org.testng.annotations.DataProvider;

public class DataProviderClass {



    @DataProvider( name = "testDataForWorkflow")
    public static Object[][] workflowData(){


        return new Object[][]{
            {
                "Template Name13Mar10" ,"Open" ,"Close"
            },
            {
                "Template Name#13Mar6" ,"Active" ,"End"
            }

        };
    }






}
