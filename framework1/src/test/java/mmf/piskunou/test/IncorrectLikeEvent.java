package mmf.piskunou.test;

import mmf.piskunou.model.HotelSearchOption;
import mmf.piskunou.page.HomePage;
import mmf.piskunou.service.HotelSearchOptionCreator;
import mmf.piskunou.test.CommonConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static mmf.piskunou.util.StringUtils.ALERT_MESSAGE_REGISTRATION;
import static mmf.piskunou.util.StringUtils.CITY_DESTINATION;

public class IncorrectLikeEvent extends CommonConditions {
    @Test
    public void likeOnlyRegistrationUser(){

        String messageRegistration = new HomePage(driver)
                .correctSearch(CITY_DESTINATION)
                .likeFlat();
        Assert.assertEquals(ALERT_MESSAGE_REGISTRATION,messageRegistration);

    }
}
