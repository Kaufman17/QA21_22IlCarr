package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.TestBase;

import static org.testng.Assert.*;


public class LoginTests extends TestBase {
    @BeforeMethod
    public void preConditions() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();

            logger.info("Before method finish logout");
        }

    }

    @Test
    public void loginSuccess1() {
        logger.info("Start test with name `loginSuccess`");
        logger.info("Test data ---> email: 'chara@gmail.com' & password: 'Chara12345$' ");

        User user = new User().setEmail("chara@gmail.com").setPassword("Chara12345$");
//        User user1 = new User();
//        user1.setEmail();
//        user.setEmail("chara@gmail.com");
//        user.setPassword("Chara12345$");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        //Assert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        //app.getHelperUser().clickOKButton();

        logger.info("Assert check is Element message 'Logged in success' present");


    }

    @Test
    public void loginSuccess() {
        logger.info("Test data ---> email: 'chara@gmail.com' & password: 'Chara12345$' ");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("chara@gmail.com", "Chara12345$");
        app.getHelperUser().submit();
        //Assert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        //app.getHelperUser().clickOKButton();

        logger.info("Assert check is Element message 'Logged in success' present");
    }

    @Test
    public void loginSuccessModel() {
        logger.info("Test data ---> email: 'chara@gmail.com' & password: 'Chara12345$' ");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("chara@gmail.com", "Chara12345$");
        app.getHelperUser().submit();
        //Assert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");

        logger.info("Assert check is Element message 'Logged in success' present");
        //app.getHelperUser().clickOKButton();

    }

    @Test
    public void loginWrongEmail() {
        logger.info("Test data ---> email: 'margagmail.com' & password: 'Mmar123456$' ");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("margagmail.com", "Mmar123456$");
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");
        logger.info("Assert check is Element ErrorText 'It'snot look like email");

        assertTrue(app.getHelperUser().isYallaButtonNotActive());
        logger.info("Assert check is Element button 'Yalla' present");
    }

    @Test
    public void loginWrongPassword() {
        logger.info("Test data ---> email: 'marga@gmail.com' & password: 'Mmar123' ");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("marga@gmail.com", "Mmar123");
        app.getHelperUser().submit();
        app.getHelperUser().getScreen("src/test/screenshots/screen.png");

        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        logger.info("Assert check is Element message 'Login or Password incorrect");
    }


    @Test
    public void loginWrongUnregisteredUser() {
        logger.info("Test data ---> email: 'luck@gmail.com' & password: 'Luck123456$' ");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("luck@gmail.com", "Luck123456$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");

        logger.info("Assert check is Element message 'Login or Password incorrect");
    }

    @AfterMethod
    public void postConditions() {
        app.getHelperUser().clickOKButton();
    }
}