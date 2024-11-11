public abstract class Personagem {
    protected String nome;
    protected double saude;
    protected double forca;
    protected double destreza;
    protected Arma arma;

    public Personagem(String nome, double saude, double forca, double destreza, Arma arma) {
        this.nome = nome;
        this.saude = saude;
        this.forca = forca;
        this.destreza = destreza;
        this.arma = arma;
    }

    public boolean estaVivo() {
        return saude > 0.0;
    }

    public void atacar(Personagem defensor) {
        if (!this.estaVivo()) {
            System.out.println("O " + this.nome + " não consegue atacar, pois está morto.");
            return;
        }

        System.out.println("O " + this.nome + " ataca o " + defensor.nome + " com " + this.arma.getNome() + ".");

        if (defensor.estaVivo()) {
            if (this.destreza > defensor.destreza) { // Ataque bem-sucedido
                double dano = this.forca * this.arma.getModificador();
                defensor.receberDano(dano);
                System.out.println("O ataque foi efetivo com " + dano + " pontos de dano!");
            } else if (this.destreza < defensor.destreza) { // Ataque revidado
                double danoRevidado = defensor.forca * defensor.arma.getModificador();
                this.receberDano(danoRevidado);
                System.out.println("O ataque foi inefetivo e revidado com " + danoRevidado + " pontos de dano!");
            } else { // Ataque defendido
                System.out.println("O ataque foi defendido, ninguém se machucou!");
            }
        } else {
            System.out.println("Pare! O " + defensor.nome + " já está morto!");
        }

        // Exibir o status dos personagens após o ataque
        System.out.println(this);
        System.out.println(defensor);
    }

    public void receberDano(double dano) {
        this.saude -= dano;
        if (this.saude < 0.0) {
            this.saude = 0.0;
        }
    }

    @Override
    public String toString() {
        if (estaVivo()) {
            return nome + " [Saúde: " + saude + ", Força: " + forca + ", Destreza: " + destreza + ", " + arma.getNome() + "]";
        } else {
            return nome + " [Morreu, Força: " + forca + ", Destreza: " + destreza + ", " + arma.getNome() + "]";
        }
    }
}
