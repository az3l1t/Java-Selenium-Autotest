package Tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Files.LoginPage;
import Files.ProfilePage;
import junit.framework.Assert;

public class LoginTest {
    public static LoginPage loginPage;
    private static WebDriver driver;
    private static ProfilePage profilePage;

    @BeforeClass
    public static void BeforeAll() {
        System.setProperty("chromedriver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        driver.manage().window().maximize();
        driver.get("https://passport.yandex.ru/auth");

    }

    @Test
    public void TestOfAuth() {
        /*
         * Метод пробы пяти основных классов ввода данных
         */
        loginPage.FillList();
        for(int i=0;i<loginPage.ListOfEqClasses.size();i++){
            loginPage.SendKeysLogin(loginPage.ListOfEqClasses.get(i));
            loginPage.ClickOnLoginButton();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"field:input-login:hint\"]")));
            try{
                loginPage.TapKeys();
                loginPage.ClearKeys();
            }catch(NoSuchElementException e){

            }
        }

    }


    @AfterClass
    public void AfterAll(){
        driver.close();
    }

}
