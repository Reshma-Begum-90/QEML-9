package runners;


import io.cucumber.core.options.CucumberOptionsAnnotationParser;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        tags="",
        features = "src/test/resources/Features/Search.feature",
        glue = {"stepdefinitions","hooks"},
        plugin = {"pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "html:target/cucumber-report.html"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
