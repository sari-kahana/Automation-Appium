package mobile.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class Timer extends BasePage{

    @AndroidFindBy(id = "com.google.android.deskclock:id/timer_setup_digit_4")
    private WebElement digit4;

    @AndroidFindBy(id = "com.google.android.deskclock:id/timer_setup_digit_0")
    private WebElement digit0;

    @AndroidFindBy(id = "com.google.android.deskclock:id/fab")
    private WebElement startTimerButton;

    public Timer(AndroidDriver d) {
        super(d);
    }

    public void StartTimer(){
        digit4.click();
        digit0.click();
        startTimerButton.click();
    }
}
