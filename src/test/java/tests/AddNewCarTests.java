package tests;


import manager.DataProviderCar;
import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Random;

public class AddNewCarTests extends TestBase {

    @BeforeClass
    public void preConditions() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().setEmail("chara@gmail.com").setPassword("Chara12345$"));

        }
    }

    @Test(dataProvider = "carSuccess", dataProviderClass = DataProviderCar.class)
  //  public void addNewCarSuccessAll() {
        public void addNewCarSuccessAll(Car car) {
        int i = new Random().nextInt(10000) + 1000;
//        Car car = Car.builder()
//                .location("Tel Aviv, Israel")
//                .manufacture("Mazda")
//                .model("M3")
//                .year("2022")
//                .fuel("Petrol")
//                .seats(4)
//                .carClass("C")
//                // .carRegNumber("678-900-" + i)
//                .carRegNumber("678-900-" + i + "1")
//                .price(50)
//                .about("Very nice car")
//                .build();
        logger.info("Test data ---> " + car.toString());
      //  logger.info("Test start with test data --->" + car.toString());
        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().attachPhoto("C:\\Users\\Public\\QA21_22\\QA21_22IlCarr\\imgpsh_fullsize_anim.jpeg");
        app.getHelperCar().getScreen("src/test/screenshots/screen-" + i + ".png");
        app.getHelperCar().submit();
        // Assert.assertTrue(app.getHelperCar().getMessage().contains(" added successful"));
        Assert.assertTrue(app.getHelperUser().getMessage().contains("added successful"));
        Assert.assertEquals(app.getHelperUser().getMessage(), car.getManufacture()
                + " " + car.getModel()
                + " added successful");
    }


    @Test
    public void addNewCarReqSuccessA() {
        int i = new Random().nextInt(1000) + 1000;
        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Mazda")
                .model("M3")
                .year("2022")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .carRegNumber("679-900-" + i)
                .price(50)
                .build();

        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().submit();
        String expectedMessage = (car.getManufacture() + " " + car.getModel() + " added successful").trim();
        // Assert.assertEquals(app.getHelperCar().getMessage().trim(), expectedMessage);
        Assert.assertTrue(app.getHelperUser().getMessage().contains("added successful"));
        Assert.assertEquals(app.getHelperUser().getMessage(), car.getManufacture()
                + " " + car.getModel()
                + " added successful");
    }

    @AfterMethod
//    public void postConditions() {
//    app.getHelperUser().clickOKButton();
//    app.stop();
//}
    public void postCondition() {
        app.getHelperCar().returnToHome();
    }


}

