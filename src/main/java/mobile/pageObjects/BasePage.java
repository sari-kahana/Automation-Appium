package mobile.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumElementLocatorFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import lombok.extern.slf4j.Slf4j;
import mobile.enums.SwipeDirection;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;



@Slf4j
public class BasePage {
    private static final Logger log = LoggerFactory.getLogger(BasePage.class);
    public AndroidDriver driver;
    private final int timeout = 30;

    public BasePage(AndroidDriver d){
        this.driver = d;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    protected WebElement elementToBeClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement visibilityOf(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement visibilityOfElementLocated(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    protected WebElement visibilityOfElementLocated(By by, int time){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected List<WebElement> visibilityOfAllElements(List<WebElement> elements){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

}
