package playwrightpractice;

import com.microsoft.playwright.*;

public class SelectingOtherElement {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.amazon.com/");

        Locator footerList = page.locator("div.navFooterLinkCol:has(a[href='https://www.amazon.jobs'])");
        footerList.allInnerTexts().forEach(e -> System.out.println(e));
    }

}
