package runners;


import com.cucumber.listener.Reporter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import utils.ConfigFileReader;

import java.io.File;

@Test
@CucumberOptions(
        tags="",
        features = "src/test/resources/Features/Search.feature",
        glue = {"stepdefinitions","hooks"},
        plugin = {"pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
                "html:target/cucumber-report.html"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {
        @AfterClass
        public static void writeExtentReport() {
                ConfigFileReader configFileReader = new ConfigFileReader();
                String reportConfigPath = configFileReader.getReportConfigPath();
                Reporter.loadXMLConfig(new File(reportConfigPath));
                }
}
