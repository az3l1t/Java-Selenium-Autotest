package Files;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    public WebDriver driver;
    public ProfilePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }

    @FindBy(xpath="//*[@id=\"__next\"]/div/header/div/div[2]/button")
    private WebElement Menu;

    @FindBy(xpath = "//*[contains(@class,'UserId-FirstLine')]")
    private WebElement NameElement;

    private WebElement ExitButton;

    public String getName(){
        String name = NameElement.getText();
        return name;
    }

    public void clickOnMenu(){
        Menu.click();
    }

    public void exitButton(){
        ExitButton.click();
    }


}
