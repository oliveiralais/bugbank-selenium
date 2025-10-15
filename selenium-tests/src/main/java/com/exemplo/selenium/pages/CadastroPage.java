package com.exemplo.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroPage {
    private WebDriver driver;

    // uso do By.xpath justificado por existir mais de um campo email com o mesmo name e classname (o mesmo se aplica ao campo senha)
    private By campoEmail = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/input");
    private By campoNome = By.name("name");  
    private By campoSenha = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/div/input");
    private By confirmarSenha = By.name("passwordConfirmation");
    private By botaoRegistrar = By.xpath("//button[contains(text(), 'Cadastrar')]");
    private By mensagemSucesso = By.xpath("//*[@id=\"modalText\"]");

    public CadastroPage(WebDriver driver) {
        this.driver = driver;
    }

    public void preencherNome(String nome) {
        driver.findElement(campoNome).sendKeys(nome);

    }

    public void preencherEmail(String email) {
        driver.findElement(campoEmail).sendKeys(email);
    }

    public void preencherSenha(String senha) {
        driver.findElement(campoSenha).sendKeys(senha);
    }

     public void confirmarSenha(String senha) {
        driver.findElement(confirmarSenha).sendKeys(senha);
    }

    public void clicarRegistrar() {
        driver.findElement(botaoRegistrar).click();
    }

    public String obterMensagemSucesso() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        System.out.println("driver.findElement(mensagemSucesso).getText()");
        return driver.findElement(mensagemSucesso).getText();
    }

    public void fecharModal() {
        driver.findElement(By.id("btnCloseModal")).click();
    }
}
