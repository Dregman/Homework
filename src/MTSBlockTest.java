import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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

        @Test
        public void testBlockTitle() {
            mtsPage.getBlockTitleText();
        }

        @Test
        public void testPaymentSystemLogos() {
            mtsPage.verifyPaymentSystemLogos();
        }

        @Test
        public void TestClickLearnMoreLink() {
            mtsPage.clickLearnMoreLink();
           mtsPage.goToHomePage();
        }

        @Test
        public void testfillForm() {
            mtsPage.fillForm("297777777", "11");
        }


        @Test
        public void testVerifyPopup() {
            mtsPage.verifyPopup();


        }

    @Test
    public void testPlaceholderOnWindow() {

        mtsPage.placeholderOnWindow("Услуги связи"); // Передаем ожидаемый тип платежа
    }

        @Test
        public void testVerifyPaymentSystemLogosOnWindow() {

            // Проверка, что логотипы платежных систем отображаются
            mtsPage.verifyPaymentSystemLogosOnWindow();
        }

    @Test
    public void testPlaceholdersForServices() {
        // Проверка плейсхолдеров для типа "Услуги связи"
        mtsPage.checkPlaceholdersForPaymentType("Услуги связи");

        // Проверка плейсхолдеров для типа "Домашний интернет"
        mtsPage.checkPlaceholdersForPaymentType("Домашний интернет");

        // Проверка плейсхолдеров для типа "Рассрочка"
        mtsPage.checkPlaceholdersForPaymentType("Рассрочка");

        // Проверка плейсхолдеров для типа "Задолженность"
        mtsPage.checkPlaceholdersForPaymentType("Задолженность");
    }
    }


