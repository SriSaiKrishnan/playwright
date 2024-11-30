package playwrightpractice;

import com.microsoft.playwright.*;

public class ShadowDom {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        Page page1 = browserContext.newPage();
        page1.navigate("https://books-pwakit.appspot.com/");
        //Handling Shadow DOM
        page1.locator("book-app[apptitle='BOOKS'] #input").fill("Testing Books");
        String text = page1.locator("book-app[apptitle='BOOKS'] .books-desc").textContent();
        System.out.println(text);

        Page page2 = browserContext.newPage();
        page2.navigate("https://selectorshub.com/xpath-practice-page");
        page2.frameLocator("#pact").locator("div#snacktime #tea").fill("Masala Tea");
    }

}
