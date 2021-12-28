package br.com.vericode.acesso;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AcessoPage {

	private static final String URL_ACESSO = "http://automationpractice.com/index.php";
	private WebDriver browser;

	public AcessoPage() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		this.browser = new ChromeDriver();
		this.browser.navigate().to(URL_ACESSO);
	}

	public void fecharNavegador() {
		this.browser.quit();
	}

	public void validarEmail(String emailValido) {
		browser.findElement(By.id("email_create")).clear();
		browser.findElement(By.id("email_create")).sendKeys(emailValido);;
//		WebElement element = browser.findElement(By.id("email_create"));
//		element.sendKeys(emailValido);
//		element.sendKeys(Keys.TAB);
	}

	public void criarNovaConta() {
		browser.findElement(By.id("SubmitCreate")).submit();
	}

	public void navegaPaginaDeAutenticacao() {
		browser.findElement(By.linkText("Sign in")).click();
	}

	public void preencheFormulario(String emailValido) {

//		browser.findElement(By.id("id_gender1")).click();

		browser.findElement(By.id("customer_firstname")).sendKeys("José Roberto");
		browser.findElement(By.id("customer_lastname")).sendKeys("Da Silva");

		browser.findElement(By.id("email")).clear();
		browser.findElement(By.id("email")).sendKeys(emailValido);

		browser.findElement(By.id("passwd")).sendKeys("ds23jr");

		WebElement elementDays = browser.findElement(By.id("days"));
		Select comboDays = new Select(elementDays);
		comboDays.selectByVisibleText("13  ");

		WebElement elementMonths = browser.findElement(By.id("months"));
		Select comboMonths = new Select(elementMonths);
		comboMonths.selectByVisibleText("January ");

		WebElement elementYears = browser.findElement(By.id("years"));
		Select comboYears = new Select(elementYears);
		comboYears.selectByVisibleText("1979  ");

		browser.findElement(By.id("firstname")).clear();
		browser.findElement(By.id("firstname")).sendKeys("José Roberto");

		browser.findElement(By.id("lastname")).clear();
		browser.findElement(By.id("lastname")).sendKeys("Da Silva");

		browser.findElement(By.id("address1")).sendKeys("Abington Lane");

		browser.findElement(By.id("city")).sendKeys("Dearborn");

		WebElement elementState = browser.findElement(By.id("id_state"));
		Select comboState = new Select(elementState);
		comboState.selectByVisibleText("Michigan");

		browser.findElement(By.id("postcode")).sendKeys("48124");

		WebElement elementCountry = browser.findElement(By.id("id_country"));
		Select comboCountry = new Select(elementCountry);
		comboCountry.selectByVisibleText("United States");

		browser.findElement(By.id("phone_mobile")).sendKeys("12981505071");

		browser.findElement(By.id("alias")).clear();
		browser.findElement(By.id("alias")).sendKeys("Appoline");

	}

	public void registrar() {
		browser.findElement(By.id("submitAccount")).submit();
	}
}
