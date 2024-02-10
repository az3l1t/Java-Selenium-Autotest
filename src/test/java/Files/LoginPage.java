package Files;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;
    public String FirstTryEquivalenceClasses = "eternity_cr9p";
    public String SecondTryEquivalenceClasses = "eternity_cr9p@mail";
    public String ThirdTryEquivalenceClasses = "eternity_cr9p@";
    public String ForthTryEquivalenceClasses = "@mail.ru";//@mail.ru
    public String FifthTryEquivalenceClasses = "eternity_cr9p@mail.ru";
    public List<String> ListOfEqClasses = new ArrayList<>();

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id='passp-field-login']")//
    private WebElement LoginField;

    ////*[@id="passp-field-login"]
    ///html/body/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/div/form/div/div[2]/div[2]/div/div/span[2]/input

    @FindBy(xpath = "//*[@id=\'passp:sign-in\']")
    private WebElement LoginButton;

    @FindBy(xpath = "//*[@id=\"passp-field-passwd\"]")
    private WebElement PasswordField;

    @FindBy(xpath = "//*[@id=\"passp:sign-in\"]")
    private WebElement PasswordButton;

    @FindBy(xpath = "//*[@id=\"field:input-login:hint\"]")
    private WebElement ErrorElement;

    public void SendKeysLogin(String Login) {
        LoginField.sendKeys(Login);
    }

    public void ClearKeys(){
        LoginField.clear();
    }

    public void TapKeys(){
        LoginField.click();
    }

    public void SendKeysPassword(String Password) {
        PasswordField.sendKeys(Password);
    }

    public void ClickOnLoginButton() {
        LoginButton.click();
    }

    public void FillList(){
        ListOfEqClasses.add(FirstTryEquivalenceClasses);
        ListOfEqClasses.add(SecondTryEquivalenceClasses);
        ListOfEqClasses.add(ThirdTryEquivalenceClasses);
        ListOfEqClasses.add(ForthTryEquivalenceClasses);
        ListOfEqClasses.add(ForthTryEquivalenceClasses);
        ListOfEqClasses.add(FifthTryEquivalenceClasses);
    }

    public boolean IsElementDisplayed() {
        return LoginField.isDisplayed();
    }

}
