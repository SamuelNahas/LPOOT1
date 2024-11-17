import java.util.Scanner;

public class PersonagemFactory {
    public static Personagem criarPersonagem(
            Scanner scanner,
            ArmaMago magiaTransmutacao,
            ArmaMago psiKappa,
            ArmaPaladino espada,
            ArmaPaladino lanca,
            ArmaClerigo martelo,
            ArmaClerigo maca) {

        int tipoPersonagem = solicitarOpcaoValida(scanner, 1, 3);
        double saude = solicitarAtributoValido(scanner);
        double forca = solicitarAtributoValido(scanner);
        double destreza = solicitarAtributoValido(scanner);

        return switch (tipoPersonagem) {
            case 1 -> new Mago(saude, forca, destreza, escolherArmaMago(scanner, magiaTransmutacao, psiKappa));
            case 2 -> new Paladino(saude, forca, destreza, escolherArmaPaladino(scanner, espada, lanca));
            case 3 -> new Clerigo(saude, forca, destreza, escolherArmaClerigo(scanner, martelo, maca));
            default -> throw new IllegalStateException("Tipo de personagem inválido.");
        };
    }

    private static double solicitarAtributoValido(Scanner scanner) {
        double valor;
        do {
            valor = scanner.nextDouble();
            if (valor < 0 || valor > 10) {
                System.out.println("Valor inválido! Deve estar entre 0 e 10.");
            }
        } while (valor < 0 || valor > 10);
        return valor;
    }

    private static int solicitarOpcaoValida(Scanner scanner, int min, int max) {
        int opcao;
        do {
            opcao = scanner.nextInt();
            if (opcao < min || opcao > max) {
                System.out.println("Opção inválida! Escolha entre " + min + " e " + max + ".");
            }
        } while (opcao < min || opcao > max);
        return opcao;
    }

    private static ArmaMago escolherArmaMago(Scanner scanner, ArmaMago magiaTransmutacao, ArmaMago psiKappa) {
        int escolha = solicitarOpcaoValida(scanner, 1, 2);
        return (escolha == 1) ? magiaTransmutacao : psiKappa;
    }

    private static ArmaPaladino escolherArmaPaladino(Scanner scanner, ArmaPaladino espada, ArmaPaladino lanca) {
        int escolha = solicitarOpcaoValida(scanner, 1, 2);
        return (escolha == 1) ? espada : lanca;
    }

    private static ArmaClerigo escolherArmaClerigo(Scanner scanner, ArmaClerigo martelo, ArmaClerigo maca) {
        int escolha = solicitarOpcaoValida(scanner, 1, 2);
        return (escolha == 1) ? martelo : maca;
    }
}
