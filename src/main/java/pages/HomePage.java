package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

public class HomePage {

    private WebDriver driver=DriverManager.getDriver();

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this); // <== THIS LINE IS ESSENTIAL

    }

    @FindBy(xpath="//a[text()=\"Phones\"]")
    private WebElement phoneCategory;

    @FindBy(xpath = "(//h4[@class=\"card-title\"]/a)[1]")
    private WebElement verifyingField;

    @FindBy(xpath = "//a[text()=\"Laptops\"]")
    private WebElement laptopCategory;

    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    public void navigateToHomePage(){
        driver.get("https://www.demoblaze.com/");
    }
    public void clickCategory(String category){
        WebElement categoryField;
        if(category=="phone"){
            categoryField=phoneCategory;
        }
        else {
            categoryField=laptopCategory;
        }
        wait.until(ExpectedConditions.elementToBeClickable(categoryField)).click();

    }
    public String verifyProduct(){
      return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4[@class=\"card-title\"]/a)[1]"))).getText();
    }
}
