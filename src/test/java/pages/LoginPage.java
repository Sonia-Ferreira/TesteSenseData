package pages;
import org.openqa.selenium.WebDriver;

import utils.DSL;


public class LoginPage {

	private DSL dsl;
	
	public LoginPage(WebDriver driver) {
		dsl=new DSL(driver);
	}
	
	public void setNome(String nome) {
		dsl.escreve("user-name", nome);
	}
	
	public void setSenha(String senha) {
		dsl.escreve("password", senha);
	}
	
	public void clicaLogin () {
		dsl.clicaBotao("login-button");
	}
	
	public void clicaCheckout () {
		dsl.clicaBotao("checkout");
	}
	
	public void realizarLogin() {
		setNome("standard_user");
		setSenha("secret_sauce");
		clicaLogin();
	}

}
