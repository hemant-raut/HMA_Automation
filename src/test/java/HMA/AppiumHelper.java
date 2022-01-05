package HMA;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumHelper {
    public static void main(String args[]) throws MalformedURLException, InterruptedException {
        Logger log = LoggerHelper.getLogger(LoggerHelper.class);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "onePlus7");
        capabilities.setCapability(MobileCapabilityType.UDID, "bb01e4f1");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        capabilities.setCapability("appPackage", "com.hidemyass.hidemyassprovpn");
        capabilities.setCapability("appActivity", "com.avast.android.vpn.activity.HmaOnboardingActivity");
       // URL url = new URL("http://127.0.0.1:4723/wd/hub");

        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

        HmaLogin hmaLogin = new HmaLogin(driver);

        log.info("HMA launched Successfully...");
        hmaLogin.HMA();
        System.out.println("Test Completed Successfully...");
        driver.quit();
    }
}
