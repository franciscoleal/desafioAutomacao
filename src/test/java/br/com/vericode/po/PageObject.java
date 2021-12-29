package br.com.vericode.po;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {
	
	protected WebDriver browser;
	
	public PageObject(WebDriver browser) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		if(browser == null) {
			System.out.println("Esta caindo aqui");
			this.browser = new ChromeDriver();
			this.browser.manage().window().maximize();
		} else {
			System.out.println("Deu certo");
			this.browser = browser;
			this.browser.manage().window().maximize();
		}
	}
}
