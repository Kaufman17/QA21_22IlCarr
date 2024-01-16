package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class SearchCarTests extends TestBase {

    @Test
    public void searchCurrentMonthSuccess() {
        int i = new Random().nextInt(10000) + 1000;
        app.getHelperCar().searchCurrentMonth("Tel Aviv, Israel", "1/15/2024", "1/23/2024");
        //app.getHelperCar().searchAnyPeriod("Tel Aviv, Israel", "1/15/2024", "1/23/2024");
        app.getHelperCar().pause(5000);
        app.getHelperCar().getScreen("src/test/screenshots/screen-" + i + ".png");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
    }


    @Test
    public void searchCurrentYearSuccess() {
        //app.getHelperCar().searchCurrentYear("Tel Aviv, Israel", "2/20/2024", "1/12/2025");
        app.getHelperCar().searchAnyPeriod("Tel Aviv, Israel", "2/20/2024", "1/12/2025");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());

    }


    @Test
    public void searchAnyPeriodSuccess() {
        int i = new Random().nextInt(10000) + 1000;

        app.getHelperCar().searchAnyPeriod("Tel Aviv, Israel", "12/31/2024", "1/13/2025");
        app.getHelperCar().submit();

        app.getHelperCar().getScreen("src/test/screenshots/screen-" + i + ".png");
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());

    }


}
