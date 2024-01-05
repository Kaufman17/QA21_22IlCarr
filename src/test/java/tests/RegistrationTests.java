package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertTrue;

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

//   @Test
//   public void registrationWrongEmail() {
//      User user = new User()
//          .withFirstName("John")
//          .withLastName("Doe")
//          .setEmail("invalid_email")
//           .setPassword("Password123$");
//     app.getHelperUser().openRegistrationForm();
//     app.getHelperUser().fillRegistrationForm(user);
//    app.getHelperUser().checkPolicyXY();
//     app.getHelperUser().submit();
//    Assert.assertEquals(app.getHelperUser().getErrorText(), "Wrong email format\n" +
//             "Wrong email format");
//     Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
//}

// @Test
//public void registrationWrongPassword() {
//    User user = new User()
//            .withFirstName("Alice")
//            .withLastName("Johnson")
//             .setEmail("alice@mail.com")
//             .setPassword("weak");

//     app.getHelperUser().openRegistrationForm();
//     app.getHelperUser().fillRegistrationForm(user);
//     app.getHelperUser().checkPolicyXY();
//     app.getHelperUser().submit();
//    Assert.assertEquals(app.getHelperUser().getErrorText(), "Password must contain minimum 8 symbols\n" +
//            "Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]");
//     Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
//}


// @Test
//public void registrationDuplicateEmail() {
//     String existingEmail = "user_with_duplicate_email@example.com";
//    User duplicateUser = new User()
//             .withFirstName("Duplicate")
//             .withLastName("User")
//             .setEmail(existingEmail)
//             .setPassword("Duplicate123$");
//
//        app.getHelperUser().openRegistrationForm();
//        app.getHelperUser().fillRegistrationForm(duplicateUser);
//        app.getHelperUser().checkPolicyXY();
//        app.getHelperUser().submit();
//
//        Assert.assertEquals(app.getHelperUser().getMessage(), "\"User already exists\"");
//       // Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
//    }

//
//    @AfterMethod
//    public void postConditions() {
//        app.getHelperUser().clickOKButton();
//        app.stop();
//        app.init();
//
//    }
//-------------Cw---------
@Test
public void registrationEmptyName(){
    User user = new User()
            .withFirstName("")
            .withLastName("Simpson")
            .setEmail("simpson@gmail.com")
            .setPassword("Simp123456$");
    app.getHelperUser().openRegistrationForm();
    app.getHelperUser().fillRegistrationForm(user);
    app.getHelperUser().checkPolicyXY();
    app.getHelperUser().submit();
    Assert.assertEquals(app.getHelperUser().getErrorText(), "Name is required");
    Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

}

    @Test
    public void registrationEmptyLastName(){
        User user = new User()
                .withFirstName("Gomer")
                .withLastName("")
                .setEmail("simpson@gmail.com")
                .setPassword("Simp123456$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Last name is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }

    @Test
    public void registrationWrongEmail(){
        User user = new User()
                .withFirstName("Gomer")
                .withLastName("Simpson")
                .setEmail("simpsongmail.com")
                .setPassword("Simp123456$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().getErrorText().contains("Wrong email format"));
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }

    @Test
    public void registrationWrongPassword(){
        User user = new User()
                .withFirstName("Gomer")
                .withLastName("Simpson")
                .setEmail("simpson@gmail.com")
                .setPassword("Simp123");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Password must contain minimum 8 symbols\n" +
                "Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }

    @AfterMethod
    public void postConditions() {
        app.getHelperUser().clickOKButton();
    }

}
