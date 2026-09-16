import model.Campeao;
import service.BatalhaService;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Cria o scanner
    static Scanner scanner = new Scanner(System.in);

    public static void linha() {
        System.out.println("-".repeat(50));
    }

    public static void main(String[] args) {
        Campeao scorpion = new Campeao(1, "Scorpion", 120, 70, 10);
        Campeao subzero = new Campeao(2, "Subzero", 130, 65, 10);
        Campeao liuKang = new Campeao(3, "Liu Kang", 90, 60, 5);
        Campeao raiden = new Campeao(4, "Raiden", 100, 75, 15);
        Campeao johnnyCage = new Campeao(5, "Johnny Cage", 80, 40, 15);
        Campeao sonyaBlade = new Campeao(6, "Sonya Blade", 125, 45, 20);

        //Array list com os campeões
        ArrayList<Campeao> listaCampeoes = new ArrayList<>();

        // Inicializa o service
        BatalhaService service = new BatalhaService();

        listaCampeoes.add(scorpion);
        listaCampeoes.add(subzero);
        listaCampeoes.add(liuKang);
        listaCampeoes.add(raiden);
        listaCampeoes.add(johnnyCage);
        listaCampeoes.add(sonyaBlade);

        while (true) {
            linha();
            mostrarCampeao(listaCampeoes);
            linha();

            System.out.println("Jogador 1");
            Campeao jogador1 = escolhaCampeao(listaCampeoes);

            System.out.println("Jogador 2");
            Campeao jogador2 = escolhaCampeao(listaCampeoes);
            linha();

            if (jogador1 == jogador2) {
                System.out.println("Erro! Os jogadores não podem escolher o mesmo campeão.");
                continue;
            }

            System.out.println("Campeões escolhidos:");
            System.out.printf("Jogador 1: %s\n", jogador1.getNomeCampeao());
            System.out.printf("Jogador 2: %s\n", jogador2.getNomeCampeao());
            linha();

            service.iniciarBatalha(jogador1, jogador2);
            service.verificarVencedor(jogador1, jogador2);
            break;
        }
    }

    public static void mostrarCampeao(ArrayList<Campeao> listaCampeoes) {
        for (Campeao campeao : listaCampeoes) {
            System.out.println(campeao);
        }
    }

    public static Campeao escolhaCampeao(ArrayList<Campeao> listaCampeoes) {
        int identificadorCampeao;

        while (true) {
            System.out.print("Escolha seu campeão: ");
            String entrada = scanner.nextLine();

            if (entrada.trim().isEmpty()) {
                System.out.println("Entrada inválida!");
                continue;
            }
            try {
                identificadorCampeao = Integer.parseInt(entrada);
                for (Campeao campeao : listaCampeoes) {
                    if (campeao.getIdentificadorCampeao() == identificadorCampeao) {
                        return campeao;
                    }
                }
                System.out.println("Escolha inválida! Escolha entre 1 e 6.");
            } catch (NumberFormatException erro) {
                System.out.println("Entrada inválida!");
            }
        }
    }
}
