package Assessment;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
public class SepeteEkle {
    WebDriver driver;
    ChromeOptions option;
    @Before
    public void oncesinde() {
        WebDriverManager.chromedriver().setup();
        option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @After
    public void sonrasinda(){
        driver.close();
    }
    @Test
    public void test11() {
        driver.get("https://testcase.myideasoft.com/");
        WebElement aramakutusu =driver.findElement(By.xpath("//input[@name=\"q\"]")); // search bar bulunur
        aramakutusu.submit(); //cursorı konumlandırmak için tıklama yapılır
        aramakutusu.sendKeys("ürün"+ Keys.ENTER); //searche ürün yazılıp entera basılır
        WebElement urunusec= driver.findElement(By.className("lazyload")); //aratılan ürün bulunur
        urunusec.click(); //istenilen ürüne tıklanır
        WebElement opendropdown = driver.findElement(By.id("qty-input")); //drop down bulunur
        opendropdown.click(); //drop down açılır
        WebElement selectnumber = driver.findElement(By.xpath("//option[@value='5']")); //açılan drop downdan 5 degeri bulunur
        selectnumber.click(); // 5 değeri seçilir
        opendropdown.click(); //drop downa tekrar tıklanıp kapanması sağlanır
        WebElement addtobox = driver.findElement(By.xpath("//div/a[@class=\"add-to-cart-button\"]"));//sepete ekle butonu bulunur
        addtobox.click(); // sepete ekle butonunu tıklanır
        WebElement sepet = driver.findElement(By.xpath("//a[@title=\"Sepet\"]"));//sağ üst köşeeki sepet butonu bulunur
        sepet.click(); // sepete tıklanır
        WebElement adet = driver.findElement(By.xpath("//input[@value=\"5\"]"));  //sepetim sayfasındaki 5 yazan yer bulunur
        String sonuc = adet.getText(); // 5 yazan yerdeki itemın değeri alnır
        String expectedvalue = "5"; //olmasını beklediğimiz değer
        Assert.assertEquals(expectedvalue,sonuc);


    }
}
