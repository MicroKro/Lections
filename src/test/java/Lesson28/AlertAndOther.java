package Lesson28;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AlertAndOther {
    protected static WebDriver driver;
    public static Logger logger = LogManager.getLogger(AlertAndOther.class);

    @BeforeAll
    public static void setUp (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info ("Драйвер поднят");
    }

    @AfterAll
    public static void setDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Драйвер успешно закрыт");
        }
    }

    @Test
    public void alert() {
        driver.get("https://otus.home.kartushin.su/alert.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String actual = alert.getText();
        alert.accept();
        Assertions.assertEquals("Test Alert", actual);
    }

}
