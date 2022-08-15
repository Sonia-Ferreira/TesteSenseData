import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	
	private WebDriver driver;
	

	public DSL(WebDriver driver) {
		this.driver = driver;
	}

	public void escreve(String id_name, String texto) {
		driver.findElement(By.id(id_name)).sendKeys(texto);
	}
	
	public void clicaBotao(String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void selecionaCombo(String id, String valor) {
		WebElement element = driver.findElement(By.className(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	
	public void escrever(String id) {
		driver.findElement(By.className(id)).click();
	}
}
