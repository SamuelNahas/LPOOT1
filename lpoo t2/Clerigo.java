public class Clerigo extends Personagem {
    public Clerigo(double saude, double forca, double destreza, Arma arma) {
        super("Clérigo", saude, forca, destreza, arma);
        if (!arma.getNome().equals("Martelo") || !arma.getNome().equals("Maça")) {
            throw new IllegalArgumentException("O Clérigo só pode usar Martelo ou Maça.");
        }
    }
}