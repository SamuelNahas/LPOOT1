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

        int tipoPersonagem = solicitarOpcaoValida(scanner,
                "Escolha o personagem: 1 para Mago, 2 para Paladino, 3 para Clérigo",
                1, 3);

        double saude = solicitarAtributoValido(scanner, "Informe a saúde do personagem (0 a 10):");
        double forca = solicitarAtributoValido(scanner, "Informe a força do personagem (0 a 10):");
        double destreza = solicitarAtributoValido(scanner, "Informe a destreza do personagem (0 a 10):");

        Arma arma = escolherArma(scanner, tipoPersonagem, magiaTransmutacao, psiKappa, espada, lanca, martelo, maca);

        return criarInstanciaPersonagem(tipoPersonagem, saude, forca, destreza, arma);
    }

    private static double solicitarAtributoValido(Scanner scanner, String mensagem) {
        double valor;
        do {
            System.out.println(mensagem);
            valor = scanner.nextDouble();
            if (valor < 0 || valor > 10) {
                System.out.println("Valor inválido! Deve estar entre 0 e 10.");
            }
        } while (valor < 0 || valor > 10);
        return valor;
    }

    private static int solicitarOpcaoValida(Scanner scanner, String mensagem, int min, int max) {
        int opcao;
        do {
            System.out.println(mensagem);
            opcao = scanner.nextInt();
            if (opcao < min || opcao > max) {
                System.out.println("Opção inválida! Escolha entre " + min + " e " + max + ".");
            }
        } while (opcao < min || opcao > max);
        return opcao;
    }

    private static Arma escolherArma(Scanner scanner, int tipoPersonagem,
                                     ArmaMago magiaTransmutacao, ArmaMago psiKappa,
                                     ArmaPaladino espada, ArmaPaladino lanca,
                                     ArmaClerigo martelo, ArmaClerigo maca) {
        String mensagem = switch (tipoPersonagem) {
            case 1 -> "1 para Magia da Transmutação, 2 para Psi-kappa";
            case 2 -> "1 para Espada, 2 para Lança";
            case 3 -> "1 para Martelo, 2 para Maça";
            default -> throw new IllegalStateException("Tipo de personagem inválido.");
        };

        int escolhaArma = solicitarOpcaoValida(scanner, mensagem, 1, 2);

        return switch (tipoPersonagem) {
            case 1 -> (escolhaArma == 1) ? magiaTransmutacao : psiKappa;
            case 2 -> (escolhaArma == 1) ? espada : lanca;
            case 3 -> (escolhaArma == 1) ? martelo : maca;
            default -> throw new IllegalStateException("Erro ao escolher arma.");
        };
    }

    private static Personagem criarInstanciaPersonagem(int tipoPersonagem, double saude, double forca, double destreza, Arma arma) {
        return switch (tipoPersonagem) {
            case 1 -> new Mago(saude, forca, destreza, arma);
            case 2 -> new Paladino(saude, forca, destreza, arma);
            case 3 -> new Clerigo(saude, forca, destreza, arma);
            default -> throw new IllegalStateException("Tipo de personagem inválido.");
        };
    }
}
