package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    //make it private, so it will not allow to create an object outside of this class. only create object in this class
    public DriverFactory(){
        //Empty Constructor
    }

    private static final Logger LOGGER = LogManager.getLogger(DriverFactory.class);
    //create object
    public static final DriverFactory instance = new DriverFactory();
    //create a method
    public static DriverFactory getInstance(){
        return instance;
    }
    //create lambda expression using ThreadLocal which allow driver object to initialize chromedriver
    ThreadLocal<AppiumDriver> driver = ThreadLocal.withInitial(() ->{
        URL url = null;
        try {
           url = new URL(ReadConfigFiles.getPropertyValues("appiumURL"));
           LOGGER.info("Appium URL is:   " + url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        CapabilitiesManager capabilitiesManager = new CapabilitiesManager();
        return new AndroidDriver(url,capabilitiesManager.getCaps());
    });
    public AppiumDriver getDriver(){
        return driver.get();
    }
    //for kill driver end of the execution
    public void removeDriver(){
        driver.get().quit();
        driver.remove();

    }

}
