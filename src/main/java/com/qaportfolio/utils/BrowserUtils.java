package com.qaportfolio.utils;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    public static String getText(WebElement element){
        return element.getText().trim();
    }

    public static void selectBy(WebElement location,String value,String methodName){
        Select select=new Select(location);

        switch (methodName){
            case "text":
                select.selectByVisibleText(value);
                break;
            case "value":
                select.selectByValue(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                System.out.println("Your methodname is not matching with text,value or index");
        }
    }
    public static String getTitleWithJS(WebDriver driver){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        return js.executeScript("return document.title").toString().trim();
    }

    public static void clickWithJS(WebDriver driver,WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",element);
    }

    public static void scrollWithJS(WebDriver driver,WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",element);
    }

    public static void switchByTitle(WebDriver driver,String title){
        Set<String> allPagesId=driver.getWindowHandles();
        for(String pageId : allPagesId){
            driver.switchTo().window(pageId);
            if(driver.getTitle().contains(title)){
                break;
            }
        }
    }


     public static void SwitchOnlyFor2Tabs(WebDriver driver, String mainPageId ){
        Set<String> allPagesId = driver.getWindowHandles();
        for(String id : allPagesId){
            if(!id.equals(mainPageId)){
                driver.switchTo().window(id);
            }
        }
    }

      public static List<String> getTextListFromWebElements(List<WebElement> elements) {
        List<String> textList = new ArrayList<>();
        for (WebElement element : elements) {
            textList.add(element.getText());
        }
        return textList;
    }
  

        public static void waitForPageToLoad(WebDriver driver, int timeoutInSeconds) {
        Duration durationSeconds = Duration.ofSeconds(timeoutInSeconds);
        WebDriverWait wait = new WebDriverWait(driver, durationSeconds);
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));
    }

    
   
public static void getScreenShot(WebDriver driver, String testName) {
    File file = ((TakesScreenshot)driver)
        .getScreenshotAs(OutputType.FILE);


    String location = "src/test/resources/screenshots/"
        + testName + "_"
        + System.currentTimeMillis() + ".png";
    try {
        FileUtils.copyFile(file, new File(location));
       
    } catch (IOException e) {
        throw new RuntimeException(
            "Screenshot could not be saved", e
        );
    }
}

public static void getScreenShotWithCucumber(
        WebDriver driver, Scenario scenario) {

    if (scenario.isFailed()) {

        String timestamp = String.valueOf(System.currentTimeMillis());

        File screenShotFile = ((TakesScreenshot)driver)
            .getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(
                screenShotFile,
                new File("target/screenshots/"
                    + scenario.getName() + "_"
                    + timestamp + ".png")
            );
        } catch (IOException e) {
            throw new RuntimeException(
                "Screenshot could not be saved", e
            );
        }
    }
}


}