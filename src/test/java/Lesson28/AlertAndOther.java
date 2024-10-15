package Lesson28;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
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

    @Test
    public void confirm() {
        driver.get("https://otus.home.kartushin.su/confirm.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        wait.until(ExpectedConditions.alertIsPresent()); //работа со вторым окном после закрытия первого
        alert = driver.switchTo().alert();
        String actual = alert.getText();
        alert.accept();
        Assertions.assertEquals("false", actual);
    }

    @Test
    public void promptTest() {
        driver.get("https://otus.home.kartushin.su/prompt.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("name");
        alert.accept();
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        String actual = alert.getText();
        alert.accept();
        Assertions.assertEquals("Hello name", actual);
    }

    @Test
    public void upload() {
        String filePath = "C:\\Users\\Di\\Downloads";
        String fileName = "жду.png";
        driver.get ("https://otus.home.kartushin.su/");
        driver.findElement(By.xpath("//a[text()=\"upload.php\"]"))
              .sendKeys (filePath + fileName);
    }

    @Test
    public void windowTest() {
        driver.get("https://omayao.blogspot.com/");
        WebElement window = driver.findElement(By.linkText("Open a popup window"));
        window.click();
        ArrayList<String> windowsCount = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowsCount.get(1));
        WebElement newWindow = driver.findElement(By.className("example"));
        String windowText = newWindow.getText();
        Assertions.assertEquals("New Window", windowText);
    }

    @Test
    public void iFrame() throws InterruptedException {
        driver.get("https://otus.home.kartushin.su/iframe2.html");
        WebElement requiredFrame = driver.findElement(By.id("myframe"));
        driver.switchTo().frame(requiredFrame);
        driver.findElement(By.id("Header1")).click();
        Thread.sleep(4000);
    }
}

