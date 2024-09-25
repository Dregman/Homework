package com.example.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class MTSBlockTest {
    private WebDriver driver;
    private MTSPage mtsPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Java\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        mtsPage = new MTSPage(driver);
        driver.get("https://mts.by");
        mtsPage.acceptCookies();
    }

    @Epic("MTS Tests")
    @Feature("Block Title Verification")
    @Story("User verifies block title")
    @Test
    @Description("Проверка заголовка блока на странице")
    @Severity(SeverityLevel.CRITICAL)
    public void testBlockTitle() {
        mtsPage.getBlockTitleText();
    }

    @Epic("MTS Tests")
    @Feature("Payment System Logos")
    @Story("User verifies payment system logos on the page")
    @Test
    @Description("Проверка наличия логотипов платежных систем")
    @Severity(SeverityLevel.MINOR)
    public void testPaymentSystemLogos() {
        mtsPage.verifyPaymentSystemLogos();
    }

    @Epic("MTS Tests")
    @Feature("Learn More Link")
    @Story("User clicks on the 'Learn More' link")
    @Test
    @Description("Тестирование клика по ссылке 'Узнать больше' и перехода на домашнюю страницу")
    @Severity(SeverityLevel.NORMAL)
    public void testClickLearnMoreLink() {
        mtsPage.clickLearnMoreLink();
        mtsPage.goToHomePage();
    }

    @Epic("MTS Tests")
    @Feature("Form Filling")
    @Story("User fills the form")
    @Test
    @Description("Заполнение формы с номером телефона и суммой")
    @Severity(SeverityLevel.NORMAL)
    public void testfillForm() {
        mtsPage.fillForm("297777777", "11");
    }


    @Epic("MTS Tests")
    @Feature("Popup Verification")
    @Story("User verifies the popup")
    @Test
    @Description("Проверка всплывающего окна на странице")
    @Severity(SeverityLevel.NORMAL)
    public void testVerifyPopup() {
        mtsPage.verifyPopup();


    }

    @Epic("MTS Tests")
    @Feature("Placeholder Verification")
    @Story("User verifies placeholder on window")
    @Test
    @Description("Проверка плейсхолдера на окне для типа платежа 'Услуги связи'")
    @Severity(SeverityLevel.MINOR)
    public void testPlaceholderOnWindow() {

        mtsPage.placeholderOnWindow("Услуги связи"); // Передаем ожидаемый тип платежа
    }

    @Epic("MTS Tests")
    @Feature("Payment System Logos")
    @Story("User verifies payment system logos on window")
    @Test
    @Description("Проверка отображения логотипов платежных систем на окне")
    @Severity(SeverityLevel.MINOR)
    public void testVerifyPaymentSystemLogosOnWindow() {

        mtsPage.verifyPaymentSystemLogosOnWindow();
    }

    @Epic("MTS Tests")
    @Feature("Placeholder Verification for Services")
    @Story("User verifies placeholders for different services")
    @Test
    @Description("Проверка плейсхолдеров для различных типов платежей")
    @Severity(SeverityLevel.NORMAL)
    public void testPlaceholdersForServices() {
        mtsPage.checkPlaceholdersForPaymentType("Услуги связи");

        mtsPage.checkPlaceholdersForPaymentType("Домашний интернет");

        mtsPage.checkPlaceholdersForPaymentType("Рассрочка");

        mtsPage.checkPlaceholdersForPaymentType("Задолженность");
    }
}


