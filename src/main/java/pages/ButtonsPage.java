package pages;

import io.opentelemetry.sdk.trace.internal.data.ExceptionEventData;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ButtonsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    Actions actions;

    @FindBy(xpath = "//span[text()='Buttons']")
    WebElement buttonsButton;

    @FindBy(xpath = "//button[text()='Click Me']")
    WebElement buttonClickMe;
    @FindBy(xpath = "//button[text()='Right Click Me']")
    WebElement buttonRightClickMe;
    @FindBy(xpath = "//button[text()='Double Click Me']")
    WebElement buttonDoubleClickMe;

    @FindBy(css = "p[id='dynamicClickMessage']")
    WebElement dynamicClickMessage;
    @FindBy(css = "p[id='rightClickMessage']")
    WebElement rightClickMessage;
    @FindBy(css = "p[id='doubleClickMessage']")
    WebElement doubleClickMessage;

    @FindBy(tagName = "body")
    WebElement body;

    public ButtonsPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    @Step("7-Нажать на \"Buttons\"")
    public void clickOnButtons() {
        Allure.step("7-Нажать на \"Buttons\"");
        buttonsButton.click();
    }

    @Step("8-Нажать на кнопку \"Click me\"")
    public void clickOnClickMe() {
        Allure.step("8-Нажать на кнопку \"Click me\"");
        buttonClickMe.click();
    }

    @Step("9-Проверить, что появился текст \"You have done a dynamic click\"")
    public void dynamicClickCheck() {
        Allure.step("9-Проверить, что появился текст \"You have done a dynamic click\"");
        try {
            Assert.assertEquals(dynamicClickMessage.getText(), "You have done a dynamic click");
        } catch (AssertionError e) {
            String errorMessage = "Assert failed: " + e.getMessage();
            Allure.addAttachment("Assert failed", errorMessage);
            System.out.println(errorMessage);
        }
    }

    @Step("10-Нажать на кнопку \"Right click me\"")
    public void clickOnRightClickMe() {
        Allure.step("10-Нажать на кнопку \"Right click me\"");
        actions.contextClick(buttonRightClickMe).perform();
    }

    @Step("11-Проверить, что появился текст \"You have done a right click\"")
    public void rightClickCheck() {
        Allure.step("11-Проверить, что появился текст \"You have done a right click\"");
        try {
            Assert.assertEquals(rightClickMessage.getText(), "You have done a right click");
        } catch (AssertionError e) {
            String errorMessage = "Assert failed: " + e.getMessage();
            Allure.addAttachment("Assert failed", errorMessage);
            System.out.println(errorMessage);
        }
    }

    @Step("12-Нажать на кнопку \"Double Click me\"")
    public void clickOnDoubleClickMe() {
        Allure.step("12-Нажать на кнопку \"Double Click me\"");
        actions.doubleClick(buttonDoubleClickMe).perform();
    }

    @Step("13-Проверить, что появился текст \"You have done a double click\"")
    public void doubleClickCheck() {
        Allure.step("13-Проверить, что появился текст \"You have done a double click\"");
        try {
            Assert.assertEquals(doubleClickMessage.getText(), "You have done a double click");
        } catch (AssertionError e) {
            String errorMessage = "Assert failed: " + e.getMessage();
            Allure.addAttachment("Assert failed", errorMessage);
            System.out.println(errorMessage);
        }
    }

    @Step("14-Нажать на \"Alerts, Frame & Window\"")
    public void moveToAlertsFrameAndWindow() throws InterruptedException {
        Allure.step("14-Нажать на \"Alerts, Frame & Window\"");
        body.sendKeys(Keys.PAGE_DOWN);
        WebElement alertsFrameWindowBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Alerts, Frame & Windows']")));
        Thread.sleep(1000);
        alertsFrameWindowBox.click();
    }


}
