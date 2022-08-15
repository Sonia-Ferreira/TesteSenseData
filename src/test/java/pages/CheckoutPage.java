package pages;
import org.openqa.selenium.WebDriver;

import utils.DSL;


public class CheckoutPage {
	
	private DSL dsl;

	public CheckoutPage (WebDriver driver) {
		dsl=new DSL(driver);
	}

	public void setNome(String nome) {
		dsl.escreve("first-name",nome);
	}
	
	public void setSobrenome(String sobrenome) {
		dsl.escreve("last-name", sobrenome);
	}
	
	public void setCEP(String CEP) {
		dsl.escreve("postal-code",CEP);
	}
	
	public void clicaContinue () {
		dsl.clicaBotao("continue");
	}
	
	public void clicaFinish() {
		dsl.clicaBotao("finish");
	}
	
	public void validaCheckoutPage() throws InterruptedException {
		dsl.validarPorXpath("//span[text() = 'Checkout: Your Information']");
	}

	public void validaCheckoutComplete() throws InterruptedException {
		dsl.validarPorXpath("//span[text() = 'Checkout: Complete!']");
	}
}
