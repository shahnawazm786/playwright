package browsertypes;

import com.microsoft.playwright.*;

public class BrowserTypeExample {
    public static void main(String[] args) throws InterruptedException{
        try(Playwright playwright=Playwright.create()) {
            BrowserType browserType = playwright.firefox();
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page=browser.newPage();
            //browser.newPage().navigate("https://www.google.com");
            //Locator locator = browser.newPage().locator("id=APjFqb");
            page.navigate("https://www.google.com");
            Locator locator=page.locator("id=APjFqb");
            locator.fill("kaz-automation");
            locator.press("Tab");
            locator.press("Enter");
            Thread.sleep(50000);
            page.locator("");
            browser.close();
        }
    }
}
