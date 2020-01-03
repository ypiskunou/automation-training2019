package com.epam.ta.test;

import com.epam.ta.model.StaySearchCriteria;
import com.epam.ta.page.StayDetailPage;
import com.epam.ta.page.StaysPage;
import com.epam.ta.service.StaySearchCriteriaCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.epam.ta.util.StringUtils.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class StayTests extends CommonConditions {

    @Test
    public void detailedStayInformationHasPriceAlertMainText() {
        StaySearchCriteria staySearchCriteria = StaySearchCriteriaCreator.withCredentialsFromProperty();

        StayDetailPage stayDetailPage = new StaysPage(driver)
                .openPage()
                .searchForStays(staySearchCriteria.getDestination(), staySearchCriteria.getCheckIn(), staySearchCriteria.getCheckOut())
                .openDetailedStayInformation(1);

        switchToWindow(1);

        String priceAlertMainText = stayDetailPage.openPricingAlertSettings()
                .getPriceAlertMainText();

        assertThat(PRICE_ALERT_MAIN_TEXT, is(equalTo(priceAlertMainText)));
    }

    @Test
    public void priceOfTheStayAfterSearchingIsTheSameAsOnTheStayPage() {
        StaySearchCriteria staySearchCriteria = StaySearchCriteriaCreator.withCredentialsFromProperty();

        StaysPage staysPage = new StaysPage(driver)
                .openPage()
                .searchForStays(staySearchCriteria.getDestination(), staySearchCriteria.getCheckIn(), staySearchCriteria.getCheckOut());

        String stayPriceAfterSearching = staysPage.getStayPrice(FIRST_STAYS_NUMBER);

        StayDetailPage stayDetailPage = staysPage.openDetailedStayInformation(FIRST_STAYS_NUMBER);

        switchToWindow(1);

        String stayPriceOnDetailPage = stayDetailPage.getStayPrice();

        assertThat(stayPriceAfterSearching, is(equalTo(stayPriceOnDetailPage)));
    }

    @Test
    public void openStayDetailPageAfterClickTheButtonMoreDetails() {
        StaySearchCriteria staySearchCriteria = StaySearchCriteriaCreator.withCredentialsFromProperty();

        StaysPage staysPage = new StaysPage(driver)
                .openPage()
                .searchForStays(staySearchCriteria.getDestination(), staySearchCriteria.getCheckIn(), staySearchCriteria.getCheckOut());

        String stayNameAfterSearching = staysPage.getStayName(FIRST_STAYS_NUMBER);
        String searchUrl = staysPage.getCurrentUrl();

        StayDetailPage stayDetailPage = staysPage.openDetailedStayInformation(FIRST_STAYS_NUMBER);

        switchToWindow(1);

        String currentUrl = stayDetailPage.getCurrentUrl();
        String stayNameOnDetailPage = stayDetailPage.getStayName();

        assertThat(stayNameAfterSearching, is(equalTo(stayNameOnDetailPage)));
        assertThat(currentUrl, is(not(searchUrl)));
    }

    @Test
    public void checkSearchDestinationAfterSearch() throws InterruptedException {
        StaySearchCriteria staySearchCriteria = StaySearchCriteriaCreator.withCredentialsFromProperty();

        StaysPage staysPage = new StaysPage(driver)
                .openPage()
                .searchForStays(staySearchCriteria.getDestination(), staySearchCriteria.getCheckIn(), staySearchCriteria.getCheckOut());

        String destinationTextFromSearchBar = staysPage.getDestination();

        assertThat(destinationTextFromSearchBar, is(equalTo(staySearchCriteria.getDestination())));
    }

    @Test
    public void checkStayRatingInDetailPage() {
        StaySearchCriteria staySearchCriteria = StaySearchCriteriaCreator.withCredentialsFromProperty();

        StaysPage staysPage = new StaysPage(driver)
                .openPage()
                .searchForStays(staySearchCriteria.getDestination(), staySearchCriteria.getCheckIn(), staySearchCriteria.getCheckOut());

        String stayRationAfterSearch = staysPage.getStayRating();

        StayDetailPage stayDetailPage = staysPage.openDetailedStayInformation(FIRST_STAYS_NUMBER);

        switchToWindow(1);

        String stayRatingOnDetailPage = stayDetailPage.getStayRating();

        assertThat(stayRationAfterSearch, is(equalTo(stayRatingOnDetailPage)));
    }

    @Test
    public void incorrectDestinationName(){
        StaySearchCriteria staySearchOptions = StaySearchCriteriaCreator.withIncorrectDestination();
        String alertMessage = new StaysPage(driver)
                .openPage()
                .searchForStays(staySearchOptions.getDestination(),
                        staySearchOptions.getCheckIn(),
                        staySearchOptions.getCheckOut())
                .searchNotFoundAlertMessage();
        Assert.assertEquals(CITY_NAME_ALERT_TEXT,alertMessage);
    }

    @Test
    public void checkAdultsOnStayDetailPage() {
        StaySearchCriteria staySearchCriteria = StaySearchCriteriaCreator.withCredentialsFromProperty();

        StayDetailPage stayDetailPage = new StaysPage(driver)
                .openPage()
                .searchForStays(staySearchCriteria.getDestination(), staySearchCriteria.getCheckIn(), staySearchCriteria.getCheckOut())
                .openDetailedStayInformation(1);

        switchToWindow(1);

        int currentNumberOfAdults = stayDetailPage.getCurrentNumberOfAdults();

        assertThat(currentNumberOfAdults, is(equalTo(staySearchCriteria.getNumberOfGuests())));

    }
    public void searchStayWithYesterdayDate(){
        StaySearchCriteria staySearchCriteria = StaySearchCriteriaCreator.withYesterdayDate();
        String textOfMessageAboutErrorsWithDate = new StaysPage(driver)
                .openPage()
                .searchForStays(staySearchCriteria.getDestination(), staySearchCriteria.getCheckIn(), staySearchCriteria.getCheckOut())
                .getTextOfMessageAboutErrorsWithDate();
        assertThat(textOfMessageAboutErrorsWithDate, is(equalTo(ERROR_MESSAGE_YESTERDAY_DATE)));
    }

    @Test
    public void searchStayWithoutDepartureDate(){
        StaySearchCriteria staySearchCriteria = StaySearchCriteriaCreator.withoutDepartureDate();
        String textOfMessageAboutErrorsWithDate = new StaysPage(driver)
                .openPage()
                .searchForStays(staySearchCriteria.getDestination(), staySearchCriteria.getCheckIn(), staySearchCriteria.getCheckOut())
                .getTextOfMessageAboutErrorsWithDate();
        assertThat(textOfMessageAboutErrorsWithDate, is(equalTo("Укажите дату выезда")));
    }
}
