import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest{
    @Test
    public void successRegistration() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.chooseGenderMale();

        registrationPage.enterFirstName("Farinuta");
        registrationPage.enterLastName("Fill");
        String uniqueEmail = "user_" + UUID.randomUUID() + "@example.com";
        registrationPage.enterEmail(uniqueEmail);
        registrationPage.enterPassword("Fa1234");
        registrationPage.enterConfirmPassword("Fa1234");

        registrationPage.clickRegisterButton();

        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        confirmationPage.getConfirmationResult();

        assertEquals("Your registration completed", confirmationPage.getConfirmationResult());

    }

    @Test
    public void registrationWithoutFirstname() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.chooseGenderMale();

        registrationPage.enterLastName("Fill");
        String uniqueEmail = "user_" + UUID.randomUUID() + "@example.com";
        registrationPage.enterEmail(uniqueEmail);
        registrationPage.enterPassword("Fa1234");
        registrationPage.enterConfirmPassword("Fa1234");

        registrationPage.clickRegisterButton();


        assertEquals("First name is required.", registrationPage.getError());

    }

    @Test
    public void registrationWithoutLastname() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.chooseGenderMale();

        registrationPage.enterFirstName("Farinuta");
        String uniqueEmail = "user_" + UUID.randomUUID() + "@example.com";
        registrationPage.enterEmail(uniqueEmail);
        registrationPage.enterPassword("Fa1234");
        registrationPage.enterConfirmPassword("Fa1234");

        registrationPage.clickRegisterButton();


        assertEquals("Last name is required.", registrationPage.getError());

    }

    @Test
    public void registrationWithoutEmail() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.chooseGenderMale();

        registrationPage.enterFirstName("Farinuta");
        registrationPage.enterLastName("Fill");

        registrationPage.enterPassword("Fa1234");
        registrationPage.enterConfirmPassword("Fa1234");

        registrationPage.clickRegisterButton();


        assertEquals("Email is required.", registrationPage.getError());

    }
}
