package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase {
    @BeforeMethod
    public void preConditions() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }

    }

    @Test
    public void registrationSuccess() {
        Random random = new Random();
        int i = random.nextInt(1000);
        User user = new User()
                .withFirstName("Lisa")
                .withLastName("Snow")
                .setEmail("snow" + i + "@mail.ru")
                .setPassword("Snow123654$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        //app.getHelperUser().checkPolicy();
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "You are logged in success");
    }

    @Test
    public void registrationWrongEmail() {
        User user = new User()
                .withFirstName("John")
                .withLastName("Doe")
                .setEmail("invalid_email")
                .setPassword("Password123$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Wrong email format\n" +
                "Wrong email format");
    }

    @Test
    public void registrationWrongPassword() {
        User user = new User()
                .withFirstName("Alice")
                .withLastName("Johnson")
                .setEmail("alice@mail.com")
                .setPassword("weak");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Password must contain minimum 8 symbols\n" +
                "Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]");
    }

    @Test
    public void registrationDuplicateEmail() {
        String existingEmail = "user_with_duplicate_email@example.com";
        User duplicateUser = new User()
                .withFirstName("Duplicate")
                .withLastName("User")
                .setEmail(existingEmail)
                .setPassword("Duplicate123$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(duplicateUser);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "\"User already exists\"");
    }


    @AfterMethod
    public void postConditions() {
        app.getHelperUser().clickOKButton();
        app.stop();
        app.init();

    }

}
