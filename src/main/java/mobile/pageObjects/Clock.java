package mobile.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class Clock extends BasePage{

    @AndroidFindBy(id = "com.google.android.deskclock:id/tab_menu_timer")
    private WebElement timerButton;
    public Clock(AndroidDriver d) {
        super(d);
    }

    public void TimerClick(){
        timerButton.click();
    }
}
