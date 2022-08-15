package pages;

import org.openqa.selenium.WebDriver;

import utils.DSL;

public class OverviewPage {
	
	private DSL dsl;

	public OverviewPage(WebDriver driver) {
		dsl=new DSL(driver);
	}	
	
	public void validaOverviewPage() throws InterruptedException {
		dsl.validarPorXpath("//span[text() = 'Checkout: Overview']");
	}

}
