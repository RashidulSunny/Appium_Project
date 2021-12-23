package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSession {
    public static void androidDriverSession(String deviceName, String udId, String appPath) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.UDID, udId);
        capabilities.setCapability(MobileCapabilityType.APP, appPath);
        capabilities.setCapability("appPackage","io.appium.android.apis");
        capabilities.setCapability("appActivity","io.appium.android.apis.ApiDemos");
        capabilities.setCapability("avd","Pixel_5_API_30");
        capabilities.setCapability("avdLaunchTimeout","180000");

        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        AppiumDriver driver = new AndroidDriver(url,capabilities);


    }
}
