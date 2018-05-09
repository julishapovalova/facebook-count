import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;
import pages.frames.FriendsFrame;

public class TestFacebook extends BaseTest {
    @Test
    public void friendsCount() {
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = loginPage.login(EMAIL, PASSWORD).openProfile();
        FriendsFrame friendsFrame = profilePage.getFriends();
        System.out.println("RESULT" + friendsFrame.getCount());
    }

}
