package mmf.piskunou.test;

import mmf.piskunou.model.HotelSearchOption;
import mmf.piskunou.page.HomePage;
import mmf.piskunou.service.HotelSearchOptionCreator;
import org.testng.Assert;
import org.testng.annotations.Test;



public class CorrectHotelSearch extends CommonConditions{
    @Test
    public void checkCorrectDataOnHotelPage(){
        HotelSearchOption hotelSearchOption = HotelSearchOptionCreator.withCorrectDestination();
        String flatCityName = new HomePage(driver)
                .correctSearch(hotelSearchOption.getDestination())
                .openInformation()
                .cityName();
        Assert.assertEquals(hotelSearchOption.getDestination(), flatCityName);
    }

}
