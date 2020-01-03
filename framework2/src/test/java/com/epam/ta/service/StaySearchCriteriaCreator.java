package com.epam.ta.service;

//import com.epam.ta.model.StaySearchCriteriaCreator;

import com.epam.ta.model.StaySearchCriteria;

public class StaySearchCriteriaCreator {


    public static final String TEST_DATA_STAY_SEARCH_CRITERIA_DESTINATION = "testdata.staySearchCriteria.destination";
    public static final String TEST_DATA_STAY_SEARCH_CRITERIA_CHECKIN_DATE = "testdata.staySearchCriteria.arrivalDate";
    public static final String TEST_DATA_STAY_SEARCH_CRITERIA_CHECKOUT_DATE = "testdata.staySearchCriteria.departureDate";
    public static final String INCORRECT_DESTINATION = "dajfkladsjfl";


    public static StaySearchCriteria withCredentialsFromProperty() {
        return new StaySearchCriteria(TestDataReader.getTestData(TEST_DATA_STAY_SEARCH_CRITERIA_DESTINATION),
                TEST_DATA_STAY_SEARCH_CRITERIA_CHECKIN_DATE,TEST_DATA_STAY_SEARCH_CRITERIA_CHECKOUT_DATE);

    }

    public static StaySearchCriteria withIncorrectDestination() {
        return new StaySearchCriteria(TestDataReader.getTestData(INCORRECT_DESTINATION),
                TEST_DATA_STAY_SEARCH_CRITERIA_CHECKIN_DATE, TEST_DATA_STAY_SEARCH_CRITERIA_CHECKOUT_DATE);

    }
    public static StaySearchCriteria withYesterdayDate(){
        return new StaySearchCriteria(TestDataReader.getTestData(TEST_DATA_STAY_SEARCH_CRITERIA_DESTINATION),
                TestDataReader.getTestData(TEST_DATA_STAY_SEARCH_CRITERIA_CHECKOUT_DATE),
                TestDataReader.getTestData(TEST_DATA_STAY_SEARCH_CRITERIA_CHECKIN_DATE));
    }

    public static StaySearchCriteria withoutDepartureDate(){
        return new StaySearchCriteria(TestDataReader.getTestData(TEST_DATA_STAY_SEARCH_CRITERIA_DESTINATION),
                TestDataReader.getTestData(TEST_DATA_STAY_SEARCH_CRITERIA_CHECKIN_DATE),
                TestDataReader.getTestData(""));
    }
    public static StaySearchCriteria withEmptyDate(){
        return new StaySearchCriteria(TestDataReader.getTestData(TEST_DATA_STAY_SEARCH_CRITERIA_DESTINATION),
                TestDataReader.getTestData(""),
                TestDataReader.getTestData(""));
    }

}
