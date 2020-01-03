package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage extends AbstractPage {
    private final String HOME_PAGE_URL = "https://www.airbnb.ru/";

    @FindBy(xpath = "//input[@id='lp-geocomplete']")
    private WebElement inputDestination;

    @FindBy(xpath ="//button[@class ='_1o4htsfg']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@id = 'checkin_input']")
    private WebElement inputCheckIn;

    @FindBy(xpath = "//input[@id = 'checkout_input']")
    private WebElement inputCheckOut;

    private WebElement inputInDate;
    private WebElement inputOutDate;



    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public HomePage openPage() {
        driver.get(HOME_PAGE_URL);
        return this;
    }

    public ResultPage correctSearch (String destination, String checkIn,String checkOut){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        inputDestination.sendKeys(destination);
        inputCheckIn.click();
        this.inputInDate = driver.findElement(By.xpath("//input[@value = '" + checkIn +"']"));
        inputCheckOut.click();
        this.inputOutDate = driver.findElement(By.xpath("//input[@value = '" + checkOut +"']"));
        searchButton.click();
        return new ResultPage(driver);
    }



}
