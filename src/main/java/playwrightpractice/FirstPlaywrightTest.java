package playwrightpractice;

import com.microsoft.playwright.*;

public class FirstPlaywrightTest {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setChannel("chrome");
        launchOptions.setHeadless(false);
        Browser browser = playwright.chromium().launch(launchOptions);
        Page page = browser.newPage();
        page.navigate("https://www.google.com");
        String pageTitle = page.title();
        System.out.println("Page title is " + pageTitle);
        String url = page.url();
        System.out.println("Page URL is " + url);
        browser.close();
        playwright.close();

    }

}
