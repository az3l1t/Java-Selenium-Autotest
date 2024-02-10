package Files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InformationPage {
    public WebDriver driver;

    public InformationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/nav/ul/li[2]/a")
    public WebElement InfoElement;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/main/div/section[3]/div/div[3]/a/div[2]/div[1]")
    public WebElement AllDocsElement;

    public void tapInfoElement(){
        InfoElement.click();
    }

    public void tapAllDocsElement(){
        AllDocsElement.click();
    }

}
