package Files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"passp-field-login\"]")
    private WebElement LoginField;

    @FindBy(xpath = "//*[@id=\'passp:sign-in\']")
    private WebElement LoginButton;

    @FindBy(xpath = "//*[@id=\"passp-field-passwd\"]")
    private WebElement PasswordField;

    @FindBy(xpath = "//*[@id=\"passp:sign-in\"]")
    private WebElement PasswordButton;

    public void SendKeysLogin(String Login) {
        LoginField.sendKeys(Login);
    }

    public void SendKeysPassword(String Password) {
        PasswordField.sendKeys(Password);
    }

    public void ClickOnLoginButton() {
        LoginButton.click();
    }

}
