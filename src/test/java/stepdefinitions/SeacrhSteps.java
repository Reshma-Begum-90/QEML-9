package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import utils.DriverManager;


public class SeacrhSteps {

    private WebDriver driver;
    private HomePage homePage;

    @Given("the user is on the homepage")
    public void userIsOnHomePage() {
        driver = DriverManager.getDriver();  // Reuse shared WebDriver instance
        homePage = new HomePage(driver);
        homePage.navigateToHomePage();

        // Take and attach a screenshot for this step to Allure
        attachScreenshot("Homepage loaded successfully");
    }

    @When("the user clicks on {string} in category section")
    public void userClicksOn(String category) {
        homePage.clickCategory(category);

        // Take and attach a screenshot after clicking the category
        attachScreenshot("Clicked on category: " + category);
    }

    @Then("the user should be displayed only {string}")
    public void userShouldSee(String category) {
        String actualProduct = homePage.verifyProduct(category);
        String expectedProduct = "Samsung galaxy s";  // Adjust based on your test logic
        attachScreenshot("Product verification step");
        Assert.assertEquals("Product mismatch!", expectedProduct, actualProduct);
    }

    @Attachment(value = "{screenshotName}", type = "image/png")
    public byte[] attachScreenshot(String screenshotName) {
        if (driver == null) {
            return new byte[0]; // Fail gracefully if WebDriver is null
        }
        // Capture screenshot
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}