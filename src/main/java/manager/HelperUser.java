package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm(){
        click(By.cssSelector("a.navigation-link[ng-reflect-router-link='login']"));
    }

    public void fillLoginRegistrationForm(String email, String password) {
        type(By.id("email"),email);
        type(By.cssSelector("[ng-reflect-name='password']"), password);
    }

    public void submitLogin(){
        click(By.cssSelector("button[type='submit']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//button[text()='Ok']"));
    }
}
