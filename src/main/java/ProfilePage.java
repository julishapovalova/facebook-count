import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {

    @FindBy(css = "[data-tab-key=friends]")
    WebElement friendsTab;

    FriendsFrame friends;
    WebDriverWait wait;
    WebDriver driver;

    public ProfilePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public FriendsFrame getFriends() {
        wait.until(ExpectedConditions.visibilityOf(friendsTab));
        friendsTab.click();
        friends = new FriendsFrame(driver);
        return friends;
    }
}
