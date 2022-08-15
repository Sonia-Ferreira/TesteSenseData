import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;


public class TesteSenseData{

	private WebDriver driver;
	private LoginPage page;
	private ProdutoPage produto;
	private CheckoutPage checkout;

@Before
public void inicializa() {
		driver = new FirefoxDriver();
//		driver = new ChromeDriver();
//		driver = new InternetExplorerDriver();
		driver.get("https://www.saucedemo.com");
		page = new LoginPage(driver);
		produto = new ProdutoPage(driver);
		checkout = new CheckoutPage(driver);
	}

//1.	Realizar login
@Test
	public void efetuaCompra() {
		page.setNome("standard_user");
		page.setSenha("secret_sauce");
		page.clicaLogin();

//2.	Ordenar os produtos pelo valor (low to high)
		produto.ordenaProdutosPorPreco("Price (low to high)");


//3.	Adicionar os seguintes produtos ao carrinho: Sauce Labs Onesie e Test.allTheThings() T-Shirt (Red)
		produto.selecionaProduto("add-to-cart-sauce-labs-onesie");
		produto.selecionaProduto("add-to-cart-test.allthethings()-t-shirt-(red)");
		produto.clicaCarrinho();
		produto.clicaCheckout();

//4.	Acessar o carrinho e prosseguir para a conclusão da compra.
		checkout.setNome("Maria");
		checkout.setSobrenome("Souza");
		checkout.setCEP("07464-100");
		checkout.clicaContinue();
		checkout.clicaFinish();
		checkout.clicaBackHome();
		
	}
	
}
