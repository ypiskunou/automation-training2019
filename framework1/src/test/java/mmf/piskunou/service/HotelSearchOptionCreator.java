package mmf.piskunou.service;

import mmf.piskunou.model.HotelSearchOption;

public class HotelSearchOptionCreator {
    public static final String TEST_DATA_HOTEL_SEARCH_CRITERIA_DESTINATION = "testdata.hotelSearchCriteria.destination";


    public static HotelSearchOption withCorrectDestination() {
        return new HotelSearchOption(TestDataReader.getTestData(TEST_DATA_HOTEL_SEARCH_CRITERIA_DESTINATION));

    }
}
