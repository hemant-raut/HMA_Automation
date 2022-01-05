package HMA;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HmaLogin {
    private AndroidDriver<AndroidElement> driver;
    public static WebDriverWait wait=null;

    public HmaLogin() {
    }

    public HmaLogin( AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.wait = new WebDriverWait(driver, 90);

    }


    @FindBy(id = "com.hidemyass.hidemyassprovpn:id/location_button")
    private AndroidElement location;


    @FindBy(id = "com.hidemyass.hidemyassprovpn:id/close_onboarding")
    private AndroidElement closeBoarding;

    @FindBy(id = "com.hidemyass.hidemyassprovpn:id/search_hint")
    private AndroidElement search;

    @FindBy(className = "android.view.ViewGroup")
    private AndroidElement selectLocation;


    @FindBy(xpath = "@resource-id='com.hidemyass.hidemyassprovpn:id/hma_location_list_tabs'/android.widget.LinearLayout[@index='1']")
    private AndroidElement e;


    Logger log = LoggerHelper.getLogger(LoggerHelper.class);


    public boolean isDisplayed() {
        return closeBoarding.isDisplayed();
    }


    public void CloseBoarding(){
        this.wait.until(ExpectedConditions.visibilityOf(closeBoarding));
        closeBoarding.click();
        log.info("Closing Onboarding...");

    }
    public void LocationButtonClicked(){
        this.wait.until(ExpectedConditions.visibilityOf(location));
        location.click();
        log.info("location button Clicked successfully...");
    }


    String abc="UK, Donkey Town";

    public void scrollAndClick(String abc) {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+abc+"\").instance(0))").click();
        log.info(" Location found and clicked...");
    }

   /* public void SearchLocation(){
       // search.click();
       // driver.getKeyboard().sendKeys("Malaysia");

        log.info("Typing Location...");
    }*/

    /*public void SelectLocation(){
        selectLocation.click();
        log.info("Location Found Successfully...");
    }*/

    public void HMA() throws InterruptedException {
        CloseBoarding();
        log.info("clicking on location Button..");
        LocationButtonClicked();
        log.info("Scrolling down...");
        scrollAndClick(abc);

    }
}
