package playwrightpractice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class NthElementLocator {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.bigbasket.com/");

        String firstFooterLink = page.locator("footer.footer li a >> nth=0").textContent();
        System.out.println(firstFooterLink);

        String lastFooterLink = page.locator("footer.footer li a >> nth=-1").textContent();
        System.out.println(lastFooterLink);


    }

}
