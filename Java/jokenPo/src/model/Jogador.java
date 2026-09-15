package model;

public class Jogador {
    // O jogador tem que ter um nome e uma jogada
    // Atributos privados
    private final String nomeJogador;
    private Jogada jogadaAtual;
    private int vitorias;

    // Construtor dos jogadores para receber os parâmetros
    public Jogador(String nomeJogador, Jogada jogadaAtual) {
        // Como o atributo é privado, tem que acessar com o 'this'
        this.nomeJogador = nomeJogador;
        this.jogadaAtual = jogadaAtual;
        this.vitorias = 0;
    }

    // Método get para retornar o valor da variável que está protegida com o private
    public String getNome() {
        return nomeJogador;
    }

    public Jogada getJogada() {
        return jogadaAtual;
    }

    // Método set para definir a nova jogada a cada partida
    public void setJogada(Jogada novaJogada) {
        this.jogadaAtual = novaJogada;
    }

    // Sempre pega o status atual da propriedade sem alterar os valores
    public int getVitorias() {
        return vitorias;
    }

    public void contabilizarVitorias() {
        this.vitorias++;
    }
}
