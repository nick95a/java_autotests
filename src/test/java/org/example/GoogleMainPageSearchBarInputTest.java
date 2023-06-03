package org.example;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.xpath;

public class GoogleMainPageSearchBarInputTest {

    // Test for navigation from google main page
    public static WebDriver driver;
    public static GoogleMainPage mainPage;
    public static String url = "https://google.com";
    public static String checkUrl = "https://www.sports.ru";
    public static String chromeDriverPath = "/Users/nikolaimaltcev/Downloads/chromedriver";
    public static String searchInputText = "Hello World";
    public String resultString;

    @BeforeClass
    public static void setup() {

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        mainPage = new GoogleMainPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void clickTest() {

        mainPage.clickSearchField();
        mainPage.inputSearchField(searchInputText);
        resultString = mainPage.getSearchFieldText();
        try{
            Boolean wait = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.attributeToBe(xpath("//textarea[@class='gLFyf']"), "value", searchInputText));
            Assert.assertTrue(wait);
            System.out.println("Test passed: Input text matches the value of the attribute.");
            }
        catch(Exception except) {
            System.out.println("Test failed: Input text does not match the value of the attribute.");
        }
        finally {
            System.out.println("End of the test");
        }
    }

    @AfterClass
    public static void closeDriver() {
        driver.quit();
    }
}