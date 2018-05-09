import driver.PropetyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    WebDriver driver;
    protected final String EMAIL = PropetyReader.getProperty("EMAIL");
    protected final String PASSWORD = PropetyReader.getProperty("PASSWORD");
    protected final String URL = PropetyReader.getProperty("URL");

    @BeforeSuite(alwaysRun = true)
    public void setUpSuite() {

    }

    @BeforeTest(alwaysRun = true)
    public void setUpTest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        if (driver == null) {
            driver = new ChromeDriver(options);
        }
        driver.manage().window().maximize();
        driver.get(URL);

    }

    @AfterTest(alwaysRun = true)
    public void tearDownTest() {
        if (driver != null) {
            driver.quit();
        }

    }
}
