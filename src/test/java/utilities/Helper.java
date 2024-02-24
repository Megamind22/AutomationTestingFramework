package utilities;

import org.openqa.selenium.WebDriver;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper {

    //Method to Screenshot when failure

    public static void captureScreenshot(WebDriver driver,String scrName){

        Path dest= Paths.get("./screenshot"+scrName+".png");


    }
}
