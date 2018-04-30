package PageObjects;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * Created by Rupesh on 1/5/2018.
 */

public class BaseSetup {

    private DesiredCapabilities capabilities = new DesiredCapabilities();
    private static AndroidDriver androidDriver = null;

    private String appiumPort = "4723";
    private String serverIp = "127.0.0.1";

    @BeforeClass
    public void setup(){
        initDriver();
    }

    public AndroidDriver getDriver() {
        return androidDriver;
    }

    private void initDriver(){
        System.out.println("Inside initDriver method");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.ebay.mobile.activities.MainActivity" );
        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.ebay.mobile");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "4000");
        cap.setCapability(MobileCapabilityType.APP, "E://Appium setup//ebay.apk");
        cap.setCapability("noReset", true);        String serverUrl = "http://" + serverIp + ":" + appiumPort + "/wd/hub";


        try
        {
            System.out.println("Argument to driver object : " + serverUrl);
            androidDriver = new AndroidDriver(new URL(serverUrl), capabilities);

        }
        catch (NullPointerException | MalformedURLException ex) {
            throw new RuntimeException("appium driver could not be initialised for device ");
        }
        System.out.println("Driver in initdriver is : "+androidDriver);

    }

    @AfterClass
    public void tearDown(){
        androidDriver.quit();
    }

}