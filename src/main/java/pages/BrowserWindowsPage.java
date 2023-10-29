package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserWindowsPage {
    private final WebDriver driver;
    private final String currentWindow;
    private final WebDriverWait wait;

    @FindBy(css = "div[class='element-list collapse show'] ul li:first-child")
    WebElement browserWindows;

    @FindBy(css = "button[id='tabButton']")
    WebElement newTabButton;
    @FindBy(css = "button[id='windowButton']")
    WebElement newWindowButton;

    public BrowserWindowsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        currentWindow = driver.getWindowHandle(); //учитывая что работаем сейчас с одним окном и максимум будем с двумя, этого достаточно
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
    }

    @Step("15-Нажать на Browser Windows")
    public void clickOnBrowserWindows() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='element-list collapse show']")));
        browserWindows.click();
    }

    @Step("16-Нажать на кнопку New Tab")
    public void newTabButtonClick() {
        newTabButton.click();
    }

    @Step("17-Закрыть новую вкладку")
    public void closeNewTab() {
        //Находим дескриптор новой вкладки
        String newWindow = "";
        for (String window : driver.getWindowHandles())
            if (!window.equals(currentWindow))
                newWindow = window;
        driver.switchTo().window(newWindow);
        driver.close();
        driver.switchTo().window(currentWindow);
    }

    @Step("18-Нажать на кнопку New window")
    public void newWindowButtonClick() {
        newWindowButton.click();
    }

    @Step("19-Закрыть новое окно")
    public void closeNewWindow() {
        String newWindow = "";
        for (String window : driver.getWindowHandles())
            if (!window.equals(currentWindow))
                newWindow = window;
        driver.switchTo().window(newWindow);
        driver.close();
        driver.switchTo().window(currentWindow);
    }
}
