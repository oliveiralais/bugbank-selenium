# Testes Automatizados com Selenium — BugBank
[![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?logo=openjdk&logoColor=white)](#)
[![Selenium](https://img.shields.io/badge/Selenium-43B02A?logo=selenium&logoColor=fff)](#)
[![JUnit5](https://img.shields.io/badge/JUnit5-C21325?logo=junit5&logoColor=fff)](#)

Este projeto tem como objetivo automatizar os testes funcionais do site **[BugBank](https://bugbank.netlify.app/)** — uma aplicação que simula um banco digital com funcionalidades de **cadastro, login e movimentações bancárias**.  

A automação foi desenvolvida utilizando **Selenium WebDriver** com **Java** e **JUnit**, seguindo o padrão **Page Object Model (POM)** para garantir uma estrutura organizada, reutilizável e de fácil manutenção.

---

## 🚀 Funcionalidades testadas
- **Cadastro de novo usuário:** valida o fluxo completo de criação de conta, incluindo o recebimento da mensagem de sucesso no modal.  
- **Login de usuário:** realiza autenticação com credenciais válidas e verifica o acesso à página inicial.  
- **Fluxo integrado:** executa o cadastro e, em seguida, utiliza os mesmos dados para login (armazenando as informações localmente).  

---

## 🧩 Tecnologias utilizadas
- **Java 17+**
- **Selenium WebDriver**
- **JUnit 5**
- **Apache Maven**
- **Page Object Model (POM)**
