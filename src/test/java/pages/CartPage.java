package pages;

import org.openqa.selenium.WebDriver;

import utils.DSL;


public class CartPage {
	private DSL dsl;
	
	public CartPage (WebDriver driver) {
		dsl=new DSL(driver);
	}
	
	public void validarCarrinhoPage() throws InterruptedException {
		dsl.validarPorXpath("//span[text() = 'Your Cart']");
	}
	
	public void clicaCheckout() {
		dsl.clicaBotao("checkout");
	}

	public void validaItensCarrinho() throws InterruptedException {
		dsl.validarPorXpath("//div[text() = 'Sauce Labs Onesie']");
		dsl.validarPorXpath("//div[text() = 'Test.allTheThings() T-Shirt (Red)']");
	}
}
