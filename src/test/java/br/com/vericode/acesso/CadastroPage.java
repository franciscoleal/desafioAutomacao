package br.com.vericode.acesso;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.com.vericode.po.PageObject;

public class CadastroPage extends PageObject {

	private static final String URL_ACESSO = "http://automationpractice.com/index.php";
	

	public CadastroPage() {
		super(null);
		this.browser.navigate().to(URL_ACESSO);
	}

	public void fecharNavegador() {
		this.browser.quit();
	}

	public void validarEmail(String emailValido) {
		browser.findElement(By.id("email_create")).clear();
		browser.findElement(By.id("email_create")).sendKeys(emailValido);;
	}

	public void criarNovaConta() {
		browser.findElement(By.id("SubmitCreate")).click();
	}

	public void navegaPaginaDeAutenticacao() {
		browser.findElement(By.linkText("Sign in")).click();
	}

	public void preencheFormulario(String emailValido) {

		browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
		browser.findElement(By.id("submitAccount")).click();
	}

	public boolean verificaNome() {
		browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return browser.getPageSource().contains("José Roberto Da Silva");
	}

	public void navegaAteAHome() {
		browser.findElement(By.linkText("Home")).click();
	}

	public void selecionarProduto() {
		browser.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[2]")).click();
	}
	
	public void verMais() {
		browser.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[2]/div/div[2]/div[2]/a[2]")).click();
	}

	public void adicionarProdutoNoCarrinho() {
		browser.findElement(By.name("Submit")).click();
	}

	public void fazerCheckOut() {
		browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		browser.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();
	}

	public void confirmarResumo() {
		browser.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();
	}

	public void confirmarEndereco() {
		browser.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button")).click();
	}

	public void confirmarEnvio() {
		browser.findElement(By.id("cgv")).click();
		browser.findElement(By.xpath("//*[@id=\"form\"]/p/button")).click();
	}

	public void formaDePagamento() {
		browser.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")).click();		
	}

	public void confirmarPedido() {
		browser.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();
	}

	public void printDoPedido() {
		try {
			browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			File teste = ((TakesScreenshot)browser).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(teste, new File("./ScreenShot_folder/Test.png"));
		} catch (IOException e) {
			System.out.println("Failed to capture screenshot: " + e.getMessage());
		}
	}
}
