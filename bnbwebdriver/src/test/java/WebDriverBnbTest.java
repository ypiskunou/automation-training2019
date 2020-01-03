import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.HomePage;

public class WebDriverBnbTest {
    public WebDriver driver;

    public static String ALERT_MESSAGE_REGISTRATION = "Do you have an account at Air BnB?";
    public static String CITY_DESTINATION = "Rome";

    @BeforeMethod(alwaysRun = true)
    public void setUpBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:/webdriver/chromedriver.exe");
        driver = new ChromeDriver();
    }


    @Test
    public void checkCorrectData(){
        String flatCityName = new HomePage(driver)
                .correctSearch(CITY_DESTINATION,"2019-12-24","2019-12-28")
                .openInformation()
                .cityName();
        Assert.assertEquals(CITY_DESTINATION, flatCityName);
    }

    @Test
    public void likeOnlyRegistrationUser(){
        String messageRegistration = new HomePage(driver)
                .correctSearch(CITY_DESTINATION,"2019-12-24","2019-12-28")
                .likeFlat();
        Assert.assertEquals(ALERT_MESSAGE_REGISTRATION,messageRegistration);

    }
    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser(){
        driver.quit();
        driver = null;
    }
}
