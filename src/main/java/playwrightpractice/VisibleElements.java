package playwrightpractice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.List;

public class VisibleElements {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://amazon.com");
        List<String> links = page.locator("a:visible").allInnerTexts();
        for (String link : links){
            System.out.println(link);
        }
        int imageCount = page.locator("xpath=//img >> visible=true").count();
        System.out.println(imageCount);

    }

}
