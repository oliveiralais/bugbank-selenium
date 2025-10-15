package com.exemplo.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By campoEmail = By.name("email");
    private By campoSenha = By.name("password");  
    private By botaoLogin = By.xpath("//button[contains(text(), 'Acessar')]");
    private By botaoRegistrar = By.xpath("//button[contains(text(), \"Registrar\")]");
    //private By mensagemErro = By.cssSelector(".error");  // exemplo

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void acessarPagina() {
        driver.get("https://bugbank.netlify.app/");
    }

    public void preencherEmail(String email) {
        driver.findElement(campoEmail).sendKeys(email);
    }

    public void preencherSenha(String senha) {
        driver.findElement(campoSenha).sendKeys(senha);
    }

    public void clicarLogin() {
        driver.findElement(botaoLogin).click();
    }

    public void irParaRegistro() {
        driver.findElement(botaoRegistrar).click();
    }
}
