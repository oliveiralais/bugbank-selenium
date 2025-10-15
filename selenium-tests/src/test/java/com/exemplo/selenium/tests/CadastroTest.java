package com.exemplo.selenium.tests;

import com.exemplo.selenium.pages.CadastroPage;
import com.exemplo.selenium.pages.LoginPage;
import com.exemplo.selenium.utils.DriverFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CadastroTest {

    static WebDriver driver;
    static LoginPage loginPage;
    static CadastroPage cadastroPage;

    @BeforeAll
    public static void setup() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        cadastroPage = new CadastroPage(driver);
    }

    @Test
    public void cadastroValido_deveDarSucesso() throws IOException{

        String email = "teste" + System.currentTimeMillis() + "@gmail.com";
        String senha = "senha123";

        loginPage.acessarPagina();
        loginPage.irParaRegistro();
        cadastroPage.preencherEmail(email);
        cadastroPage.preencherNome("Teste Automação");
        cadastroPage.preencherSenha(senha);
        cadastroPage.confirmarSenha(senha);
        cadastroPage.clicarRegistrar();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement modalText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalText")));
        String mensagem = modalText.getText();
        
        System.out.println("Mensagem exibida: " + mensagem);
        assertTrue(mensagem.contains("foi criada com sucesso"), "Erro!");

        cadastroPage.fecharModal();

        // Salvar dados do usuário em um arquivo temporário
        try (FileWriter writer = new FileWriter("src/main/java/com/exemplo/selenium/utils/usuario_teste.txt")) {
            writer.write(email + ";" + senha);
        }
    }

    @AfterAll
    public static void tearDown() {
        DriverFactory.killDriver();
    }
}
