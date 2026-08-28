import model.Jogada;
import model.Jogador;
import service.JokenpoService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Cadastro do jogador 1");
        Jogador jogador1 = obterJogador();

        System.out.println("Cadastro do jogador 2");
        Jogador jogador2 = obterJogador();

        // Inicializar o service
        JokenpoService service = new JokenpoService();

        for (int i = 1; i < 4; i++) {
            System.out.println("-".repeat(20));
            System.out.printf("%dª rodada:\n", i);
            System.out.println("Escolha: PEDRA, PAPEL ou TESOURA");

            // Entrada de dados (jogadas)
            jogador1.setJogada(obterJogada(jogador1.getNome()));
            jogador2.setJogada(obterJogada(jogador2.getNome()));

            service.analisarResultado(jogador1, jogador2);
        }

        service.mostrarPlacar(jogador1, jogador2);
        service.verificarCampeao(jogador1, jogador2);
    }

    // Method para controlar os jogadores
    public static Jogador obterJogador() {
        // Cria o objeto Scanner para ler o teclado
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do jogador: ");
        String nome = scanner.nextLine();

        nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();

        return new Jogador(nome, null);
    }

    // Method para controlar as jogadas e o while
    public static Jogada obterJogada(String nomeJogador) {
        // Cria o objeto Scanner para ler o teclado
        Scanner scanner = new Scanner(System.in);
        Jogada jogada = null;

        while (jogada == null) {

            System.out.printf("Jogada de %s: ", nomeJogador);
            String input = scanner.nextLine();
            try {
                jogada = Jogada.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Valor invalido, digite novamente");
            }
        }
        return jogada;
    }
}
