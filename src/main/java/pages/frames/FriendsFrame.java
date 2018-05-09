package pages.frames;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FriendsFrame {

    @FindBys(
            {@FindBy(css = "._698")}
    )
    private
    List<WebElement> friends;

    private Actions actions;
    private WebDriverWait wait;

    public FriendsFrame(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
        actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfAllElements(friends));
    }

    public int getCount() {

        int tempCountOfFriends = friends.size();
        scrollTo(friends.get(friends.size() - 1));
        while (true) {
            scrollTo(friends.get(friends.size() - 1));
            if (tempCountOfFriends == friends.size()) {
                break;
            }
            tempCountOfFriends = friends.size();
        }
        return friends.size();
    }

    public void scrollTo(WebElement elementOfList) {
        actions.moveToElement(elementOfList).perform();
        wait.until(ExpectedConditions.visibilityOfAllElements(friends));
    }
}
