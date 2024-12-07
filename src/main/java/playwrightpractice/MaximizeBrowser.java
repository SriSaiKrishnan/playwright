package playwrightpractice;

import com.microsoft.playwright.*;

import java.awt.*;

public class MaximizeBrowser {

    public static void main(String[] args) {

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int) dimension.getHeight();
        int width = (int) dimension.getWidth();

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width,height));
        Page page = context.newPage();
        page.navigate("https://amazon.com");

    }

}
