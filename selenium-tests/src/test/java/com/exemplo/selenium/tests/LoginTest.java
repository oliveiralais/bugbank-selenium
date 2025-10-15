package com.exemplo.selenium.tests;

import com.exemplo.selenium.pages.LoginPage;
import com.exemplo.selenium.utils.DriverFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest {

    static WebDriver driver;
    static LoginPage loginPage;

    @BeforeAll
    public static void setup() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    @Order(1)
    public void loginValido() throws IOException {
        loginPage.acessarPagina();

        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/com/exemplo/selenium/utils/usuario_teste.txt"));
        String[] dados = reader.readLine().split(";");
        String email = dados[0];
        String senha = dados[1];
        reader.close();

        loginPage.preencherEmail(email);
        loginPage.preencherSenha(senha);
        loginPage.clicarLogin();
    }

    @Test
    @Order(2)
    public void loginInvalido() {
        loginPage.acessarPagina();
        loginPage.preencherEmail("email@invalido.com");
        loginPage.preencherSenha("senhaerrada");
        loginPage.clicarLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement modalText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalText")));
        String mensagem = modalText.getText();
        
        System.out.println("Mensagem exibida: " + mensagem);
        assertTrue(mensagem.contains("Usuário ou senha inválido."), "Erro esperado não apareceu");
    }

    @AfterAll
    public static void tearDown() {
        DriverFactory.killDriver();
    }
}
