package playwrightpractice;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class Degugger {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://toolsqa.com/");
            Page page1 = page.waitForPopup(() -> {
                page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Demo Site")).click();
            });
            page1.locator("div:nth-child(2) > div > .avatar > svg").click();
            page1.getByText("Practice Form").click();
            page1.getByPlaceholder("First Name").click();
            page1.getByPlaceholder("First Name").fill("test");
            page1.getByPlaceholder("First Name").press("Tab");
            page1.getByPlaceholder("Last Name").fill("practice");
            page1.getByPlaceholder("name@example.com").click();
            page1.getByPlaceholder("name@example.com").fill("test@email");
            //To debug the script page.pause() method is used
            page1.pause();
            page1.getByText("Male", new Page.GetByTextOptions().setExact(true)).click();
            page1.getByPlaceholder("Mobile Number").click();
            page1.getByPlaceholder("Mobile Number").fill("7843657843");
            page1.locator("#dateOfBirthInput").click();
            page1.getByLabel("Choose Thursday, November 28th,").click();
            page1.locator(".subjects-auto-complete__value-container").click();
            page1.locator("#subjectsInput").fill("test");
            page1.getByText("Sports").click();
        }
    }
}
