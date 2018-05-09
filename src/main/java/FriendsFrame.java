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
    List<WebElement> friends;

    @FindBy(id = "medley_header_movies")
    WebElement films;
    Actions actions;
    WebDriverWait wait;

    public FriendsFrame(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
        actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfAllElements(friends));

    }

    public int getCount() {
//        for (WebElement temFriendProfile : friends) {
//            scrollTo(temFriendProfile);
//        }
        int tempCountOfFriends;
        scrollTo(friends.get(friends.size() - 1));
        while (true) {

            scrollTo(friends.get(friends.size() - 1));
            tempCountOfFriends = friends.size();
            if (tempCountOfFriends == friends.size()) {
                break;
            }
            scrollTo(friends.get(friends.size() - 1));
        }

//            if (tempFriends != friends.size()) {
//                tempFriends = friends.size();
//            } else if (tempFriends == friends.size()) {
//                break;
//            }
//        }
        return friends.size();
    }

    public void scrollTo(WebElement element) {
        actions.moveToElement(element);
        actions.perform();
    }
}
