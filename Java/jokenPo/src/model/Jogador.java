package model;

public class Jogador {
    // O jogador tem que ter um nome e uma jogada
    // Atributos privados
    private String nomeJogador;
    private Jogada jogadaAtual;
    private int vitorias;

    // Construtor dos jogadores para receber os parâmetros
    public Jogador(String nomeJogador, Jogada jogadaAtual) {
        // Como o atributo é privado, tem que acessar com o 'this'
        this.nomeJogador = nomeJogador;
        this.jogadaAtual = jogadaAtual;
        this.vitorias = 0;
    }

    // Retorna o valor de uma variável que está protegida com o private
    public String getNome() {
        return nomeJogador;
    }

    // Method get para retornar o valor da variável protegida com private
    public Jogada getJogada() {
        return jogadaAtual;
    }

    // Metohd set para definir a nova jogada a cada partida
    public void setJogada(Jogada jogadaAtual) {
        this.jogadaAtual = jogadaAtual;
    }

    // Method get para retornar o valor da variável protegida com private
    public int getVitorias() { //Sempre pega o status atual da propriedade sem alterar os valores
        return vitorias;
    }

    public void contabilizarVitorias() {
        this.vitorias++;
    }
}
