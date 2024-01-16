package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    WebDriver wd;
    HelperUser helperUser;
    HelperCar helperCar;

    public void init() {
        wd = new ChromeDriver();

        logger.info("All tests rus in Chrome Browser");

        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro.web.app");

        logger.info("The link --->" + wd.getCurrentUrl());

        helperUser = new HelperUser(wd);
        helperCar = new HelperCar(wd);
    }

    public HelperUser getHelperUser() {

        return helperUser;
    }

    public HelperCar getHelperCar() {
        return helperCar;
    }

    public void stop() {
        wd.quit();

    }

}
