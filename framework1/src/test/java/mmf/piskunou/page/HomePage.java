package mmf.piskunou.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage extends AbstractPage {
    private String HOME_PAGE_URL = "https://www.airbnb.ru";


    @FindBy(xpath ="//*[@id='Koan-via-SearchHeader__input']")
    private WebElement inputDestination;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public HomePage openPage() {
        driver.get(HOME_PAGE_URL);
        return this;
    }

    public ResultPage correctSearch (String destination){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        inputDestination.sendKeys(destination);
        inputDestination.sendKeys(Keys.RETURN);
        inputDestination.click();
        return new ResultPage(driver);
    }



}

