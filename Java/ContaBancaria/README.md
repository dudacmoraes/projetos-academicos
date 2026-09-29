# 🏦 Sistema Bancário em Java

Projeto desenvolvido em Java com foco na prática de Programação Orientada a Objetos (POO), encapsulamento, enumerações, coleções (`ArrayList`), organização em camadas e regras de negócio.

## 📋 Descrição

O sistema simula operações básicas de uma conta bancária por meio de uma aplicação executada no terminal.

O usuário pode:

- Abrir uma nova conta;
- Escolher entre conta corrente e conta poupança;
- Entrar em uma conta utilizando seu número;
- Visualizar os dados da conta;
- Realizar depósitos;
- Realizar saques;
- Pagar a mensalidade;
- Encerrar a conta;
- Sair do sistema.

Cada conta possui os seguintes atributos:

- Número da conta;
- Tipo da conta;
- Nome do titular;
- Saldo atual;
- Status da conta;
- Valor da mensalidade.

## 🚀 Tecnologias utilizadas

- Java
- IntelliJ IDEA
- Programação Orientada a Objetos (POO)

## 📂 Estrutura do projeto

```text
src
├── model
│   ├── ContaBanco.java
│   └── TipoConta.java
├── service
│   └── ContaService.java
└── Main.java
