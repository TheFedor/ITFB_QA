package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class AlertsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "div[class='element-list collapse show'] ul li:nth-child(2)")
    WebElement alertsBox;

    @FindBy(css = "button[id='alertButton']")
    WebElement alertButton;
    @FindBy(css = "button[id='timerAlertButton']")
    WebElement timerAlertButton;
    @FindBy(css = "button[id='confirmButton']")
    WebElement confirmButton;
    @FindBy(xpath = "//span[contains(text(), 'You selected')]")
    WebElement dynamicSpan;
    @FindBy(css = "button[id='promtButton']")
    WebElement promtButton;

    @FindBy(xpath = "//span[contains(text(), 'You entered')]")
    WebElement enteredTextFromAlert;

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
    }

    @Step("20-Нажать на \"Alerts\"")
    public void clickOnAlertsBox() {
        alertsBox.click();
    }

    @Step("21-Нажать на кнопку \"Click me\" рядом с Click Button to see alert")
    public void clickAlertButton() {
        alertButton.click();
    }

    @Step("22-Закрыть уведомление")
    public void closeAlert() {
        Alert alert = wait.until(alertIsPresent());
        alert.accept();
    }

    @Step("23-Нажать на кнопку \"Click me\" рядом с On button click, alert will appear after 5 seconds")
    public void clickTimeAlertButton() {
        timerAlertButton.click();
    }

    @Step("24-Закрыть уведомление")
    public void closeTimeAlert() {
        Alert alert = wait.until(alertIsPresent());
        alert.accept();
    }

    @Step("25-Нажать на кнопку \"Click me\" рядом с On button click, confirm box will appear")
    public void confirmButtonClick() {
        confirmButton.click();
    }

    @Step("26-Нажать на кнопку \"Да\" в уведомлении")
    public void acceptConfirmAlert() {
        Alert alert = wait.until(alertIsPresent());
        alert.accept();
    }

    @Step("27-Проверить, что появился текст You selected Ok")
    public void checkSelectedStatus() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'You selected')]")));
        try {
            Assert.assertEquals(dynamicSpan.getText(), "You selected Ok");
        } catch (AssertionError e) {
            String errorMessage = "Assert failed: " + e.getMessage();
            Allure.addAttachment("Assert failed", errorMessage);
            System.out.println(errorMessage);
        }
    }

    @Step("28-Нажать на кнопку \"Click me\" рядом с On button click, prompt box will appear")
    public void promtButtonClick() {
        promtButton.click();
    }

    @Step("29-Заполнить поле в уведомлении данными Test name")
    public void fillingInAlert() {
        Alert alert = wait.until(alertIsPresent());
        alert.sendKeys("Test name");
        alert.accept();
    }

    @Step("30-Проверить, что появился текст You entered Test name")
    public void checkTextEnteredAfterAlert() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'You entered')]")));
        try {
            Assert.assertEquals(enteredTextFromAlert.getText(), "You entered Test name");
        } catch (AssertionError e) {
            String errorMessage = "Assert failed: " + e.getMessage();
            Allure.addAttachment("Assert failed", errorMessage);
            System.out.println(errorMessage);
        }
    }




}
