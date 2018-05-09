import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest {
    WebDriver driver;
    final String EMAIL = "??????";
    final String PASSWORD = "???????????";
    final String URL = "https://www.facebook.com/";

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        if (driver == null) {
            driver = new ChromeDriver(options);
        }
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test
    public void test1() {
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = loginPage.login(EMAIL, PASSWORD).openProfile();
        FriendsFrame friendsFrame = profilePage.getFriends();
        friendsFrame.getCount();
        System.out.println(friendsFrame.getCount());
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
