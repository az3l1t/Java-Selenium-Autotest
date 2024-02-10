package Tests;

import java.time.Duration;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Files.InformationPage;
import Files.LoginPage;

public class LogsTest {
    /*
     * Тут будет собираться информация по личным
     * данным пользователя
     */
    private static WebDriver driver;
    private static LoginPage loginPage;
    private static InformationPage informationPage;

    @BeforeClass
    public static void BeforeAll() {
        System.setProperty("chromedriver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        informationPage = new InformationPage(driver);
        //profilePage = new ProfilePage(driver);
        driver.manage().window().maximize();
        driver.get("https://passport.yandex.ru/auth");

    }

    @Test
    public void LogginTest(){
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div/nav/ul/li[2]/a")));

        informationPage.tapInfoElement();
        WebDriverWait wait_second = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait_second.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/main/div/section[3]/div/div[3]/a/div[2]/div[1]/div/div/span")));
        informationPage.tapAllDocsElement();

        informationPage.tapPassport();


        String nameOfRoot = informationPage.getName();
        System.out.println(nameOfRoot);

        //driver.switchTo().frame(informationPage.getFrame());
        /*
         * Доделать систему сбора информации
         * и инициализация логов
         */
        String passportNumber = informationPage.getPassportNumber();
        // String

    }

}
