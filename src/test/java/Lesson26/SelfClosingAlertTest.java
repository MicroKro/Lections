package Lesson26;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SelfClosingAlertTest {

    static WebDriver driver;
    private static final String URL = "https://ng-bootstrap.github.io/#/components/alert/examples";
    private static final By BUTTON = By.xpath("//button[contains(text(), 'Change message')]");
    private static final By MESSAGE = By.xpath("//mgb-alert[contains(text(), 'Message successfully change')]");
    static WebDriverWait elementWait;


    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        elementWait = new WebDriverWait(driver, Duration.ofSeconds(7));
    }

    @AfterAll
    public static void tearDown(){
        if (driver !=null) {
            driver.quit();
        }
    }

    @Test
    public void checkMessage () throws InterruptedException {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].sceollIntoView()", getElenent(BUTTON));
        je.executeScript("arguments[0].click()", getElenent(BUTTON));

        //getElenent(BUTTON).click(); не нужно, так как загнали в джава скрипт
        String messageBefore = getElenent(MESSAGE).getText();

        Thread.sleep(1500L);

        getElenent(BUTTON).click();
        String messageAfter = getElenent(MESSAGE).getText();

        Assertions.assertNotEquals(messageBefore, messageAfter, "Message sre equals");

    }

    private WebElement getElenent(By locator){
        return new WebDriverWait(driver, Duration.ofSeconds(15))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
// иной вариант
//    private boolean waitDisapireElenent(WebElement webElement){
//        return new WebDriverWait(driver, 10)
//                   .until(ExpectedConditions.invisibilityOf(webElement));
//    }
}
