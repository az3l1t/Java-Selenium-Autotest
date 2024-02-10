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

    @FindBy(xpath = "//*[@id=\"__next\"]/div/main/div/section[1]/div/div/div/div/div/ul/li/div")
    public WebElement Passport;

    @FindBy(xpath = "//section[@class='Section_root__zl60G']")
    public WebElement Frame;

    @FindBy(xpath = "//h2[@data-testid='heading-title']")
    public WebElement Name;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div/div/div[3]/section[2]/div/div/div[1]/div/div[1]/span[2]")
    public WebElement PassportNumber;

    public String getPassportNumber(){
        return PassportNumber.getText();
    }

    public String getName(){
        return Name.getText();
    }

    public WebElement getFrame(){
        return Frame;
    }

    public void tapPassport(){
        Passport.click();
    }

    public void tapInfoElement(){
        InfoElement.click();
    }

    public void tapAllDocsElement(){
        AllDocsElement.click();
    }

}
