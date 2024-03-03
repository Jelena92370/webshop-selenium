import org.junit.Test;

import java.util.UUID;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest{
    @Test
    public void successRegistration() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        User user = new User("Farinuta", "Fill", "user_" + UUID.randomUUID() + "@example.com", "Fa1234", "Fa1234");
        registrationPage.registrate(user);

        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        confirmationPage.getConfirmationResult();

        assertEquals("Your registration completed", confirmationPage.getConfirmationResult());

    }

    @Test
    public void registrationWithoutFirstname() {
        RegistrationPage registrationPage = new RegistrationPage(driver);


        User user = new User("", "Fill", "user_" + UUID.randomUUID() + "@example.com", "Fa1234", "Fa1234");
        registrationPage.registrate(user);


        assertEquals("First name is required.", registrationPage.getError());

    }

    @Test
    public void registrationWithoutLastname() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        User user = new User("Farinuta", "", "user_" + UUID.randomUUID() + "@example.com", "Fa1234", "Fa1234");
        registrationPage.registrate(user);


        assertEquals("Last name is required.", registrationPage.getError());

    }

    @Test
    public void registrationWithInvalidEmailFormat() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        User user = new User("Farinuta", "Fill", "user_" + UUID.randomUUID() + "example.com", "Fa1234", "Fa1234");
        registrationPage.registrate(user);

        assertEquals("Wrong email", registrationPage.getError());

    }

    @Test
    public void registrationWithoutEmail() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        User user = new User("Farinuta", "Fill", "", "Fa1234", "Fa1234");
        registrationPage.registrate(user);
        assertEquals("Email is required.", registrationPage.getError());

    }

    @Test
    public void registrationWithoutPassword() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        User user = new User("Farinuta", "Fill", "user_" + UUID.randomUUID() + "@example.com", "", "Fa1234");
        registrationPage.registrate(user);
        assertEquals("Password is required.", registrationPage.getError());

    }

    @Test
    public void registrationWithoutConfirmPassword() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        User user = new User("Farinuta", "Fill", "user_" + UUID.randomUUID() + "@example.com", "Fa1234", "");
        registrationPage.registrate(user);
        assertEquals("Password is required.", registrationPage.getError());

    }

    @Test
    public void registrationWithShortPassword() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        User user = new User("Farinuta", "Fill", "user_" + UUID.randomUUID() + "@example.com", "Fa12", "Fa1234");
        registrationPage.registrate(user);
        assertEquals("The password should have at least 6 characters.", registrationPage.getError());

    }

    @Test
    public void registrationWithDifferentConfirmPassword() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        User user = new User("Farinuta", "Fill", "user_" + UUID.randomUUID() + "@example.com", "Fa1234", "Fa123456");
        registrationPage.registrate(user);

        assertEquals("The password and confirmation password do not match.", registrationPage.getError());

    }

    //@Test
    public void registrationWithVeryLongPassword() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.chooseGenderMale();

        registrationPage.enterFirstName("Farinuta");
        registrationPage.enterLastName("Fill");
        String uniqueEmail = "user_" + UUID.randomUUID() + "@example.com";
        registrationPage.enterEmail(uniqueEmail);

        registrationPage.enterPassword("ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
        registrationPage.enterConfirmPassword("ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");


        registrationPage.clickRegisterButton();

        assertEquals("Password can not contain more then 250 symbols.", registrationPage.getError());

    }

    @Test
    public void registrationIfConfirmPasswordHasDifferentCase() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        User user = new User("Farinuta", "Fill", "user_" + UUID.randomUUID() + "@example.com", "Fa1234", "FA1234");
        registrationPage.registrate(user);
        System.out.println(registrationPage.getError());
        assertEquals("The password and confirmation password do not match.", registrationPage.getError());

    }

}
