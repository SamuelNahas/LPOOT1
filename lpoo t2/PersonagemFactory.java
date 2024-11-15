import java.util.Scanner;

public class PersonagemFactory {
    public static Personagem criarPersonagem(Scanner scanner, Arma magiaTransmutacao, Arma psiKappa, Arma espada, Arma lanca, Arma martelo, Arma maca) {
        System.out.println("Escolha o personagem: 1 para Mago, 2 para Paladino, 3 para Clérigo");
        int tipoPersonagem = scanner.nextInt();
        
        System.out.println("Informe a saúde, força e destreza do personagem:");
        double saude = scanner.nextDouble();
        double forca = scanner.nextDouble();
        double destreza = scanner.nextDouble();

        while(atributoIsNotValid(saude)){
            System.out.println("Informe a saúde do personagem (0 a 10):");
            saude = scanner.nextDouble();
        }

        while(atributoIsNotValid(forca)){
            System.out.println("Informa a forca do personagem (0 a 10):");
            forca = scanner.nextDouble();
        }

        while(atributoIsNotValid(destreza)){
            System.out.println("Informe a destreza do personagem (0 a 10):");
            destreza = scanner.nextDouble();
        }

        System.out.println("Escolha a arma: ");
        Arma arma = null;
        switch (tipoPersonagem) {
            case 1: {
                System.out.println("1 para Magia da Transmutação, 2 para Psi-kappa");
                int armaEscolha = scanner.nextInt();
                arma = (armaEscolha == 1) ? magiaTransmutacao : psiKappa;
                break;
            }
            case 2: {
                System.out.println("1 para Espada, 2 para Lança");
                int armaEscolha = scanner.nextInt();
                arma = (armaEscolha == 1) ? espada : lanca;
                break;
            }
            case 3: {
                System.out.println("1 para Martelo, 2 para Maça");
                int armaEscolha = scanner.nextInt();
                arma = (armaEscolha == 1) ? martelo : maca;
                break;
            }
            default: {
                System.out.println("Tipo de personagem inválido.");
                break;
            }
        }

        switch (tipoPersonagem) {
            case 1: 
                return new Mago(saude, forca, destreza, arma);
            case 2: 
                return new Paladino(saude, forca, destreza, arma);
            case 3: 
                return new Clerigo(saude, forca, destreza, arma);
            default: 
                return null;
        }
    }

    private static boolean atributoIsNotValid(double attr) {
        return attr > 10 || attr < 0;
    }
}
