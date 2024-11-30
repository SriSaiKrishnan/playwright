package playwrightpractice;

import com.microsoft.playwright.*;

public class MultipleBrowserContext {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context1 = browser.newContext();
        Page page1 = context1.newPage();
        page1.navigate("https://www.orangehrm.com/");

        BrowserContext context2 = browser.newContext();
        Page page2 = context1.newPage();
        page2.navigate("https://toolsqa.com/");
    }

}
