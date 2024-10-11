package Lessons23_25.Tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertSame;

public class FirstTest {

    private static final Logger logger = LogManager.getLogger(FirstTest.class);
    public static WebDriver driver;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeEach
    void beforeEach() {
        logger.info("Новый тест");
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void test1(int arguments) {
        logger.info("тест1 с параметром " + arguments);
        driver.get("https://otus.ru/");
        assertSame (arguments, 2);
        logger.error("Сообщение лога");
    }

    @Tag("пробный тег")
    @ParameterizedTest
    @ValueSource(ints = {4,5,6})
    void test2(int arguments) {
        logger.info("тест2 с параметром " + arguments);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Тест окончен");
        assert driver != null;
        driver.quit();
    }
}
