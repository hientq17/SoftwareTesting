import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class CalculatorTesting {

    final int time = 10;

    final int MAX = 1000;

    final int MIN = -100;

    final int timeSleep = 50;


    WebDriver driver;

    public void init(){
        // set chrome driver
        System.setProperty("webdriver.chrome.driver",
                "D:\\Code\\IntelliJ\\SWT301\\chromedriver.exe");
        driver = new ChromeDriver();
        // wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        // open website
        driver.get("http://localhost:3000/calculator");
    }

    public void test() throws InterruptedException{
        init();
        int successCount = 0;
        int i=0;
        float num1 = 0;
        float num2 = 0;
        double result = 0;
        String calculation = "";
        System.out.println("==================================================");
        while(i<time){
            num1 = (float)(Math.random()*(MAX-MIN+1)+MIN);
            num2 = (float)(Math.random()*(MAX-MIN+1)+MIN);
            switch((int)(Math.random()*4+1)){
                case 1: calculation = "plus"; result = num1+num2; break;
                case 2: calculation = "minus";result = num1-num2; break;
                case 3: calculation = "multiply"; result = num1*num2; break;
                case 4: calculation = "divide"; result = num1/num2; break;
            }
            String EO = String.valueOf(result);
            String RO = calculate(num1,num2,calculation);
            if(Double.parseDouble(EO)==Double.parseDouble(RO)){
                System.out.println("=> Case "+(i+1)+": PASS. (EO: "+EO+" = RO: "+RO+")");
                successCount++;
            } else{
                System.err.println("=> Case "+(i+1)+": FAIL. (EO: "+EO+" # RO: "+RO+")");
            }
            i++;
        };
        System.out.println("===> PERCENTAGE: "+((double)successCount/(double)i)*100+"%");
        System.out.println("==================================================");
        // Close the Browser.
        driver.quit();
    }

    public String calculate(float num1, float num2, String calculation) throws InterruptedException{

        // Maximize the browser
//        driver.manage().window().maximize();

        // Enter value 10 in the first number of the percent Calculator
        driver.findElement(By.id("num1")).sendKeys(String.valueOf(num1));

        Thread.sleep(timeSleep);

        // Enter value 50 in the second number of the percent Calculator
        driver.findElement(By.id("num2")).sendKeys(String.valueOf(num2));

        Thread.sleep(timeSleep);

        // Click Calculate Button
        driver.findElement(By.id(calculation)).click();

        // Get the Result Text based on its xpath
        String result = driver.findElement(By.id("result")).getText();

        Thread.sleep(timeSleep);

        // Click continue Button
        driver.findElement(By.id("continue")).click();

        return result;
    }
}
