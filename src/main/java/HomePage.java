import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = "._2s25._606w")
    WebElement profile;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(profile));
    }

    public ProfilePage openProfile() {
        profile.click();
        return new ProfilePage(driver);
    }
}
