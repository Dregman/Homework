import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;



public class MTSBlockTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Java\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mts.by");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cookie-agree")));
        cookieButton.click();
    }


    @Test
    public void testBlockTitle() {
        WebElement blockTitle = driver.findElement(By.xpath("//h2[text()='Онлайн пополнение ']"));
        Assert.assertTrue(blockTitle.getText().contains("Онлайн пополнение"), "Текст внутри блока не содержит ожидаемую строку");
    }

    @Test
    public void testPaymentSystemLogos() {
        WebElement visaLogo = driver.findElement(By.xpath("//img[@alt='Visa']"));
        WebElement mastercardLogo = driver.findElement(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners > ul > li:nth-child(3) > img"));
        WebElement belkartLogo = driver.findElement(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners > ul > li:nth-child(5) > img"));
        WebElement verifiedByVisa = driver.findElement(By.xpath("//img[@alt='Verified By Visa']"));
        WebElement masterCardSecureCode = driver.findElement(By.xpath("//img[@alt='MasterCard Secure Code']"));

        Assert.assertTrue(visaLogo.isDisplayed(), "Логотип Visa не отображается");
        Assert.assertTrue(mastercardLogo.isDisplayed(), "Логотип MasterCard не отображается");
        Assert.assertTrue(belkartLogo.isDisplayed(), "Логотип Белкарт не отображается");
        Assert.assertTrue(verifiedByVisa.isDisplayed(), "Логотип Verified By Visa не отображается");
        Assert.assertTrue(masterCardSecureCode.isDisplayed(), "Логотип Master Card Secure Code не отображается");
    }

    @Test
    public void testLearnMoreLink() {

        WebElement learnMoreLink = driver.findElement(By.xpath("//a[contains(text(),'Подробнее о сервисе')]"));
        Assert.assertTrue(learnMoreLink.isDisplayed(), "Ссылка 'Подробнее о сервисе' не отображается");

        learnMoreLink.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("poryadok-oplaty-i-bezopasnost-internet-platezhey"), "Ссылка не ведет на нужную страницу");
    }

    @Test
    public void testFormSubmission() {

        WebElement phoneNumberField = driver.findElement(By.cssSelector("#connection-phone"));
        phoneNumberField.sendKeys("297777777");

        WebElement price = driver.findElement(By.cssSelector("#connection-sum"));
        price.sendKeys("11");


        WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection > button"));
        continueButton.click();



    }

}
