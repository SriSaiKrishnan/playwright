package playwrightpractice;

import com.microsoft.playwright.*;

public class Xpath {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.amazon.com/");
        Locator locator = page.locator("xpath=//input[@id='twotabsearchtextbox']");
        locator.fill("iPhone Pro j           ");

    }

}
