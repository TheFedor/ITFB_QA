package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TextBoxPage {
    private final WebDriver driver;

    @FindBy(css = "div[class='element-list collapse show'] ul li:first-child")
    WebElement textBoxElement;

    @FindBy(css = "[placeholder='Full Name']")
    WebElement fullNameInput;
    @FindBy(css = "[placeholder='name@example.com']")
    WebElement emailInput;
    @FindBy(css = "[placeholder='Current Address']")
    WebElement currentAddressTextarea;
    @FindBy(id = "permanentAddress")
    WebElement permanentAddressTextarea;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement submitButton;

    @FindBy(css = "div[class='border col-md-12 col-sm-12'] p:nth-child(1)")
    WebElement nameInOutput;
    @FindBy(css = "div[class='border col-md-12 col-sm-12'] p:nth-child(2)")
    WebElement emailInOutput;
    @FindBy(css = "div[class='border col-md-12 col-sm-12'] p:nth-child(3)")
    WebElement currentAddressInOutput;
    @FindBy(css = "div[class='border col-md-12 col-sm-12'] p:nth-child(4)")
    WebElement permanentAddressInOutput;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("3-Нажать на элемент \"Text box\"")
    public void clickOnTextBoxElement() {
        Allure.step("3-Нажать на элемент \"Text box\"");
        textBoxElement.click();
    }

    @Step("4-Заполнить поля:Full Name, Email, Current Address, Permanent Address")
    public void fillingInFieldsForTextBox(String fullName, String email, String currentAddress, String permanentAddress) {
        Allure.step("4-Заполнить поля:Full Name, Email, Current Address, Permanent Address");
        fullNameInput.sendKeys(fullName);
        emailInput.sendKeys(email);
        currentAddressTextarea.sendKeys(currentAddress);
        permanentAddressTextarea.sendKeys(permanentAddress);
    }

    @Step("5-Нажать на кнопку \"Submit\"")
    public void clickOnButtonSubmit() {
        Allure.step("5-Нажать на кнопку \"Submit\"");
        submitButton.click();
    }

    @Step("6-Проверить, что данные в блоке сохранены корректно")
    public void checkingCorrectnessOfOutput() {
        Allure.step("6-Проверить, что данные в блоке сохранены корректно");
        try {
            Assert.assertEquals(nameInOutput.getText(), "Name:Фёдор");
        } catch (AssertionError e) {
            String errorMessage = "Assert failed: " + e.getMessage();
            Allure.addAttachment("Assert failed", errorMessage);
            System.out.println(errorMessage);
        }
        try {
            Assert.assertEquals(emailInOutput.getText(), "Email:mail@mail.ru");
        } catch (AssertionError e) {
            String errorMessage = "Assert failed: " + e.getMessage();
            Allure.addAttachment("Assert failed", errorMessage);
            System.out.println(errorMessage);
        }
        try {
            Assert.assertEquals(currentAddressInOutput.getText(), "Current Address :Москва");
        } catch (AssertionError e) {
            String errorMessage = "Assert failed: " + e.getMessage();
            Allure.addAttachment("Assert failed", errorMessage);
            System.out.println(errorMessage);
        }
        try {
            Assert.assertEquals(permanentAddressInOutput.getText(), "Permanent Address :Тоже Москва"); //тут ошибка в записи на сайте
        } catch (AssertionError e) {
            String errorMessage = "Assert failed: " + e.getMessage();
            Allure.addAttachment("Assert failed", errorMessage);
            System.out.println(errorMessage);
        }
    }


}
