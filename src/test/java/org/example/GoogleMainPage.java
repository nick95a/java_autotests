package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage {

    public WebDriver driver;

    public GoogleMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@class, 'gLFyf')]")
    private WebElement searchField;

    @FindBy(xpath = "//*[contains(@class, 'gNO89b')]")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@aria-label = 'Поиск по картинке']")
    private WebElement imageUploadButton;

    @FindBy(xpath = "//span[@value = 'Поиск по картинке']")
    private WebElement imageUploadLink;

    public void clickSearchField() {
        searchField.click();
    }

    public void inputSearchField(String search) {
        searchField.sendKeys(search);
    }

    public String getSearchFieldText() {
        return searchField.getAttribute("value");
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickImageUploadButton() {
        imageUploadButton.click();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

}
