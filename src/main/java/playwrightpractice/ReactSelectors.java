package playwrightpractice;

import com.microsoft.playwright.*;

public class ReactSelectors {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.netflix.com/in/");
        Locator locator = page.locator("_react=Anonymous[data-uia='field-email+label']").first();
        locator.fill("krishnansai99@gmail.com");

    }

}
