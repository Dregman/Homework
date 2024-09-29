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
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Visa']")));
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Visa']")).isDisplayed(), "Логотип Visa не отображается");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[3]/img")));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[3]/img")).isDisplayed(), "Логотип MasterCard не отображается");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[5]/img")));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[5]/img")).isDisplayed(), "Логотип Белкарт не отображается");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Verified By Visa']")));
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Verified By Visa']")).isDisplayed(), "Логотип Verified By Visa не отображается");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='MasterCard Secure Code']")));
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='MasterCard Secure Code']")).isDisplayed(), "Логотип MasterCard Secure Code не отображается");
    }

    @Test
    public void testLearnMoreLink() {

        WebElement learnMoreLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Подробнее о сервисе')]")));
        learnMoreLink.click();
        driver.navigate().back();
    }

    @Test
    public void testFormSubmission() {

        WebElement phoneNumberField = driver.findElement(By.cssSelector("#connection-phone"));
        phoneNumberField.sendKeys("297777777");

        WebElement price = driver.findElement(By.cssSelector("#connection-sum"));
        price.sendKeys("11");


        WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection > button"));
        continueButton.click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe.bepaid-iframe")));

    }

}