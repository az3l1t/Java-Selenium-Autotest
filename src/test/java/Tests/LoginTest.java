package Tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

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
        //profilePage = new ProfilePage(driver);
        driver.manage().window().maximize();
        driver.get("https://passport.yandex.ru/auth");

    }

    @Test
    public void testOfAuth() throws InterruptedException {
        /*
         * Метод пробы пяти основных классов ввода данных
         */
        for(String listValue : loginPage.ListOfEqClasses){
            try{
                loginPage.SendKeysLogin(listValue);
                loginPage.ClickOnLoginButton();
            }
            catch (NoSuchElementException e){
                System.out.println("No Error Founded");
            }
            finally{
                if (loginPage.IsElementDisplayed()) {
                    loginPage.ClearKeys();
                }
            }
        }
    }


    @AfterClass
    public static void AfterAll(){
        driver.close();
    }

}
