import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginTesting {

    final int timeSleep = 500;

    final String initUrl = "https://h2ln-store.herokuapp.com/login-page";

    WebDriver driver;

    public void init(){
        // set chrome driver
        System.setProperty("webdriver.chrome.driver",
                "D:\\Code\\IntelliJ\\SWT301\\chromedriver.exe");
        driver = new ChromeDriver();
        // wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

//    public void test() throws InterruptedException{
//        init();
//        List<String[]> listAccounts = readEO();
//        int successCount = 0;
//        System.out.println("==================================================");
//        for (int i=0; i<listAccounts.size();i++) {
//            Thread.sleep(timeSleep);
//            //open a website
//            driver.get(initUrl);
//            String EO = listAccounts.get(i)[2];
//            String RO = login(listAccounts.get(i)[0],listAccounts.get(i)[1]);
//            if(RO.equalsIgnoreCase(EO)){
//                System.out.println("=> Case "+(i+1)+": PASS. (EO: "+EO+" = RO: "+RO+")");
//                successCount++;
//            } else{
//                System.err.println("=> Case "+(i+1)+": FAIL. (EO: "+EO+" # RO: "+RO+")");
//            }
//        }
//        System.out.println("===> PERCENTAGE: "+((double)successCount/(double)listAccounts.size())*100+"%");
//        System.out.println("==================================================");
//        driver.quit();
//    }

    public void test() throws InterruptedException{
        init();
        List<String[]> listAccounts = readEO();
        int successCount = 0;
        System.out.println("==================================================");
        for (int i=0; i<listAccounts.size();i++) {
            Thread.sleep(timeSleep);
            //open a website
            driver.get(initUrl);
            String RO = login(listAccounts.get(i)[0],listAccounts.get(i)[1]);
            if(RO.equalsIgnoreCase("user")||RO.equalsIgnoreCase("admin")){
                System.out.println("=> Case "+(i+1)+": PASS. ("+RO+")");
                successCount++;
            } else{
                System.err.println("=> Case "+(i+1)+": FAIL. ("+RO+")");
            }
        }
        System.out.println("===> PERCENTAGE: "+((double)successCount/(double)listAccounts.size())*100+"%");
        System.out.println("==================================================");
        driver.quit();
    }


    public String login(String username, String password) throws InterruptedException{

        // Maximize the browser
//        driver.manage().window().maximize();

        // Enter value 10 in the first number of the percent Calculator
        driver.findElement(By.id("login_form_cnoLogin")).sendKeys(String.valueOf(username));

        Thread.sleep(timeSleep);

        // Enter value 50 in the second number of the percent Calculator
        driver.findElement(By.id("login_form_cpass")).sendKeys(String.valueOf(password));

        Thread.sleep(timeSleep);

        // Click Login Button
        driver.findElement(By.id("login_form_0")).click();


        //within 10 seconds
        long createdMillis = System.currentTimeMillis();
        int seconds = 0;
        do{
            long nowMillis = System.currentTimeMillis();
            seconds = (int)((nowMillis - createdMillis) / 1000);
            if(driver.getCurrentUrl().equalsIgnoreCase("https://h2ln-store.herokuapp.com/home-page")){
                return "user";
            }
            if(driver.getCurrentUrl().equalsIgnoreCase("https://h2ln-store.herokuapp.com/customer-page-admin")){
                return "admin";
            }
            if(driver.findElements(By.className("errorMessage")).size()>0){
                // Get the Result Text
                String result = driver.findElement(By.className("errorMessage")).getText();
                return result;
            }
        }while (seconds<10);
        return "Crashed";
    }

    private List<String[]> readEO() {
        List<String[]> records = new ArrayList<String[]>();
        try{
            BufferedReader br = new BufferedReader(new FileReader("accounts.csv"));
            String line;
            br.readLine();
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(values);
            }
            return records;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }
}
