public class Arma {
    private String nome;
    private double modificador;

    public Arma(String nome, double modificador) {
        this.nome = nome;
        this.modificador = modificador;
    }

    public String getNome() {
        return nome;
    }

    public double getModificador() {
        return modificador;
    }
}
