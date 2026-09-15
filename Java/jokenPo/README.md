# Jokenpo em Java

Projeto desenvolvido durante meus estudos de Java como desafio proposto pelos desenvolvedores responsáveis pelo meu estágio para praticar conceitos de Programação Orientada a Objetos (POO).

## Funcionalidades

- Cadastro de jogadores
- Escolha de jogadas:
  - PEDRA
  - PAPEL
  - TESOURA
- Validação de entrada do usuário
- Contagem de vitórias
- Exibição de placar
- Definição do campeão ao final da partida

## Estrutura do Projeto

### Model

#### Jogada.java

Enum responsável por representar as jogadas possíveis.

```java
PEDRA
PAPEL
TESOURA
```

#### Jogador.java

Classe responsável por representar um jogador.

Atributos:

- nomeJogador
- jogadaAtual
- vitorias

Métodos principais:

- getNome()
- getJogada()
- setJogada()
- contabilizarVitorias()

### Service

#### JokenpoService.java

Responsável por:

- analisar o resultado das partidas
- atualizar o placar
- exibir o campeão

### Main

Responsável por:

- controlar o fluxo da aplicação
- coletar entradas do usuário
- iniciar as rodadas
- chamar os serviços do jogo

## Conceitos Praticados

- Classes e Objetos
- Encapsulamento
- Getters e Setters
- Construtores
- Enums
- Métodos
- Loops (`for` e `while`)
- Tratamento de exceções (`try/catch`)
- Separação de responsabilidades
- Programação Orientada a Objetos

## Exemplo de Execução

```text
1ª rodada:

Jogada de Jogador 1: pedra
Jogada de Jogador 2: tesoura

Yuri venceu! PEDRA ganha de TESOURA.

--------------------
Jogador: Jogador 1 | Partidas ganhas: 1
Jogador: Jogador 2 | Partidas ganhas: 0
```

## Objetivo

Este projeto foi criado com fins educacionais para praticar os primeiros conceitos de Java e Programação Orientada a Objetos.
