import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {

    ChromeDriver driver;

    public ConfirmationPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "result")
    private WebElement confirmationResult;

    @FindBy(className = "ico-logout")
    private WebElement logoutLink;

    public String getConfirmationResult() {
        return confirmationResult.getText();
    }

    public void clickOnLogoutLink() {
        logoutLink.click();
    }
}
