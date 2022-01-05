package HMA;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class LoggerHelper {
    private static boolean root=false;

    public static Logger getLogger(Class cls){
        if(root){
            return Logger.getLogger(cls);
        }
        PropertyConfigurator.configure("log4j.properties");
        root = true;
        return Logger.getLogger(cls);
    }

    public static void main(String[] args) {
        Logger log = LoggerHelper.getLogger(LoggerHelper.class);

    }
}
