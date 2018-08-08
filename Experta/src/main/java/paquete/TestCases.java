package paquete;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCases {

	WebDriver driver;
	WebDriverWait wait;
	
	@Test (priority = 1)
	public void loginInvalido() {
		/*Test Case: probar funcionalidad de Login igresando
		parametros incorrectos*/
		
		//Estableciendo Chrome como el navegador a utilizar
		System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver241.exe");
		ChromeOptions op = new ChromeOptions();
		
		op.addArguments("--start-maximized");
		driver = new ChromeDriver(op);
		wait = new WebDriverWait(driver, 15);
		
		driver.get("https://www.experta.com.ar/");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("headerimg"))).click();
		
		//Workaround para pasar el foco de una pestaña a otra
	    ArrayList<String> pestañas = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(pestañas.get(1));
	    
	    //Ingreso de parametros
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("usuario"))).sendKeys("davg1988");
		driver.findElement(By.id("password")).sendKeys("12345678");
	    driver.findElement(By.name("submit")).click();
	    
	    //Comprobacion de que el mensaje de error se muestre
		Assert.assertEquals(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[text()='La contraseña ingresada es incorrecta.'   ]"))).isDisplayed(), true);
		driver.close();
		driver.switchTo().window(pestañas.get(0));
		driver.close();
	}
	
	@Test (priority = 2)
	public void VerificarEnlaceLinkedin() {
		
		//Estableciendo Chrome como el navegador a utilizar
		System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver241.exe");
		ChromeOptions op = new ChromeOptions();
		
		op.addArguments("--start-maximized");
		driver = new ChromeDriver(op);
		wait = new WebDriverWait(driver, 15);
		
		//Acceder a la pagina de Experta
		driver.get("https://www.experta.com.ar/");
		
		//Clic en el icono de linkedin
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='icono_red_top in']"))).click();
		
		//Workaround para pasar el foco de una pestaña a otra
	    ArrayList<String> pestañas = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(pestañas.get(1));
	    
	    //Comprobar si redirige a la pagina de linkedin de Experta
	    Assert.assertEquals(driver.getTitle(), "Experta ART | LinkedIn");
	    
		driver.close();
		driver.switchTo().window(pestañas.get(0));
		driver.close();
	}
}
