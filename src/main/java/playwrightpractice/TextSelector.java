package playwrightpractice;

import com.microsoft.playwright.*;

public class TextSelector {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://demo.opencart.com/index.php?route=account/login");
        Locator links = page.locator("text=Privacy Policy");
        for (int i=0; i<links.count(); i++){
            String linkText = links.nth(i).textContent();
            if(linkText.contains("Service Privacy Policy"))
            {
                links.nth(i).click();
                break;
            }
        }

        //has text
        String header = page.locator("div.well h2:has-text('New Customer')").textContent();
        System.out.println(header);

        String pageHeader = page.locator("'Your Store'").textContent();
        System.out.println(pageHeader);
    }

}
