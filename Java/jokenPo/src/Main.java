import model.Jogada;
import model.Jogador;
import service.JokenpoService;
import java.util.Scanner;

public class Main {
    // Cria o objeto Scanner para ler o teclado
    private static final Scanner input = new Scanner(System.in);

    // Método para controlar os jogadores
    public static Jogador obterJogador() {
        String nome;

        while (true) {
            System.out.print("Nome do jogador: ");
            nome = input.nextLine();

            if (nome.trim().isEmpty()) {
                System.out.println("Entrada inválida!");
            } else {
                nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();

                // Retorna false se for digitado algum número
                boolean verificacaoTexto = nome.matches("[a-zA-ZÀ-ÿ ]+");

                if (!verificacaoTexto) {
                    System.out.println("Entrada inválida!");
                } else {
                    break;
                }
            }
        }
        return new Jogador(nome, null);
    }

    // Método para controlar as jogadas e o while
    public static Jogada obterJogada(String nomeJogador) {
        Jogada jogadaAtual;

        while (true) {
            System.out.printf("Jogada de %s: ", nomeJogador);
            String entrada = input.nextLine();

            if (entrada.trim().isEmpty()) {
                System.out.println("Entrada inválida!");
                continue;
            }

            try {
                jogadaAtual = Jogada.valueOf(entrada.toUpperCase());
                return jogadaAtual;
            } catch (IllegalArgumentException e) {
                System.out.println("Entrada inválida! Digite novamente.");
            }
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("Cadastro do jogador 1");
            Jogador jogador1 = obterJogador();

            System.out.println("Cadastro do jogador 2");
            Jogador jogador2 = obterJogador();

            // Inicializa o JokenpoService
            JokenpoService service = new JokenpoService();

            for (int i = 1; i <= 3; i++) {
                System.out.println("-".repeat(30));
                System.out.printf("%dª rodada\n", i);
                System.out.println("Escolha: PEDRA, PAPEL ou TESOURA");

                // Entrada de dados (jogadas)
                jogador1.setJogada(obterJogada(jogador1.getNome()));
                jogador2.setJogada(obterJogada(jogador2.getNome()));

                service.analisarResultado(jogador1, jogador2);
            }
            service.mostrarPlacar(jogador1, jogador2);
            service.verificarCampeao(jogador1, jogador2);

            System.out.println("\nJogar novamente?\n1- Sim\n2- Não");
            System.out.print("Sua escolha: ");
            int escolha = input.nextInt();
            input.nextLine(); // Para limpar o buffer

            if (escolha == 1) {
                System.out.println("-".repeat(30));
            } else if (escolha == 2) {
                System.out.println("Encerrando o jogo.");
                break;
            } else {
                System.out.println("Escolha inválida!");
            }
        }
    }
}
