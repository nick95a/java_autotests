package org.example;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GoogleMainPageTest {

    public static WebDriver driver;
    public static GoogleMainPage mainPage;
    public static String url = "https://google.com";
    public static String checkUrl = "https://www.sports.ru";
    public static String chromeDriverPath = "/Users/nikolaimaltcev/Downloads/chromedriver";
    public static String searchText = "Hello World";

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
        mainPage.inputSearchField(searchText);
        mainPage.clickSearchButton();
        String currentUrl = mainPage.getUrl();
        Assert.assertNotEquals(checkUrl, currentUrl);

    }

    @AfterClass
    public static void closeDriver() {
        driver.quit();
    }
}