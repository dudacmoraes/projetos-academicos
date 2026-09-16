package service;
import model.Campeao;
import java.util.Random;

public class BatalhaService {
    Random random = new Random();

    public void iniciarBatalha(Campeao jogador1, Campeao jogador2) {
        int i = 1;

        while (jogador1.estaVivo() && jogador2.estaVivo()) {
            System.out.printf("Round %d... FIGHT!\n", i++);
            executarAtaque(jogador1, jogador2);
            if (jogador2.estaVivo()) {
                mostrarVida(jogador2);
                eventoEspecial(jogador2);
                linha();
            } else {
                System.out.printf("%s está morto...\n", jogador2.getNomeCampeao());
                linha();
                break;
            }

            executarAtaque(jogador2, jogador1);
            if (jogador1.estaVivo()) {
                mostrarVida(jogador1);
                eventoEspecial(jogador1);
                linha();
            } else {
                System.out.printf("%s está morto...\n", jogador1.getNomeCampeao());
                linha();
                break;
            }
        }
    }

    public void executarAtaque(Campeao atacante, Campeao defensor) {
        defensor.defender(atacante.getAtaque());
        System.out.printf("%s atacou %s\n", atacante.getNomeCampeao(), defensor.getNomeCampeao());
    }

    public void mostrarVida(Campeao defensor) {
        System.out.printf("Vida restante de %s: %d\n", defensor.getNomeCampeao(), defensor.getVida());
    }

    public void eventoEspecial(Campeao jogador) {
        boolean eventoEspecial = random.nextBoolean();
        if (eventoEspecial) {
            jogador.setVida(0.10);
            System.out.println(" ");
            System.out.println("EVENTO ESPECIAL!");
            System.out.printf("%s recuperou 10%% de sua vida!\n", jogador.getNomeCampeao());
        }
    }

    public void verificarVencedor(Campeao jogador1, Campeao jogador2) {
        if (jogador1.estaVivo()) {
            System.out.printf("%s wins!", jogador1.getNomeCampeao());
            return;
        }
        System.out.printf("%s wins!", jogador2.getNomeCampeao());
    }

    public void linha() {
        System.out.println("-".repeat(50));
    }
}
