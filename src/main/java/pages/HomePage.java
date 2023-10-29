package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private final WebDriver driver;

    @FindBy(xpath = "//div[@class='card mt-4 top-card' and .//h5[text()='Elements']]")
    private WebElement elementsBox;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("1-Перейти на https://demoqa.com/")
    public void enterToSite(){
        Allure.step("1-Перейти на https://demoqa.com/");
        driver.get("https://demoqa.com/");
    }

    @Step("2-Нажать на 'Elements'")
    public void clickOnElementsBox(){
        Allure.step("2-Нажать на \"Elements\"");
        elementsBox.click();
    }


}
