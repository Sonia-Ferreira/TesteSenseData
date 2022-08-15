package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.OverviewPage;
import pages.ProdutoPage;


public class TesteSenseData{

	private WebDriver driver;
	private LoginPage page;
	private ProdutoPage produto;
	private CheckoutPage checkout;
	private CartPage cart;
	private OverviewPage overview;

@Before
public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		page = new LoginPage(driver);
		produto = new ProdutoPage(driver);
		checkout = new CheckoutPage(driver);
		cart = new CartPage(driver);
		overview = new OverviewPage(driver);
	}

//1.	Realizar login
@Test
	public void efetuaCompra() throws InterruptedException {
		page.realizarLogin();
		produto.validarProdutoPage();

//2.	Ordenar os produtos pelo valor (low to high)
		produto.ordenaProdutosPorPreco("Price (low to high)");


//3.	Adicionar os seguintes produtos ao carrinho: Sauce Labs Onesie e Test.allTheThings() T-Shirt (Red)
		produto.selecionaProduto("add-to-cart-sauce-labs-onesie");
		produto.selecionaProduto("add-to-cart-test.allthethings()-t-shirt-(red)");
		produto.clicaCarrinho();
		cart.validarCarrinhoPage();
		cart.validaItensCarrinho();
		cart.clicaCheckout();

//4.	Acessar o carrinho e prosseguir para a conclus�o da compra.
		checkout.validaCheckoutPage();
		checkout.setNome("Maria");
		checkout.setSobrenome("Souza");
		checkout.setCEP("07464-100");
		checkout.clicaContinue();
		overview.validaOverviewPage();
		checkout.clicaFinish();
		checkout.validaCheckoutComplete();
		
	}

	@After
	public void finalizar() {
		driver.close();
	}
	
}
