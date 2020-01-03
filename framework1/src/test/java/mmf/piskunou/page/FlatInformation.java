package mmf.piskunou.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class FlatInformation extends AbstractPage {

    @FindBy(xpath = "//*[@id='summary']")
    private WebElement cityFlatInfo;


    public String cityName () {
        return cityFlatInfo.getText();
    }


    protected FlatInformation(WebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
