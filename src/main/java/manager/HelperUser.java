package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void openLoginForm(){
        click(By.xpath("//a[text()=' Log in ']"));
    }
    public void fillLoginForm(String email, String password){
        type(By.id("email"),email);
        type(By.id("password"), password);
    }

    //overloading
    public void fillLoginForm(User user){
        type(By.id("email"),user.getEmail());
        type(By.id("password"), user.getPassword());
    }


    public void submitLogin(){
        wd.findElement(By.xpath("//button[@type='submit']"))
                .click();
    }


    public void clickOKButton() {
       // click(By.xpath("//button[text()='Ok']"));
        if(isElementPresent(By.xpath("//button[text()='Ok']")))
            click(By.xpath("//button[text()='Ok']"));

    }

    public boolean isLogged() {
        return
                isElementPresent(By.xpath("//*[.=' Logout ']"));
    }
    public void logout(){
        click(By.xpath("//*[.=' Logout ']"));
    }


    public String getErrorText() {
        return wd.findElement(By.cssSelector("div.error")).getText();
    }
}