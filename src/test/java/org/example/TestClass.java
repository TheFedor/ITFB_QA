package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class TestClass {

    private WebDriver driver;
    private HomePage homePage;
    private TextBoxPage textBoxPage;
    private ButtonsPage buttonsPage;
    private BrowserWindowsPage browserWindowsPage;
    private AlertsPage alertsPage;

    @BeforeClass
    public void setup() {
        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        textBoxPage = new TextBoxPage(driver);
        buttonsPage = new ButtonsPage(driver);
        browserWindowsPage = new BrowserWindowsPage(driver);
        alertsPage = new AlertsPage(driver);
    }

    @AfterClass
    public void driverQuit() {
        driver.quit();
    }

    @Test
    @Description("Все тесты по шагам")
    @Story("All tests")
    public void completeTest() throws InterruptedException {
        homePage.enterToSite();
        homePage.clickOnElementsBox();

        textBoxPage.clickOnTextBoxElement();
        textBoxPage.fillingInFieldsForTextBox("Фёдор", "mail@mail.ru", "Москва", "Тоже Москва");
        textBoxPage.clickOnButtonSubmit();
        textBoxPage.checkingCorrectnessOfOutput();

        buttonsPage.clickOnButtons();
        buttonsPage.clickOnClickMe();
        buttonsPage.dynamicClickCheck();
        buttonsPage.clickOnRightClickMe();
        buttonsPage.rightClickCheck();
        buttonsPage.clickOnDoubleClickMe();
        buttonsPage.doubleClickCheck();
        buttonsPage.moveToAlertsFrameAndWindow();

        browserWindowsPage.clickOnBrowserWindows();
        browserWindowsPage.newTabButtonClick();
        browserWindowsPage.closeNewTab();
        browserWindowsPage.newWindowButtonClick();
        browserWindowsPage.closeNewWindow();

        alertsPage.clickOnAlertsBox();
        alertsPage.clickAlertButton();
        alertsPage.closeAlert();
        alertsPage.clickTimeAlertButton();
        alertsPage.closeTimeAlert();
        alertsPage.confirmButtonClick();
        alertsPage.acceptConfirmAlert();
        alertsPage.checkSelectedStatus();
        alertsPage.promtButtonClick();
        alertsPage.fillingInAlert();
        alertsPage.checkTextEnteredAfterAlert();
    }

}
