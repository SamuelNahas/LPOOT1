import java.util.Scanner;

public class RPGGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando armas
        ArmaMago magiaTransmutacao = new Transmutacao();
        ArmaMago psiKappa = new Psikappa();
        ArmaPaladino espada = new Espada();
        ArmaPaladino lanca = new Lanca();
        ArmaClerigo martelo = new Martelo();
        ArmaClerigo maca = new Maca();

        // Criação dos personagens com base na entrada do usuário
        Personagem personagem1 = PersonagemFactory.criarPersonagem(scanner, magiaTransmutacao, psiKappa, espada, lanca, martelo, maca);
        Personagem personagem2 = PersonagemFactory.criarPersonagem(scanner, magiaTransmutacao, psiKappa, espada, lanca, martelo, maca);

        // Exibindo os personagens criados
        personagem1.printStatus();
        personagem2.printStatus();

        // Loop para a sequência de ataques
        while (true) {
            int atacante = scanner.nextInt();
            if (atacante == 0) {
                break;
            }
            int defensor = scanner.nextInt();

            if (atacante == 1 && defensor == 2) {
                personagem1.atacar(personagem2);
            } else if (atacante == 2 && defensor == 1) {
                personagem2.atacar(personagem1);
            }
        }

        scanner.close();
    }
}
