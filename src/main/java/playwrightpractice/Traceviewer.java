package playwrightpractice;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class Traceviewer {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            // Start tracing before creating / navigating a page.
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));

            page.navigate("https://toolsqa.com/");
            Page page1 = page.waitForPopup(() -> {
                page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Demo Site")).click();
            });
            page1.locator("div:nth-child(2) > div > .card-up").click();
            page1.locator("span").filter(new Locator.FilterOptions().setHasText("Forms")).locator("div").first().click();
            page1.locator("span").filter(new Locator.FilterOptions().setHasText("Forms")).locator("div").first().click();
            page1.getByRole(AriaRole.LISTITEM).click();
            page1.getByPlaceholder("First Name").click();
            page1.getByPlaceholder("First Name").fill("test");
            page1.getByPlaceholder("First Name").press("Tab");
            page1.getByPlaceholder("Last Name").fill("test");
            page1.getByPlaceholder("name@example.com").click();
            page1.getByPlaceholder("name@example.com").fill("test@email");
            page1.getByPlaceholder("Mobile Number").click();
            page1.getByPlaceholder("Mobile Number").fill("7364637543");
            page1.getByText("Male", new Page.GetByTextOptions().setExact(true)).click();
            page1.close();

            // Stop tracing and export it into a zip archive.
            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("trace.zip")));
        }
    }
}


