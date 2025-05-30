package hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;

import java.util.logging.Logger;


public class TestHooks {
    private static final Logger LOGGER= Logger.getLogger(TestHooks.class.getName());
private WebDriver driver;
    @Before
    public void SetUp(){
        LOGGER.info("setting up");
        System.out.println("Setting up");
        driver=DriverManager.getDriver();
    }
    @After
    public void tearDown(Scenario scenario){
        LOGGER.info("tearing");
//        takeScreenshot();
        try {
            String screenshotName = scenario.getName();
            if (scenario.isFailed()) {
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "img/png", screenshotName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DriverManager.quitDriver();


    }


}
