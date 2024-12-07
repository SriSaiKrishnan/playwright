package playwrightpractice;

import com.microsoft.playwright.*;

public class DynamicWebTable {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://datatables.net/");

        Locator row = page.locator("table#example tr");
        row.locator(":scope", new Locator.LocatorOptions()
                .setHasText("Airi Satou"))
                .locator("td.dtr-control sorting_1")
                .click();

        row.locator(":scope").allInnerTexts().forEach(e -> System.out.println(e));

    }

}
