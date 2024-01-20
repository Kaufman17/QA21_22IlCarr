package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class SearchCarTests extends TestBase {

    @Test
    public void searchCurrentMonthSuccess() {
        int i = new Random().nextInt(10000) + 1000;
        app.getHelperCar().searchCurrentMonth("Tel Aviv, Israel", "1/31/2024", "1/23/2024");
        //app.getHelperCar().searchAnyPeriod("Tel Aviv, Israel", "1/15/2024", "1/23/2024");
        app.getHelperCar().getScreen("src/test/screenshots/currentMonth.png");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
    }


    @Test
    public void searchCurrentYearSuccess() {
        app.getHelperCar().searchCurrentYear("Tel Aviv, Israel", "2/20/2024", "1/12/2025");
        //   app.getHelperCar().searchAnyPeriod("Tel Aviv, Israel", "2/20/2024", "1/12/2025");
        app.getHelperCar().getScreen("src/test/screenshots/currentYear.png");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());

    }


    @Test
    public void searchAnyPeriodSuccess() {

        app.getHelperCar().searchAnyPeriod("Tel Aviv, Israel", "12/31/2024", "1/13/2025");
        app.getHelperCar().submit();

        app.getHelperCar().getScreen("src/test/screenshots/any.png");
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());

    }

    @Test
    public void AnyPeriodNegative() {

        app.getHelperCar().negativeAnyPeriod("Tel Aviv, Israel", "12/31/2024", "2/13/2025");
        app.getHelperCar().submit();
        app.getHelperCar().getScreen("src/test/screenshots/anyNeg.png");
       Assert.assertEquals(app.getHelperCar().getErrorText(), "You can't pick date after one year");
       Assert.assertTrue(app.getHelperCar().isYallaButtonNotActive());

    }

    @BeforeMethod
    public void postCondition() {
        app.getHelperCar().navigateByLogo();
    }

}
