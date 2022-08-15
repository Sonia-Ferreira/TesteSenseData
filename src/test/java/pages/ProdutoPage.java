package pages;
import org.openqa.selenium.WebDriver;

import utils.DSL;

public class ProdutoPage {

private DSL dsl;
	
	public ProdutoPage(WebDriver driver) {
		dsl=new DSL(driver);
	}
	
	public void ordenaProdutosPorPreco(String preco) {
		dsl.selecionaCombo("product_sort_container", preco);
	}
	
	public void selecionaProduto (String produto) {
		dsl.clicaBotao(produto);
	}
	
	public void clicaCarrinho () {
		dsl.escrever("shopping_cart_link");
	}
	

	
	public void validarProdutoPage() throws InterruptedException {
		dsl.validarPorXpath("//span[text() = 'Products']");
	}

}
