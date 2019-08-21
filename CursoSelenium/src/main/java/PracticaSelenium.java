import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.NoSuchElementException;
import junit.framework.Assert;

import java.util.List;

import org.junit.Test;

public class PracticaSelenium {

	@Test
	public void prueba() {
		System.setProperty("webdriver.chrome.driver", "C://selenium//chromedriver_win32//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//Implicit Wait
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		testBasicNavigation(driver);
		testCheckBox(driver);
		testRadioButton(driver);
		testDropdown(driver);
		testDragDrop(driver);
		testMultipleSelection(driver);
		testListaElementos(driver);
		testExplicitAndFluentWait(driver);
		testAlert(driver);
		testConfirm(driver);
		testPrompt(driver);
		testFrame(driver);
		
	}

	public void testBasicNavigation(WebDriver driver) {
		// Launch website
		driver.navigate().to("https://www.google.com/");
		// Maximize the browser
		driver.manage().window().maximize();

		// Buscar Textbox y Escribir 2+2
		WebElement googleTextBox = driver.findElement(By.name("q"));
		googleTextBox.sendKeys("2+2", Keys.RETURN);

		// Buscar Textbox de resultado y extraer texto
		WebElement calculatorTextBox = driver.findElement(By.id("cwos"));
		String result = calculatorTextBox.getText();
		System.out.println("Resultado" + result);

		// Buscar boton numero 1 y dar click
		WebElement button1 = driver.findElement(By.xpath("//div[@class=\"XRsWPe AOvabd\" and text()=\"1\"]"));
		button1.click();

		// Buscar boton numero 2 y dar click
		WebElement button2 = driver.findElement(By.xpath("//div[@class=\"XRsWPe AOvabd\" and text()=\"2\"]"));
		button2.click();

		// Buscar boton suma y dar click
		WebElement sum = driver.findElement(By.xpath("//div[@class=\"XRsWPe MEdqYd\" and text()=\"+\"]"));
		sum.click();

		button1.click();

		button2.click();

		// Buscar boton resultado(=) y dar click
		WebElement res = driver.findElement(By.xpath("//div[@class=\"XRsWPe UUhRt\" and text()=\"=\"]"));
		res.click();

		// Extraer Resultado
		result = calculatorTextBox.getText();

		System.out.println("Resultado" + result);
	}

	public void testCheckBox(WebDriver driver) {
		// Launch website
		driver.navigate().to("http://www.calculator.net/mortgage-calculator.html");
		driver.manage().window().maximize();

		// Click en Checkbox
		driver.findElement(By.id("caddoptional")).click();

		// Validaciones
		System.out.println("IsSelected " + driver.findElement(By.id("caddoptional")).isSelected());
		System.out.println("IsEnabled " + driver.findElement(By.id("caddoptional")).isEnabled());
		System.out.println("IsDisplayed " + driver.findElement(By.id("caddoptional")).isDisplayed());

	}

	public void testRadioButton(WebDriver driver) {
		// Launch website
		driver.navigate().to("http://www.calculator.net/mortgage-payoff-calculator.html");
		driver.manage().window().maximize();

		// Click en el Checkbox
		driver.findElement(By.id("cpayoff1")).click();

		// Validaciones
		System.out.println("IsSelected " + driver.findElement(By.id("cpayoff1")).isSelected());
		System.out.println("IsEnabled " + driver.findElement(By.id("cpayoff1")).isEnabled());
		System.out.println("IsDisplayed " + driver.findElement(By.id("cpayoff1")).isDisplayed());

	}

	public void testDropdown(WebDriver driver) {
		// Launch website
		driver.navigate().to("http://www.calculator.net/interest-calculator.html");
		driver.manage().window().maximize();

		// Selecciona un item del Drop Down list
		Select dropdown = new Select(driver.findElement(By.id("ccompound")));
		dropdown.selectByVisibleText("continuously");

		// Tambien se puede usar dropdown.selectByIndex(1) para seleccionar elementos,
		// donde 1 pude ser cualquier
		// otra posicion, iniciando el indice en 0
		// Asi como tambien seleccionar por valor
		// dropdown.selectByValue("annually");

		// Validaciones
		System.out.println("IsSelected " + driver.findElement(By.id("ccompound")).isSelected());
		System.out.println("IsEnabled " + driver.findElement(By.id("ccompound")).isEnabled());
		System.out.println("IsDisplayed " + driver.findElement(By.id("ccompound")).isDisplayed());

	}

	public void testDragDrop(WebDriver driver) {
		driver.navigate().to("http://www.keenthemes.com/preview/metronic/templates/admin/ui_tree.html");
		driver.manage().window().maximize();

		// Creamos el objeto Actions
		Actions builder = new Actions(driver);

		// Indicamos los elementos que se usaran para la accion
		// Elemento desde donde haremos el click and hold
		WebElement From = driver.findElement(By.xpath(".//*[@id='j3_7']/a"));
		// Elemento donde haremos el relase
		WebElement To = driver.findElement(By.xpath(".//*[@id='j3_1']/a"));

		builder.clickAndHold(From).moveToElement(To).release(To).build().perform();

	}

	public void testMultipleSelection(WebDriver driver) {
		driver.navigate().to("http://demos.devexpress.com/aspxeditorsdemos/ListEditors/MultiSelect.aspx");
		driver.manage().window().maximize();

		driver.findElement(By.id("ControlOptionsTopHolder_lbSelectionMode_B-1")).click();

		driver.findElement(By.id("ControlOptionsTopHolder_lbSelectionMode_DDD_L_LBI1T0")).click();

		// Creamos un Actions
		Actions builder = new Actions(driver);

		// iniciamos el Elemento que contiene las opciones a seleccionar
		WebElement select = driver.findElement(By.id("ContentHolder_lbFeatures_LBT"));
		// Listamos las opciones contenidas en elemento
		List<WebElement> options = select.findElements(By.tagName("td"));

		// Se indica la accion, presionar la tecla Control, y dar click en diversas
		// opciones
		Action multipleSelect = builder.keyDown(Keys.CONTROL).click(options.get(2)).click(options.get(4))
				.click(options.get(6)).build();

		// Ejecutamos la accion
		multipleSelect.perform();
	}

	public void testListaElementos(WebDriver driver) {
		driver.navigate().to("http://www.calculator.net");

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of Links in the Page is " + links.size());
		for (int i = 1; i <= links.size(); i = i + 1) {
			System.out.println("Name of Link# " + i + links.get(i).getText());
		}
	}

	public void testExplicitAndFluentWait(WebDriver driver) {
		driver.navigate().to("http://demos.devexpress.com/aspxeditorsdemos/ListEditors/MultiSelect.aspx");
		driver.manage().window().maximize();

		driver.findElement(By.id("ControlOptionsTopHolder_lbSelectionMode_B-1")).click();

		WebDriverWait explicitWait = new WebDriverWait(driver, 10);
		WebElement element=explicitWait.until(ExpectedConditions.elementToBeClickable(By.id("ControlOptionsTopHolder_lbSelectionMode_DDD_L_LBI1T0")));
	    element.click();

		
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
			       .withTimeout(30, TimeUnit.SECONDS)
			       .pollingEvery(5, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);

		WebElement select = fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id("ContentHolder_lbFeatures_LBT"));
			}
		});
		// Listamos las opciones contenidas en elemento
		List<WebElement> options = select.findElements(By.tagName("td"));

		// Creamos un Actions
		Actions builder = new Actions(driver);

		// Se indica la accion, presionar la tecla Control, y dar click en diversas
		// opciones
		Action multipleSelect = builder.keyDown(Keys.CONTROL).click(options.get(2)).click(options.get(4))
				.click(options.get(6)).build();

		// Ejecutamos la accion
		multipleSelect.perform();
	}

	public void testAlert(WebDriver driver) {
		// Navigate to URL
		driver.navigate().to("http://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
		driver.manage().window().maximize();

		// Nos cambiamos de frame
		driver.switchTo().frame("iframeResult");

		// Buscamos el boton Try it.
		WebElement alertButton = driver.findElement(By.cssSelector("html>body>button"));

		// Damos click en el boton
		alertButton.click();

		// Nos cambiamos a la alerta, y damos click en Accept
		driver.switchTo().alert().accept();
	}

	public void testConfirm(WebDriver driver) {
		// Navigate to URL
		driver.navigate().to("http://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();

		// Nos cambiamos de frame
		driver.switchTo().frame("iframeResult");

		// Buscamos el boton Try it.
		WebElement alertButton = driver.findElement(By.cssSelector("html>body>button"));

		// Damos click en el boton
		alertButton.click();

		// Nos cambiamos a la ventana de confirmacion, y damos click en Accept
		driver.switchTo().alert().accept();

		// Damos click en el boton
		alertButton.click();

		// Nos cambiamos a la ventana de confirmacion, y damos click en Accept
		driver.switchTo().alert().dismiss();

	}

	public void testPrompt(WebDriver driver) {
		// Navigate to URL
		driver.navigate().to("http://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().window().maximize();

		// Nos cambiamos de frame
		driver.switchTo().frame("iframeResult");

		// Buscamos Boton Tryit y damos click
		WebElement promptButton = driver.findElement(By.cssSelector("html>body>button"));
		promptButton.click();

		// Send Enviamos texto al textbox de la alerta.
		driver.switchTo().alert().sendKeys("Hakunamatata");

		// Damos click en accept
		driver.switchTo().alert().accept();
	}

	public void testFrame(WebDriver driver) {

		// Navigate to URL
		driver.navigate().to("http://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().window().maximize();

		// Nos cambiamos de frame por nombre
		driver.switchTo().frame("iframeResult");

		// Nos regresamos a la pagina principal
		driver.switchTo().defaultContent();

		// Nos cambiamos de frame por index
		driver.switchTo().frame(0);

		// Nos regresamos a la pagina principal
		driver.switchTo().defaultContent();

		// Nos cambiamos de frame por Elemento
		WebElement resultFrame = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame("iframeResult");

		// Nos regresamos a la pagina principal
		driver.switchTo().defaultContent();

		// Buscamos Boton Tryit y damos click
		WebElement promptButton = driver.findElement(By.cssSelector("html>body>button"));
		promptButton.click();

		// Send Enviamos texto al textbox de la alerta.
		driver.switchTo().alert().sendKeys("Hakunamatata");

		// Damos click en accept
		driver.switchTo().alert().accept();

	}

}
