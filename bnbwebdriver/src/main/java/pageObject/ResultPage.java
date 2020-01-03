package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.spec.ECParameterSpec;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ResultPage extends AbstractPage {

    @FindBy(xpath = "//div[@class ='_csdb5x5']")
    private WebElement likeButton;

    @FindBy(xpath = "//div[@class ='_8ssblpx']")
    private List<WebElement> listOfFlat;

    @FindBy(xpath = "//span[@class ='_czm8crp']")
    private WebElement loginMessageAlert;



    public FlatInformation openInformation(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        listOfFlat.get(0).click();
        return new FlatInformation(driver);
    }

    public String likeFlat(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        likeButton.click();
        return loginMessageAlert.getText();
    }


    protected ResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    protected ResultPage openPage() {
        return this;
    }
}
