import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    ChromeDriver driver;

    public RegistrationPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "gender-male")
    private WebElement genderMale;

    @FindBy(id = "FirstName")
    private WebElement firstName;

    @FindBy(id = "LastName")
    private WebElement lastName;

    @FindBy(id = "Email")
    private WebElement email;

    @FindBy(id = "Password")
    private WebElement password;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPassword;

    @FindBy(id = "register-button")
    private WebElement registerButton;

    @FindBy(className = "field-validation-error")
    private WebElement fieldValidationError;

    @FindBy(className = "ico-login")
    private WebElement loginPageLink;


        public void registrate(User user) {
            chooseGenderMale();
            enterFirstName(user.getFirstName());
            enterLastName(user.getLastName());
            enterEmail(user.getEmail());
            enterPassword(user.getPassword());
            enterConfirmPassword(user.getConfirmPassword());
            clickRegisterButton();
        }



    public void chooseGenderMale() {
       genderMale.click();
    }

    public void enterFirstName(String firstNameValue) {
        firstName.sendKeys(firstNameValue);
    }

    public void enterLastName(String lastNameValue) {
        lastName.sendKeys(lastNameValue);
    }

    public void enterEmail(String emailValue) {
        email.sendKeys(emailValue);
    }

    public void enterPassword(String passwordValue) {
        password.sendKeys(passwordValue);
    }

    public void enterConfirmPassword(String confirmPasswordValue) {
        confirmPassword.sendKeys(confirmPasswordValue);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public String getError() {
        return fieldValidationError.getText();
    }

    public void clickOnLogin() {
        loginPageLink.click();
    }
}
