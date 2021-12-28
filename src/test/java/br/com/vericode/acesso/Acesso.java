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
//		que carregará o acesso onde se encontra o webdriver do chrome
//		abrirá o navegador
//		e carregará a pagina inicial do site de compras
		this.paginaDeAcesso = new AcessoPage();
	}

	@AfterEach
	public void afterEach() {
//		agora para manipulação do navegador, eu preciso de um método
//		que estará no meu page object
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
