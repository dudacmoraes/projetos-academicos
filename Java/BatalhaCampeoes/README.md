## 🥊 Batalha de Campeões

Projeto desenvolvido em Java com foco na prática de Programação Orientada a Objetos (POO), encapsulamento, coleções (ArrayList), organização em camadas e regras de negócio.

## 📋 Descrição

O sistema permite que dois jogadores escolham campeões de uma lista pré-definida e realizem uma batalha por turnos.

Cada campeão possui atributos próprios de:

Vida
Ataque
Defesa

Durante a batalha:

Os campeões atacam alternadamente;
O dano causado considera o valor de defesa do oponente;
Existe um evento especial com chance aleatória de cura;
A batalha termina quando um dos campeões perde toda a vida.

## 🚀 Tecnologias utilizadas
Java
IntelliJ IDEA
Programação Orientada a Objetos (POO)

## 📂 Estrutura do projeto
src
├── model
│   └── Campeao.java
├── service
│   └── BatalhaService.java
└── Main.java

model

Responsável pelas entidades do sistema.

Campeao

Representa um campeão disponível para batalha.

Atributos:

Identificador
Nome
Vida
Ataque
Defesa

Métodos principais:

estaVivo()
defender()
getAtaque()
getVida()
toString()
service

Responsável pelas regras de negócio da batalha.

BatalhaService

Métodos principais:

iniciarBatalha()
executarAtaque()
mostrarVida()
eventoEspecial()
verificarVencedor()
Main

Responsável por:

Exibir os campeões disponíveis;
Validar entradas do usuário;
Selecionar os campeões;
Iniciar a batalha.

## 🎮 Campeões disponíveis
ID	Campeão	Vida	Ataque	Defesa1	Scorpion	120	70	10
2	Subzero	130	65	10
3	Liu Kang	90	60	5
4	Raiden	100	75	15
5	Johnny Cage	80	40	15
6	Sonya Blade	125	45	20

## ⚔️ Regras da batalha
Cada jogador escolhe um campeão.
Dois jogadores não podem escolher o mesmo campeão.
O campeão atacante causa dano considerando a defesa do oponente.
O dano mínimo causado é igual a 1.
Após cada ataque, a vida restante é exibida.
Existe uma chance aleatória de ativação do evento especial.
O evento especial recupera 10% da vida atual do campeão.
A batalha termina quando um dos campeões perde toda a vida.

## 📸 Exemplo de execução
--------------------------------------------------

Jogador 1
Escolha seu campeão: 1

Jogador 2
Escolha seu campeão: 2

--------------------------------------------------

Campeões escolhidos:

Jogador 1: Scorpion
Jogador 2: Subzero

--------------------------------------------------

Round 1... FIGHT!

Scorpion atacou Subzero
Vida restante de Subzero: 70

Subzero atacou Scorpion
Vida restante de Scorpion: 65

--------------------------------------------------
## 
