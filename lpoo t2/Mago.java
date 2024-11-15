public class Mago extends Personagem {
    public Mago(double saude, double forca, double destreza, Arma arma) {
        super("Mago", saude, forca, destreza, arma);
        if (!arma.getNome().equals("Magia da Transmutação") || !arma.getNome().equals("Psi-kappa")) {
            throw new IllegalArgumentException("O Mago só pode usar Magia da Transmutação ou Psi-kappa.");
        }
    }
}