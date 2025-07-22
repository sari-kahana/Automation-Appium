package com.google;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import mobile.pageObjects.Clock;
import mobile.pageObjects.Timer;
import mobile.pageObjects.TimerWorking;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class firstTest {

    AndroidDriver driver;

    @BeforeEach
    public void beforeEach() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554");
        options.setAutomationName("UiAutomator2");
        options.setPlatformName("Android");
        options.setPlatformVersion("15");
        options.setAppPackage("com.google.android.deskclock");
        options.setAppActivity("com.android.deskclock.DeskClock");
        options.setNoReset(false);
        options.setFullReset(false);

        //options.setNoReset(true);
        //options.setFullReset(false);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
    }

    @Test
    public void TimerTest() throws InterruptedException {

        Clock clockPage = new Clock(driver);
        Timer timerPage = new Timer(driver);
        TimerWorking timerWorkingPage = new TimerWorking(driver);
        clockPage.TimerClick();
        timerPage.StartTimer();
        Thread.sleep(20000);
        timerWorkingPage.PauseTimer();
        Assertions.assertTrue(timerWorkingPage.GetTimerNumber() <= 20 , "test worked successfully");






        // add asserttion trasn page loaded

    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}




//{
//        "platformName": "android",
//        "appium:platformVersion": 16,
//        "appium:deviceName": "emulator-5554",
//        "appium:appPackage": "com.google.android.deskclock",
//        "appium:appActivity": "com.android.deskclock.DeskClock",
//        "appium:automationName": "UiAutomator2",
//        "appium:noReset": false,
//        "appium:fullReset": false
//        }
//
//
//        {
//        "platformName": "android",
//        "appium:platformVersion": "16",
//        "appium:deviceName": "emulator-5554",
//        "appium:appPackage": "com.google.android.deskclock",
//        "appium:appActivity": "com.android.deskclock.DeskClock",
//        "appium:automationName": "UiAutomator2",
//        "appium:noReset": "false",
//        "appium:fullReset": "false"
//        }
