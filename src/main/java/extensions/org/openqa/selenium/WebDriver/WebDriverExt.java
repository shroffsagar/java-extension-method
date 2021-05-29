package extensions.org.openqa.selenium.WebDriver;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import org.openqa.selenium.WebDriver;

@Extension
public class WebDriverExt {
    public static void switchToTab(@This WebDriver thiz, String tabToSwitch){
        String tabBeforeSwitching = thiz.getWindowHandle();
        for(String tabName: thiz.getWindowHandles()){
            if(thiz.switchTo().window(tabName).getTitle().contains(tabToSwitch)) {
                return;
            }
        }
        thiz.switchTo().window(tabBeforeSwitching);
        throw new RuntimeException("Could not find matching tab with title: "+tabToSwitch);
    }
}
