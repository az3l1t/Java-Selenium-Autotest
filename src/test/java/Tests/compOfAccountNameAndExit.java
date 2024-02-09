package Tests;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void compOfAccountNameAndExit(){
        /*
         * Отправление позитивных ключей для входа
         * в аккаунт
         */

        loginPage.SendKeysLogin("onelive32111@mail.ru");
        loginPage.ClickOnLoginButton();
        /*
         * Ожидание появления ввода
         * пароля
         */
        WebDriverWait wait_first = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait_first.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"passp-field-passwd\"]")));
        /*
         * Ввод пароля
         */
        loginPage.SendKeysPassword("Chemege1.");
        loginPage.ClickOnLoginButton();
        /*
         * Вход в аккаунт и переход
         * в аккаунт-страницу
         * поиск иконки аккаунта и нажатие по ней
         */

        WebDriverWait wait_second = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait_second.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/header/div/div[2]/button/div/div[1]/img")));
        profilePage.clickOnMenu();
        /*
         * Переход на всплювабщий фрейм
         * и проверка данных со значением в классе
         * + выход из аккаунта во фрейме
         */
        driver.switchTo().frame(profilePage.getFrame());
        String user = profilePage.getName();
        assertEquals(user, userName);
        profilePage.exitButton();
    }

    @AfterClass
    public static void AfterAll(){
        driver.close();
    }
}
