import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class MTSPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Локаторы
    private By visaLogoLocator = By.xpath("//img[@alt='Visa']");
    private By mastercardLogoLocator = By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners > ul > li:nth-child(3) > img");
    private By belkartLogoLocator = By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners > ul > li:nth-child(5) > img");
    private By verifiedByVisaLocator = By.xpath("//img[@alt='Verified By Visa']");
    private By masterCardSecureCodeLocator = By.xpath("//img[@alt='MasterCard Secure Code']");
    private By cookieButtonLocator = By.cssSelector("#cookie-agree");
    private By blockTitleLocator = By.xpath("//h2[text()='Онлайн пополнение ']");
    private By learnMoreLinkLocator = By.xpath("//a[contains(text(),'Подробнее о сервисе')]");
    private By phoneNumberFieldLocator = By.cssSelector("#connection-phone");
    private By priceFieldLocator = By.cssSelector("#connection-sum");
    private By continueButtonLocator = By.cssSelector("#pay-connection > button");
    private By paymentTypeDropdownLocator = By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__form > div.select > div.select__wrapper > button");
    private By locators1ForCommunicationServices = By.id("connection-phone");  // Замените на реальный локатор поля 1
    private By locators2ForCommunicationServices = By.id("connection-sum");  // Замените на реальный локатор поля 2
    private By locators3ForCommunicationServices = By.id("connection-email");
    private By locators1ForHomeInternet = By.id("internet-phone");
    private By locators2ForHomeInternet = By.id("internet-sum");
    private By locators3ForHomeInternet = By.id("internet-email");
    private By locators1ForInstalment = By.id("score-instalment");
    private By locators2ForInstalment = By.id("instalment-sum");
    private By locators3ForInstalment = By.id("instalment-email");
    private By locators1ForArrears = By.id("score-arrears");
    private By locators2ForArrears = By.id("arrears-sum");
    private By locators3ForArrears = By.id("arrears-email");
    private By locatorOnWindow1 = By.xpath("//label[text()='Номер карты']");
    private By locatorOnWindow2 = By.xpath("//label[text()='Срок действия']");
    private By locatorOnWindow3 = By.xpath("//label[text()='CVC']");
    private By locatorOnWindow4 = By.xpath("//label[text()='Имя держателя (как на карте)']");
    private By visaLogoLocatorOnNextPage = By.xpath("//img[@src='assets/images/payment-icons/card-types/visa-system.svg']");
    private By mastercardLogoLocatorOnNextPage = By.xpath("//img[@src='assets/images/payment-icons/card-types/mastercard-system.svg']");
    private By starLocatorOnNextPage = By.xpath("//img[@src='assets/images/payment-icons/card-types/belkart-system.svg']");
    private By mirLocatorOnNextPage = By.xpath("//img[@src='assets/images/payment-icons/card-types/maestro-system.svg']");
    private By popupTextLocator = By.cssSelector("iframe.bepaid-iframe");


    public MTSPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    //Метод для проверки логотипов на основной странице
    public void verifyPaymentSystemLogos() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(visaLogoLocator));
        Assert.assertTrue(driver.findElement(visaLogoLocator).isDisplayed(), "Логотип Visa не отображается");

        wait.until(ExpectedConditions.visibilityOfElementLocated(mastercardLogoLocator));
        Assert.assertTrue(driver.findElement(mastercardLogoLocator).isDisplayed(), "Логотип MasterCard не отображается");

        wait.until(ExpectedConditions.visibilityOfElementLocated(belkartLogoLocator));
        Assert.assertTrue(driver.findElement(belkartLogoLocator).isDisplayed(), "Логотип Белкарт не отображается");

        wait.until(ExpectedConditions.visibilityOfElementLocated(verifiedByVisaLocator));
        Assert.assertTrue(driver.findElement(verifiedByVisaLocator).isDisplayed(), "Логотип Verified By Visa не отображается");

        wait.until(ExpectedConditions.visibilityOfElementLocated(masterCardSecureCodeLocator));
        Assert.assertTrue(driver.findElement(masterCardSecureCodeLocator).isDisplayed(), "Логотип MasterCard Secure Code не отображается");
    }

    // Принимаем куки
    public void acceptCookies() {
        WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(cookieButtonLocator));
        cookieButton.click();
    }

    // Проверка блока
    public String getBlockTitleText() {
        WebElement blockTitle = driver.findElement(blockTitleLocator);
        String blockTitleText = blockTitle.getText(); // Получаем текст заголовка
        Assert.assertEquals(blockTitleText, "Онлайн пополнение\nбез комиссии", "Текст внутри блока не содержит ожидаемую строку");
        return blockTitleText; // Возвращаем текст после проверки
    }

    public void goToHomePage() {
        driver.navigate().back();
    }

    public void clickLearnMoreLink() {
        WebElement learnMoreLink = wait.until(ExpectedConditions.elementToBeClickable(learnMoreLinkLocator));
        learnMoreLink.click();
    }

    public void fillForm(String phoneNumber, String price) {
        WebElement phoneNumberField = driver.findElement(phoneNumberFieldLocator);
        phoneNumberField.sendKeys(phoneNumber);

        WebElement priceField = driver.findElement(priceFieldLocator);
        priceField.sendKeys(price);
        WebElement continueButton = driver.findElement(continueButtonLocator);
        continueButton.click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(popupTextLocator));


     WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("svg-icon.header__close-icon")));
     closeButton.click();
        driver.switchTo().defaultContent();
        phoneNumberField.clear();
        priceField.clear();
    }


    public void selectPaymentType(String paymentType) {
        WebElement dropdown = driver.findElement(paymentTypeDropdownLocator);
        dropdown.click();
        WebElement option = dropdown.findElement(By.xpath("//option[text()='" + paymentType + "']"));
        option.click();
    }

    // Далее описаны методы для получения текста с плейсхолдеров
    public String getField1Placeholder() {
        WebElement field1 = driver.findElement(locators1ForCommunicationServices);
        return field1.getAttribute("placeholder");
    }

    public String getField2Placeholder() {
        WebElement field2 = driver.findElement(locators2ForCommunicationServices);
        return field2.getAttribute("placeholder");
    }

    public String getField3Placeholder() {
        WebElement field3 = driver.findElement(locators3ForCommunicationServices);
        return field3.getAttribute("placeholder");
    }

    public String getField4Placeholder() {
        WebElement field4 = driver.findElement(locators1ForHomeInternet);
        return field4.getAttribute("placeholder");
    }

    public String getField5Placeholder() {
        WebElement field5 = driver.findElement(locators2ForHomeInternet);
        return field5.getAttribute("placeholder");
    }

    public String getField6Placeholder() {
        WebElement field6 = driver.findElement(locators3ForHomeInternet);
        return field6.getAttribute("placeholder");
    }

    public String getField7Placeholder() {
        WebElement field7 = driver.findElement(locators1ForInstalment);
        return field7.getAttribute("placeholder");
    }

    public String getField8Placeholder() {
        WebElement field8 = driver.findElement(locators2ForInstalment);
        return field8.getAttribute("placeholder");
    }

    public String getField9Placeholder() {
        WebElement field9 = driver.findElement(locators3ForInstalment);
        return field9.getAttribute("placeholder");
    }

    public String getField10Placeholder() {
        WebElement field10 = driver.findElement(locators1ForArrears);
        return field10.getAttribute("placeholder");
    }

    public String getField11Placeholder() {
        WebElement field11 = driver.findElement(locators2ForArrears);
        return field11.getAttribute("placeholder");
    }

    public String getField12Placeholder() {
        WebElement field12 = driver.findElement(locators3ForArrears);
        return field12.getAttribute("placeholder");
    }


    // Проверка плейсхолдеров для каждого типа оплаты
    public void checkPlaceholdersForPaymentType(String paymentservice) {
        // Выбираем тип оплаты
        selectPaymentType(paymentservice);


        String placeholder1 = getField1Placeholder();
        String placeholder2 = getField2Placeholder();
        String placeholder3 = getField3Placeholder();
        String placeholder4 = getField4Placeholder();
        String placeholder5 = getField5Placeholder();
        String placeholder6 = getField6Placeholder();
        String placeholder7 = getField7Placeholder();
        String placeholder8 = getField8Placeholder();
        String placeholder9 = getField9Placeholder();
        String placeholder10 = getField10Placeholder();
        String placeholder11 = getField11Placeholder();
        String placeholder12 = getField12Placeholder();

        // Проверяем плейсхолдеры в зависимости от типа оплаты
        switch (paymentservice) {
            case "Услуги связи":
                Assert.assertEquals(placeholder1, "Номер телефона", "Неправильный плейсхолдер для поля 1 (Услуги связи)");
                Assert.assertEquals(placeholder2, "Сумма", "Неправильный плейсхолдер для поля 2 (Услуги связи)");
                Assert.assertEquals(placeholder3, "E-mail для отправки чека", "Неправильный плейсхолдер для поля 3 (Услуги связи)");
                break;

            case "Домашний интернет":
                Assert.assertEquals(placeholder4, "Номер абонента", "Неправильный плейсхолдер для поля 1 (Домашний интернет)");
                Assert.assertEquals(placeholder5, "Сумма", "Неправильный плейсхолдер для поля 2 (Домашний интернет)");
                Assert.assertEquals(placeholder6, "E-mail для отправки чека", "Неправильный плейсхолдер для поля 3 (Домашний интернет)");
                break;

            case "Рассрочка":
                Assert.assertEquals(placeholder7, "Номер счета на 44", "Неправильный плейсхолдер для поля 1 (Рассрочка)");
                Assert.assertEquals(placeholder8, "Сумма", "Неправильный плейсхолдер для поля 2 (Рассрочка)");
                Assert.assertEquals(placeholder9, "E-mail для отправки чека", "Неправильный плейсхолдер для поля 3 (Рассрочка)");
                break;

            case "Задолженность":
                Assert.assertEquals(placeholder10, "Номер счета на 2073", "Неправильный плейсхолдер для поля 1 (Задолженность)");
                Assert.assertEquals(placeholder11, "Сумма", "Неправильный плейсхолдер для поля 2 (Задолженность)");
                Assert.assertEquals(placeholder12, "E-mail для отправки чека", "Неправильный плейсхолдер для поля 3 (Задолженность)");
                break;

        }
    }

    // Методы для плейсхолдеров после нажатия клавиши продолжить, в сплывающем окне
    public String getField01Placeholder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locatorOnWindow1));
        WebElement field01 = driver.findElement(locatorOnWindow1);
        return field01.getText();

    }

    public String getField02Placeholder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locatorOnWindow2));
        WebElement field02 = driver.findElement(locatorOnWindow2);
        return field02.getText();
    }

    public String getField03Placeholder() {
        WebElement field03 = driver.findElement(locatorOnWindow3);
        return field03.getText();
    }

    public String getField04Placeholder() {
        WebElement field04 = driver.findElement(locatorOnWindow4);
        return field04.getText();
    }

    // Проверки отображения введенной суммы и номера телефона после того как заполнили данные в услуге связи и нажали продолжить
    public void verifyPopup() {
        WebElement phoneField = driver.findElement(phoneNumberFieldLocator);
        WebElement amountField = driver.findElement(priceFieldLocator);
        WebElement continueButton = driver.findElement(continueButtonLocator);

        phoneField.sendKeys("297777777");

        amountField.sendKeys("11");
        continueButton.click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(popupTextLocator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='11.00 BYN']")));
        WebElement summ11 = driver.findElement(By.xpath("//span[text()='11.00 BYN']"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]/span")));
        WebElement numberPhone = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]/span"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Оплатить') and contains(text(), '11.00 BYN')]")));
        WebElement payButton = driver.findElement(By.xpath("//button[contains(text(), 'Оплатить') and contains(text(), '11.00 BYN')]"));

        Assert.assertTrue(summ11.getText().contains("11.00"), "Сумма отображается неверно");
        Assert.assertTrue(numberPhone.getText().contains("375297777777"), "Номер телефона отображается неверно");
        Assert.assertTrue(payButton.getText().contains("11"), "Сумма отображается неверно");

        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("svg-icon.header__close-icon")));
        closeButton.click();
        driver.switchTo().defaultContent();
        phoneField.clear();
        amountField.clear();
    }

    //Метод проверки плейсхолдеров в полях ввода карты, после того как заполнили данные в услуге связи и нажали продолжить
    public void placeholderOnWindow(String placeholderInWindow) {
        WebElement phoneField = driver.findElement(phoneNumberFieldLocator);
        WebElement amountField = driver.findElement(priceFieldLocator);
        WebElement continueButton = driver.findElement(continueButtonLocator);

        phoneField.sendKeys("297777777");
        amountField.sendKeys("11");
        continueButton.click();


        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(popupTextLocator));


        String placeholder01 = getField01Placeholder();
        String placeholder02 = getField02Placeholder();
        String placeholder03 = getField03Placeholder();
        String placeholder04 = getField04Placeholder();


        switch (placeholderInWindow) {
            case "Услуги связи":
                Assert.assertEquals(placeholder01, "Номер карты", "Неправильный плейсхолдер для поля Номер карты");
                Assert.assertEquals(placeholder02, "Срок действия", "Неправильный плейсхолдер для поля Срок действия");
                Assert.assertEquals(placeholder03, "CVC", "Неправильный плейсхолдер для поля CVC");
                Assert.assertEquals(placeholder04, "Имя держателя (как на карте)", "Неправильный плейсхолдер для поля Имя держателя");
                break;
        }

        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("svg-icon.header__close-icon")));
        closeButton.click();
        driver.switchTo().defaultContent();
        phoneField.clear();
        amountField.clear();

    }

//в сплывающем окне проверяем наличие иконок платежных систем
    public void verifyPaymentSystemLogosOnWindow() {

        WebElement phoneField = driver.findElement(phoneNumberFieldLocator);
        WebElement amountField = driver.findElement(priceFieldLocator);
        WebElement continueButton = driver.findElement(continueButtonLocator);

        phoneField.sendKeys("297777777");
        amountField.sendKeys("11");
        continueButton.click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(popupTextLocator));

        wait.until(ExpectedConditions.visibilityOfElementLocated(visaLogoLocatorOnNextPage));
        Assert.assertTrue(driver.findElement(visaLogoLocatorOnNextPage).isDisplayed(), "Логотип Visa не отображается");

        wait.until(ExpectedConditions.visibilityOfElementLocated(mastercardLogoLocatorOnNextPage));
        Assert.assertTrue(driver.findElement(mastercardLogoLocatorOnNextPage).isDisplayed(), "Логотип MasterCard не отображается");

        wait.until(ExpectedConditions.visibilityOfElementLocated(starLocatorOnNextPage));
        Assert.assertTrue(driver.findElement(starLocatorOnNextPage).isDisplayed(), "Логотип Звезда не отображается");

        wait.until(ExpectedConditions.visibilityOfElementLocated(mirLocatorOnNextPage));
        Assert.assertTrue(driver.findElement(mirLocatorOnNextPage).isDisplayed(), "Логотип Мир не отображается");

        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("svg-icon.header__close-icon")));
        closeButton.click();
        driver.switchTo().defaultContent();
        phoneField.clear();
        amountField.clear();
    }
}



