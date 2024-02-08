package Tests;

import java.time.Duration;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Files.LoginPage;
import Files.ProfilePage;

public class MainAccountAuth {
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
    public void mainAccountAuth(){
        loginPage.SendKeysLogin("onelive32111@mail.ru");
        loginPage.ClickOnLoginButton();
        WebDriverWait wait_first = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait_first.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"passp-field-passwd\"]")));
        loginPage.SendKeysPassword("Chemege1.");
        loginPage.ClickOnLoginButton();
    }

    @AfterClass
    public void AfterAll(){
        driver.close();
    }
}
