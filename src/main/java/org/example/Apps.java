package org.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import javax.swing.*;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Apps {
    public static void main(String[] args) throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            BrowserType chromium = playwright.chromium();
            Browser browser = chromium.launch(
                    new BrowserType.LaunchOptions().setHeadless(false)); // true be default - headless
            System.out.println(browser.contexts().size());
            System.out.println(browser.isConnected());
            BrowserContext context=browser.newContext();
            System.out.println(browser.contexts().size());
            Page page = browser.newPage();
            page.navigate("https://www.google.com/");
            // other actions...
           // Thread.sleep(5000);
            assertThat(page).hasTitle(Pattern.compile("Google"));
            Locator searchText=page.locator("id=APjFqb");
            searchText.fill("KAZ-automation");
            //searchText.press("Tab");
            page.keyboard().press("Enter");
            Thread.sleep(10000);
            context.close();
            browser.close();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
