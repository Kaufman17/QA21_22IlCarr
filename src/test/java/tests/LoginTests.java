package tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

  @BeforeMethod
 public void preConditions(){
      if(app.getHelperUser().isLogged()){
          app.getHelperUser().logout();
      }
 }
    @Test
    public void loginSuccess() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("chara@gmail.com", "Chara12345$");
        app.getHelperUser().submitLogin();
        //  Assert is element with text "Logged in success" is present
        //    Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        //app.getHelperUser().clickOKButton();
    }

    @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("chara@gmail.com", "Chara12345$");
        app.getHelperUser().submitLogin();
        //  Assert is element with text "Logged in success" is present
        //    Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        // app.getHelperUser().clickOKButton();
    }

    @AfterMethod
    public void postConditions() {
        app.getHelperUser().clickOKButton();

    }
}


