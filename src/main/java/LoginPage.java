import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    WebDriver driver;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "pass")
    WebElement passwordInput;

    @FindBy(id = "loginbutton")
    WebElement loginButton;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public HomePage login(String email, String password) {
        emailInput.clear();
        emailInput.sendKeys(email);

        passwordInput.clear();
        passwordInput.sendKeys(password);

        loginButton.click();
        return new HomePage(driver);
    }
}
