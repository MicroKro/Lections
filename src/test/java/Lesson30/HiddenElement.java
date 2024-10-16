package Lesson30;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HiddenElement {

    protected static WebDriver driver;
    protected Actions action;


    private static final String CONSOLE_LOG = "var test = 'I am text'; console.log(test);"; //null
    private static final String RETURN_TEXT = "return 'text'"; // string
    private static final String RETURN_NUMBER = "return 26"; // int
    private static final String RETURN_BOOL = "return true"; // boolean
    private static final String RETURN_ELEMENT = "return document.querySelector('#text');"; // WebElement

    @Test
    public void execute(){
        driver.get("https://ya.ru");

        Object willBeNull = ((JavascriptExecutor) driver).executeScript(CONSOLE_LOG);
        String string = (String) ((JavascriptExecutor) driver).executeScript(RETURN_TEXT);
        Long number = (Long) ((JavascriptExecutor) driver).executeScript(RETURN_NUMBER);
        Boolean bool = (Boolean) ((JavascriptExecutor) driver).executeScript(RETURN_BOOL);
        WebElement element = (WebElement) ((JavascriptExecutor) driver).executeScript(RETURN_ELEMENT);
        var placeholderValue = element.getAttribute("placeholder");
    }

    @BeforeAll
    public static void setUp (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void uploadToHidden() {
        driver.get ("https://otus.home.kartushin.su/");
        String filePath = "C:\\Users\\Di\\Downloads";
        String fileName = "жду.png";
        var uplaodButton = driver.findElement(By.id("idButton"));
        ((JavascriptExecutor) driver).executeScript("arguments[0}.removeAttribute(\"hidden\")", uplaodButton);
        uplaodButton.sendKeys(filePath + fileName);
    }

    @Test
    public void execute(){
        driver.get("https://ya.ru");

        Object willBeNull = ((JavascriptExecutor) driver).executeScript(CONSOLE_LOG);
        String string = (String) ((JavascriptExecutor) driver).executeScript(RETURN_TEXT);
        Long number = (Long) ((JavascriptExecutor) driver).executeScript(RETURN_NUMBER);
        Boolean bool = (Boolean) ((JavascriptExecutor) driver).executeScript(RETURN_BOOL);
        WebElement element = (WebElement) ((JavascriptExecutor) driver).executeScript(RETURN_ELEMENT);
        var placeholderValue = element.getAttribute("placeholder");
    }
}
