package com.epam.ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StaysPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='Koan-via-SearchHeader__input']")
    private WebElement destinationsInput;

    @FindBy(xpath = "//input[@id='guests-rooms']")
    private WebElement guestsSelect;

    @FindBy(xpath = "//div[@class='SearchBar_SearchBa']")
    private WebElement searchBarDestination;

    @FindBy(xpath = "//*[@id='popover-gst']")
    private WebElement applyGuestsNumber;

    @FindBy(xpath = "//*[@id='frm']/button")
    private WebElement searchStaysButton;

    @FindBy(xpath = "//div[@class='StayCard_StayCard__price__1Q_iY']")
    private List<WebElement> stayPrice;

    @FindBy(xpath = "//*[@id='site-content']/div[3]/div/div[2]")
    private List<WebElement> stayName;

    @FindBy(xpath = "//*[@id='app-root']")
    private WebElement stayRating;

    @FindBy(xpath = "//div[@class='SayCard_HotelCard__cta__26snW']")
    private List<WebElement> detailStayInformationButton;

    @FindBy(xpath = "//a[@class='BpkCard_bpk-card__3E_5J ']")
    private List<WebElement> selectionOfStays;

    @FindBy(xpath = "//div[@class ='sb-searchbox__error -visible']")
    private WebElement alertMessage;

    @FindBy(xpath = "//div[@class='form-error']/span")
    private WebElement errorMessageDate;

    public StaysPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public StaysPage openPage() {
        return this;
    }

    public StaysPage searchForStays(String destinations, String checkIn, String checkOut) {
        destinationsInput.sendKeys(destinations);
        destinationsInput.click();
        guestsSelect.click();
        applyGuestsNumber.click();
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        searchStaysButton.click();
        return this;
    }

    public StayDetailPage openDetailedStayInformation(int stayNumber) {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        if (stayNumber - 1 < detailStayInformationButton.size()) {
            detailStayInformationButton.get(stayNumber - 1).click();
            ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(newTab.get(1));
            return new StayDetailPage(driver);
        }
        return null;
    }

    public String getStayPrice(int stayNumber) {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return stayNumber - 1 < stayPrice.size() ? stayPrice.get(stayNumber - 1).getText() : null;
    }

    public String getStayName(int stayNumber) {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);

        return stayNumber - 1 < stayName.size() ? stayName.get(stayNumber - 1).getText() : null;
    }

    public String getDestination() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return destinationsInput.getAttribute("value");
    }


    public String getStayRating() {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return stayRating.getText();
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String searchNotFoundAlertMessage(){
        return alertMessage.getText();
    }

    public String getTextOfMessageAboutErrorsWithDate(){
        return errorMessageDate.getText();
    }


}
