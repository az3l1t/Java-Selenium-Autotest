package Tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.logging.Logger;
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
    private static Logger logger = Logger.getLogger(LogsTest.class.getName());

    @BeforeClass
    public static void BeforeAll() {
        System.setProperty("chromedriver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        informationPage = new InformationPage(driver);
        //profilePage = new ProfilePage(driver);
        driver.manage().window().maximize();
        driver.get("https://passport.yandex.ru/auth");
        logger.info("Go to the authorization page");
    }

    @Test
    public void LogginTest() throws InterruptedException{
        loginPage.SendKeysLogin("#LoginOfYandex");
        loginPage.ClickOnLoginButton();
        logger.info("A login has been entered");
        /*
         * Ожидание появления ввода
         * пароля
         */
        WebDriverWait wait_first = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait_first.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"passp-field-passwd\"]")));
        /*
         * Ввод пароля
         */
        loginPage.SendKeysPassword("#PasswordOfYandex");
        loginPage.ClickOnLoginButton();
        logger.info("The password is entered");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div/nav/ul/li[2]/a")));

        informationPage.tapInfoElement();
        WebDriverWait wait_second = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait_second.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/main/div/section[3]/div/div[3]/a/div[2]/div[1]/div/div/span")));
        informationPage.tapAllDocsElement();
        informationPage.tapPassport();
        logger.info("Switched to passport information");

        //driver.switchTo().frame(informationPage.getFrame());
        /*
         * Доделать систему сбора информации
         * и инициализация логов
         */
        WebDriverWait wait_third = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait_third.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
        ("//div[@class='Slot_root__jYlNI Slot_content__XYDYF alignment-center_root__ndulA color-inherit_root__OQmPQ Slot_direction_vertical__I3MEt FieldItem_content__adUIk']")));
        System.out.println(informationPage.setArray(0));
        logger.info("The data has been received!");
        System.out.println(informationPage.setArray(1));
        logger.info("The data has been received!");
        System.out.println(informationPage.setArray(2));
        logger.info("The data has been received!");
        System.out.println(informationPage.setArray(4));
        logger.info("The data has been received!");
        System.out.println(informationPage.setArray(8));
        logger.info("The data has been received!");
        System.out.println(informationPage.setArray(9));
        logger.info("The data has been received!");
        /*
         * Добавить логгирование и try-catch
         */

    }

    @AfterClass
    public static void AfterAll(){
        driver.close();
    }

}
