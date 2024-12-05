package playwrightpractice;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class DownloadFile {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://demoqa.com/upload-download");

        Download download =  page.waitForDownload(() ->
        {
            page.click("a#downloadButton");
        });

        System.out.println(download.url());

        System.out.println(download.page().title());

        String path = download.path().toString();
        System.out.println(path);

        download.saveAs(Paths.get("sai_download.zip"));

    }

}
