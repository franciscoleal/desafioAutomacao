package br.com.vericode.acesso;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;	

public class CadastroTest {

	private CadastroPage paginaDeAcesso;
	private static final String emailValido = "tqqqq@ecallen.com";

	@BeforeEach
	public void beforeEach() {
//		instancio meu page object
//		que carregará o acesso onde se encontra o webdriver do chrome
//		abrirá o navegador
//		e carregará a pagina inicial do site de compras
		this.paginaDeAcesso = new CadastroPage();
	}

	@AfterEach
	public void afterEach() {
//		agora para manipulação do navegador, eu preciso de um método
//		que estará no meu page object
		this.paginaDeAcesso.fecharNavegador();
	}

	@Test
	public void cadastrarNovoUsuario() {

		paginaDeAcesso.navegaPaginaDeAutenticacao();

		paginaDeAcesso.validarEmail(emailValido);

		paginaDeAcesso.criarNovaConta();

		paginaDeAcesso.preencheFormulario(emailValido);

		paginaDeAcesso.registrar();
		
		Assert.assertTrue(paginaDeAcesso.verificaNome());
		
		paginaDeAcesso.navegaAteAHome();
		
		paginaDeAcesso.selecionarProduto();
		
		paginaDeAcesso.verMais();
		
		paginaDeAcesso.adicionarProdutoNoCarrinho();
		
		paginaDeAcesso.fazerCheckOut();
		
		paginaDeAcesso.confirmarResumo();
		
		paginaDeAcesso.confirmarEndereco();
		
		paginaDeAcesso.confirmarEnvio();
		
		paginaDeAcesso.formaDePagamento();
		
		paginaDeAcesso.confirmarPedido();
		
		paginaDeAcesso.printDoPedido();
		
	}
}
