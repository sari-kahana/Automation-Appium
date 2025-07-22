package mobile.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class TimerWorking extends BasePage{

    @AndroidFindBy(id = "com.google.android.deskclock:id/play_pause")
    private WebElement pauseButton;

    @AndroidFindBy(id = "com.google.android.deskclock:id/timer_text")
    private WebElement timerNumber;

    public TimerWorking(AndroidDriver d) {
        super(d);
    }

    public void PauseTimer(){
        pauseButton.click();
    }
    public int GetTimerNumber(){
        return Integer.parseInt(timerNumber.getText());
    }

}
