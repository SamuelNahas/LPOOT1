public class Paladino extends Personagem {
    public Paladino(double saude, double forca, double destreza, Arma arma) {
        super("Paladino", saude, forca, destreza, arma);
        if (!arma.getNome().equals("Espada") || !arma.getNome().equals("Lança")) {
            throw new IllegalArgumentException("O Paladino só pode usar Espada ou Lança.");
        }
    }
}