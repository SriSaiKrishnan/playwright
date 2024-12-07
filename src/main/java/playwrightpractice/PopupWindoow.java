package playwrightpractice;

import com.microsoft.playwright.*;

public class PopupWindoow {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        //Navigate to next window pop up
        page.navigate("https://opensource-demo.orangehrmlive.com/");
        Page popup = page.waitForPopup(() -> {
            page.click("p:has(a[href='http://www.orangehrm.com'])");
        });
        popup.waitForLoadState();

        System.out.println("Popup URL " + popup.url());
        popup.close();
        System.out.println("Parent window " + page.title());
        page.close();

        //Navigate to blank window and launch URL
        page.navigate("https://www.google.com");
        popup = page.waitForPopup(() -> {
            page.click("a[target='blank']");
        });
        popup.waitForLoadState();
        popup.navigate("https://www.amazon.com");
        System.out.println("Popup URL " + popup.title());
        popup.close();
        System.out.println("Parent window " + page.title());
        page.close();

    }

}
