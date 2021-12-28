package br.com.vericode.acesso;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Acesso {

	private AcessoPage paginaDeAcesso;
	private static final String emailValido = "testandols@ecallen.com";

	@BeforeEach
	public void beforeEach() {
//		instancio meu page object
//		que carregar� o acesso onde se encontra o webdriver do chrome
//		abrir� o navegador
//		e carregar� a pagina inicial do site de compras
		this.paginaDeAcesso = new AcessoPage();
	}

	@AfterEach
	public void afterEach() {
//		agora para manipula��o do navegador, eu preciso de um m�todo
//		que estar� no meu page object
//		this.paginaDeAcesso.fecharNavegador();
	}

	@Test
	public void cadastrarNovoUsuario() throws InterruptedException {

		paginaDeAcesso.navegaPaginaDeAutenticacao();

		paginaDeAcesso.validarEmail(emailValido);

		paginaDeAcesso.criarNovaConta();

		Thread.sleep(10000);

		paginaDeAcesso.preencheFormulario(emailValido);

		Thread.sleep(20000);

		paginaDeAcesso.registrar();
	}
}
