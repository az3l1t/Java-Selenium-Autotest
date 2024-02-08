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
import junit.framework.Assert;

public class compOfAccountNameAndExit {
    public static LoginPage loginPage;
    private static WebDriver driver;
    private static ProfilePage profilePage;
    private String userName = "Norair Avanesian";

    @BeforeClass
    public static void BeforeAll() {
        System.setProperty("chromedriver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        driver.manage().window().maximize();
        driver.get("https://passport.yandex.ru/auth");

    }

    @SuppressWarnings("deprecation")
    @Test
    public void compOfAccountNameAndExit(){
        WebDriverWait wait_second = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait_second.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/header/div/div[2]/button/div/div[1]/img")));
        profilePage.clickOnMenu();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String user = profilePage.getName();
        Assert.assertEquals(user, userName);
        profilePage.exitButton();
    }

    @AfterClass
    public void AfterAll(){
        driver.close();
    }
}
