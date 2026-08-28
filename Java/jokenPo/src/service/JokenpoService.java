package service;
import model.Jogada;
import model.Jogador;

public class JokenpoService {

    public void analisarResultado(Jogador jogador1, Jogador jogador2) {
        if (jogador1.getJogada() == jogador2.getJogada()) {
            System.out.print("Empate!\n");
        }
        else if (jogador1.getJogada() == Jogada.PAPEL && jogador2.getJogada() == Jogada.PEDRA) {
            System.out.printf("%s venceu! PAPEL ganha de PEDRA.\n", jogador1.getNome());
            jogador1.contabilizarVitorias();
        }

        else if (jogador1.getJogada() == Jogada.PAPEL && jogador2.getJogada() == Jogada.TESOURA) {
            System.out.printf("%s venceu! TESOURA ganha de PAPEL.\n", jogador2.getNome());
            jogador2.contabilizarVitorias();
        }

        else if (jogador1.getJogada() == Jogada.PEDRA && jogador2.getJogada() == Jogada.PAPEL) {
            System.out.printf("%s venceu! PAPEL ganha de PEDRA.\n", jogador2.getNome());
            jogador2.contabilizarVitorias();
        }

        else if (jogador1.getJogada() == Jogada.PEDRA && jogador2.getJogada() == Jogada.TESOURA) {
            System.out.printf("%s venceu! PEDRA ganha de TESOURA.\n", jogador1.getNome());
            jogador1.contabilizarVitorias();
        }

        else if (jogador1.getJogada() == Jogada.TESOURA && jogador2.getJogada() == Jogada.PEDRA) {
            System.out.printf("%s venceu! PEDRA ganha de TESOURA.\n", jogador2.getNome());
            jogador2.contabilizarVitorias();
        }

        else if (jogador1.getJogada() == Jogada.TESOURA && jogador2.getJogada() == Jogada.PAPEL) {
            System.out.printf("%s venceu! TESOURA ganha de PAPEL.\n", jogador1.getNome());
            jogador1.contabilizarVitorias();
        }
        else {
            System.out.println(" ");
        }
    }

    public void mostrarPlacar(Jogador jogador1, Jogador jogador2) {
        System.out.println("-".repeat(30));
        System.out.printf("Jogador: %s | Partidas ganhas: %d\n", jogador1.getNome(), jogador1.getVitorias());
        System.out.printf("Jogador: %s | Partidas ganhas: %d\n", jogador2.getNome(), jogador2.getVitorias());
    }

    public void verificarCampeao(Jogador jogador1, Jogador jogador2) {
        System.out.println("-".repeat(30));

        if (jogador1.getVitorias() > jogador2.getVitorias()) {
            System.out.printf("Vitória de %s", jogador1.getNome());
        } else if (jogador2.getVitorias() > jogador1.getVitorias()) {
            System.out.printf("Vitória de %s", jogador2.getNome());
        } else {
            System.out.println("Empate! Ninguém venceu.");
        }
    }
}
