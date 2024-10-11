package Lessons23_25.Tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ConfigDriver {

    static WebDriver driver;

    @BeforeAll
    public static void webDriverInstall() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void webDriverStart() {
        System.out.println("webDriverStart");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        //        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); установить таймаут
        driver.get("https://otus.home.kartushin.su/training.html");
    }

    @AfterEach
    public void webDriverStop() {
        System.out.println("Тест окончен");
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void cookieTest (){
        driver.manage().addCookie(new Cookie("Otus1", "Value1"));
        Cookie cookie = new Cookie("Otus2", "Value2");
        driver.manage().addCookie(cookie);
        System.out.println(driver.manage().getCookies());
        System.out.println(driver.manage().getCookieNamed("Otus1"));
        driver.manage().deleteCookieNamed("Otus1");
        System.out.println(driver.manage().getCookies());
        driver.manage().deleteAllCookies();
        Assertions.assertEquals(0, driver.manage().getCookies().size());
    }

    @Test
    public void windowTest (){
        driver.manage().window().maximize();
        System.out.println(driver.manage().window().getSize());
        driver.manage().window().setSize(new Dimension(800,600)); //запуск тста в расширении 800 на 600
        System.out.println(driver.manage().window().getPosition());

        Point point = driver.manage().window().getPosition();
        point.x += 100;
        driver.manage().window().setPosition(point);
        point.y = 100;
        driver.manage().window().setPosition(point);
        point.x -= 100;
        driver.manage().window().setPosition(point);
        point.y -= 100;
        driver.manage().window().setPosition(point);
    }
}