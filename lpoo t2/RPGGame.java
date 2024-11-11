import java.util.Scanner;

public class RPGGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando armas
        Arma magiaTransmutacao = new Arma("Magia da Transmutação", 0.25);
        Arma psiKappa = new Arma("Psi-kappa", 0.5);
        Arma espada = new Arma("Espada", 0.3);
        Arma lanca = new Arma("Lança", 0.5);
        Arma martelo = new Arma("Martelo", 0.6);


        Arma maca = new Arma("Maça", 0.4);

        // Criação dos personagens com base na entrada do usuário
        System.out.println("Criação do primeiro personagem: ");
        Personagem personagem1 = PersonagemFactory.criarPersonagem(scanner, magiaTransmutacao, psiKappa, espada, lanca, martelo, maca);

        System.out.println("Criação do segundo personagem: ");
        Personagem personagem2 = PersonagemFactory.criarPersonagem(scanner, magiaTransmutacao, psiKappa, espada, lanca, martelo, maca);

        // Exibindo os personagens criados
        System.out.println(personagem1);
        System.out.println(personagem2);

        // Loop para a sequência de ataques
        while (true) {
            System.out.println("Informe o ataque no formato: <atacante> <defensor>, ou 0 para sair:");
            int atacante = scanner.nextInt();
            if (atacante == 0) {
                System.out.println("Fim da batalha.");
                break;
            }
            int defensor = scanner.nextInt();

            if (atacante == 1 && defensor == 2) {
                personagem1.atacar(personagem2);
            } else if (atacante == 2 && defensor == 1) {
                personagem2.atacar(personagem1);
            } else {
                System.out.println("Opção inválida! Use 1 ou 2 para os personagens.");
            }
        }

        scanner.close();
    }
}
