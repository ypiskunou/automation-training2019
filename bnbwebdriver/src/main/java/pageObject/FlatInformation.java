package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class FlatInformation extends AbstractPage {

    @FindBy(xpath = "//span[@class ='_doc79r']")
    private WebElement flatPrice;

    @FindBy(xpath = "//div[@class ='_czm8crp']")
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
