package testCases;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static java.time.Duration.ofSeconds;

public class TestBase {
    protected WebDriver driver;

    /* @BeforeClass
     public void openBrowser() {
         System.setProperty("webdriver.chrome.driver", "D:\\to run  intelliJ & to begin automation\\chromedriver_win32\\chromedriver.exe");
         driver = new ChromeDriver();
         driver.get("https://mybusiness-42c2x6-dev.dafater.biz/index.html");
         //https://mybusiness-42c2x6-dev.dafater.biz/index.html
        // https://mybusiness-42c2x6-dev.dafater.biz/index.html
         driver.manage().timeouts().implicitlyWait(ofSeconds(30));
         driver.manage().window().maximize();

     }*/
    @BeforeMethod
    public void openBrowser() {
        // System.setProperty("webdriver.chrome.driver", "D:\\to run  intelliJ & to begin automation\\chromedriverr_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //   driver = new FirefoxDriver();
        driver.get("https://engineering-dorgham.dafater.biz/index.html");
        driver.manage().timeouts().implicitlyWait(ofSeconds(30));
        driver.manage().window().maximize();
    }

    //@DataProvider(name = "testdata")
    public Object[][] readingDataMethod(String filePath, int cols) throws IOException {
        File src = new File(filePath);
        FileInputStream inputfile = new FileInputStream(src);
        XSSFWorkbook book = new XSSFWorkbook(inputfile);
        XSSFSheet sheet = book.getSheetAt(0);
        int rows = sheet.getLastRowNum() + 1;
        System.out.println(rows);

        String[][] arr = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = sheet.getRow(i).getCell(j).toString();
            }
        }
        book.close();
        return arr;
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
