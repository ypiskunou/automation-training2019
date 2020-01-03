package com.epam.ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class StayDetailPage extends AbstractPage {
    @FindBy(xpath = "//*[@id='Koan-via-HeaderController__input']")
    private WebElement inputPlace;

    @FindBy(xpath = "//button[@class='BpkButton_bpk-button__3CLCxL']")
    private WebElement priceAlertButton;

    @FindBy(xpath = "//div[@class='SubscribeLogin_SubscribeLogin__2XDN6']']")
    private WebElement priceAlertMainText;

    @FindBy(xpath = "//*[@id='app-root-rmch-btn']")
    private WebElement chooseRoomButton;

    @FindBy(xpath = "//*[@id='app-root-room-btn']")
    private WebElement roomDetailInformationButton;

    @FindBy(xpath = "//*[@id='app-root-st-name']")
    private WebElement stayName;

    @FindBy(xpath = "//*[@id='app-root-st-price']")
    private WebElement stayPrice;

    @FindBy(xpath = "//*[@id='host-profile']")
    private WebElement stayRating;

    @FindBy(xpath = "//*[@id='rooms']")
    private WebElement currectRoomsNumber;

    @FindBy(xpath = "//*[@id='adults']")
    private WebElement currectAdultsNumber;

    public StayDetailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getPriceAlertMainText() {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return priceAlertMainText.getText();
    }

    public StayDetailPage openRoomDetailInformationButton() {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        roomDetailInformationButton.click();
        return this;
    }
    public StayDetailPage openPricingAlertSettings() {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        priceAlertButton.click();
        return this;
    }


    public String getStayName() {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return stayName.getText();
    }


    public String getStayPrice() {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return stayPrice.getText();
    }


    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getStayRating() {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return stayRating.getText();
    }

    public int getCurrentNumberOfAdults() {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return Integer.parseInt(currectAdultsNumber.getAttribute("value"));
    }

    public int getCurrentNumberOfRooms() {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return Integer.parseInt(currectRoomsNumber.getAttribute("value"));
    }

    @Override
    public StayDetailPage openPage() {
        return this;
    }

}
